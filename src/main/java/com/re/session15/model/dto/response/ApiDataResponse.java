package com.re.session15.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiDataResponse <T>{
    private Boolean success;
    private String message;
    private T data;
    private Object error;
    private HttpStatus status;
}
