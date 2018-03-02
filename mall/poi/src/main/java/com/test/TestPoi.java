package com.test;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestPoi {

    public static  void write() {
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet first = book.createSheet("first");
        HSSFRow row = first.createRow(0);
        row.createCell(0).setCellValue("sdfsaf");
        row.createCell(1).setCellValue(999);
        try {
            book.write(new File("f:/tt/first.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void read() {
        HSSFWorkbook book = null;

        try {
            book = new HSSFWorkbook(new FileInputStream(new File("F:/tt/first.xls")));
            HSSFSheet sheet = book.getSheetAt(0);
            for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                HSSFRow row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    HSSFCell cell = row.getCell(j);
                    System.out.println(cell.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //write();
        read();
    }
}
































