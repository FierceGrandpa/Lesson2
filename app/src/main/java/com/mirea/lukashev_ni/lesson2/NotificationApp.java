package com.mirea.lukashev_ni.lesson2;

import static android.Manifest.permission.POST_NOTIFICATIONS;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class NotificationApp extends AppCompatActivity {
    private final int permissionCode = 200;
    private final String TAG = NotificationApp.class.getSimpleName();

    private static final String CHANNEL_ID = "com.mirea.lukashev_ni.notification.ANDROID";

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_app);
        if (ContextCompat.checkSelfPermission(this, POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permissions granted");
        } else {
            Log.d(TAG, "Permissions denied");
            ActivityCompat.requestPermissions(this, new String[]{ POST_NOTIFICATIONS }, permissionCode);
        }
    }

    public void onClickNewMessageNotification(View view) {
        if (ActivityCompat.checkSelfPermission(this, POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentText("Congratulation!");
        builder.setSmallIcon(R.drawable.ic_stat_name);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Much longer text that cannot fit one line..."));
        builder.setContentTitle("Mirea");

        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Nikita Lukashev Notification", importance);
        channel.setDescription("MIREA Channel");

        NotificationManagerCompat manager  = NotificationManagerCompat.from(this);
        manager.createNotificationChannel(channel);
        manager.notify(1, builder.build());
    }
}