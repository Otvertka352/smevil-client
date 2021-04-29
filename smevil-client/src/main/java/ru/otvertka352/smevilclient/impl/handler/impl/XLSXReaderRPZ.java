package ru.otvertka352.smevilclient.impl.handler.impl;

import org.apache.poi.xssf.usermodel.*;
import ru.otvertka352.smevilclient.impl.handler.XLSXReader;
import ru.otvertka352.smevilclient.impl.util.ExcelUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class XLSXReaderRPZ implements XLSXReader {
    @Override
    public void read(byte[] file) {

        final XSSFWorkbook workbook = ExcelUtil.getWorkbook(file);
        final XSSFSheet sheet = workbook.getSheetAt(0);
        final List<XSSFTable> sheetTables = sheet.getTables();

        final List<XSSFName> allNames = workbook.getAllNames();
        final Map<String, Optional<XSSFCell>> valueMap = allNames.
                stream().
                collect(Collectors.toMap(XSSFName::getNameName, field -> ExcelUtil.getXssfCell(field, sheet)));

        System.out.println("sdfds");
    }


}
