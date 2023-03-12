package com.dfa.sanitest.infraestructure.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Objects;

public class SanitestCommonUtils {
   
    public static <E> boolean checkCollection(Collection<E> collection) {
        return (Objects.nonNull(collection) && !collection.isEmpty());
    }

    public static LocalDateTime toLocalDate(String date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(date, formatter);
    }

}
