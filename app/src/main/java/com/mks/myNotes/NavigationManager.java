package com.mks.myNotes;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.mks.myNotes.mvp.presneter.UserInteraction;

/**
 * Created by MKS on 29/05/18.
 */

public class NavigationManager {

    public static void openAddNoteDialog(Context context, final UserInteraction.UserItemClickListener userItemClickListener) {
        final EditText input = new EditText(context);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setImeOptions(EditorInfo.IME_ACTION_DONE);

        input.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){
                if(s != null && s.length() > 1000 && input.getError() != null) {
                    input.setError("1000 character Limit reached.");
                }
            }
        });

        input.setLayoutParams(lp);

        new AlertDialog.Builder(context)
                .setView(input)
                .setTitle("Add Note")
                .setMessage("Add text below: ")
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        userItemClickListener.onAddNoteClick(input.getText().toString());
                        userItemClickListener.fetchNotesAndRefreshRecyclerView();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
}
