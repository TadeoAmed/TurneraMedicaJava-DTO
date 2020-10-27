package Services;

import java.util.ArrayList;
import java.util.List;

import entidades.Medico;
import entidades.MedicoDAO;
import entidades.MedicoDAOImpl;

import excepciones.IdRepetidoException;
import excepciones.ServicioException;

public class MedicoService extends Medico {


	public void MedicoService(){
		
	}


	public void crearMedico(Medico unMedico) throws ServicioException{
		MedicoDAO daoM = new MedicoDAOImpl();
		try {
			daoM.crearMedico(unMedico);
		} catch (IdRepetidoException e) {
            e.printStackTrace();
		}
	}

	
	
	public void actualizaMedico(Medico unMedico) throws ServicioException{
		
		
		MedicoDAO daoM = new MedicoDAOImpl();
		try{
			daoM.actualizaMedico(unMedico);
		} catch (Exception e) {
            throw new ServicioException(e);		
			
		}
		
		
		
	}
	
	
	
	public void borraMedico(Medico unMedico) throws ServicioException{
		MedicoDAO daoM = new MedicoDAOImpl();
		try{
			daoM.borraMedico(unMedico.getCodId());
		} catch (Exception e) {
			
            throw new ServicioException(e);
		}
		
	}
	
	
	
    public List<Medico> muestraTodosLosMedicos() {
    	List<Medico> lista = new ArrayList<Medico>();
    	MedicoDAO dao = new MedicoDAOImpl();
        try{
    	lista=dao.muestraTodosLosMedicos();
        } catch (Exception e){
          e.printStackTrace();
        }

        return lista;
    }


    public Medico muestraMedico(Medico unMedico){
    	Medico medi = new Medico();
    	MedicoDAO daoM = new MedicoDAOImpl();
    	
    	try{
    		medi =  daoM.muestraMedico(unMedico.getCodId());
    		
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	
    	return medi;
    }
    



}
