package com.mirea.lukashev_ni.lesson2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        ProgressDialog nDialog = new ProgressDialog(getActivity()); //Here I get an error: The constructor ProgressDialog(PFragment) is undefined
        nDialog.setMessage("Loading..");
        nDialog.setTitle("Checking Network");
        nDialog.setIndeterminate(false);
        nDialog.setCancelable(true);
        nDialog.show();
        return nDialog;
    }
}
