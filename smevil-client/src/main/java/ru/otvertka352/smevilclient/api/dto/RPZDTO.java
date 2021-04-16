package ru.otvertka352.smevilclient.api.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class RPZDTO {
    private LocalDate reportDate;
    private BankDTO bank;
    private Set<OrderDTO> orders;
    private FooterDTO footer;
    private String comment;
}

