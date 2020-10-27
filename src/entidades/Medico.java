package entidades;

import java.util.List;

import excepciones.ServicioException;

public class Medico  {

	private String codId;
	private String nombre;
	private String apellido;
	private String pw;
	private String tipoPerfil;
	private String montoConsulta;
	
	
public Medico (){
	
}

	public Medico(String codId, String nombre, String apellido, String pw, String tipoPerfil, String montoConsulta) {
		super();
		this.codId = codId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pw = pw;
		this.tipoPerfil = tipoPerfil;
		this.montoConsulta = montoConsulta;
	}
	public String getMontoConsulta() {
		return montoConsulta;
	}
	public void setMontoConsulta(String montoConsulta) {
		this.montoConsulta = montoConsulta;
	}
	public String getTipoPerfil() {
		return tipoPerfil;
	}
	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
	public String getCodId() {
		return codId;
	}
	public void setCodId(String codId) {
		this.codId = codId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	

	
}
