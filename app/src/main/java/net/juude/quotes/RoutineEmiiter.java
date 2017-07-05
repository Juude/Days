package net.juude.quotes;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by juude on 2017/7/5.
 */

public class RoutineEmiiter {

    private static RoutineEmiiter sInstance;

    public static RoutineEmiiter get() {
        if (sInstance == null) {
            sInstance = new RoutineEmiiter();
        }
        return sInstance;
    }

    public void emit(Context context) {
        long currentMillis = System.currentTimeMillis();
        Calendar current = Calendar.getInstance();
        current.setTime(new Date(currentMillis));
        long deltaMillis;
        int hourOfDay = current.get(Calendar.HOUR_OF_DAY);
        deltaMillis = (hourOfDay < 8 ? 8 : 8 + 24) * TimeUnit.HOURS.toMillis(1) -
                hourOfDay * TimeUnit.HOURS.toMillis(1) -
                current.get(Calendar.MINUTE) * TimeUnit.MINUTES.toMillis(1) -
                current.get(Calendar.SECOND) * TimeUnit.SECONDS.toMillis(1);

        long nextMillis = currentMillis + deltaMillis;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                nextMillis, TimeUnit.DAYS.toMillis(1),
                PendingIntent.getBroadcast(context, (int) currentMillis, new Intent("ACTION_ROUTINE_FIRE"), PendingIntent.FLAG_UPDATE_CURRENT)
        );
        Log.d("RoutineEmiiter", "next time" + new Date(nextMillis));
    }

}
