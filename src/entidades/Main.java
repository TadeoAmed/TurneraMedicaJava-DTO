package entidades;

import java.util.List;

import Ventanas.PanelManager;

public class Main {

	private PanelManager manager;

//agregar un boton que actualice la info de la tabla.
// porque cuando apreto en la tabla me queda seleccionado?  eso lo explico guido en la clase 
// hacer un parseint del montoconsulta cuando quiera hacer suma

	
// EXCEPCIONES: 



	public static void main(String [] args) {
	


		Main ppal = new Main();
		ppal.iniciarManager();
		ppal.showFrame();
	
	}
		
		
		
		public void iniciarManager() {
			manager = new PanelManager();
			manager.armar();
			manager.mostrarPantallaLogin();
			//manager.mostrarPanelMedicoPanelFormularioBorrar();
			//manager.mostrarUnPanel();
			//manager.mostrarPruebaPanel();
		}
		
		
		
		public void showFrame() {
			manager.showFrame();
		}
		
		
	
}
		/*
		MedicoDAO daoM = new MedicoDAOImpl ();
	

		int codId = 01;
		String nombre = "Martin";
		String apellido = "Lopez";
		int pw = 1234;
		boolean administrador = true;
		int montoConsulta = 1000;
		Medico mInsertar = new Medico(); // creo un objeto de clase Medico donde guardare los set de la clase en cuestion. Paso el objeto creado como parametro en le metodo de crearMedico
		mInsertar.setCodId(codId);
		mInsertar.setNombre(nombre);
		mInsertar.setApellido(apellido);
		mInsertar.setPw(pw);
		mInsertar.setAdministrador(administrador);
		mInsertar.setMontoConsulta(montoConsulta);
		daoM.crearMedico(mInsertar);
		
	
*/
