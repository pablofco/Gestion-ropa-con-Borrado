package modelo;

import java.util.ArrayList;

public interface CamisetasDAO {
	void registrarCamiseta(Camiseta camiseta);
	ArrayList<Camiseta> obtenerCamiseta();
	void borrarCamiseta (long idCamiseta);
}
