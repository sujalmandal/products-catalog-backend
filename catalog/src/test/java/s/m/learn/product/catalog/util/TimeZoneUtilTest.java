package s.m.learn.product.catalog.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TimeZone;

import static s.m.learn.product.catalog.util.TimeZoneUtil.ASIA_DUBAI;

class TimeZoneUtilTest {

    @Test
    void setDefaultTimeZone() {
        TimeZoneUtil.setDefaultTimeZone();
        TimeZone defaultTimeZone = TimeZone.getDefault();
        Assertions.assertEquals(defaultTimeZone.getID(), ASIA_DUBAI);
    }
}