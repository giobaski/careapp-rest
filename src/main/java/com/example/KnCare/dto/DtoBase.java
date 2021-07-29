package com.example.KnCare.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

public class DtoBase {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer limit;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer page;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String sort;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Sort.Direction dir;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
