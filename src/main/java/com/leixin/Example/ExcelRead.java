package com.leixin.Example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.applet.Main;

import java.io.IOException;

/*
This is the API method provided by the official POI
 */
public class ExcelRead  {
    public static void main(String[] args) throws IOException {
        //工作薄对象
        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\泪心\\Desktop\\xl.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);
/*
        //行
        for (Row row : sheet) {
            //获取单元格
            for (Cell cell : row) {
                String value = cell.getStringCellValue();
                System.out.println(value);
            }
        }
 */
        int lastRowNum = sheet.getLastRowNum();
        //获取行
        for(int i = 0;i<=lastRowNum;i++){

            XSSFRow row = sheet.getRow(i);
            if(row!=null){
                //获取列
                short lastCellNum = row.getLastCellNum();
                for(int j = 0;j<=lastCellNum;j++){
                    XSSFCell cell = row.getCell(j);
                    if(cell!=null){
                        String value = cell.getStringCellValue();
                        System.out.println(value);
                    }

                }
            }
        }
        workbook.close();

    }


}
