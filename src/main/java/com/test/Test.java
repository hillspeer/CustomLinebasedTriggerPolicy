package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    Logger logger = LogManager.getLogger("index");
    Logger rootLogger = LogManager.getLogger(LogManager.getRootLogger());

    public static void main(String[] args) {

        Test t = new Test();//

        Stream<Integer> stream = IntStream.range(1,60).boxed();

        stream.forEach( v ->{
            if(v%2==1) {
                t.logger.trace("Hello " + v);
            }else{
                t.rootLogger.trace("Hello " + v);
            }
        });


    }

}
