package com.org.isdb62.school_management.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class InstantDeserializer extends JsonDeserializer <Instant> {
@Override
public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws
 IOException {
    String date = p.getText();    
    return LocalDate.parse(date).atStartOfDay().toInstant(ZoneOffset.UTC);
}
}
