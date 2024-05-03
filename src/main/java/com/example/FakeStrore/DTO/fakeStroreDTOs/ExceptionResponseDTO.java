package com.example.FakeStrore.DTO.fakeStroreDTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDTO {
    //if removed getter and setter you will receive a big error code with exception message
    private String message;
    private int code;// error code , http code

    public ExceptionResponseDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
