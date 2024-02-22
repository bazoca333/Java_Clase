package ejercicio_practica;

public class Animal {
	private String nombre;
	private String color;
	private int edad;
	private String sexo;


	public Animal(String nombre, String color, int edad, String sexo) {
		this.nombre = nombre;
		this.color = color;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	public void imprimir() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Color: " + this.color);
		System.out.println("Edad: " + this.edad);
		System.out.println("Sexo: " + this.sexo);

	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
