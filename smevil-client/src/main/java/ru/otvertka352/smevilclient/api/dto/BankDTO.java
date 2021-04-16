package ru.otvertka352.smevilclient.api.dto;

import lombok.Data;

@Data
public class BankDTO {
    private String bankName;
    private String bankBIK;
    private String bankINN;
}
