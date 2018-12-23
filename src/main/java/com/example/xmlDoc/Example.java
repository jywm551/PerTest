package com.example.xmlDoc;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Example {


    public static void main(String[] args) throws IOException {
        try {
            // 读取Excel
            Workbook wb = new XSSFWorkbook(
                    new FileInputStream(
                            new File("C:\\Users\\Mloong\\Desktop\\询问单原始数据.xlsx")));

            // 获取sheet数目
            for (int t = 0; t < wb.getNumberOfSheets(); t++) {
                Sheet sheet = wb.getSheetAt(t);
                Row row = null;
                int lastRowNum = sheet.getLastRowNum();

                // 循环读取
                for (int i = 1; i <= lastRowNum; i++) {
                    row = sheet.getRow(i);
                    if (row != null) {
                        // 获取每一列的值
                        for (int j = 0; j < row.getLastCellNum(); j++) {
                            Cell cell = row.getCell(j);
                            String value = getCellValue(cell);
                            if (!value.equals("")) {
                                System.out.print(value + ",");
                            }
                        }
                        System.out.println();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static String getCellValue(Cell cell) {
        Object value = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case 0: // 数字
                    value = cell.getNumericCellValue() + "";
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        if (date != null) {
                            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        } else {
                            value = "";
                        }
                    } else {
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case 1: // 字符串
                    value = cell.getStringCellValue();
                    break;
                case 4: // Boolean
                    value = cell.getBooleanCellValue() + "";
                    break;
                case 2: // 公式
                    value = cell.getCellFormula() + "";
                    break;
                case 3: // 空值
                    value = "";
                    break;
                case 5: // 故障
                    value = "非法字符";
                    break;
                default:
                    value = "未知类型";
                    break;
            }
        }
        return value.toString();
    }
}

