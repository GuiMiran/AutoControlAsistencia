package controlSistencia.complementos.Utiles;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import utils.TableMarcador;

public class ExcelExporter {
	@SuppressWarnings("resource")
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

