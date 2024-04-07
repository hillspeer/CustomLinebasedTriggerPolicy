package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    public static void main(String[] args) {

        Test t = new Test();//

        Stream<Integer> stream = IntStream.range(1,100).boxed();

        stream.forEach( v ->{
            t.logger.trace("Hello "+v);
        });


    }

}
