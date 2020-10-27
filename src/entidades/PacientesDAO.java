package entidades;

import java.util.List;

import excepciones.ErrorMailException;
import excepciones.IdRepetidoException;

public interface PacientesDAO {
	public void crearPaciente(Pacientes unPaciente) throws ErrorMailException,IdRepetidoException;
		
	
	
    public void actualizaPaciente(Pacientes unPaciente) throws ErrorMailException;
		  
	   
	   
	public void borrarPaciente(String id);
		
	
		 
	public List<Pacientes> muestraTodosLosPacientes();
		
	
	public Pacientes muestraPacientes(String id);

}
