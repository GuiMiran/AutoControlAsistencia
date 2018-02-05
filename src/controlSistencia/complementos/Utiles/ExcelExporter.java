package controlSistencia.complementos.Utiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.ss.usermodel.Workbook;

import utils.TableMarcador;

public class ExcelExporter {

	//	private static void writeToExcell(JTable table, Path path) throws FileNotFoundException, IOException {
	//	    new WorkbookUtil();
	//	    Workbook wb = new Workbook(path); //Excell workbook
	//	    Sheet sheet = wb.createSheet(); //WorkSheet
	//	    Row row = sheet.createRow(2); //Row created at line 3
	//	    TableModel model = table.getModel(); //Table model
	//
	//
	//	    Row headerRow = sheet.createRow(0); //Create row at line 0
	//	    for(int headings = 0; headings < model.getColumnCount(); headings++){ //For each column
	//	        headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
	//	    }
	//
	//	    for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
	//	        for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
	//	            row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
	//	        }
	//
	//	        //Set the row to the next one in the sequence 
	//	        row = sheet.createRow((rows + 3)); 
	//	    }
	//	    wb.write(new FileOutputStream(path.toString()));//Save the file     
	//	}

	public void exportTable(TableMarcador jTable1,String file) throws IOException{

		try {
			Workbook wb = new HSSFWorkbook();

			wb.getCreationHelper();
			Sheet sheet = (Sheet) wb.createSheet("new sheet");
			Row row = null;
			Cell cell = null;

			TableModel model=jTable1.getTable().getModel();
			for (int i=0;i<model.getRowCount();i++) {
				row = sheet.createRow(i);
				for (int j=0;j<model.getColumnCount();j++) {

					cell = row.createCell(j);
					System.out.println(model.getValueAt(i, j));
					cell.setCellValue(model.getValueAt(i, j).toString() );
				}
			}
			FileOutputStream out = new FileOutputStream(file);
			wb.write(out);
			out.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ExcelExporter.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ExcelExporter.class.getName()).log(Level.SEVERE, null, ex);
		}

	}


}

