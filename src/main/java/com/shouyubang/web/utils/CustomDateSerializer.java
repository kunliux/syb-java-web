package com.shouyubang.web.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * Created by KunLiu on 2017/7/26.
 */
public class CustomDateSerializer extends JsonSerializer<LocalDate>{

    private static DateTimeFormatter formatter =
            DateTimeFormat.forPattern("yyyyMMdd");

    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider){
        try {
            jsonGenerator.writeString(formatter.print(localDate));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
