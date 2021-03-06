package sorec.evaluation.task.apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
public class App {

	public HSSFWorkbook writeExcelFile(String filename) {

		FileOutputStream out;
		try {
			out = new FileOutputStream(filename);
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Datatypes in Java");
			workbook.write(out);
			workbook.close();
			out.close();
			return workbook;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public HSSFWorkbook readExcel(String filename) {

		try {

			FileInputStream excelFile = new FileInputStream(new File(filename));
			HSSFWorkbook wb = new HSSFWorkbook(excelFile);
			return wb;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public HSSFWorkbook createNewCell(String filename) throws FileNotFoundException, IOException {

		try (FileInputStream is = new FileInputStream(new File(filename)); HSSFWorkbook wb = new HSSFWorkbook(is)) {
			File file = new File(filename);
			Sheet sheet = wb.createSheet("NewSheet");
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(1);
			cell.setCellValue("Hola");

			FileOutputStream out = new FileOutputStream(file);
			wb.write(out);
			out.close();
			return wb;

		}
	}

	public Workbook iterateCell(String filename) throws FileNotFoundException, IOException {
		try (FileInputStream is = new FileInputStream(filename); Workbook wb = new HSSFWorkbook(is)) {

			return wb;
		}

	}

	public Workbook addCellColors(String filename) throws FileNotFoundException, IOException {
		try (FileInputStream is = new FileInputStream(new File(filename)); Workbook wb = new HSSFWorkbook(is)) { // or
			File file = new File(filename);
																					// new
			// HSSFWorkbook();
			Sheet sheet = wb.createSheet("NewSheet");

			// Create a row and put some cells in it. Rows are 0 based.
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);

			// Aqua background
			CellStyle style = wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());

			cell.setCellStyle(style);
			FileOutputStream out = new FileOutputStream(file);
			wb.write(out);
			wb.close();
			out.close();
			return wb;
		}

	}

	public HSSFWorkbook createNewSheet(String filename) throws FileNotFoundException, IOException {

		try (FileInputStream is = new FileInputStream(new File(filename)); HSSFWorkbook wb = new HSSFWorkbook(is)) { // or
			File file = new File(filename);
			Sheet sheet = wb.createSheet("NewSheetNew");

			FileOutputStream out = new FileOutputStream(file);
			wb.write(out);
			out.close();
			return wb;
		}

	}

	public Workbook commentsCell(String filename) throws IOException {
		try (FileInputStream is = new FileInputStream (new File(filename));Workbook wb = new HSSFWorkbook(is)) {
			File file = new File(filename);
			CreationHelper factory = wb.getCreationHelper();
			Sheet sheet = wb.createSheet("SheetWithComment");
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);

	        ClientAnchor anchor = factory.createClientAnchor();
	        //i found it useful to show the comment box at the bottom right corner
	        anchor.setCol1(cell.getColumnIndex() + 1); //Where the comment starts
	        anchor.setCol2(cell.getColumnIndex() + 3); //Where ends
	        anchor.setRow1(cell.getRowIndex() + 1); //About rows
	        anchor.setRow2(cell.getRowIndex() + 5); 

	        Drawing drawing = sheet.createDrawingPatriarch();
	        Comment comment = drawing.createCellComment(anchor);
	        comment.setString(factory.createRichTextString("New comment"));

	        cell.setCellComment(comment);
	        FileOutputStream out = new FileOutputStream(file);
			wb.write(out);
			out.close();
			return wb;

		}
	}

	public HSSFWorkbook addCellDate(String filename) throws FileNotFoundException, IOException {
		try (HSSFWorkbook wb = new HSSFWorkbook()) {
			HSSFSheet sheet = wb.createSheet("new sheet");

			HSSFRow row = sheet.createRow(0);

		}
		return null;
	}

}
