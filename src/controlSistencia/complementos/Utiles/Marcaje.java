package controlSistencia.complementos.Utiles;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormatSymbols;
import java.util.Calendar;

import controlSistencia.complementos.Utiles.TipoMarcaje.Tipo;

public class Marcaje {

	private String entrada;
	private int dia;
	private int anyo;
	private String mes;
	private int numMes;
	private Tipo tipo ;
	private int hora;
	private int minutos;
	private int segundos;

	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	public Marcaje(String entrada, int dia, int anyo, String mes) {
		super();
		this.entrada = entrada;
		this.dia = dia;
		this.anyo = anyo;
		this.mes = mes;
		
	}
	public Marcaje(Calendar calendar, Tipo tipo){
		this.dia=calendar.get(Calendar.DAY_OF_MONTH);
		this.numMes=calendar.get(Calendar.MONTH);
		this.mes=getMonthForInt(numMes);
		this.anyo=calendar.get(Calendar.YEAR);
		this.setHora(calendar.get(Calendar.HOUR_OF_DAY));
		this.setMinutos(calendar.get(Calendar.MINUTE));
		this.setSegundos(calendar.get(Calendar.SECOND));
		this.tipo=tipo;
	}
	String getMonthForInt(int num) {
		String month = "Error numero de mes";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (num >= 0 && num <= 11 ) {
			month = months[num];
		}
		return month;
	}

	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public int getNumMes() {
		return numMes;
	}
	public void setNumMes(int numMes) {
		this.numMes = numMes;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	/*
	public void serializeJson(){



		//Object to JSON in file
		mapper.writeValue(new File("c:\\marcaje.json"), this);

		//Object to JSON in String
		String jsonInString = mapper.writeValueAsString(this);


	}*/
	public void escribirFicehro(String linea){	
		FileWriter fichero = null;
		PrintWriter pw = null;
		try
		{
			fichero = new FileWriter("c:/grabacionDatos.txt");
			pw = new PrintWriter(fichero);

		//	for (int i = 0; i < 10; i++)
				pw.println(linea);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para 
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	
}
		
	
	
	
	


