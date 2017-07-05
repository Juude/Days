package net.juude.quotes;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by sjd on 2017/7/5.
 */

public class LifeBuilder {

    public String buildTime() {
        Calendar birthDay = Calendar.getInstance();
        birthDay.set(Calendar.YEAR, 1989);
        birthDay.set(Calendar.MONTH, Calendar.OCTOBER);
        birthDay.set(Calendar.DAY_OF_MONTH, 20);
        birthDay.set(Calendar.HOUR_OF_DAY, 0);
        birthDay.set(Calendar.MINUTE, 0);
        birthDay.set(Calendar.SECOND, 0);
        birthDay.set(Calendar.MILLISECOND, 0);
        long dayDeltaBirth = (System.currentTimeMillis() -  birthDay.getTimeInMillis()) / (TimeUnit.DAYS.toMillis(1)) + 1;

        Calendar nextYear = Calendar.getInstance();
        nextYear.set(Calendar.YEAR, 2018);
        nextYear.set(Calendar.MONTH, Calendar.JANUARY);
        nextYear.set(Calendar.DAY_OF_MONTH, 1);
        nextYear.set(Calendar.HOUR_OF_DAY, 0);
        nextYear.set(Calendar.MINUTE, 0);
        nextYear.set(Calendar.SECOND, 0);
        nextYear.set(Calendar.MILLISECOND, 0);
        long dayDeltaNextYear = (nextYear.getTimeInMillis() - System.currentTimeMillis()) / (TimeUnit.DAYS.toMillis(1)) + 1;
        return "我一生的第" + dayDeltaBirth + "天" + "; 距离2018还有" + dayDeltaNextYear + "天";
    }
}
