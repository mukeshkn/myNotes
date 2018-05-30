package com.mks.myNotes.mvp.view.add_note;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.mks.myNotes.R;
import com.mks.myNotes.mvp.model.manager.NotesManagerImpl;
import com.mks.myNotes.mvp.presneter.UserInteraction;
import com.mks.myNotes.mvp.view.ViewMvc;
import com.mks.myNotes.mvp.view.notes_recyclerview.NotesAdapter;
import com.mks.myNotes.mvp.model.pojo.Note;
import com.mks.myNotes.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by MKS on 26/05/18.
 */

public class AddNoteView extends NotesManagerImpl implements ViewMvc {
    private View rootView;
    private NotesAdapter notesAdapter;
    private List<Note> notes = new ArrayList<>();
    private UserInteraction userInteraction;
    private Context mContext;
    private

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    public AddNoteView(Context context) {
        rootView = LayoutInflater.from(context).inflate(R.layout.mvc_view_note_add, null, false);
        mContext = context;
        initialize();
    }

    private void initialize() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getRootView().getContext());

        notesAdapter = new NotesAdapter(notes);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(notesAdapter);
        fetchNotesAndRefreshRecyclerView();
    }

    public void fetchNotesAndRefreshRecyclerView() {
        notes = AppDatabase.getInstance(mContext).noteDao().getAllNotes();
        notesAdapter.notifyDataSetChanged();
    }

    @OnClick
    private void onFabClick() {
        userInteraction.onFabClick();
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }
}
