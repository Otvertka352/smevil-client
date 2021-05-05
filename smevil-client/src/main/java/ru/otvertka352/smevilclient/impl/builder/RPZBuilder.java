package ru.otvertka352.smevilclient.impl.builder;

import org.apache.poi.xssf.usermodel.*;
import ru.otvertka352.smevilclient.api.dto.BankDTO;
import ru.otvertka352.smevilclient.api.dto.FooterDTO;
import ru.otvertka352.smevilclient.api.dto.OrderDTO;
import ru.otvertka352.smevilclient.api.dto.RPZDTO;
import ru.otvertka352.smevilclient.impl.util.ExcelUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class RPZBuilder {

    private final XSSFWorkbook workbook;
    private final XSSFSheet sheet;
    private final List<XSSFTable> sheetTables;
    private final Map<String, Optional<XSSFCell>> fieldsValues;
    private final RPZDTO rpzdto;

    private LocalDate reportDate;
    private BankDTO bank;
    private Set<OrderDTO> orders;
    private FooterDTO footer;
    private String comment;

    public RPZBuilder(byte[] file) {
        this.workbook = ExcelUtil.getWorkbook(file);
        this.sheet = workbook.getSheetAt(0);
        this.sheetTables = sheet.getTables();
        this.fieldsValues = workbook.getAllNames().
                stream().
                collect(Collectors.toMap(XSSFName::getNameName, field -> ExcelUtil.getXssfCell(field, sheet)));
        rpzdto = new RPZDTO();
    }

    public RPZBuilder setReportDate(){

        this.reportDate = getReportDateFromFields();
        return this;
    }

    public RPZBuilder setBank(){
        this.bank = getBankFromFields();
        return this;
    }

    private BankDTO getBankFromFields() {

        BankDTO  bankDTO = new BankDTO();

        final Optional<XSSFCell> bankNameField = fieldsValues.get("bankName");
        bankDTO.setBankName(bankNameField.map(ExcelUtil::getStringFromField).orElse(""));

        final Optional<XSSFCell> bankBIKField = fieldsValues.get("bankBIK");
        bankDTO.setBankBIK(bankBIKField.map(ExcelUtil::getStringFromField).orElse(""));

        final Optional<XSSFCell> bankINNField = fieldsValues.get("bankINN");
        bankDTO.setBankINN(bankINNField.map(ExcelUtil::getStringFromField).orElse(""));

        return bank;
    }

    private LocalDate getReportDateFromFields() {
//        TODO добавить обработку если нет такого ключа
        final Optional<XSSFCell> reportDateField = fieldsValues.get("reportDate");

        return reportDateField.
                map(ExcelUtil::getLocalDateFromField).
                orElse(LocalDate.of(1,1,1));
    }


}
