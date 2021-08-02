package com.udacity.jwdnd.course1.cloudstorage.mapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES")
    List<Notes> getNotes();

    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) VALUES(#{notetitle}, #{notedescription}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int insert(Notes note);

    @Update("UPDATE NOTES set notetitle = #{notetitle}, notedescription = #{notedescription} WHERE noteid = #{noteid}")
    void update(Notes note);

}