package modelo;

import java.util.ArrayList;

public interface PantalonDAO { //Preguntar ma�ana
	
	void registrarPantalon (Pantalon pantalon);
	ArrayList<Pantalon> obtenerPantalon();
	void borrarPantalon (long idPantalon);

}
