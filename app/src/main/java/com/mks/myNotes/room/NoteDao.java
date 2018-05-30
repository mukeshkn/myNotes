package com.mks.myNotes.room;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mks.myNotes.mvp.model.pojo.Note;

import java.util.List;

/**
 * Created by MKS on 26/05/18.
 */

public interface NoteDao {
    @Query("SELECT * FROM notes")
    List<Note> getAllNotes();

    @Query("SELECT count(*) FROM notes")
    int getTotalNotes();

    @Insert
    void insert(Note note);

    @Delete
    void deleteNote(Note notes);

    @Update
    void updateNote(Note notes);
}
