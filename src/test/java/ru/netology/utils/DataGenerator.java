package ru.netology.utils;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import ru.netology.domain.RegCity;
import ru.netology.domain.RegistrationInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class Registration {
        public static RegistrationInfo generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            RegCity regCity = new RegCity();
            int randomCity = (int) (Math.random() * regCity.getRegCity().length);
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return new RegistrationInfo(regCity.getRegCity()[randomCity],
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber(),
                    today.plusDays(faker.number().numberBetween(3, 9)).format(formatter),
                    today.plusDays(faker.number().numberBetween(3, 9)).format(formatter)
            );
        }
    }
}
