package Services;

import java.util.ArrayList;
import java.util.List;
import entidades.Medico;
import entidades.MedicoDAO;
import entidades.MedicoDAOImpl;
import entidades.Pacientes;
import entidades.PacientesDAO;
import entidades.PacientesDAOIMPL;
import excepciones.ErrorMailException;
import excepciones.IdRepetidoException;
import excepciones.ServicioException;

public class PacientesServices extends Pacientes {

	public void crearPaciente(Pacientes unPaciente) throws ServicioException{
		PacientesDAO daoP = new PacientesDAOIMPL();
		try {
		daoP.crearPaciente(unPaciente);
		} catch (ErrorMailException e){
			System.out.println("No se pudo dar de alta el usuario " + e.getMessage());
		} catch(IdRepetidoException ex){
			System.out.println("No se pudo dar de alta el usuario " + ex.getMessage());
		}
	}
	
    public void actualizaPaciente(Pacientes unPaciente) throws ServicioException{
		PacientesDAO daoP = new PacientesDAOIMPL();	
		try {
			daoP.actualizaPaciente(unPaciente);
			} catch (ErrorMailException e){
				e.printStackTrace();
			}
	   }
	   
	public void borrarPaciente(Pacientes unPaciente){
		PacientesDAO daoP = new PacientesDAOIMPL();
		daoP.borrarPaciente(unPaciente.getId());
		
	}
		 
	public List<Pacientes> muestraTodosLosPacientes(){
		List<Pacientes> lista = new ArrayList<Pacientes>(); // por que pongo primero list y despues arraylist?
		PacientesDAO daoP = new PacientesDAOIMPL();	
		
		lista=daoP.muestraTodosLosPacientes();
		
		return lista; 
		
	}

    public Pacientes muestraPaciente(Pacientes unPaciente){
    	Pacientes p = new Pacientes();
    	PacientesDAO daoP = new PacientesDAOIMPL();
    	
    	try{
    		p =  daoP.muestraPacientes(unPaciente.getId());
    		
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	
    	return p;
    }
    
	
}
