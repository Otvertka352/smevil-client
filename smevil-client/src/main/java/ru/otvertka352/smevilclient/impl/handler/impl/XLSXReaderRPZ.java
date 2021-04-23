package ru.otvertka352.smevilclient.impl.handler.impl;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import ru.otvertka352.smevilclient.impl.handler.XLSXReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class XLSXReaderRPZ implements XLSXReader {
    @Override
    public void read(byte[] file) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(file);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            final List<XSSFName> allNames = workbook.getAllNames();
            final List<XSSFTable> sheetTables = sheet.getTables();

            for (XSSFName field: allNames
                 ) {
                System.out.println(field.getRefersToFormula());
                AreaReference areaRef;
                try {
                    areaRef = new AreaReference(field.getRefersToFormula(), SpreadsheetVersion.EXCEL2007);
                }catch (IllegalArgumentException e){
                    //TODO: Add log record
                    continue;
                }

                if (areaRef.isSingleCell()){
                    CellReference cellRef = areaRef.getFirstCell();
                    XSSFRow row = sheet.getRow(cellRef.getRow());
                    XSSFCell cell = row.getCell(cellRef.getCol());
                    CellType cellType = cell.getCellType();
                    if (cellType == CellType.STRING){
                        System.out.println(cell.getStringCellValue());
                    }
                }


            }

            String testRefFormula = allNames.get(0).getRefersToFormula();
            AreaReference areaRef = new AreaReference(testRefFormula, SpreadsheetVersion.EXCEL2007);

            if (areaRef.isSingleCell()){
                CellReference cellRef = areaRef.getFirstCell();
                XSSFRow row = sheet.getRow(cellRef.getRow());
                XSSFCell cell = row.getCell(cellRef.getCol());
                System.out.println('t');
            }


            System.out.println(testRefFormula);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
