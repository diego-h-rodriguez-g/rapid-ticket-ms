package com.dev.rapidticket.javastack.service;

import com.dev.rapidticket.commons.utilities.Utilities;
import com.dev.rapidticket.javastack.model.JavaStackResponse;
import org.springframework.boot.SpringBootVersion;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.logging.Level;

import static com.dev.rapidticket.commons.utilities.Constants.RESPONSE_MESSAGE_JAVA_STACK;

@Service
public class JavaStackServiceImpl implements JavaStackService{

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(String.valueOf(JavaStackServiceImpl.class));

    private final Utilities utilities;

    public JavaStackServiceImpl(Utilities utilities) {
        this.utilities = utilities;
    }

    @Override
    @Cacheable(value = "JavaStackResponse", key = "#root.method.name")
    public JavaStackResponse getJavaStack() {
        JavaStackResponse getJavaStackResponse = JavaStackResponse.builder()
                .code(HttpStatus.OK.value())
                .message(RESPONSE_MESSAGE_JAVA_STACK)
                .springVersion(SpringVersion.getVersion())
                .springBootVersion(SpringBootVersion.getVersion())
                .javaVersion(System.getProperty("java.version"))
                .build();
        log.log(Level.INFO, "Microservice basic stack service: {0}", new Object[]{utilities.convertObjectToString(getJavaStackResponse)});
        return getJavaStackResponse;
    }
}
