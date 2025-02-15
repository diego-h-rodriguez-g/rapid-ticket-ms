package com.dev.rapid_ticket_ms.javastack.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JavaStackResponse {
    private int code;
    private String message;
    private String springVersion;
    private String springBootVersion;
    private String javaVersion;
}
