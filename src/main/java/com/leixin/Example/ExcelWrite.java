package com.leixin.Example;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
This is the API method provided by the official POI
 */
public class ExcelWrite {
    public static void main(String[] args) throws IOException {
        //创建工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet("工作表一");
       //创建行
        XSSFRow row = sheet.createRow(0);
        //创建单元格
        row.createCell(0).setCellValue("嘿嘿");
        row.createCell(1).setCellValue("哈哈");
        row.createCell(2).setCellValue("嘎嘎");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("嘿嘿");
        row1.createCell(1).setCellValue("哈哈");
        row1.createCell(2).setCellValue("嘎嘎");

        FileOutputStream out = new FileOutputStream("C:\\Users\\泪心\\Desktop\\out.xlsx");
        workbook.write(out);
        out.flush();

        out.close();
        workbook.close();

        System.out.println("写入成功");

    }
}
