package hello.springmvc.basic.config.team;

import hello.springmvc.basic.config.team.exception.ScheduleDateFormatException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.stereotype.Component;

@Component
public class LocalDateParser {

    private static final DateTimeFormatter DATE_PARAM_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

    public LocalDate parse(final String yearMonthDay) {
        try {
            return LocalDate.parse(yearMonthDay, DATE_PARAM_FORMAT);
        } catch (final DateTimeParseException e) {
            throw new ScheduleDateFormatException(e);
        }
    }
}