package com.test;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    Logger logger = LogManager.getLogger("index");
    Logger rootLogger = LogManager.getLogger(LogManager.getRootLogger());

    static String formatUsingApacheCommonsLang(LocalDate localDate) {
        Date date = Date.from(localDate.atStartOfDay().toInstant(ZoneOffset.UTC));
        String formattedDate = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss.sss'Z'", TimeZone.getTimeZone("UTC"))
                .format(date);
        return formattedDate;
    }

    Lock l = new ReentrantLock();
    public static void main(String[] args) {
        String hello = args[0];
        int max = (null==args[1])?100:Integer.parseInt(args[1]);
        Test t = new Test();

        Stream<Integer> stream = IntStream.range(1,max).boxed();

        stream.parallel().forEach( v ->{

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            var message = "{\"message\": \""+ hello +  v + "\", \"timestamp\": \""+ dateFormat.format(new Date()) +"\"}";

            //t.l.lock();
                //if(v%2==1) {
                    t.logger.trace(message );
                    t.rootLogger.trace(message.substring(message.indexOf("{")));
                /*}else{
                    t.rootLogger.trace(message.substring(message.indexOf("{")));
                }*/
            //t.l.unlock();
        });


    }

}
