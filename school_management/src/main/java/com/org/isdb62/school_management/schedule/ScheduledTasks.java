package com.org.isdb62.school_management.schedule;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5, timeUnit = TimeUnit.MINUTES)
	public void reportCurrentTime() {

        try{
            Thread.sleep(Duration.ofMinutes(1));
        }catch(InterruptedException ignored){

        }
		log.info("The time is now {}", dateFormat.format(new Date()));
	}
    @Scheduled(fixedDelay =  2, timeUnit = TimeUnit.SECONDS)
    public void reportCurrentTimeFixedDelay() {
        try {
            
            Thread.sleep(Duration.ofMinutes((1)));
        } catch (InterruptedException ignored) {            
        }

        // @Scheduled(cron = "0 */5 * ? * *") // every 5 minutes
        // public void reportCurrentTimeCron(){

        //     try {
        //         Thread.sleep(Duration.ofMinutes(1)); // sleep 1 minute
        //     } catch (InterruptedException Ignored) {
        //         // Ignored
        //     }
        // }
        
    }
}