package ru.maxima.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlResponseDto {


    @Size(min = 2 , max = 1000 , message = "Not found url")
    private String url;

    private String shortsUrl;


    private int clickUrl;
}
