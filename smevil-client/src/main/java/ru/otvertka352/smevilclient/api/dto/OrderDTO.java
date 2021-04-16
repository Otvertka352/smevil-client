package ru.otvertka352.smevilclient.api.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class OrderDTO {
    private int npp;
    private int orderNumberInBank;
    private LocalDate dateOfReceiptInBank;
    private String borrowerFullName;
    private String borrowerINN;
    private String borrowerForm;
    private boolean smallFirm;
    private boolean again;
    private RegionDTO region;
    private String creditLine;
    private Set<String> creditLineDetails;
    private float amountRequested;
    private String investProjectID;
    private String investProjectName;
    private float investProjectValue;
    private String creditPeriod;
    private String authorityName;
    private LocalDate acceptDate;
    private int acceptNumber;
    private PlannedPercentDTO plannedPercent;
    private int monthsOfThisYear;
    private boolean firmedContract;
    private float amountSubsidyTotal;
    private float amountSubsidyThisYear;
    private float amountSubsidyYear1;
    private float amountSubsidyYear2;
    private float amountSubsidyYear3;
}
