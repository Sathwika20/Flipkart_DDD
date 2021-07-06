package com.bridgelabz.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExcelUtils {
    static String projectPath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath,String sheetName){
        try {
            projectPath = System.getProperty("user.dir");
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public  int getRowCount() {
        int RowCount = 0;
        try {

            RowCount = sheet.getPhysicalNumberOfRows();
            //RowCount = sheet.getLastRowNum();
            System.out.println("Number of rows : "+RowCount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return RowCount;
    }
    public  int getColCount() {
        int ColCount = 0;
        try {

            ColCount = sheet.getRow(0).getPhysicalNumberOfCells();
//            ColCount = sheet.getRow(0).getLastCellNum();
            System.out.println("Number of columns : "+ColCount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return ColCount;
    }
    public  String getCellData(int rowNum,int colNum) {
        String cellData = null;
        try {
            DataFormatter dataFormatter = new DataFormatter();
        //getRow returns a row and getCell returns the cell value representing a column
        cellData = dataFormatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
            /*cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();*/
            System.out.println("Data is : "+cellData);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();

        }
        return cellData;

    }
}
