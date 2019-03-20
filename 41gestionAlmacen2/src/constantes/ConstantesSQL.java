package constantes;

public class ConstantesSQL {
	
	public static final String SQL_INSERCION_CAMISETA = //MAYUS HACE REFERENCIA A CONSTANTES
			"insert into tabla_camisetas(nombre,talla,precio,material,sexo)"+" values (?,?,?,?,?)";
	
	public static final String SQL_SELECCION_CAMISETAS =
			"select * from tabla_camisetas order by id asc"; //asc orden que hemos metido
	
	public static final String SQL_BORRADO_CAMISETAS =
			"delete from tabla_camisetas where id = ?;";
	
	public static final String SQL_INSERCION_PANTALONES =
			"insert into tabla_pantalones(nombre,talla,precio,material,sexo)" + "values (?,?,?,?,?)";
	
	public static final String SQL_SELECCION_PANTALONES =
			"select * from tabla_pantalones order by id desc";
	
	public static final String SQL_BORRADO_PANTALONES =
			"delete from tabla_pantalones where id = ?;";
}
