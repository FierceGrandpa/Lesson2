package com.mirea.lukashev_ni.lesson2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("Hello Mirea!")
            .setMessage("Is victory near?")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("I'm moving on", (dialog, i) -> {
                    ((MainActivity)getActivity()).onChoice("I'm moving on");
                    dialog.cancel();
                })
                .setNeutralButton("On pause", (dialog, i) -> {
                    ((MainActivity)getActivity()).onChoice("Pause");
                    dialog.cancel();
                })
                .setNegativeButton("No", (dialog, i) -> {
                    ((MainActivity)getActivity()).onChoice("No");
                    dialog.cancel();
                });
        return b.create();
    }
}
