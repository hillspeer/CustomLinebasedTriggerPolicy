package com.test;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.util.Integers;

@Plugin(name = "MaxLineBasedTriggeringPolicy", category = "Core", printObject = true)
public class MaxLineBasedTriggeringPolicy implements TriggeringPolicy {
    //private final TimeBasedTriggeringPolicy timeBasedTriggeringPolicy;
    private RollingFileManager manager;

    private int counter;
    private int count;
    private int maxLines = 10;
    private MaxLineBasedTriggeringPolicy(final int interval, final int modulate) {
/*        timeBasedTriggeringPolicy = TimeBasedTriggeringPolicy.createPolicy(
            String.valueOf(interval), String.valueOf(modulate));*/
            count = interval;
            maxLines = modulate;
    }

    public void checkRollover(final LogEvent event) {
        this.manager.checkRollover(event);
    }

    @Override
    public void initialize(final RollingFileManager manager) {
        this.manager = manager;
        //manager.rollover();
        //timeBasedTriggeringPolicy.initialize(manager);
    }

    @Override
    public boolean isTriggeringEvent(final LogEvent event) {
        if(counter>=count) {
            counter=1;
            return true;
        }else{
            ++counter;
            return false;
        }
    }

    @Override
    public String toString() {
        return "MaxLineBasedTriggeringPolicy";
    }

    @PluginFactory
    public static MaxLineBasedTriggeringPolicy createPolicy(
        @PluginAttribute("count") final String interval,
        @PluginAttribute("modulate") final String modulate) {
        final int increment = Integers.parseInt(interval, 1);
        final int mod = Integer.parseInt(modulate);
        return new MaxLineBasedTriggeringPolicy(increment, mod);
    }
}
