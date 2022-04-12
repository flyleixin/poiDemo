package com.leixin;

import com.leixin.dao.Overall;
import com.leixin.dao.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SourceMain {
//    public static void main(String[] args) throws IOException {
//
//        List<Product> readList= read(path);
//      //  System.out.println(readList);
//        for (Product product : readList) {
//            System.out.println(product);
//        }
//
//        String outPath = "C:\\Users\\泪心\\Desktop\\out.xlsx";
//        Integrate.write(readList,outPath);
//        System.out.println("成功");
//    }


    /*

     */

    public static List<Overall> read (String path) throws IOException {
        List<Overall> overallList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(path);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();

        XSSFRow row0 = sheet.getRow(0);
        if(row0!=null){
            Integrate.titleColumn.clear();
            for(int j = 0;j<=row0.getLastCellNum();j++){
                XSSFCell cell = row0.getCell(j);
                if (cell != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String value = cell.getStringCellValue();
                    if (value != null && (!"".equals(value))) {
                        Integrate.titleColumn.add(value);
                    }
                }
            }
        }


        for(int i = 1;i<=lastRowNum;i++){
            XSSFRow row = sheet.getRow(i);
            if(row!=null){
              List<String> list = new ArrayList<>();
              ArrayList<Double> newList = new ArrayList<>();
                short lastCellNum = row.getLastCellNum();

                for(int j = 0;j<=lastCellNum;j++) {

                        XSSFCell cell = row.getCell(j);
                        if (cell != null) {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String value = cell.getStringCellValue();
                            if (value != null && (!"".equals(value))) {
                                if(j<=6){
                                    list.add(value);
                                }
                                else {
                                    newList.add(Double.parseDouble(value));
                                }
                            }
                        }


                }



                if(list.size()>0) {
                    Overall overall = new Overall(Integer.parseInt(list.get(0)), list.get(1), Integer.parseInt(list.get(2)), list.get(3), list.get(4), list.get(5), list.get(6),newList);
                    overallList.add(overall);

//                    Product products = new Product(Integer.parseInt(list.get(0)), list.get(1), Integer.parseInt(list.get(2)), list.get(3), list.get(4), list.get(5), list.get(6));
//                    productList.add(products);

                }
            }
        }
        return overallList;
    }

}

