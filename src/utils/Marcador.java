package utils;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;

import controlSistencia.complementos.Utiles.ExcelExporter;
import controlSistencia.complementos.Utiles.Marcaje;
import controlSistencia.complementos.Utiles.TipoMarcaje;
import controlSistencia.complementos.Utiles.TipoMarcaje.Tipo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.invoke.SerializedLambda;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

import java.awt.Font;

public class Marcador extends JFrame {

	private JPanel contentPane;
	private JTextField textHora;
	private TableMarcador table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marcador frame = new Marcador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Marcador() {
		setTitle("Tempo GUIDO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 474);
		contentPane = new JPanel();
//		boolean entrada=true;
//		boolean comida=false;
		List<Marcaje> liHoras=new ArrayList<Marcaje>();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);	
		textHora = new JTextField();
		textHora.setColumns(10);	
		table = new TableMarcador();
		
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.setSurrendersFocusOnKeystroke(true);
//		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		table.setFillsViewportHeight(true);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"asdas", null, null, null},
//				{null, null, null, null},
//				{null, null, null, null}
//			},
//			new String[] {
//				"Tipo", "fecha", "hora", "Segundos"
//			}
//		));
//				
//		table.setRowHeight(30);
//		table.setFillsViewportHeight(true);
//		JScrollPane js =new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		js.setVisible(true);
//table.setRowHeight(30);		

		
		
		JButton btnEntrada = new JButton("Entrada");
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Calendar calendar = Calendar.getInstance();
//			if (entrada==true){entrada=false;
//			}else
//				{entrada=true;}
			//comida?false:true;
			
			
			Marcaje marcaje=new Marcaje(calendar, Tipo.ENTRADA);
			//SerializedLambda gson = new Gson();
			 //Gson gson = new Gson()	 ;
			liHoras.add(marcaje);
				textHora.setText("la"+marcaje.getTipo()+"del: "+marcaje.getDia()+"de"+marcaje.getMes()+"del"+marcaje.getAnyo()
						+"time"+marcaje.getHora()+":"+marcaje.getMinutos());
				System.out.println(liHoras.size());
				//btnEntrada.setVisible(false);
				table.mostrar(liHoras);
				
			}

			public void mostrar() {
				Object matris[][]=new Object[liHoras.size()][4];
				for (int i = 0; i < liHoras.size(); i++) {
					matris[i][0]=liHoras.get(i).getTipo();
					matris[i][1]=liHoras.get(i).getDia();
					matris[i][2]=liHoras.get(i).getHora();
					matris[i][3]=liHoras.get(i).getMinutos();
				}
				
				
				
				
			}
			
		});
		
		JButton btnComida = new JButton("Comida");
		btnComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar calendar = Calendar.getInstance();
//				if (entrada==true){entrada=false;
//				}else
//					{entrada=true;}
				//comida?false:true;
				
				
				Marcaje marcaje=new Marcaje(calendar, Tipo.COMIDA);
				//SerializedLambda gson = new Gson();
				 //Gson gson = new Gson()	 ;
				liHoras.add(marcaje);
					textHora.setText("la"+marcaje.getTipo()+"del: "+marcaje.getDia()+"de"+marcaje.getMes()+"del"+marcaje.getAnyo());
					System.out.println(liHoras.size());
//					btnComida.setVisible(false);
//					btnComida.setVisible(true);
					table.mostrar(liHoras);
				
			}
			
		});
		
		JButton btnFinComida = new JButton("Fin Comida");
		btnFinComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar calendar = Calendar.getInstance();
//				if (entrada==true){entrada=false;
//				}else
//					{entrada=true;}
				//comida?false:true;
				
				
				Marcaje marcaje=new Marcaje(calendar, Tipo.REGRESO);
				//SerializedLambda gson = new Gson();
				 //Gson gson = new Gson()	 ;
				liHoras.add(marcaje);
					textHora.setText("la"+marcaje.getTipo()+"del: "+marcaje.getDia()+"de"+marcaje.getMes()+"del"+marcaje.getAnyo());
					System.out.println(liHoras.size());
					//btnFinComida.setVisible(false);
					table.mostrar(liHoras);
					//btnSalida.setVisible(true);
					
			}
			
		});
		
		JButton btnSalida = new JButton("Salida");	
		btnSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar calendar = Calendar.getInstance();
//				if (entrada==true){entrada=false;
//				}else
//					{entrada=true;}
				//comida?false:true;
				
				
				Marcaje marcaje=new Marcaje(calendar, Tipo.SALIDA);
				//SerializedLambda gson = new Gson();
				 //Gson gson = new Gson()	 ;
				liHoras.add(marcaje);
					textHora.setText("la"+marcaje.getTipo()+"del: "+marcaje.getDia()+"de"+marcaje.getMes()+"del"+marcaje.getAnyo());
					System.out.println(liHoras.size());
//					btnSalida.setVisible(false);
//					btnEntrada.setVisible(true);
					table.mostrar(liHoras);
			}
			
		});
		
		JButton btnExportToExcel = new JButton("Export to EXCEL");
		btnExportToExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ExcelExporter ex = new ExcelExporter();
			try {
				ex.exportTable(table, "D:\\workbook.xls");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		JLabel lblHora = new JLabel("hola");
		lblHora.setFont(new Font("Times New Roman", Font.ITALIC, 39));
		Timer SimpleTimer = new Timer(1000, new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //jLabel1.setText(SimpleDay.format(new Date()));
		        //jLabel2.setText(SimpleDate.format(new Date()));
		    	Calendar calendar= Calendar.getInstance();
		        lblHora.setText(calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
		    }
		});
		SimpleTimer.start();

		
		
		
		
		


		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textHora, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnExportToExcel)
									.addComponent(table, GroupLayout.PREFERRED_SIZE, 594, GroupLayout.PREFERRED_SIZE)))
							.addGap(66))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnSalida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEntrada, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnFinComida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnComida, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
							.addComponent(lblHora, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addGap(21))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHora, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSalida))
							.addGap(32)
							.addComponent(btnExportToExcel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEntrada)
								.addComponent(btnComida))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFinComida)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnEntrada, btnComida, btnFinComida, btnSalida});
		contentPane.setLayout(gl_contentPane);
	}
}
