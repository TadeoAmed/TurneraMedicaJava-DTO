package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entidades.Medico;
import tablaTurnos.PanelTableTur;
import tablasPacientes.PanelTablePac;
import ventanasBase.PanelTableADM;

public class PanelManager extends JPanel{
	private JFrame marco;
	private MedicoADMPanelFormulario medicoADMPanelFormulario;
	private MedicoADMPanelFormularioModif medicoADMPanelFormularioModif;
	private MedicoADMPanelFormularioBorra medicoADMPanelFormularioBorra;
	private PacientesPanelFormularioAlta pacientesPanelFormularioAlta;
	private PacientesPanelFormularioModificar pacientesPanelFormularioModificar;
	private PacientesPanelFormularioBorrar pacientesPanelFormularioBorrar;
	private TurnosPanelFormularioAlta turnosPanelFormularioAlta; 
	private TurnosPanelFormularioModif turnosPanelFormularioModif;
	private TurnosPanelFormularioBorrar turnosPanelFormularioBorrar;
	private PanelTableADM panelTableADM;
	private PanelTableTur panelTableTur;
	private PanelTablePac panelTablePac;
	private OpcionesADM opcionesADM;
	private OpcionPacientes opcionPacientes;
	private OpcionMedicos opcionMedicos;
	private OpcionTurnos opcionTurnos;
	private PantallaLogin pantallaLogin;
	private ReporteMedico reporteMedico;
	JPanel plantilla = new JPanel();

	
	public PanelManager (){
		
	}
	
	public void armar ()
	{
		
		
		
	   // plantilla.setBorder(BorderFactory.createBevelBorder(1, Color.BLUE, null)); 
		
		marco = new JFrame();
		marco.setBounds(100,100,500,500);
		
		medicoADMPanelFormulario = new MedicoADMPanelFormulario(this);
		medicoADMPanelFormularioModif = new MedicoADMPanelFormularioModif(this);
		medicoADMPanelFormularioBorra = new MedicoADMPanelFormularioBorra(this);
		pacientesPanelFormularioAlta = new PacientesPanelFormularioAlta(this);
		pacientesPanelFormularioModificar = new PacientesPanelFormularioModificar(this);
		pacientesPanelFormularioBorrar = new PacientesPanelFormularioBorrar(this);
		turnosPanelFormularioAlta = new TurnosPanelFormularioAlta(this);
		turnosPanelFormularioModif = new TurnosPanelFormularioModif(this);
		turnosPanelFormularioBorrar  = new TurnosPanelFormularioBorrar(this);
		panelTableADM = new PanelTableADM(this);
		panelTableTur = new PanelTableTur(this);
		panelTablePac = new PanelTablePac(this);
		opcionesADM = new OpcionesADM(this);
		opcionPacientes = new OpcionPacientes(this);
		opcionMedicos = new OpcionMedicos(this);
		opcionTurnos = new OpcionTurnos(this);
		pantallaLogin = new PantallaLogin(this);
		reporteMedico = new ReporteMedico(this);
		
		}



