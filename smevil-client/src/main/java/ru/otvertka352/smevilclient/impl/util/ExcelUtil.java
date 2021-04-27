package ru.otvertka352.smevilclient.impl.util;

import lombok.experimental.UtilityClass;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@UtilityClass
public class ExcelUtil {

    private static Map<CellType, Supplier<FieldValue>> cellsTypes;
    static {
        cellsTypes = new HashMap<>();
        cellsTypes.put(CellType.STRING, () -> new FieldValue<String>("22"));
        cellsTypes.put(CellType.NUMERIC, () -> new FieldValue<Integer>(22));
        cellsTypes.put(CellType.BLANK, () -> new FieldValue<String>(""));
    }

    public static XSSFWorkbook getWorkbook(byte[] file){
        ByteArrayInputStream inputStream = new ByteArrayInputStream(file);
        try {
            return new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AreaReference getAreaReference(XSSFName field) {
        try {
            return new AreaReference(field.getRefersToFormula(), SpreadsheetVersion.EXCEL2007);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static FieldValue getFieldValue(XSSFName field, XSSFSheet sheet) {
        final AreaReference areaReference = getAreaReference(field);

        FieldValue value = null;
        if (areaReference.isSingleCell()) {
            XSSFCell cell = getXssfCell(sheet, areaReference);
            final CellType cellType = cell.getCellType();
            value = cellsTypes.get(cellType).get();
        }
        return value;
    }

    private static XSSFCell getXssfCell(XSSFSheet sheet, AreaReference areaReference) {
        CellReference cellRef = areaReference.getFirstCell();
        XSSFRow row = sheet.getRow(cellRef.getRow());
        XSSFCell cell = row.getCell(cellRef.getCol());
        return cell;
    }
}


