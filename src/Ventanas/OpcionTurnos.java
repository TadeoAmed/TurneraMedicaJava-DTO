package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OpcionTurnos extends JPanel implements ActionListener {
	private Botonera  botonera;
	private PanelManager m; 
	private JButton crear, modificar, borrar, cancelar; 

	public OpcionTurnos(PanelManager m){
		this.m=m;
		armarOpcionesT();
	}


	public void armarOpcionesT (){
		crear = new JButton(" CREAR");
		crear.addActionListener(this);
		this.add(crear);

		modificar = new JButton("MODIFICAR");
		modificar.addActionListener(this);
		this.add(modificar);

		borrar = new JButton("BORRAR");
		borrar.addActionListener(this);
		this.add(borrar);

		
		
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
    		m.mostrarPanelFormularioTurnosAlta();
    	}else if(e.getSource() == modificar){
    		m.mostrarPanelFormularioTurnosModif();
    	}else if (e.getSource()== borrar){
    		m.mostrarPanelFormularioTurnosBorrar();
    	}else if (e.getSource()==cancelar){
    		m.mostrarPanelOpcionesADM();
    	}
    }
}
