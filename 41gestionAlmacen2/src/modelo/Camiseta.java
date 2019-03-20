package modelo;

public class Camiseta {
	
	private String nombre;
	private String tamano;
	private double precio;
	private String material;
	private String sexo;
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	//metodos de acceso; 
	//metodo de acceso para nombre:
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return this.nombre;
	}
	// como nombre es un campo interno si se necesita asignarle un nuevo valor habrá que usar setNmbre
	//si se quiere obtener habra que usar getNombre

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	

	public String toString() {
		return "Camiseta [nombre=" + nombre + ", tamano=" + tamano
				+ ", precio=" + precio + ", material=" + material + ", sexo="
				+ sexo + ", id=" + id + "]";
	}
	
	
	// el metodo que devuelve un string con la informacion de una camiseta es el toString 
	// toString es un metodo muy comun que devuelve un String de un objeto
	
	//resto de setters y getters se generan de manera auto con eclipse
	
}// end class
