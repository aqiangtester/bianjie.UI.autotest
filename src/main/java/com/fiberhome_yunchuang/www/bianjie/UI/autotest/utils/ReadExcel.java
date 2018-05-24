package com.fiberhome_yunchuang.www.bianjie.UI.autotest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private static final String XLS = "xls";
	private static final String XLSX = "xlsx";

	Workbook wb = null;

	/*
	 * 实例化WorkBook对象
	 */
	public ReadExcel(String filePath) {
		super();
		File file = null;
		FileInputStream in = null;
		try {
			file = new File(filePath);
			in = new FileInputStream(file);
			checkExcel(file);
			wb = getWorkBook(in, file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	
	/*
	 * 判断excel版本，拿到WorkBook对象
	 * 
	 */
	private Workbook getWorkBook(InputStream in, File file) throws IOException {
		Workbook wb = null;
		if (file.getName().endsWith(XLS)) {
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(XLSX)) {
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}
	

	/*
	 * 判断文件是否存在，及格式是否正确
	 */
	private void checkExcel(File file) throws Exception {
		if (!file.exists()) {
			throw new Exception("文件不存在！");
		}
		if (!(file.isFile() && (file.getName().endsWith(XLS) || file.getName().endsWith(XLSX)))) {
			throw new Exception("不是Excel文件！");
		}
	}
	

	/*
	 * 遍历出所有的sheet对象
	 */
	public List<Sheet> getSheetLists() {
		List<Sheet> sheetLists = new ArrayList<Sheet>();
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			Sheet sheet = wb.getSheetAt(i);
			sheetLists.add(sheet);
		}
		return sheetLists;
	}

	
	/*
	 * 获取当前sheet内的总列数，如果第一行为空，则返回0
	 */
	public int getTotalColumnNums(Sheet sheet) {
		if (sheet.getRow(0) != null) {
			int totalColumnNums = sheet.getRow(0).getPhysicalNumberOfCells();
			return totalColumnNums;
		}
		return 0;
	}
	

	/*
	 * 获取某一列的所有cell内的值,除去第一个列名
	 */
	public List<String> getColumnCell(Sheet sheet, int columnNo) {
		List<String> columnCells = new ArrayList<String>();
		int totalRowNums = sheet.getLastRowNum() + 1;
		System.out.println(totalRowNums);
		for (int j = 2; j < totalRowNums + 1; j++) {
			List<String> rowCells = getRowCell(sheet, j);
			String cellValue = rowCells.get(columnNo-1);
			columnCells.add(cellValue);
		}
		return columnCells;
	}

	
	
	/*
	 * 获取某一行的所有cell内的值
	 */
	public List<String> getRowCell(Sheet sheet, int rowNo) {

		List<String> rowCells = new ArrayList<String>();
		Row row = sheet.getRow(rowNo - 1);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i);
			String rowCell = getCellValue(cell);
			rowCells.add(rowCell);
		}
		return rowCells;
	}

	
	// 获取单元格的值
	private String getCellValue(Cell cell) {
		String cellValue = "";
		DataFormatter formatter = new DataFormatter();
		if (cell != null) {
			// 判断单元格数据的类型，不同类型调用不同的方法
			switch (cell.getCellType()) {
			// 数值类型
			case Cell.CELL_TYPE_NUMERIC:
				// 进一步判断 ，单元格格式是日期格式
				if (DateUtil.isCellDateFormatted(cell)) {
					cellValue = formatter.formatCellValue(cell);
				} else {
					// 数值
					double value = cell.getNumericCellValue();
					int intValue = (int) value;
					cellValue = value - intValue == 0 ? String.valueOf(intValue) : String.valueOf(value);
				}
				break;
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			// 判断单元格是公式格式，需要做一种特殊处理来得到相应的值
			case Cell.CELL_TYPE_FORMULA: {
				try {
					cellValue = String.valueOf(cell.getNumericCellValue());
				} catch (IllegalStateException e) {
					cellValue = String.valueOf(cell.getRichStringCellValue());
				}

			}
				break;
			case Cell.CELL_TYPE_BLANK:
				cellValue = "";
				break;
			case Cell.CELL_TYPE_ERROR:
				cellValue = "";
				break;
			default:
				cellValue = cell.toString().trim();
				break;
			}
		}
		return cellValue.trim();
	}

	

	/*
	 * 遍历出所有的行
	 */
	private List<Row> getRowList(Sheet sheet) {
		List<Row> rowList = new ArrayList<Row>();

		// 获取总行数
		int totalRowNums = sheet.getLastRowNum() + 1;

		// 遍历所有行
		for (int i = 0; i < totalRowNums; i++) {
			Row row = sheet.getRow(i);
			rowList.add(row);
		}
		return rowList;
	}

}
