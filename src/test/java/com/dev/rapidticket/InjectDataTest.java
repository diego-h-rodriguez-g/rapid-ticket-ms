package com.dev.rapidticket;

import com.dev.rapidticket.filterevent.model.FilterEventRequest;
import com.dev.rapidticket.filterevent.model.FilterEventResponse;
import com.dev.rapidticket.javastack.model.JavaStackResponse;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;

import static com.dev.rapidticket.commons.utilities.Constants.RESPONSE_MESSAGE_FILTER_EVENT;
import static com.dev.rapidticket.commons.utilities.Constants.RESPONSE_MESSAGE_JAVA_STACK;

public class InjectDataTest {

    public JavaStackResponse buildJavaStackResponse(int index) {
        if (index == 200) {
            return JavaStackResponse.builder()
                    .code(HttpStatus.OK.value())
                    .message(RESPONSE_MESSAGE_JAVA_STACK)
                    .springVersion(SpringVersion.getVersion())
                    .springBootVersion(SpringBootVersion.getVersion())
                    .javaVersion(System.getProperty("java.version"))
                    .build();
        }
        return JavaStackResponse.builder().build();
    }

    public FilterEventRequest buildFilterEventRequest(int index) {
        if (index == 200) {
            FilterEventRequest.builder().eventId(index).build();
        }
        return FilterEventRequest.builder().build();
    }

    public FilterEventResponse buildFilterEventResponse(int index) {
        if (index == 200) {
            FilterEventResponse.builder().rowCount(index).message(RESPONSE_MESSAGE_FILTER_EVENT).build();
        }
        return FilterEventResponse.builder().build();
    }
}
