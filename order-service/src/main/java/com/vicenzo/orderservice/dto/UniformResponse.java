package com.vicenzo.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UniformResponse {

    private String status;
    private String message;
    private Object parsedData;

    public void setResponse(String status, String message){
        this.status = status;
        this.message= message;
    }


    public void setResponse(String status, String message, Object parsedData){
        this.status = status;
        this.message= message;
        this.parsedData = parsedData;
    }
}
