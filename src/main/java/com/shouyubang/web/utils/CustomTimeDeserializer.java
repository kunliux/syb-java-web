package com.shouyubang.web.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * Created by KunLiu on 2017/7/26.
 */
public class CustomTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static DateTimeFormatter formatter =
            DateTimeFormat.forPattern("yyyyMMddHHmmss");

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        LocalDateTime datetime = null;
        try {
            datetime = formatter.parseLocalDateTime(jsonParser.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datetime;
    }
}
