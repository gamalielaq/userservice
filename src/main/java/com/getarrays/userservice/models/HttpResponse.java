package com.getarrays.userservice.models;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HttpResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "America/Lima")
    
    private  Date timeStamp;
    private int status; // 200, 201, 400, 500
    // private HttpStatus status;
    private String error;
    private String message;
    
    public HttpResponse(int status, String error, String message) {
        this.timeStamp = new Date();
        // this.code = code;
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
