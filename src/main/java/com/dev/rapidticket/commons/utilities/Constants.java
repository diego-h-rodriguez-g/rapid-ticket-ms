package com.dev.rapidticket.commons.utilities;

public class Constants {

    public static final String ERROR_MESSAGE_POSITIVE = "The field must be a positive number greater than 0.";

    public static final String ERROR_MESSAGE_FUTURE = "The field must be a date greater than the current date";

    public static final String ERROR_MESSAGE_NOT_NULL = "The field cannot be null.";

    public static final String ERROR_MESSAGE_NOT_BLANK = "The field cannot be null and must contain at least one non-whitespace character/element.";

    public static final String ERROR_MESSAGE_NOT_EMPTY = "The field cannot be null and must contain at least one character.";

    public static final String RESPONSE_MESSAGE_FILTER_RESERVATION = "The query on the reservation table was successful";

    public static final String RESPONSE_MESSAGE_GLOBAL = "An error has occurred in one of the rapid-ticket-ms services, please check the entered data, documentation or AWS Cloudwatch logs for more information.";

}
