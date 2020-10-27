package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import Services.TurnosService;
import entidades.Turnos;
import tablaTurnos.PanelTableTur;


public class TurnosPanelFormularioBorrar extends JPanel {

	private PanelManager m;
	private Botonera botonera;	
	private Turnos unTurno;
	private TurnosService ts;
	private PanelTableTur paneltabletur;
	private JLabel tituloLbl;

	public TurnosPanelFormularioBorrar(PanelManager m) {
	    this.m = m;
	    armarFormularioBorraTur();
	}
		

	public void armarFormularioBorraTur (){
		
		this.setLayout(new FlowLayout());
		
		paneltabletur = new PanelTableTur();
		botonera = new Botonera();
		unTurno = new Turnos();
		tituloLbl = new JLabel("Turno: seleccione el id del turno a borrar");
		ts = new TurnosService();
		List<Turnos> lista = ts.muestraTodosLosTurnos();
		
		
		for (Turnos unTurno: lista){
			botonera.getCombo().addItem(unTurno.getIdTurno());
		}
		this.add(tituloLbl);
		this.add(botonera.getIdLbl());
		this.add(botonera.getCombo());
		this.add(botonera.getBtnConfirmar());
		this.add(botonera.getBtnConfirmar());
		
		botonera.getBtnConfirmar().addActionListener(new ActionListener() {

	        public void actionPerformed(ActionEvent e) {
	            int response = JOptionPane.showConfirmDialog(null, "Seguro que quiere BORRAR este Turno?");
	            if (response == JOptionPane.OK_OPTION){
	             
	             String id = (String)botonera.getCombo().getSelectedItem();
	             ts.setIdTurno(id);
	            
	        	try {
	                ts.borrarTurnos(ts);;
	        
	            } catch ( Exception e1 ) {
	                e1.printStackTrace();
	            }

	            JOptionPane.showMessageDialog(null, " borrado CON EXITO" );
	            }


	        }

	    });
	
	    
		botonera.getBtnCancelar().addActionListener(new ActionListener() {

	        public void actionPerformed(ActionEvent e) {
	            m.mostrarPanelOpcionesADM(); // aca vuelvo al formulario inicial
	        }

	    });
	}

}
