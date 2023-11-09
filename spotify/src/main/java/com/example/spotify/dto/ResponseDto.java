package com.example.spotify.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDto {

    private HttpStatus status;
    private String message;
    private Object data;
}
