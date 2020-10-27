package Ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Services.MedicoService;
import Services.PacientesServices;
import entidades.Pacientes;

public class PacientesPanelFormularioBorrar extends JPanel {

	
private JComboBox combo;
private PanelManager m;
private Botonera botonera;	
private Pacientes unPaciente;
private PacientesServices ps;
private JLabel tituloLbl;

public PacientesPanelFormularioBorrar(PanelManager m) {
    this.m = m;
    armarFormularioBorraPac();
}
	

public void armarFormularioBorraPac (){
	
	this.setLayout(new FlowLayout());

	botonera = new Botonera();
	combo = new JComboBox<String>();
	unPaciente = new Pacientes();
	tituloLbl = new JLabel("BORRAR PACIENTE: seleccione el id del usuario que quiera eliminar de la base");
	ps = new PacientesServices();
	List<Pacientes> lista = ps.muestraTodosLosPacientes();
	
	
	for (Pacientes unPaciente: lista){
		combo.addItem(unPaciente.getId());
	}
	this.add(tituloLbl);
	this.add(botonera.getIdLbl());
	this.add(combo);
	this.add(botonera.getBtnConfirmar());
	this.add(botonera.getBtnCancelar());
	
	botonera.getBtnConfirmar().addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            System.out.println("SOY CONFIRMAR DE BORRAR");
            int response = JOptionPane.showConfirmDialog(null, "Seguro que quiere BORRAR este usuario?");
            if (response == JOptionPane.OK_OPTION){
             PacientesServices p = new PacientesServices();
             String id = (String)combo.getSelectedItem();
             p.setId(id);
            
        	try {
                p.borrarPaciente(p);
            } catch ( Exception e1 ) {
                e1.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(null, " borrado CON EXITO" );
            }


        }

    });
    
	botonera.getBtnCancelar().addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            System.out.println("SOY CANCELAR BORRAR");
            m.mostrarPanelOpcionesADM(); // aca vuelvo al formulario inicial
        }

    });
}
	
	
}
