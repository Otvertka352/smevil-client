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
import java.util.Optional;
import java.util.function.Supplier;

@UtilityClass
public class ExcelUtil {
    public static XSSFWorkbook getWorkbook(byte[] file){
        ByteArrayInputStream inputStream = new ByteArrayInputStream(file);
        try {
            return new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Optional<AreaReference> getAreaReference(XSSFName field) {
        try {
            return Optional.of(new AreaReference(field.getRefersToFormula(), SpreadsheetVersion.EXCEL2007));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    public static Optional<XSSFCell> getXssfCell(XSSFName field, XSSFSheet sheet) {

        final Optional<AreaReference> areaReference = getAreaReference(field);

        Optional<XSSFCell> cell = Optional.empty();

        if (areaReference.isPresent() && areaReference.get().isSingleCell()) {
            CellReference cellRef = areaReference.get().getFirstCell();
            XSSFRow row = sheet.getRow(cellRef.getRow());
            cell = Optional.of(row.getCell(cellRef.getCol()));
        }
        return cell;
    }


}


