package com.mks.myNotes.mvp.presneter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mks.myNotes.NavigationManager;
import com.mks.myNotes.mvp.model.pojo.Note;
import com.mks.myNotes.mvp.view.add_note.AddNoteView;
import com.mks.myNotes.room.AppDatabase;

public class MainActivity extends AppCompatActivity implements UserInteraction {

    AddNoteView addNoteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addNoteView = new AddNoteView(this);
        setContentView(addNoteView.getRootView());
    }


    @Override
    public void onFabClick() {
        NavigationManager.openAddNoteDialog(this, new UserItemClickListener() {

            @Override
            public void onAddNoteClick(String note) {
                AppDatabase.getInstance(MainActivity.this).noteDao().insert(new Note(note));
            }

            @Override
            public void onRvItemClick() {

            }

            @Override
            public void onNoteAdditionComplete() {
            }
        });
    }
}
