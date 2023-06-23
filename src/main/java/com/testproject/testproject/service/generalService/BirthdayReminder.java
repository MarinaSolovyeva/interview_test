package com.testproject.testproject.service.generalService;
import com.testproject.testproject.models.driver.Driver;
import org.springframework.stereotype.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class BirthdayReminder {

    private static final String LOG_FILE_PATH = "birthday.log";
    private Map<Long, LocalDate> driversBirthday;

    public BirthdayReminder() {
        driversBirthday = new HashMap<>();
    }

    public void addDrivers(Driver driver) {
        Long key = driver.getId();
        LocalDate value = driver.getDateBirth();
        driversBirthday.put(key, value);
    }

    public void checkBirthdays(LocalDate currentDate, Driver driver) {
        for (Map.Entry<Long, LocalDate> entry : driversBirthday.entrySet()) {
            Long key = entry.getKey();
            LocalDate birthday = entry.getValue();

            if (currentDate.getMonth() == birthday.getMonth() && currentDate.getDayOfMonth() == birthday.getDayOfMonth()) {
                String message = "Сегодня день рождения у " + driver.getName() + "!";
                writeLog(message);
                System.out.println(message);
            }
        }
    }
    private void writeLog(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}