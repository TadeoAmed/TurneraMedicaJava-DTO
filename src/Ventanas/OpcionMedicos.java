package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OpcionMedicos extends JPanel implements ActionListener{
	private Botonera  botonera;
	private PanelManager m;
	private JButton crear, modificar, borrar, cancelar, consultarMonto; 
	public OpcionMedicos(PanelManager m) {
	    this.m = m;
	    armarOpcionesM();
	}



	public void armarOpcionesM(){
		crear = new JButton(" CREAR");
		crear.addActionListener(this);
		this.add(crear);

		modificar = new JButton("MODIFICAR");
		modificar.addActionListener(this);
		this.add(modificar);

		borrar = new JButton("BORRAR");
		borrar.addActionListener(this);
		this.add(borrar);

		consultarMonto = new JButton("MONTO A COBRAR");
		consultarMonto.addActionListener(this);
		this.add(consultarMonto);
		
		cancelar = new JButton("cancelar" );
		cancelar.addActionListener(this);
	    this.add(cancelar);
		/*
		this.add(botonera.getBotonCrear());
		this.add(botonera.getBotonModificar());
		this.add(botonera.getBotonBorrar());
		this.add(botonera.getBtnCancelar());
		*/
	}
	public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == crear){
    		m.mostrarPanelMedicoPanelFormulario();
    	}else if(e.getSource() == modificar){
    		m.mostrarPanelMedicoPanelFormularioModificar();
    	}else if (e.getSource()== borrar){
    		m.mostrarPanelMedicoPanelFormularioBorrar();
    	}else if(e.getSource()==consultarMonto){
    		m.mostrarPanelReporteMedico();    		
    	}else if (e.getSource()==cancelar){
    		m.mostrarPanelOpcionesADM();
    	}
    }


}
