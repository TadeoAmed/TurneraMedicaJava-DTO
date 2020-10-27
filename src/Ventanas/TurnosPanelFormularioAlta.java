package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import Services.MedicoService;
import Services.PacientesServices;
import Services.TurnosService;
import entidades.Medico;
import entidades.Pacientes;
import entidades.Turnos;
import excepciones.ServicioException;



public class TurnosPanelFormularioAlta extends JPanel{
	private PanelManager m;
	private Botonera botonera;
	private JLabel tituloLbl;
	private Turnos turno;
	private TurnosService ts;
	private Pacientes unPaciente;
	private PacientesServices ps;
	private Medico unMedico;
	private MedicoService ms;

	
	public TurnosPanelFormularioAlta(PanelManager m) {
	        this.m = m;
	        armarFormularioAltaTur();
	    }
	
		
	public void	armarFormularioAltaTur(){
		this.setLayout(new FlowLayout());
		
		botonera = new Botonera();
		turno = new Turnos();
		ts = new TurnosService();
		ps = new PacientesServices();
		ms = new MedicoService ();
		
		List<Medico> listaM = ms.muestraTodosLosMedicos();
		List<Pacientes> listaP = ps.muestraTodosLosPacientes();
		
		
		
		for (Medico unMedico: listaM){
			botonera.getComboIdM().addItem(unMedico.getCodId());
		}
		
		for (Pacientes unPaciente: listaP){
			botonera.getComboIdP().addItem(unPaciente.getId());
			
		}
		
		botonera.combohora();
		botonera.combominuto();
		
		
		tituloLbl = new JLabel("CREAR TURNO");
		
		this.add(botonera.getIdLbl());
		this.add(botonera.getidTXT());
		this.add(botonera.getIdMLbl());
		this.add(botonera.getComboIdM());
		this.add(botonera.getIdPLbl());
		this.add(botonera.getComboIdP());
		this.add(botonera.getNombreMLbl());
		this.add(botonera.getNombreMTXT());
		this.add(botonera.getApellidoMLbl());
		this.add(botonera.getApellidoMTXT());
		this.add(botonera.getNombrePLbl());
		this.add(botonera.getNombrePTXT());
		this.add(botonera.getApellidoPLbl());
		this.add(botonera.getApellidoPTXT());
		this.add(botonera.getDnilbl());
		this.add(botonera.getDnitxt());
		this.add(botonera.getFechalbl());
     	//this.add(botonera.getFechatxt());
		this.add(botonera.getDate_chooser());
		botonera.getDate_chooser().setDateFormatString("yyyy-MM-dd");
		this.add(botonera.getHoralbl());
		this.add(botonera.getCombo());
		this.add(botonera.getCombo2());
		this.add(botonera.getBtnConfirmar());
		this.add(botonera.getBtnCancelar());
		
		
		botonera.getComboIdP().addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent e){
	        	PacientesServices unPaciente = new PacientesServices();  
	        	String id = (String) botonera.getComboIdP().getSelectedItem(); // casteo a string el id que seleccioné del combobox y lo guardo en una variable tipo string llamada id
	        	Pacientes m1 = new Pacientes(); // creo un objeto pacientes
	        	m1.setId(id); // mediante un setter de id de la clase pacientes, seteo al objeto m1 con el id seleccionado del combobox
	            m1 = unPaciente.muestraPaciente(m1); // ahora m1 va a contenter toda la informacion que contiene el objeto en la base de daots con el id seleccionado. Nos dará, nombre, apellido, etc 
	            
	            botonera.getNombrePTXT().setText(m1.getNombre());
	            botonera.getApellidoPTXT().setText(m1.getApellido());	
	            botonera.getDnitxt().setText(m1.getDni());
	            
			}
		});
		
		botonera.getComboIdM().addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent e){
	        	MedicoService unMedico = new MedicoService();  
	        	String id = (String) botonera.getComboIdM().getSelectedItem(); // casteo a string el id que seleccioné del combobox y lo guardo en una variable tipo string llamada id
	        	Medico m1 = new Medico(); // creo un objeto pacientes
	        	m1.setCodId(id); // mediante un setter de id de la clase pacientes, seteo al objeto m1 con el id seleccionado del combobox
	            m1 = unMedico.muestraMedico(m1); // ahora m1 va a contenter toda la informacion que contiene el objeto en la base de daots con el id seleccionado. Nos dará, nombre, apellido, etc 
	            
	            botonera.getNombreMTXT().setText(m1.getNombre());
	            botonera.getApellidoMTXT().setText(m1.getApellido());
	            
			}
		});
		
	    botonera.getBtnConfirmar().addActionListener(new ActionListener(){
	    	
	    public void actionPerformed(ActionEvent e){
	    		
	    	TurnosService t = new TurnosService();
	    	Medico m = new Medico();
	    	Pacientes p = new Pacientes();
	    	String idP = (String) botonera.getComboIdP().getSelectedItem();
	    	String idM = (String) botonera.getComboIdM().getSelectedItem();
         	SimpleDateFormat strf = new SimpleDateFormat("yyyy-MM-dd");
	    	String fecha =strf.format(botonera.getDate_chooser().getDate());
	    	
	    	String hora = botonera.ArmarHora(botonera.getCombo(), botonera.getCombo2());

	    	m.setCodId(idM);
	    	m.setNombre(botonera.getNombreMTXT().getText());
	    	m.setApellido(botonera.getApellidoMTXT().getText());
	
	    	p.setId(idP);
	    	p.setNombre(botonera.getNombrePTXT().getText());
	    	p.setApellido(botonera.getApellidoPTXT().getText());    	
	    	p.setDni(botonera.getDnitxt().getText());
	    	t.setFecha(fecha);
	    	t.setHora(hora);
         	t.setIdTurno(botonera.getidTXT().getText());
         	
	       
	        try {
	        	
	        	
	        	
	            t.crearTurno(m, p, t);
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
