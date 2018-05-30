package com.mks.myNotes.mvp.view.notes_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mks.myNotes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MKS on 26/05/18.
 */

class NotesViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvNote)
     TextView tvNotes;

    @BindView(R.id.tvCreatedDate)
     TextView tvCreatedDate;

    public NotesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
