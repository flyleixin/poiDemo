package com.leixin;

import com.leixin.dao.Attendance;
import com.leixin.dao.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewOne {
    /*
    This path refers to the path of
    the latest attendance sheet

    And

    you should make sure that  the attendance sheet is the data sheet of Tencent Conference
    --2022.4.10
    */
    public static String sheetName;

    public static List<Attendance> read (String path) throws IOException {
        List<Attendance> AttendanceList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(path);
        XSSFSheet sheet = workbook.getSheetAt(0);
        sheetName=sheet.getSheetName();
        int lastRowNum = sheet.getLastRowNum();
        for(int i = 9;i<=lastRowNum;i++){
            XSSFRow row = sheet.getRow(i);
            if(row!=null){
                List<String> list = new ArrayList<>();
                for (Cell cell : row) {
                    if(cell!=null){
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String value = cell.getStringCellValue();
                        if(value!=null&&(!"".equals(value))){
                            list.add(value);
                        }

                    }
                }
                if(list.size()>0) {
                    Attendance attendance = new Attendance(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
                    AttendanceList.add(attendance);
                }
            }
        }
        return AttendanceList;
    }

}

