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


    // 01. java.util.Date --> java.time.LocalDateTime
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    // 02. java.util.Date --> java.time.LocalDate
    public static LocalDate dateToLocalDate() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    // 03. java.util.Date --> java.time.LocalTime
    public static LocalTime dateToLocalTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
        return localTime;
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public static Date localDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }


    // 05. java.time.LocalDate --> java.util.Date
    public static Date localDateToUdate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }

    // 06. java.time.LocalTime --> java.util.Date
    public static Date localTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }

}
