package ru.otus.project.rnis.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransportTypeDto {
    private Long id;
    private String name;
}