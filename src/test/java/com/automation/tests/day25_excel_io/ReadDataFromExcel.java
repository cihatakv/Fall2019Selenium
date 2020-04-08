package com.automation.tests.day25_excel_io;

import com.automation.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws Exception {
        //we need to get a file as an object
        File file = new File("VytrackTestUsers.xlsx");
        //object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //get QA1-short
        Sheet workSheet = workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);
        //get string value
        String value = firstCell.getStringCellValue();

        System.out.println("value = " + value);

        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println("##################");

        int lastCell = firstRow.getLastCellNum();

        for (int i = 0; i < lastCell; i++) {
            System.out.print(firstRow.getCell(i) + " | ");
        }
        System.out.println();
        int numberOfRows = workSheet.getLastRowNum() + 1;
        System.out.println("numberOfRows = " + numberOfRows);
        int numberOfRows2 = workSheet.getPhysicalNumberOfRows();
        System.out.println("numberOfRows2 = " + numberOfRows2);


        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
//                System.out.print(cellValue + " | ");
                System.out.printf("%-17s", cellValue);
            }
            System.out.println();
        }

        System.out.println("###################");

        for (int i = 0; i < lastCell; i++) {
            System.out.printf("%-15s", firstRow.getCell(i));
        }
        System.out.println();
        Row secondRaw = workSheet.getRow(1);
        for (int i = 0; i < lastCell; i++) {
            System.out.printf("%-15s", secondRaw.getCell(i));
        }


    }

    @Test
    public void excelUtilityTest() {
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-All";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
//        excelUtil.getDataList().forEach(System.out::println);

    }

    @Test
    public void getColumnNamesTest() {
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);

        System.out.println(excelUtil.getColumnsNames());
    }

}
