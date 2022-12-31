package s.m.learn.product.catalog.util;

import java.util.TimeZone;

public final class TimeZoneUtil {

    public static final String ASIA_DUBAI = "Asia/Dubai";

    private TimeZoneUtil(){}

    public static void setDefaultTimeZone(){
        TimeZone.setDefault(TimeZone.getTimeZone(ASIA_DUBAI));
    }

}
