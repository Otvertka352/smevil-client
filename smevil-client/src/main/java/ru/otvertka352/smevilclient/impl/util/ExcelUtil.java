package ru.otvertka352.smevilclient.impl.util;

import lombok.experimental.UtilityClass;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@UtilityClass
public class ExcelUtil {

    public XSSFWorkbook getWorkbook(byte[] file) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(file);
        return new XSSFWorkbook(inputStream);
    }

    public AreaReference getAreaReference(XSSFName field) {
        try {
            return new AreaReference(field.getRefersToFormula(), SpreadsheetVersion.EXCEL2007);
        } catch (IllegalArgumentException e) {
            return null;
        }

    }

    public static FieldValue getFieldValue(XSSFName field, XSSFSheet sheet) {
//        final AreaReference areaReference = getAreaReference(field);
//        FieldValue value = null;
//        if (areaReference.isSingleCell()) {
//            XSSFCell cell = getXssfCell(sheet, areaReference);
//            switch (cell.getCellType()) {
//                case STRING:
//                    value = new FieldValue<String>("dfdf");
//                    break;
//                case NUMERIC:
//                    value = new FieldValue<Integer>(1);
//                    break;
//                default:
//                    throw new IllegalStateException("Unexpected value: " + cell.getCellType());
//            }
//        }
        return null;
    }

    private static XSSFCell getXssfCell(XSSFSheet sheet, AreaReference areaReference) {
        CellReference cellRef = areaReference.getFirstCell();
        XSSFRow row = sheet.getRow(cellRef.getRow());
        XSSFCell cell = row.getCell(cellRef.getCol());
        return cell;
    }
}


