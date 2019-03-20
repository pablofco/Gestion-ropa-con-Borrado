package modelo;

import java.util.ArrayList;

public class CamisetasDAOImplMock implements CamisetasDAO{
	
	private static ArrayList<Camiseta> camisetas = new ArrayList<Camiseta>();
			//significa dato unico en la clase y no va variar su definicion de objeto

	public void registrarCamiseta(Camiseta camiseta){
		camisetas.add(camiseta);
	}


	@Override
	public ArrayList<Camiseta> obtenerCamiseta() {
	
		return camisetas;
	}

	@Override
	public void borrarCamiseta(long idCamiseta) {
		// TODO Auto-generated method stub
		
	}
}
