package s.m.learn.product.catalog.util;

import java.util.TimeZone;

public final class TimeZoneUtil {
    private TimeZoneUtil(){}

    public static void setDefaultTimeZone(){
        TimeZone.setDefault(TimeZone.getTimeZone("UnitedArabEmirate"));
    }

}
