package utils;


import java.awt.Dimension;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controlSistencia.complementos.Utiles.Marcaje;

	public class TableMarcador extends JPanel{

	    
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTable table;
	    public JTable getTable() {
			return table;
		}
		public void setTable(JTable table) {
			this.table = table;
		}
		public TableMarcador(){

	        String [] header={"Tipo", "fecha", "hora", "Segundos"};
	        String [][] data={{"","","",""}};
	        		/*{"ENTRADA"," "},
	        				  {"COMIDA"," "},
	        				  {"REGRESO"," "},
	        				  {"SALIDA"," "}
	        				  };
*/

	        DefaultTableModel model = new DefaultTableModel(data,header);

	        table = new JTable(model);

	        table.setPreferredScrollableViewportSize(new Dimension(450,120));
	        table.setFillsViewportHeight(true);
	        
	        table.setRowHeight(30);

	        JScrollPane js=new JScrollPane(table);
	        js.setVisible(true);
	        add(js);

	    }
	    public void mostrar(List<Marcaje> liHoras) {
	    	escribirArchivo(liHoras);
	    	Object matris[][]=new Object[liHoras.size()][4];
			for (int i = 0; i < liHoras.size(); i++) {
				matris[i][0]=liHoras.get(i).getTipo();
				matris[i][1]=liHoras.get(i).getDia()+"/"+liHoras.get(i).getMes()+"/"+liHoras.get(i).getAnyo();
				matris[i][2]=liHoras.get(i).getHora();
				matris[i][3]=liHoras.get(i).getMinutos()+","+liHoras.get(i).getSegundos();
			}
			
			this.table.setModel(new DefaultTableModel(
					matris,
					new String[] {
						"Tipo", "fecha", "hora", "Segundos"
					}
				));
			
		}
	    
	    private void escribirArchivo(List<Marcaje> liHoras){
	    	try (Writer writer = new FileWriter("C:\\Output.json")) {
			    Gson gson = new GsonBuilder().create();
			    gson.toJson(liHoras, writer);
			} catch (IOException e) {
			Logger.getLogger(e.getMessage());
				e.printStackTrace();
			}
	    }
		

	}

