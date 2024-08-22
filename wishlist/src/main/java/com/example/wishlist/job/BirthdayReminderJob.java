package com.example.wishlist.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class BirthdayReminderJob {

    private static final Logger logger = LoggerFactory.getLogger(BirthdayReminderJob.class);

    @Scheduled(cron = "0 0 7 * * ?") // Runs every day at 7am // Выполняется каждый день в 7 утра
    public void sendBirthdayReminders() {
        // Logic for sending birthday reminders
        // Логика отправки напоминаний о днях рождения
        logger.info("Executing birthday reminder job");
    }
}
