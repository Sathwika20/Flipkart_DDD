package com.bridgelabz.utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;


public class ReadExcelFile {
    @DataProvider(name = "data-provider")
    public static Object[][] testData() throws IOException {
        ExcelUtils excel = new ExcelUtils("C:\\Users\\gopir\\IdeaProjects\\Flipkart_DDD\\ExcelData.xlsx", "Sheet1");
        int RowCount = excel.getRowCount();
        int ColumnCount = excel.getColCount();
        Object[][] data = new Object[RowCount - 1][ColumnCount];

        for(int i=1;i<RowCount;i++){

            for(int j=0;j<ColumnCount;j++){
                String cellData = excel.getCellData(i,j);
                System.out.print(cellData+" | ");
                data[i-1][j] = cellData;
            }
            System.out.println();
        }
        return data;
    }

}
