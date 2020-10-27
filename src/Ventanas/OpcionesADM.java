package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entidades.Medico;

public class OpcionesADM extends JPanel implements ActionListener {
	private PanelManager manager;
    private JLabel tituloLbl;
    private JComboBox combo;
	private JButton medico,turnos,pacientes,salir;

	
    public OpcionesADM(PanelManager manager) {
        this.manager = manager;
        armarOpciones();
    }
    

    public void armarOpciones(){
    	this.setLayout( new FlowLayout() );
    	medico = new JButton(" MEDICOS");
		medico.addActionListener(this);
		this.add(medico);

		turnos = new JButton("TURNOS");
		turnos.addActionListener(this);
		this.add(turnos);

		pacientes = new JButton("PACIENTES");
		pacientes.addActionListener(this);
		this.add(pacientes);

		
		
		salir = new JButton("SALIR" );
		salir.addActionListener(this);
	    this.add(salir);

		
    }
    

    


    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == medico){
    		manager.mostrarPanelOpcioneMed();
    	}else if(e.getSource() == turnos){
    		manager.mostrarPanelOpcionesTur();
    	}else if (e.getSource()==pacientes){
    		manager.mostrarPanelOpcionePac();
    	}else if (e.getSource()==salir){
    		int response = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere salir?");
        	if (response == JOptionPane.OK_OPTION){
        		System.exit(0);
        	}
    	}
    }
    

  
    
}
