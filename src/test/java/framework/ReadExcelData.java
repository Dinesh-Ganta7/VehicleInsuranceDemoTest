package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import freemarker.template.utility.DateUtil;

public class ReadExcelData {

	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {

		File file = new File(filePath);

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook workBook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workBook.getSheet(sheetName);

		int rowCount = sheet.getPhysicalNumberOfRows() - 1;

		int dataCellCount = sheet.getRow(1).getPhysicalNumberOfCells();
		Object[][] data = new Object[rowCount][dataCellCount];

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			int cellCount = row.getPhysicalNumberOfCells();

			for (int j = 0; j < cellCount; j++) {

				XSSFCell cell = row.getCell(j);
				data[i - 1][j] = getCellValue(cell);

			}

		}
		workBook.close();
		fis.close();
		System.out.println(Arrays.toString(data[0]));
		return data;

	}

	public static String getCellValue(XSSFCell cell) {

		switch (cell.getCellType()) {
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		default:
			return String.valueOf(cell.getStringCellValue());
		}
	}

}
