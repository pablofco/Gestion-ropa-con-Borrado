package modelo;

import java.util.ArrayList;

public interface PantalonDAO { //Preguntar mañana
	
	void registrarPantalon (Pantalon pantalon);
	ArrayList<Pantalon> obtenerPantalon();
	void borrarPantalon (long idPantalon);

}
