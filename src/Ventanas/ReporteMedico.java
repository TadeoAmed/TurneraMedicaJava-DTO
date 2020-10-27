package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Services.MedicoService;
import Services.TurnosService;
import entidades.Medico;
import entidades.Turnos;

public class ReporteMedico extends JPanel {

	private PanelManager m;
	private Botonera botonera;	
	private Turnos unTurno;
	private Turnos unTurno2;
	private Medico unMedico;
	private MedicoService ms;
	private JLabel tituloLbl;

	public ReporteMedico(PanelManager m) {
	    this.m = m;
	    armarReporteMedico();
	}
		

	public void armarReporteMedico (){
		
		this.setLayout(new FlowLayout());

		botonera = new Botonera();
		unTurno = new Turnos();
		unTurno2 = new Turnos();
		unMedico = new Medico();
		tituloLbl = new JLabel("Seleccione el id del medico que necesite consultar y el rango de fechas");
		ms = new MedicoService();
		JLabel totallbl = new JLabel( "Total Recaudado:" );
		List<Medico> lista = ms.muestraTodosLosMedicos() ;
		
		
		for (Medico unMedico: lista){
			botonera.getCombo().addItem(unMedico.getCodId());
		}
		this.add(tituloLbl);
		this.add(botonera.getIdLbl());
		this.add(botonera.getCombo());
		this.add(botonera.getFechalbl());
		this.add(botonera.getFechatxt());
		this.add(botonera.getFechalbl());
		this.add(botonera.getFechatxt2());
		this.add(totallbl);
		this.add(botonera.getContraseñaTXT());// va a mostrar el total. reutilizamos este txt para no tener que declarar uno especial para el total.
		this.add(botonera.getBtnConfirmar());
		this.add(botonera.getBtnCancelar());
		
		botonera.getContraseñaTXT().setEditable(false);// Hacemos no editable el textfield de total
		

		
		botonera.getBtnConfirmar().addActionListener(new ActionListener() {

	        public void actionPerformed(ActionEvent e) {

                TurnosService ts = new TurnosService();
	        	
	        	String id = (String)botonera.getCombo().getSelectedItem();
	        	unTurno.setFecha(botonera.getFechatxt().getText());
	        	unTurno2.setFecha(botonera.getFechatxt2().getText());
	        	
				unMedico.setCodId(id);


	        	
	        	/*
	        	ESTO ES LO QUE HICE PARA OBTENER EL TEXTO DE LA FUNCION FECHATEXT 1 Y 2  DE BOTONERA EN LA CUAL  USO UN JFORMATTEDTEXTFIELD PERO ME OBTIENE EL TEXTO COMO NULL
	        	String fecha1 = botonera.fechatext().getText();
				String fecha2 = botonera.fechatext2().getText();
	        	
				System.out.println(fecha1);
				System.out.println(fecha2);
			    
			    unTurno.setFecha(fecha1);
	        	unTurno2.setFecha(fecha2);
	        	*/
	        	
	        	
	        	try {
		        	Integer i =  ts.totalMedico(unMedico, unTurno, unTurno2);
		        	String strTotalm = Integer.toString(i);
		        	botonera.getContraseñaTXT().setText(strTotalm);
	            } catch ( Exception e1 ) {
	                e1.printStackTrace();
	            }
	            
            } 

	    });
	    
		botonera.getBtnCancelar().addActionListener(new ActionListener() {

	        public void actionPerformed(ActionEvent e) {
	            m.mostrarPanelOpcioneMed(); // aca vuelvo al formulario inicial
	        }

	    });
	}
}
