package com.mirea.lukashev_ni.lesson2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private final String COUNT_STUDENTS = "COUNT_STUDENTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_main);

        Double countStudents = savedInstanceState == null ? 0.0 : savedInstanceState.getDouble(COUNT_STUDENTS);

        Toast toast = Toast.makeText(getApplicationContext(), "Hello, MIREA!", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState()");
        outState.putInt(COUNT_STUDENTS, 2);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    public void onClickNewActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra("key", "MIREA - Лукашев Никита Иванович");

        EditText mEdit   = findViewById(R.id.edit_text);

        intent.putExtra("key", mEdit.getText().toString());

        startActivity(intent);
    }

    public void onClickOpenNotificationApp(View view) {
        Intent intent = new Intent(this, NotificationApp.class);
        startActivity(intent);
    }

    public void onClickOpenMireaButton(View view) {
        Uri  address = Uri.parse("https://www.mirea.ru/");
        Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openLinkIntent);
    }

    public void onClickShareButton(View view) {
        Intent shareIntent  = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Лукашев Никита Иванович");
        startActivity(Intent.createChooser(shareIntent, "Мои ФИО"));
    }

    public void onClickOpenShowDialog(View view) {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), "mirea");
    }

    public void onChoice(String choice) {
        Toast.makeText(getApplicationContext(), "Your choice: " + choice, Toast.LENGTH_LONG).show();
    }

    public void onClickOpenShowDialog_time_choice(View view) {
        MyTimeDialogFragment dialog = new MyTimeDialogFragment();
        dialog.show(getSupportFragmentManager(), "mirea");
    }

    public void onClickOpenShowDialog_date_choice(View view) {
        MyDateDialogFragment dialog = new MyDateDialogFragment();
        dialog.show(getSupportFragmentManager(), "mirea");
    }

    public void onClickOpenShowDialog_progress_choice(View view) {
        MyProgressDialogFragment dialog = new MyProgressDialogFragment();
        dialog.show(getSupportFragmentManager(), "mirea");
    }
}