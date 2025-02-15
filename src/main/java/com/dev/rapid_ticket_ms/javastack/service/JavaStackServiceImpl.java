package com.dev.rapid_ticket_ms.javastack.service;

import com.dev.rapid_ticket_ms.commons.utilities.Utilities;
import com.dev.rapid_ticket_ms.javastack.model.JavaStackResponse;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.logging.Level;

@Service
public class JavaStackServiceImpl implements JavaStackService{

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(String.valueOf(JavaStackServiceImpl.class));

    private final Utilities utilities;

    public JavaStackServiceImpl(Utilities utilities) {
        this.utilities = utilities;
    }

    @Override
    public JavaStackResponse getJavaStack() {
        JavaStackResponse getJavaStackResponse = JavaStackResponse.builder()
                .code(HttpStatus.OK.value())
                .message("Test service executed successfully")
                .springVersion(SpringVersion.getVersion())
                .springBootVersion(SpringBootVersion.getVersion())
                .javaVersion(System.getProperty("java.version"))
                .build();
        log.log(Level.INFO, "Microservice basic stack service: {0}", new Object[]{utilities.convertObjectToString(getJavaStackResponse)});
        return getJavaStackResponse;
    }
}
