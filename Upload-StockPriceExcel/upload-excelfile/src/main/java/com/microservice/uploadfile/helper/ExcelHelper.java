package com.microservice.uploadfile.helper;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microservice.uploadfile.model.StockPrice;

public class ExcelHelper {
	
	static String[] HEADERs = { "Company Code", "Stock Exchange", "Price Per Share(in Rs)", "Date", "Time" };
	static String SHEET = "Sheet1";
	
	public static boolean isRowEmpty(Row row) {
	    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != CellType.BLANK)
	            return false;
	    }
	    return true;
	}
	
	public static List<StockPrice> excelToData(InputStream is) throws IOException{
	
			Workbook workbook = new XSSFWorkbook(is);
			Iterator<Sheet> sheets = workbook.iterator();
			ArrayList<StockPrice> data = new ArrayList<StockPrice>();
			while(sheets.hasNext()) {
				Sheet sheet = sheets.next();
				Iterator<Row> rows = sheet.iterator();
//				int numRows = sheet.getPhysicalNumberOfRows();
//				System.out.println(numRows);
				
				
				int rowNumber = 0;
				
				while(rows.hasNext()) {
					Row row = rows.next();
					if(isRowEmpty(row)) {
						break;
					}
					
					//skip header
					if(rowNumber==0) {
						rowNumber++;
						continue;
					}
					
					Iterator<Cell> cellsInRow = row.iterator();
//					int cellNu = row.getPhysicalNumberOfCells();
//					System.out.println(cellNu);
					StockPrice stockPrice = new StockPrice();
					int cellIndex = 0;
					
					while(cellsInRow.hasNext()) {
						Cell currentCell = cellsInRow.next();
						
						switch(cellIndex) {
						case 0: 
//							String str1 = currentCell.getStringCellValue();
//							String str12 = str1.trim();
//							System.out.println(str12);
//							stockPrice.setCompanyId(Integer.parseInt(str12));
//							System.out.println(str1);
							stockPrice.setCompanyId((int) currentCell.getNumericCellValue());
							break;
						case 1:
							stockPrice.setStockExchange(currentCell.getStringCellValue());
							System.out.println(currentCell.getStringCellValue());
							break;
						case 2:
							stockPrice.setCurrentPrice((int)currentCell.getNumericCellValue());
							System.out.println((int)currentCell.getNumericCellValue());
							break;
						case 3:
							stockPrice.setDate(currentCell.getDateCellValue().toInstant()
											.atZone(ZoneId.systemDefault()).toLocalDate());
							System.out.println(currentCell.getDateCellValue().toInstant()
											.atZone(ZoneId.systemDefault()).toLocalDate());
							break;
						case 4:
							String str = currentCell.getStringCellValue();
							str = str.replaceAll("\\s", "");
							System.out.println(str);
							stockPrice.setTime(LocalTime.parse(str));
							break;
						default:
							break;
						}
						cellIndex++;
					}
					data.add(stockPrice);
					rowNumber++;
				}
				workbook.close();

			}
			Sheet sheet = workbook.getSheet(SHEET);
			return data;
	}
}
