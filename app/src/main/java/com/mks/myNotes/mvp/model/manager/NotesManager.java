package com.mks.myNotes.mvp.model.manager;

/**
 * Created by MKS on 29/05/18.
 */

public interface NotesManager {
    interface AddNotesListener {
        void onNoteAddition();
    }

    void registerListener(AddNotesListener addNotesListener);
    void unregisterListener();
}
