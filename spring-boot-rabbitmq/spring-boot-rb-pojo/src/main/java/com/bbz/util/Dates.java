package com.bbz.util;

import org.apache.commons.lang3.time.DateUtils;

import java.time.*;
import java.util.Date;

public abstract class Dates extends DateUtils {

    public Dates() {

    }

    /**
     * LocalDate 转时间戳
     *
     * @param localDate
     * @return
     */
    static long localDateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant()).getTime();
    }

    /**
     * LocalDateTime 转时间戳
     *
     * @param dateTime
     * @return
     */
    static long localDateTimeToDate(LocalDateTime dateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = dateTime.atZone(zoneId);
        return Date.from(zdt.toInstant()).getTime();
    }


    /**
     * 根据当前日期获取周一到周日的任意日期，不带时间
     *
     * @param week      -1:上一周 0:本周 1下一周 以此类推
     * @param dayOfWeek
     * @return
     */
    public static Long getBeginEndWeek(int week, DayOfWeek dayOfWeek) {
        return localDateToDate(LocalDate.now().plusWeeks(week).with(DayOfWeek.from(dayOfWeek)));
    }

    /**
     * 根据当前日期获取周一到周日的任意日期，带时间
     *
     * @param week      -1:上一周 0:本周 1下一周 以此类推
     * @param dayOfWeek
     * @return
     */
    public static long getBenginEndWeekTime(int week, DayOfWeek dayOfWeek) {
        return localDateTimeToDate(LocalDateTime.now().plusWeeks(week).with(DayOfWeek.from(dayOfWeek)));
    }

    /**
     * 获取系统当前时间戳
     *
     * @return
     */
    public static long unixNow() {
        return localDateTimeToDate(LocalDateTime.now());
    }

}
