package tarea1;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Tarea1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numAl = pedirAlum();
		
		int notas = pedirNumNotas();
		
		Hashtable<String,String> bd = new Hashtable<String,String>();
		
		anadirDatos(bd, numAl, notas);
		
		mostrarTodo(bd);
	}

	public static void anadirDatos(Hashtable<String,String> bd, int numAl, int notas) {
		for (int i = 0; i<numAl; i++) {
			double notMedia = 0;
			String nombre = JOptionPane.showInputDialog("Nombre del alumno:");
			for (int j = 1; j <= notas; j++) {
				String dia = JOptionPane.showInputDialog("Introduzca nota "+j+ ":");
				double num = Double.parseDouble(dia);
				
				while (num < 0 || num > 10) {
					JOptionPane.showMessageDialog(null,"Valor no vàlido");
					dia = JOptionPane.showInputDialog("Introduzca nota "+j+ ":");
					num = Integer.parseInt(dia);
				}
				notMedia = notMedia + num;
			}
			notMedia = notMedia/notas;
			if (bd.containsKey(nombre)){
				bd.replace(nombre, notMedia+"");
				i--;
			}
			else {
				bd.put(nombre, notMedia+"");
			}		
		}
	}
	
	public static int pedirAlum() {
		String dia = JOptionPane.showInputDialog("Cuantos alumnos tiene el curso?");
		int num = Integer.parseInt(dia);
		
		while (num <= 0) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Cuantos alumnos tiene el curso?");
			num = Integer.parseInt(dia);
		}
		return num;
	}
	
	public static int pedirNumNotas() {
		String dia = JOptionPane.showInputDialog("Cuantas notas por alumno quiere introducir?");
		int num = Integer.parseInt(dia);
		
		while (num <= 0) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Cuantas notas por alumno quiere introducir?");
			num = Integer.parseInt(dia);
		}
		return num;
	}

	public static void mostrarTodo(Hashtable<String,String> bd) {
		Enumeration<String> llaves = bd.keys();
		Enumeration<String> valores = bd.elements();
		System.out.println("Listado de alumnos y notas medias:");
		while(llaves.hasMoreElements()) {
			System.out.println(llaves.nextElement() + ": "+ valores.nextElement());
		}
	}
}