package ru.otvertka352.smevilclient.impl.handler.impl;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import ru.otvertka352.smevilclient.impl.handler.XLSXReader;
import ru.otvertka352.smevilclient.impl.util.ExcelUtil;

import java.util.List;
import java.util.stream.Collectors;


public class XLSXReaderRPZ implements XLSXReader {
    @Override
    public void read(byte[] file) {

        final XSSFWorkbook workbook = ExcelUtil.getWorkbook(file);
        final XSSFSheet sheet = workbook.getSheetAt(0);
        final List<XSSFTable> sheetTables = sheet.getTables();


        final List<XSSFName> allNames = workbook.getAllNames();
        allNames.
                stream().
                collect(Collectors.toMap(XSSFName::getNameName, field -> ExcelUtil.getFieldValue(field, sheet)));

        for (XSSFName field : allNames
        ) {
            System.out.println(field.getRefersToFormula());
            AreaReference areaRef;
            try {
                areaRef = new AreaReference(field.getRefersToFormula(), SpreadsheetVersion.EXCEL2007);
            } catch (IllegalArgumentException e) {
                //TODO: Add log record!
                continue;
            }

            if (areaRef.isSingleCell()) {
                CellReference cellRef = areaRef.getFirstCell();
                XSSFRow row = sheet.getRow(cellRef.getRow());
                XSSFCell cell = row.getCell(cellRef.getCol());
                CellType cellType = cell.getCellType();
                if (cellType == CellType.STRING) {
                    System.out.println(cell.getStringCellValue());
                }
            }


        }

        String testRefFormula = allNames.get(0).getRefersToFormula();
        AreaReference areaRef = new AreaReference(testRefFormula, SpreadsheetVersion.EXCEL2007);

        if (areaRef.isSingleCell()) {
            CellReference cellRef = areaRef.getFirstCell();
            XSSFRow row = sheet.getRow(cellRef.getRow());
            XSSFCell cell = row.getCell(cellRef.getCol());
            System.out.println('t');
        }

        System.out.println(testRefFormula);
    }


}
