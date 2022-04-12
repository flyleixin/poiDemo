package com.leixin;

import com.leixin.dao.Attendance;
import com.leixin.dao.NotAttendance;
import com.leixin.dao.Overall;
import com.leixin.dao.Product;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import until.MyUntil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Integrate {
    public static List <String> titleColumn = new ArrayList<>();
    public static void main(String[] args) throws IOException, ParseException {




        //这个路径是腾讯课堂导出的表格路径
        String newPath = "C:\\Users\\泪心\\Desktop\\算法引论—俊采星驰创新实践班2022线上课程-373153036-3295726fe447.xlsx";
        //这个路径是excel输出的路径
        String outPath ="C:\\Users\\泪心\\Desktop\\out.xlsx";


        List<Attendance> attendances = NewOne.read(newPath);
        List<Overall> overallList = SourceMain.read("src/main/resources/1.xlsx");
        List<NotAttendance> notAttendances = new ArrayList<>();

        if(titleColumn.contains(NewOne.sheetName)==true){

            System.out.println("名称为  \""+NewOne.sheetName+"\"  的表格已经记过考勤了哦！");
            System.exit(0);
        }else{
            titleColumn.add(NewOne.sheetName);

        }

        for (Overall overall : overallList) {
            ArrayList<Double> everyStatus = overall.getEveryStatus();
            everyStatus.add(Double.parseDouble("0.0"));
        }
        for (Attendance attendance : attendances) {
            //该人在腾讯会议的名字
            String nickname = attendance.getNickName();
            int flag = 0;
            //number -- 参加的人的实际学号
            int number = MyUntil.findNum(nickname);
            //duration 该人出席的时间
            double duration = MyUntil.StrToDate(attendance.getDuration());
            double status;
            //
            if(duration<50){
                //缺勤
                status = 0;
            }
            if(50<=duration&&duration<=80){
                //半勤
                status = 0.5;
            }
            else{
                //全勤
                status = 1.0;
            }
            for (Overall overall : overallList) {
               if(overall.getStudentId()==number){
                   flag = 1;
                   ArrayList<Double> everyStatus = overall.getEveryStatus();
                   everyStatus.set(everyStatus.size()-1,status);
               }
            }
            if(flag == 0){
                notAttendances.add(new NotAttendance(nickname,duration,status));
            }
        }

        System.out.println("---------------");
        System.out.println("下面同学可能学号写错或者昵称不包含学号");
        for (NotAttendance notAttendance : notAttendances) {

            System.out.println(notAttendance);

        }
        writeResult(overallList,outPath);

    }
    public static int cur;

    public static void writeResult (List<Overall> overallList, String path) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = xssfWorkbook.createSheet("俊采星驰创新实践班考勤表");
        //设置宽度
        sheet.setColumnWidth(0, 10*256);
        sheet.setColumnWidth(2, 12*256);
        sheet.setColumnWidth(3, 18*256);
        sheet.setColumnWidth(4, 18*256);
        sheet.setColumnWidth(5, 18*256);
        sheet.setColumnWidth(6, 18*256);
        for(int i = 7;i<titleColumn.size();i++){
            sheet.setColumnWidth(i, 15*256);
        }

        XSSFRow row = sheet.createRow(0);

        cur = row.getLastCellNum();
        for(int i = 0;i<titleColumn.size();i++){
            row.createCell(i).setCellValue(titleColumn.get(i));

        }
          XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
//       //单元格样式
//        cellStyle.setFillBackgroundColor(IndexedColors.PINK.getIndex());
//        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
       //字体样式
        XSSFFont font = xssfWorkbook.createFont();
        font.setFontName("黑体");
        //font.setColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFont(font);
        //设置居中
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for(int i = 0;i<overallList.size();i++){
            XSSFRow row1 = sheet.createRow(i + 1);
            XSSFCell cell0 = row1.createCell(0);
            cell0.setCellValue(overallList.get(i).getSid().toString());
            cell0.setCellStyle(cellStyle);

            XSSFCell cell = row1.createCell(1);
            cell.setCellValue(overallList.get(i).getName());
            cell.setCellStyle(cellStyle);
            XSSFCell cell1 = row1.createCell(2);
            cell1.setCellValue(overallList.get(i).getStudentId().toString());
            cell1.setCellStyle(cellStyle);
            XSSFCell cell2 = row1.createCell(3);
            cell2.setCellValue(overallList.get(i).getProfession());
            cell2.setCellStyle(cellStyle);
            XSSFCell cell3 = row1.createCell(4);
            cell3.setCellValue(overallList.get(i).getPhone());
            cell3.setCellStyle(cellStyle);
            XSSFCell cell4 = row1.createCell(5);
            cell4. setCellValue(overallList.get(i).getCollege());
            cell4.setCellStyle(cellStyle);
            XSSFCell cell5 = row1.createCell(6);
            cell5.setCellValue(overallList.get(i).getDirection());
            cell5.setCellStyle(cellStyle);
                for(int j = 7;j<titleColumn.size();j++){
                    XSSFCell cell6 = row1.createCell(j);
                    cell6.setCellValue(overallList.get(i).getEveryStatus().get(j-7));
                    cell6.setCellStyle(cellStyle);
                }


        }
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.flush();

        FileOutputStream fileOutputStream2 = new FileOutputStream("src/main/resources/1.xlsx");
        xssfWorkbook.write(fileOutputStream2);
        fileOutputStream2.flush();
        fileOutputStream2.close();

        fileOutputStream.close();
        xssfWorkbook.close();
        System.out.println("考勤成功！");
    }


}


