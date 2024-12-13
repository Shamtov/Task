package org.example.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorResponse {

    private String errorTitle;
    private String errorDetail;
    private List<?> errorDetails;

    public ErrorResponse(String errorTitle, String errorDetail) {
        this.errorTitle = errorTitle;
        this.errorDetail = errorDetail;
    }

    public ErrorResponse(String errorTitle, String errorDetail, List<?> errorDetails) {
        this.errorTitle = errorTitle;
        this.errorDetail = errorDetail;
        this.errorDetails = errorDetails;
    }

    public ErrorResponse(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public ErrorResponse(String errorTitle, List<?> errorDetails) {
        this.errorDetails = errorDetails;
        this.errorTitle = errorTitle;
    }
}
