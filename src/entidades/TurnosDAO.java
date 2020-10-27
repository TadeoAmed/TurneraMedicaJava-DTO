package entidades;

import java.util.List;

import excepciones.IdRepetidoException;
import excepciones.MedicoTurnoException;

public interface TurnosDAO {
	public void crearTurno (Medico unMedico, Pacientes unPaciente, Turnos unTurno ) throws MedicoTurnoException, IdRepetidoException;
    public void modificarTurno (Medico unMedico, Pacientes unPaciente, Turnos unTurno ) throws MedicoTurnoException;
    public void borrarTurnos(String id);
    public List<Turnos> muestraTodosLosTurnos();
    public Turnos muestraTurno(String id); 
    public Integer totalMedico(Medico unMedico, Turnos unTurno, Turnos unTurno2);
}
