package com.dev.rapidticket.commons.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Level;

@Component
public class UtilitiesImpl implements Utilities{

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(String.valueOf(UtilitiesImpl.class));

    private final ObjectMapper objectMapper;

    public UtilitiesImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean isNullObject(Object object) {
        return Objects.isNull(object);
    }

    @Override
    public String convertObjectToString(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception exception) {
            log.log(Level.INFO, "an uncaught exception has occurred: {0}", exception);
        }
        return null;
    }
}
