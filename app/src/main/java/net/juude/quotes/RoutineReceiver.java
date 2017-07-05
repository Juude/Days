package net.juude.quotes;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


/**
 * Created by juude on 2017/7/5.
 */

public class RoutineReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Notification notification =
                new NotificationCompat.Builder(context.getApplicationContext())
                .setContentTitle(new LifeBuilder().buildTime())
                .setContentText("如果不做决定怎么活，就会被别人决定")
                .setSmallIcon(R.drawable.icon)
                .setAutoCancel(false)
                .setOngoing(true)
                .build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(context.getApplicationContext().hashCode(), notification);
    }
}
