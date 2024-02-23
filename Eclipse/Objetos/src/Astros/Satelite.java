package Astros;

public class Satelite extends Astro {

	public boolean artificial;
	public Satelite(String nombre, int peso, boolean artificial) {
		super(nombre, peso);
		this.artificial = artificial;
	}

	public boolean isArtificial() {
		return artificial;
	}

	public void setArtificial(boolean artificial) {
		this.artificial = artificial;
	}
	
	@Override
	public void mostrar() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Peso: " + peso);
		System.out.println("Artificial: " + artificial);
		
	}

	public void esSateliteArtificial() {
		if (artificial) {
			System.out.println("El satélite es artificial");
		}else {
			System.out.println("El satélite NO es artificial");

		}
		
	}

	@Override
	public void tieneElementos() {
		
		
	}

}
