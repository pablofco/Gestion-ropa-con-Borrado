package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import constantes.ConstantesConexion;
import constantes.ConstantesSQL;

public class PantalonDAOImpl implements PantalonDAO {

	public PantalonDAOImpl() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("***NO ENCUENTRO EL DRIVER DE SQL***");
		}
	}

	private Connection obtenerConexion() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(
					ConstantesConexion.URL_CONEXION,
					ConstantesConexion.USUARIO, ConstantesConexion.PASS);
		} catch (SQLException e) {
			System.out.println("***NO TENGO CONEXION A LA BASE***");
			System.out.println(e.getMessage());
		}
		return conexion;
	}

	@Override
	public void registrarPantalon(Pantalon pantalon) {
		Connection conexion = obtenerConexion();

		String sql = ConstantesSQL.SQL_INSERCION_PANTALONES;
		PreparedStatement instruccion = null;

		try {
			instruccion = conexion.prepareStatement(sql);
			instruccion.setString(1, pantalon.getNombre());
			instruccion.setString(2, pantalon.getTamano());
			instruccion.setDouble(3, pantalon.getPrecio());
			instruccion.setString(4, pantalon.getMaterial());
			instruccion.setString(5, pantalon.getSexo());

		} catch (SQLException e) {
			System.out.println("NO PUEDE OBTENER EL STATEMENT");
		}

		try {
			instruccion.executeUpdate();
		} catch (SQLException e) {
			System.out.println("NO SE PUDO REALIZAR EL EXECUTE");
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("NO SE CERRO LA CONEXION ");
		}
	}

	public ArrayList<Pantalon> obtenerPantalon() {
		ArrayList<Pantalon> pantalon = new ArrayList<Pantalon>();
		Connection conexion = obtenerConexion();
		String sql = ConstantesSQL.SQL_SELECCION_PANTALONES;
		Statement instruccion = null;

		try {
			instruccion = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("no puedo crear el statement");
		}

		try {
			ResultSet rs = instruccion.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));
				Pantalon c = new Pantalon();
				c.setNombre(rs.getString("nombre"));
				c.setTamano(rs.getString("talla"));
				c.setPrecio(rs.getDouble("precio"));
				c.setMaterial(rs.getString("material"));
				c.setSexo(rs.getString("sexo"));
				c.setId(rs.getLong("id"));
				pantalon.add(c);
			}
		} catch (SQLException e) {
			System.out.println("no puedo obtener result set");
			e.printStackTrace();
		}
		return pantalon;
	}

	@Override
	public void borrarPantalon(long idPantalon) {
		Connection conexion = obtenerConexion();

		// lanzar SQL a la base de datos para borrar pantalon
		String sql = ConstantesSQL.SQL_BORRADO_PANTALONES;
		// asi no concatenas en ningun lado
		PreparedStatement instruccion = null;
		try {
			instruccion = conexion.prepareStatement(sql);
			instruccion.setLong(1, idPantalon);
			
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
