package com.mks.myNotes.mvp.model.manager;

/**
 * Created by MKS on 29/05/18.
 */

public class NotesManagerImpl implements NotesManager {
    AddNotesListener addNotesListener;

    @Override
    public void registerListener(AddNotesListener addNotesListener) {
        this.addNotesListener = addNotesListener;
    }

    @Override
    public void unregisterListener() {
        this.addNotesListener = null;
    }
}
