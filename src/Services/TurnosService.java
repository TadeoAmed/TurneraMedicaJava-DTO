package Services;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;

import entidades.Medico;
import entidades.Pacientes;
import entidades.Turnos;
import entidades.TurnosDAO;
import entidades.TurnosDAOImpl;
import excepciones.IdRepetidoException;
import excepciones.MedicoTurnoException;
import excepciones.ServicioException;

public class TurnosService extends Turnos{
	public void crearTurno (Medico unMedico, Pacientes unPaciente, Turnos unTurno ) throws ServicioException{
		TurnosDAO daoT = new TurnosDAOImpl();
		try{
		daoT.crearTurno(unMedico, unPaciente, unTurno);;
		} catch (MedicoTurnoException e){
			e.printStackTrace();
		} catch (IdRepetidoException e1){
			e1.printStackTrace();
		}
	}

    public void modificarTurno (Medico unMedico, Pacientes unPaciente, Turnos unTurno ) throws ServicioException{
    	TurnosDAO daoT = new TurnosDAOImpl();
		try{
    	daoT.modificarTurno(unMedico, unPaciente, unTurno);
		} catch (MedicoTurnoException e){
			e.printStackTrace();
		}
	   }
	   
    public void borrarTurnos(Turnos unTurno){
    	TurnosDAO daoT = new TurnosDAOImpl();
		daoT.borrarTurnos(unTurno.getIdTurno());
		
	}
		 
    public List<Turnos> muestraTodosLosTurnos(){
		List<Turnos> lista = new ArrayList<Turnos>(); // por que pongo primero list y despues arraylist?
		TurnosDAO daoT = new TurnosDAOImpl();
		
		lista= daoT.muestraTodosLosTurnos();
		
		return lista; 
		
	}

    public Turnos muestraTurno(Turnos unTurno){
    	Turnos t = new Turnos();
    	TurnosDAO daoT = new TurnosDAOImpl();
    	
    	try{
    		t =  daoT.muestraTurno(unTurno.getIdTurno());
    		
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	
    	return t;
    }
    
    public Integer totalMedico(Medico unMedico, Turnos unTurno, Turnos unTurno2){
    	Integer total;
    	TurnosDAO daoT = new TurnosDAOImpl();
    	total = daoT.totalMedico(unMedico, unTurno, unTurno2);
    	return total;
    }
    
}
