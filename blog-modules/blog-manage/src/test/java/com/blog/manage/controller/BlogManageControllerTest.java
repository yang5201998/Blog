package com.blog.manage.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.IntConsumer;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2022-04-13-16:48
 */
@SpringBootTest
public class BlogManageControllerTest {

    @Test
    public  void test() {
        LocalDateTime localDate = LocalDateTime.now();
        String nowDate = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime localDateTime = localDate.plusYears(1);
        String nextDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        LocalDateTime s = localDateTime.with(LocalTime.MIN);
        int t=0;
        ZoneId zoneId = ZoneId.systemDefault();
        Date date=new Date("Sun Apr 24 11:11:27 CST 2022");
        LocalDateTime lastLocalDateTime = localDate.plusYears(0);
        LocalDateTime localDateTimes = lastLocalDateTime.plusDays(0);
        Date minf = Date.from(localDateTimes.with(LocalTime.MIN).atZone(zoneId).toInstant());
        Date maxf = Date.from(localDateTimes.with(LocalTime.MAX).atZone(zoneId).toInstant());
        if (minf.before(date) && maxf.after(date)){
            t++;
        }
        System.out.println(t);
        System.out.println(date);

        System.out.println(nowDate);
        System.out.println(nextDate);
        System.out.println(endOfDay);
        System.out.println(s);
    }


}
