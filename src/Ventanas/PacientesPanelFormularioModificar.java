package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Services.MedicoService;
import Services.PacientesServices;
import entidades.Medico;
import entidades.Pacientes;
import excepciones.ServicioException;

public class PacientesPanelFormularioModificar extends JPanel{
	private PanelManager m;
	private Botonera botonera;
	private JLabel tituloLbl;
	private JComboBox combo;
	private Pacientes unPaciente;
	private PacientesServices ps;

	
	
	public PacientesPanelFormularioModificar(PanelManager m) {
	        this.m = m;
	        armarFormularioModifPac();
	    }
	    
	public void armarFormularioModifPac(){
	    
		this.setLayout(new FlowLayout());
		
		botonera = new Botonera();
		combo = new JComboBox<String>();
		unPaciente = new Pacientes();
		ps = new PacientesServices();
		List<Pacientes> lista = ps.muestraTodosLosPacientes();
		tituloLbl = new JLabel("CREAR PACIENTE: Seleccione el id del paciente a modificar");
		
		for (Pacientes unPaciente: lista){
			combo.addItem(unPaciente.getId());
		}
		

			 
		
		
		this.add(botonera.getIdLbl());
		this.add(combo);
		this.add(botonera.getNombreLbl());
		this.add(botonera.getNombreTXT());
		this.add(botonera.getApellidoLbl());
		this.add(botonera.getApellidoTXT());
		this.add(botonera.getDnilbl());
		this.add(botonera.getDnitxt());
		this.add(botonera.getMaillbl());
		this.add(botonera.getMailtxt());
		this.add(tituloLbl);
		this.add(botonera.getBtnConfirmar());
		this.add(botonera.btnCancelar);
		
		 
		combo.addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent e){
	        	PacientesServices unPaciente = new PacientesServices();  
	        	String id = (String) combo.getSelectedItem(); // casteo a string el id que seleccioné del combobox y lo guardo en una variable tipo string llamada id
	        	Pacientes m1 = new Pacientes(); // creo un objeto pacientes
	        	m1.setId(id); // mediante un setter de id de la clase pacientes, seteo al objeto m1 con el id seleccionado del combobox
	            m1 = unPaciente.muestraPaciente(m1); // ahora m1 va a contenter toda la informacion que contiene el objeto en la base de daots con el id seleccionado. Nos dará, nombre, apellido, etc 
	            
	            botonera.getNombreTXT().setText(m1.getNombre());
	            botonera.getApellidoTXT().setText(m1.getApellido());
	            botonera.getDnitxt().setText(m1.getDni());
	            botonera.getMailtxt().setText(m1.getMail());	           
				
			}
		});
		
		
		
	
		
		
	    botonera.getBtnConfirmar().addActionListener(new ActionListener(){
	    	
	    public void actionPerformed(ActionEvent e){
	    		
	    	PacientesServices p = new PacientesServices();
	    	String id = (String) combo.getSelectedItem();
	    	p.setNombre(botonera.getNombreTXT().getText());
	    	p.setApellido(botonera.getApellidoTXT().getText());
	    	p.setDni(botonera.getDnitxt().getText());
	    	p.setMail(botonera.getMailtxt().getText());    	
	    	p.setId(id);
	       
	        try {
	        	
	        	
	        	
	            p.actualizaPaciente(p);
	        } catch ( ServicioException ex ) {
	            ex.printStackTrace();
	        }
	 	
	    }    		
	   });
		
	    botonera.getBtnCancelar().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("SOY CANCELAR");
	            m.mostrarPanelOpcionesADM();
	        }
	    });


	    }
	
}
