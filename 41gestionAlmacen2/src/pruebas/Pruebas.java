package pruebas;

import modelo.Camiseta;

public class Pruebas {

	public static void main(String[] args) {
		
		Camiseta c = new Camiseta();
		// lo siguiente no puedo hacerlo porque nombre es algo interno de una camiseta, es private
//		c.nombre = 'deportiva';
		c.setNombre("camiseta deportiva");
		System.out.println("nombre de la camiseta: " + c.getNombre());
	}

}
