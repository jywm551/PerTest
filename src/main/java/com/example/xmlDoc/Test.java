package com.example.xmlDoc;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class Test {
    public static void main(String[] args) {
        try{
            Workbook wb = new XSSFWorkbook(
                    new FileInputStream(
                            new File("C:\\Users\\Mloong\\Desktop\\询问单原始数据.xlsx")));
            Sheet sheet;
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {//获取每个Sheet表
                sheet = wb.getSheetAt(i);
                for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {//获取每行
                    Row row = sheet.getRow(j);
                    for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {//获取每个单元格
                        System.out.print(row.getCell(k) + "\t");
                    }
                    System.out.println("---Sheet表" + i + "处理完毕---");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