	public void mostrarPantallaLogin(){
		marco.setBounds(10,30,1250,700);
		marco.getContentPane().removeAll();
		marco.getContentPane().add(pantallaLogin);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	
	public void mostrarPanelOpcionesADM(){
			marco.setBounds(10,40,1250,700);
			marco.getContentPane().removeAll();
			marco.getContentPane().add(panelTableADM);
			marco.getContentPane().add(opcionesADM);
			marco.getContentPane().validate();
			marco.getContentPane().repaint();
		}
	
	public void mostrarPanelOpcioneMed(){
		marco.setBounds(10,40,1250,700);
		marco.getContentPane().removeAll();
		marco.getContentPane().add(opcionMedicos);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	public void mostrarPanelOpcionePac(){
		marco.setBounds(10,40,1250,700);
		marco.getContentPane().removeAll();
		marco.getContentPane().add(opcionPacientes);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	public void mostrarPanelOpcionesTur(){
		marco.setBounds(10,40,1250,700);
		marco.getContentPane().removeAll();
		marco.getContentPane().add(opcionTurnos);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	
	
		public void mostrarPanelMedicoPanelFormulario()
		{
			marco.setBounds(10,40,1250,700);
			marco.getContentPane().removeAll();
			marco.getContentPane().add(panelTableADM, BorderLayout.SOUTH);
		//marco.getContentPane().add(panelAdminMed);// 
			marco.getContentPane().add(medicoADMPanelFormulario); 
			marco.getContentPane().validate();
			marco.getContentPane().repaint();
		}
		
		
		public void mostrarPanelMedicoConsulta()
		{
			marco.setBounds(10,40,1250,700);
			marco.getContentPane().removeAll();
			marco.getContentPane().add(panelTableTur, BorderLayout.CENTER);
		//marco.getContentPane().add(panelAdminMed);// 
			marco.getContentPane().validate();
			marco.getContentPane().repaint();
		}
		 
		  public void mostrarPanelMedicoPanelFormularioModificar() {
        marco.setBounds( 10,40,1250,700 );
		marco.getContentPane().removeAll();
	//	marco.getContentPane().add(panelAdminMed, BorderLayout.NORTH );
		marco.getContentPane().add(medicoADMPanelFormularioModif);
		marco.getContentPane().add(panelTableADM, BorderLayout.SOUTH);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}


		  
	public void mostrarPanelMedicoPanelFormularioBorrar() {
        marco.setBounds( 10,40,1250,700 );
		marco.getContentPane().removeAll();
	//	marco.getContentPane().add(panelAdminMed, BorderLayout.NORTH );
		marco.getContentPane().add(medicoADMPanelFormularioBorra);
	    marco.getContentPane().add(panelTableADM, BorderLayout.SOUTH);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	
	
	public void mostrarPanelFormularioPacienteAlta()
	{
		marco.setBounds(10,40,1250,700);
		marco.getContentPane().removeAll();
	//marco.getContentPane().add(panelAdminMed);// 
		marco.getContentPane().add(pacientesPanelFormularioAlta); 
		marco.getContentPane().add(panelTablePac, BorderLayout.SOUTH);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	
	public void mostrarPanelFormularioPacienteModif()
	{
		marco.setBounds(10,40,1250,700);
		marco.getContentPane().removeAll();
	//marco.getContentPane().add(panelAdminMed);// 
		marco.getContentPane().add(pacientesPanelFormularioModificar);
		marco.getContentPane().add(panelTablePac, BorderLayout.SOUTH);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	
	public void mostrarPanelFormularioPacienteBorrar()
	{
		marco.setBounds(10,40,1250,700);
		marco.getContentPane().removeAll();
	//marco.getContentPane().add(panelAdminMed);// 
		marco.getContentPane().add(pacientesPanelFormularioBorrar); 
		marco.getContentPane().add(panelTablePac, BorderLayout.SOUTH);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	
	public void mostrarPanelFormularioTurnosAlta()
	{
		marco.setBounds(10,40,1250,700);
		marco.getContentPane().removeAll();
	//marco.getContentPane().add(panelAdminMed);// 
		marco.getContentPane().add(turnosPanelFormularioAlta); 
		marco.getContentPane().add(panelTableTur, BorderLayout.SOUTH);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	
	public void mostrarPanelFormularioTurnosModif()
	{
		marco.setBounds(10,40,1250,700);
		marco.getContentPane().removeAll();
	//marco.getContentPane().add(panelAdminMed);// 
		marco.getContentPane().add(turnosPanelFormularioModif); 
		marco.getContentPane().add(panelTableTur, BorderLayout.SOUTH);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	
	
	
	
	public void mostrarPanelFormularioTurnosBorrar()
	{
		marco.setBounds(10,40,1250,700);
		marco.getContentPane().removeAll();
	//marco.getContentPane().add(panelAdminMed);// 
		marco.getContentPane().add(turnosPanelFormularioBorrar); 
		marco.getContentPane().add(panelTableTur, BorderLayout.SOUTH);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	
	public void mostrarPanelReporteMedico()
	{
		marco.setBounds(10,40,1250,700);
		marco.getContentPane().removeAll();
	//marco.getContentPane().add(panelAdminMed);// 
		marco.getContentPane().add(reporteMedico); 
		marco.getContentPane().add(panelTableTur, BorderLayout.SOUTH);
		marco.getContentPane().validate();
		marco.getContentPane().repaint();
	}
	
	public void showFrame() {
		marco.setVisible(true);
	}

	public void cargarEditaFormulario(Medico med) {
		medicoADMPanelFormularioModif.armarFormulario();
		
	}

	
}
