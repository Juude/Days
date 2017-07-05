package net.juude.quotes;

import android.app.Application;
import android.content.Intent;

/**
 * Created by juude on 2017/7/5.
 */

public class QuotesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RoutineEmiiter.get().emit(getApplicationContext());
        sendBroadcast(new Intent("ACTION_ROUTINE_FIRE"));
    }
}
