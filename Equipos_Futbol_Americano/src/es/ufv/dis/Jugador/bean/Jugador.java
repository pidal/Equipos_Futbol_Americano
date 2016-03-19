package es.ufv.dis.Jugador.bean;



public class Jugador {

	private String nombre;
	private String apellidos;
	private String equipo;
	private String posicion;
	private String dorsal;
	private String salario;

	
	public Jugador() {
		super();
		
	}


	public Jugador(String nombre, String apellidos, String equipo, String posicion,String dorsal, String salario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.equipo = equipo;
		this.posicion = posicion;
		this.dorsal = dorsal;
		this.salario = salario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEquipo() {
		return equipo;
	}


	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}


	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}


	public String getDorsal() {
		return dorsal;
	}


	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}
	
	public String getSalario(){
		return salario;
	}
	
	public void setSalario(String salario){	
		this.salario = salario;
	}

}

