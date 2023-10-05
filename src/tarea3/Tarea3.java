package tarea3;

import javax.swing.JOptionPane;

import java.util.Enumeration;
import java.util.Hashtable;
public class Tarea3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Crear los 10 elementos manualmente
		Hashtable<String,Double[]> bd = new Hashtable<String,Double[]>();
		Double n[] = {2.5, 3.0};
		bd.put("elemento0", n);
		bd.put("elemento1", n);
		bd.put("elemento2", n);
		bd.put("elemento3", n);
		bd.put("elemento4", n);
		bd.put("elemento5", n);
		bd.put("elemento6", n);
		bd.put("elemento7", n);
		bd.put("elemento8", n);
		bd.put("elemento9", n);
		
		
		while(true) {
			int elec = mostrarMenu();
			switch(elec) {
			case 1:
				anadirVal(bd);
				break;
			case 2:
				mostrarTodo(bd);
				break;
			case 3:
				System.exit(0);
			}
		}
		
	}

	public static int mostrarMenu() {
		String dia = JOptionPane.showInputDialog("Que quieres hacer?\n"
				+ "1. Añadir elemento y cantidad \n"
				+ "2. Mostrar elementos\n"
				+ "3. Salir\n");
		int sel = Integer.parseInt(dia);
		while (sel < 1 || sel>3) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Que quieres hacer?\n"
					+ "1. Añadir elemento y cantidad \n"
					+ "2. Mostrar elementos\n"
					+ "3. Salir\n");
			sel = Integer.parseInt(dia);
		}
		return sel;
	}
	
	public static void mostrarTodo(Hashtable<String,Double[]> bd) {
		Enumeration<String> llaves = bd.keys();
		System.out.println("----------------------------------------------");
		while(llaves.hasMoreElements()) {
			String elem = llaves.nextElement();
			System.out.println("Producto: " + elem);
			System.out.println("Precio: "+ bd.get(elem)[0]);
			System.out.println("Stock: "+ bd.get(elem)[1]);
			System.out.println("----------------------------------------------");
		}
	}
	
	public static void anadirVal(Hashtable<String,Double[]> bd) {
		Double[] lista = new Double[2];
		
		String prod = JOptionPane.showInputDialog("Nombre del articulo:");
		
		String dia = JOptionPane.showInputDialog("Precio del articulo:");
		double precio = Double.parseDouble(dia);
		while (precio < 0) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Precio del producto:");
			precio = Double.parseDouble(dia);
		}
		
		dia = JOptionPane.showInputDialog("Stock del articulo:");
		double art = Double.parseDouble(dia);
		while (art < 0) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Stock del articulo:");
			art = Double.parseDouble(dia);
		}
		
		lista[0] = precio;
		lista[0] = art;
		
		if (bd.containsKey(prod)){
			bd.replace(prod, lista);
		}
		else {
			bd.put(prod, lista);
		}
	}

}