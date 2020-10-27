package entidades;

import java.util.List;

import excepciones.IdRepetidoException;

public interface MedicoDAO {

		
		void crearMedico(Medico unMedico) throws IdRepetidoException;

		void actualizaMedico(Medico unMedico);
		
		void borraMedico(String id);
		
	    public List<Medico> muestraTodosLosMedicos();

	    public Medico muestraMedico(String codId);
	


}
