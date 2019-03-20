package modelo;

import java.util.ArrayList;

public class  PantalonDAOImplMock implements PantalonDAO{
	
	private static ArrayList<Pantalon> pantalones = new ArrayList<Pantalon>();
	
	public void registrarPantalon (Pantalon pantalon){
		pantalones.add(pantalon);
	}
	
	public ArrayList<Pantalon> obtenerPantalon(){ //preguntar si hay un atajo o doble click 
		return pantalones;
	}
	public void borrarPantalon (int idPantalon){
		
	}

	@Override
	public void borrarPantalon(long idPantalon) {
		// TODO Auto-generated method stub
		
	}

}
