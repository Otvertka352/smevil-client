package ru.otvertka352.smevilclient.api.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;


@Data
public class FooterDTO {
    private ConditionsDTO conditions;
    private Set<PersonDTO> persons;
    private LocalDate docDate;
}
