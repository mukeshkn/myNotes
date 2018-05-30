package com.mks.myNotes.mvp.view.notes_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mks.myNotes.R;
import com.mks.myNotes.mvp.model.pojo.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by MKS on 26/05/18.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesViewHolder> {
    private List<Note> notes;

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_row_view, parent, false);
        return new NotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.tvNotes.setText(note.getNotes());
        holder.tvCreatedDate.setText(getFormattedDate(note.getCreatedDate()));
    }

    private String getFormattedDate(Date createdDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(createdDate);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
