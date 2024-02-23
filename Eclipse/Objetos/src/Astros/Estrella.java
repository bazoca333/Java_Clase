package Astros;

import java.util.ArrayList;

public class Estrella extends Astro{
	public String color;
	public ArrayList<Planeta> arrayPlanetas;

	public Estrella(String nombre, int peso, String color) {
		super(nombre, peso);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ArrayList<Planeta> getArrayPlanetas() {
		return arrayPlanetas;
	}

	public void setArrayPlanetas(ArrayList<Planeta> arrayPlanetas) {
		this.arrayPlanetas = arrayPlanetas;
	}
	
	@Override
	public void mostrar() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Peso: " + peso);
		System.out.println("Color: " + color);
		
	}

	public void añadirPlaneta(Planeta p) {
		arrayPlanetas.add(p);
	}
	
	@Override
	public void tieneElementos() {
		if (arrayPlanetas.size() > 0) {
			System.out.println("No orbita ningún planeta en esta estrella");
		}else {
			System.out.println("Planetas en órbita:");
			for(Planeta p : arrayPlanetas) {
				System.out.println(p.nombre);
			}
		}
		
	}

}
