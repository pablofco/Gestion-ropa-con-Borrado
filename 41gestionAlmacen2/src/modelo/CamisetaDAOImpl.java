package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

import constantes.ConstantesConexion;
import constantes.ConstantesSQL;

//DAO data access object (clase que va a registrar,editar,listar y realizar) una serie de operaciones
// de camisetas sobre la base de datos
public class CamisetaDAOImpl implements CamisetasDAO {

	public CamisetaDAOImpl() {
		// esto se debería hacer en una clase fuera dedicada a preparar
		// configuraciones y conexiones con una base de datos.
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("***NO ENCUENTRO EL DRIVER DE MYSQL***");
		} // dejamos puntero arriba forname (surround with try/catch)
	}

	private Connection obtenerConexion() {
		Connection conexion = null;

		try {
			conexion = DriverManager.getConnection(
					ConstantesConexion.URL_CONEXION,
					ConstantesConexion.USUARIO, ConstantesConexion.PASS);
		} catch (SQLException e) {
			System.out.println("***NO PUDE CONECTARME A LA BASE DE DATOS***");
			System.out.println(e.getMessage());
		}
		return conexion;
	}

	public void registrarCamiseta(Camiseta camiseta) {

		Connection conexion = obtenerConexion();

		// lanzar SQL a la base de datos para insertar camisetas
		String sql = ConstantesSQL.SQL_INSERCION_CAMISETA;
		// asi no concatenas en ningun lado
		PreparedStatement instruccion = null;
		try {
			instruccion = conexion.prepareStatement(sql);
			instruccion.setString(1, camiseta.getNombre());
			instruccion.setString(2, camiseta.getTamano());
			instruccion.setDouble(3, camiseta.getPrecio());
			instruccion.setString(4, camiseta.getMaterial());
			instruccion.setDouble(5, camiseta.getPrecio());
		} catch (SQLException e) {
			System.out.println("NO PUDE OBTENER EL STATEMENT");
		}

		try {
			instruccion.executeUpdate();
		} catch (SQLException e) {
			System.out.println("NO SE PUDO HACER EL EXECUTE");
			System.out.println(e.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("no pude cerrar conexion");
		}
	}

	public ArrayList<Camiseta> obtenerCamiseta() {
		ArrayList<Camiseta> camisetas = new ArrayList<Camiseta>();
		// vamos a meter en camisetas una camiseta para cada fila devuelta por
		// la base de datos.
		Connection conexion = obtenerConexion();
		String sql = ConstantesSQL.SQL_SELECCION_CAMISETAS;
		Statement instruccion = null;

		try {
			instruccion = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("no puedo crear statement");
		}
		try {
			ResultSet rs = instruccion.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));
				Camiseta c = new Camiseta();
				
				c.setNombre(rs.getString("nombre"));
				c.setTamano(rs.getString("talla"));
				c.setPrecio(rs.getDouble("precio"));
				c.setMaterial(rs.getString("material"));
				c.setSexo(rs.getString("sexo"));
				c.setId(rs.getLong("id"));
				camisetas.add(c);
			}
		} catch (SQLException e) {
			System.out.println("no puedo obtener result set");
			e.printStackTrace();
		}

		return camisetas;
	}

	public void borrarCamiseta(long idCamiseta) {
		
		Connection conexion = obtenerConexion();

		// lanzar SQL a la base de datos para borrar camisetas
		String sql = ConstantesSQL.SQL_BORRADO_CAMISETAS;
		// asi no concatenas en ningun lado
		PreparedStatement instruccion = null;
		try {
			instruccion = conexion.prepareStatement(sql);
			instruccion.setLong(1, idCamiseta);
			
		} catch (SQLException e) {
			System.out.println("NO PUDE OBTENER EL STATEMENT");
		}

		try {
			instruccion.executeUpdate();
		} catch (SQLException e) {
			System.out.println("NO SE PUDO HACER EL EXECUTE");
			System.out.println(e.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("no pude cerrar conexion");
		}
	}

	}


