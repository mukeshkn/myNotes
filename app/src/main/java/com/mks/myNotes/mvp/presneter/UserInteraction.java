package com.mks.myNotes.mvp.presneter;

/**
 * Created by MKS on 29/05/18.
 */

public interface UserInteraction {
    interface UserItemClickListener {
        void onAddNoteClick(String note);
        void onRvItemClick();
        void onNoteAdditionComplete();
    }

    void onFabClick();

}
