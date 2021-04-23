package ru.otvertka352.smevilclient.impl.handler.impl;

import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
            System.out.println("sdfsdf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
