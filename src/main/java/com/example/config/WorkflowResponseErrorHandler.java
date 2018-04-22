package com.example.config;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class WorkflowResponseErrorHandler implements ResponseErrorHandler {
    Logger logger = Logger.getLogger(WorkflowResponseErrorHandler.class);
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatus httpStatus = response.getStatusCode();
        HttpStatus.Series series = httpStatus.series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series));
    }
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        logger.error("Response error: " + response.getStatusCode() + " " + response.getStatusText());
    }
}
