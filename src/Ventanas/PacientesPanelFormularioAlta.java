package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Services.MedicoService;
import Services.PacientesServices;
import entidades.Medico;
import entidades.Pacientes;
import excepciones.ServicioException;

public class PacientesPanelFormularioAlta extends JPanel{
   
private PanelManager m;
private Botonera botonera;
private JLabel tituloLbl;

PacientesServices ps;

	public PacientesPanelFormularioAlta(PanelManager m) {
        this.m = m;
        armarFormularioAltaPac();
    }
    
public void armarFormularioAltaPac(){
    
	this.setLayout(new FlowLayout());
	
	boolean repetido = false;
	ps = new PacientesServices();
	botonera = new Botonera();
	tituloLbl = new JLabel("CREAR PACIENTE");
	

	
	

	
	for (Integer i = 1000; i < 1100; ++i){ // como automatizar la cantidad de pacientes. Ahora yo estoy poniendo hasta 1100, pero si tengo mas de 100 pacientes? Puedo crear un metodo que se mllame aumentar, que le sume 1 al segundo indice cada vez que apreto el boton " crear " 
		

		List<Pacientes> lista = ps.muestraTodosLosPacientes();
			for (Pacientes unPaciente: lista){
				String idPaciente = unPaciente.getId();	
				Integer ind= Integer.parseInt(idPaciente);
				if (i == ind ){
						
						repetido = true;		 
					}
				}
			
			if (repetido == false){
				String in = Integer.toString(i);
				botonera.getComboIdP().addItem(in);
			}
			

		 }
	
	
	
	this.add(botonera.getIdLbl());
	this.add(botonera.getComboIdP());
	this.add(botonera.getNombreLbl());
	this.add(botonera.getNombreTXT());
	this.add(botonera.getApellidoLbl());
	this.add(botonera.getApellidoTXT());
	this.add(botonera.getDnilbl());
	this.add(botonera.getDnitxt());
	this.add(botonera.getMaillbl());
	this.add(botonera.getMailtxt());
	this.add(botonera.getBtnConfirmar());
	this.add(botonera.getBtnCancelar());
	
	
	
    botonera.getBtnConfirmar().addActionListener(new ActionListener(){
    	
    public void actionPerformed(ActionEvent e){
    		
    	PacientesServices p = new PacientesServices();
    	String idp = (String) botonera.getComboIdP().getSelectedItem();
    	p.setId(idp);
    	p.setNombre(botonera.getNombreTXT().getText());
    	p.setApellido(botonera.getApellidoTXT().getText());
    	p.setDni(botonera.getDnitxt().getText());
    	p.setMail(botonera.getMailtxt().getText());    	
       
        try {
        	
            p.crearPaciente(p);
        } catch ( ServicioException e1 ) {
        	System.out.println("Hubo un error en el ingreso de datos" + e1.getMessage());
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
