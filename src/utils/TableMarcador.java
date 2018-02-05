package utils;


import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import controlSistencia.complementos.Utiles.Marcaje;

	public class TableMarcador extends JPanel{

	    
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTable table;
		private List<Marcaje> liData;

	    public List<Marcaje> getLiData() {
			return liData;
		}
		public void setLiData(List<Marcaje> liData) {
			this.liData = liData;
		}
		public JTable getTable() {
			return table;
		}
		public void setTable(JTable table) {
			this.table = table;
		}
		public TableMarcador() throws FileNotFoundException{
			String [] header={"Tipo", "fecha", "hora", "Segundos"};
			
			Gson gson = new Gson();
			java.lang.reflect.Type listType = new TypeToken<ArrayList<Marcaje>>() {}.getType();
			String msj="[{\"dia\":5,\"anyo\":2018,\"mes\":\"febrero\",\"numMes\":1,\"tipo\":\"COMIDA\",\"hora\":21,\"minutos\":2,\"segundos\":43}]";
			BufferedReader br = new BufferedReader(
				     new FileReader("Output.json"));

			liData = gson.fromJson(br, listType); // contains the whole reviews list
			System.out.println(liData.size()); 
			String [][] newData = new String[30][4];
	        for (Marcaje marcajeElement : liData) {
	        	newData[liData.indexOf(marcajeElement)][0]=marcajeElement.getTipo().toString();
	        	newData[liData.indexOf(marcajeElement)][1]=marcajeElement.getMes().toString();
	        	newData[liData.indexOf(marcajeElement)][2]=""+marcajeElement.getHora();
	        	newData[liData.indexOf(marcajeElement)][3]=""+marcajeElement.getMinutos();
			}
	        String [][] data={{"","","",""}};
	        		/*{"ENTRADA"," "},
	        				  {"COMIDA"," "},
	        				  {"REGRESO"," "},
	        				  {"SALIDA"," "}
	        				  };
*/

	        DefaultTableModel model = new DefaultTableModel(newData,header);

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
	    	try (Writer writer = new FileWriter("D:\\Output.json")) {
			    Gson gson = new GsonBuilder().create();
			    gson.toJson(liHoras, writer);
			} catch (IOException e) {
			Logger.getLogger(e.getMessage());
				e.printStackTrace();
			}
	    }
		

	}

