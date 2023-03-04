package com.mirea.lukashev_ni.lesson2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyDateDialogFragment extends DialogFragment {

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    public MyDateDialogFragment() {
        // nothing to see here, move along
    }

    public MyDateDialogFragment(DatePickerDialog.OnDateSetListener callback) {
        mDateSetListener = (DatePickerDialog.OnDateSetListener) callback;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();

        return new DatePickerDialog(getActivity(),
                mDateSetListener, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
    }
}
