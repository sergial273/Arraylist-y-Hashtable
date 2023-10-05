package tarea4;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
public class Tarea4{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Crear los 10 elementos manualmente de stock
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
		
		Hashtable<String,ArrayList<Double>> bdCaj = new Hashtable<String,ArrayList<Double>>();
		while(true) {
			int el = mostrarMenuPrincipal();
			switch(el) {
			case 1: //Controlar stock/precio
				while(true) {
					boolean salida = false;
					int elec = mostrarMenuCont();
					switch(elec) {
					case 1:
						anadirValCont(bd);
						break;
					case 2:
						mostrarTodoCont(bd);
						break;
					case 3:
						salida = true;
						break;
					}
					if (salida) {break;}
				}
				break;
			case 2: //Modo cajero
				while(true) {
					boolean salida = false;
					int elec = mostrarMenu();
					switch(elec) {
					case 1:
						anadirVal(bdCaj, bd);
						break;
					case 2:
						mostrarTodo(bdCaj);
						break;
					case 3:
						salida = true;
						break;
					}
					if (salida) {break;}
				}
				break;
				
			case 3:
				System.exit(0);
			}
		}
		
		
	}
	
	public static int mostrarMenuPrincipal() {
		String dia = JOptionPane.showInputDialog("Que quieres hacer?\n"
				+ "1. Control de productos \n"
				+ "2. Modo cajero\n"
				+ "3. Salir\n");
		int sel = Integer.parseInt(dia);
		while (sel < 1 || sel>3) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Que quieres hacer?\n"
					+ "1. Control de productos \n"
					+ "2. Modo cajero\n"
					+ "3. Salir\n");
			sel = Integer.parseInt(dia);
		}
		return sel;
	}
	
	public static int mostrarMenu() {
		String dia = JOptionPane.showInputDialog("(CAJERO) Que quieres hacer?\n"
				+ "1. Añadir compra \n"
				+ "2. Mostrar elementos\n"
				+ "3. Salir\n");
		int sel = Integer.parseInt(dia);
		while (sel < 1 || sel>3) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("(CAJERO) Que quieres hacer?\n"
					+ "1. Añadir compra \n"
					+ "2. Mostrar elementos\n"
					+ "3. Salir\n");
			sel = Integer.parseInt(dia);
		}
		return sel;
	}
	
	public static int mostrarMenuCont() {
		String dia = JOptionPane.showInputDialog("(CONTROl) Que quieres hacerAAA?\n"
				+ "1. Añadir elemento y cantidad \n"
				+ "2. Mostrar elementos\n"
				+ "3. Salir\n");
		int sel = Integer.parseInt(dia);
		while (sel < 1 || sel>3) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("(CONTROL) Que quieres hacerAAA?\n"
					+ "1. Añadir elemento y cantidad \n"
					+ "2. Mostrar elementos\n"
					+ "3. Salir\n");
			sel = Integer.parseInt(dia);
		}
		return sel;
	}
	
	public static void mostrarTodoCont(Hashtable<String,Double[]> bd) {
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
	
	public static void anadirValCont(Hashtable<String,Double[]> bd) {
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
	
	public static void anadirVal(Hashtable<String,ArrayList<Double>> bd, Hashtable<String,Double[]> bdPrec) {
		ArrayList<Double> lista = new ArrayList<>();
		
		String prod = JOptionPane.showInputDialog("Nombre del producto:");
		while(!bdPrec.containsKey(prod)) { //comprobamos que el producto exista
			prod = JOptionPane.showInputDialog("Nombre del producto:");
		}
		
		String dia = JOptionPane.showInputDialog("Número de articulos comprados:");
		double art = Double.parseDouble(dia);
		while (art < 0) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Número de articulos comprados:");
			art = Double.parseDouble(dia);
		}
		while (bdPrec.get(prod)[1] < art) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Número de articulos comprados:");
			art = Double.parseDouble(dia);
		}
		
		bdPrec.get(prod)[1] = bdPrec.get(prod)[1] - art;
		
		
		dia = JOptionPane.showInputDialog("IVA a aplicar (4 o 21):");
		double iva = Double.parseDouble(dia);
		while (iva != 4 && iva != 21) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("IVA a aplicar (4 o 21):");
			iva = Double.parseDouble(dia);
		}
		/**
		 * En lugar de pedir el precio lo cogemos de la lista de la bd de stock
		dia = JOptionPane.showInputDialog("Precio del producto:");
		double precio = Double.parseDouble(dia);
		while (precio < 0) {
			JOptionPane.showMessageDialog(null,"Valor no vàlido");
			dia = JOptionPane.showInputDialog("Precio del producto:");
			precio = Double.parseDouble(dia);
		}
		**/
		double precio = bdPrec.get(prod)[0];
		
		
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
