package entidades;


public class Turnos {
	
	

private String hora;
private String fecha;
public String getmId() {
	return mId;
}

public void setmId(String mId) {
	this.mId = mId;
}

public String getpId() {
	return pId;
}

public void setpId(String pId) {
	this.pId = pId;
}
private String idTurno;
private String mId,mNombre,mApellido,pId,pNombre,pApellido,pDni;

//private Pacientes idP = new Pacientes();


public Turnos() {
	// TODO Auto-generated constructor stub
}

public Turnos(String idTurno, String mId, String mNombre, String mApellido, String pId, String pNombre, String pApellido,
		String pDni, String hora, String fecha) {
	super();
	this.hora = hora;
	this.fecha = fecha;
	this.idTurno = idTurno;
	this.mId = mId;
	this.mNombre = mNombre;
	this.mApellido = mApellido;
	this.pId = pId;
	this.pNombre = pNombre;
	this.pApellido = pApellido;
	this.pDni = pDni;
}

public void setIdTurno(String idTurno) {
	this.idTurno = idTurno;
}
public String getIdTurno() {
	return idTurno;
}



//public void setPacienteId(Pacientes idP){
//	this.pacienteId = idP.getId();
//}

//public String getPacienteId(){
//	return pacienteId;
//}

public String getmNombre() {
	return mNombre;
}

public void setmNombre(String mNombre) {
	this.mNombre = mNombre;
}

public String getmApellido() {
	return mApellido;
}

public void setmApellido(String mApellido) {
	this.mApellido = mApellido;
}

public String getpNombre() {
	return pNombre;
}

public void setpNombre(String pNombre) {
	this.pNombre = pNombre;
}

public String getpApellido() {
	return pApellido;
}

public void setpApellido(String pApellido) {
	this.pApellido = pApellido;
}

public String getpDni() {
	return pDni;
}

public void setpDni(String pDni) {
	this.pDni = pDni;
}

public String getHora() {
	return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}



}
