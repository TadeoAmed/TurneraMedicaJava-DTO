package entidades;

public class Pacientes {
	
//	String sq = "CREATE TABLE ENTIDADES.pacientes ( id INTEGER IDENTITY, nombre VARCHAR(256), apellido VARCHAR(10), dni VARCHAR(256))";
	private String id; 
	private String nombre;
	private String apellido;
	private String dni;
	private String mail;
	

	public Pacientes(String id, String nombre, String apellido, String dni, String mail) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
	}
	public Pacientes(){
		
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
