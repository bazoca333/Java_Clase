package Astros;

import java.util.ArrayList;

public class Planeta extends Astro {
	public String tipo;
	public ArrayList<Satelite> arraySatelites;
	public Planeta(String nombre, int peso, String tipo) {
		super(nombre, peso);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Satelite> getArraySatelites() {
		return arraySatelites;
	}

	public void setArraySatelites(ArrayList<Satelite> arraySatelites) {
		this.arraySatelites = arraySatelites;
	}

	@Override
	public void mostrar() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Peso: " + peso);
		System.out.println("Tipo: " + tipo);
		
	}
	
	public void añadirSatelites(Satelite s) {
		
	}

	@Override
	public void tieneElementos() {
		
		
	}
}
