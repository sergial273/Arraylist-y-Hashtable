package tarea2;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
public class Tarea2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,ArrayList<Double>> bd = new Hashtable<String,ArrayList<Double>>();
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
				+ "1. Añadir compra \n"
				+ "2. Mostrar elementos\n"
				+ "3. Salir\n");
		int sel = Integer.parseInt(dia);
		while (sel < 1 || sel>3) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Que quieres hacer?\n"
					+ "1. Añadir compra \n"
					+ "2. Mostrar elementos\n"
					+ "3. Salir\n");
			sel = Integer.parseInt(dia);
		}
		return sel;
	}
	
	public static void mostrarTodo(Hashtable<String,ArrayList<Double>> bd) {
		Enumeration<String> llaves = bd.keys();
		System.out.println("----------------------------------------------");
		while(llaves.hasMoreElements()) {
			String elem = llaves.nextElement();
			System.out.println("ID prod: " + elem);
			System.out.println("IVA: "+ bd.get(elem).get(0));
			System.out.println("Precio bruto: "+ bd.get(elem).get(1));
			double precioConIva = bd.get(elem).get(1)*(1+bd.get(elem).get(0)/100);
			System.out.println("Precio con IVA: "+ precioConIva);
			System.out.println("Articulos comprados: "+ bd.get(elem).get(2));
			double pagado = bd.get(elem).get(2)*precioConIva;
			System.out.println("Cantidad pagada: "+ pagado);
			System.out.println("Cambio a devolver: "+ (bd.get(elem).get(3)- pagado) );
			System.out.println("----------------------------------------------");
		}
	}
	
	public static void anadirVal(Hashtable<String,ArrayList<Double>> bd) {
		ArrayList<Double> lista = new ArrayList<>();
		
		String prod = JOptionPane.showInputDialog("Id de la compra:");
		
		String dia = JOptionPane.showInputDialog("IVA a aplicar (4 o 21):");
		double iva = Double.parseDouble(dia);
		while (iva != 4 && iva != 21) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("IVA a aplicar (4 o 21):");
			iva = Double.parseDouble(dia);
		}
		dia = JOptionPane.showInputDialog("Precio del producto:");
		double precio = Double.parseDouble(dia);
		while (precio < 0) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Precio del producto:");
			precio = Double.parseDouble(dia);
		}
		
		dia = JOptionPane.showInputDialog("Número de articulos comprados:");
		double art = Double.parseDouble(dia);
		while (art < 0) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Número de articulos comprados:");
			art = Double.parseDouble(dia);
		}
		
		dia = JOptionPane.showInputDialog("Cantidad pagada:");
		double cant = Double.parseDouble(dia);
		while (cant < 0) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Cantidad pagada:");
			cant = Double.parseDouble(dia);
		}
		
		
		lista.add(iva);
		lista.add(precio);
		lista.add(art);
		lista.add(cant);
		
		if (bd.containsKey(prod)){
			bd.replace(prod, lista);
		}
		else {
			bd.put(prod, lista);
		}
		
	}

}
