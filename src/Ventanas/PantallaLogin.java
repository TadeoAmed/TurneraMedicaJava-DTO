package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Services.MedicoService;
import entidades.Medico;

public class PantallaLogin extends JPanel {

	private PanelManager manager;
	
	JTextField codIdtxt, pwtxt;
	JLabel titulo, idlbl, contraseñalbl;
	MedicoService m;
    
	
	public PantallaLogin(PanelManager manager) {
        this.manager = manager;
        armarFormularioLogin();
    }
	
	
	public void armarFormularioLogin(){
		
		titulo = new JLabel("BIENVENIDO! INGRESE SU ID Y CONTRASEÑA");
		JButton btnconfirmar = new JButton("confirmar");
		JButton btncancelar = new JButton ("cancelar");
		
		codIdtxt = new JTextField( "", 10 );
		pwtxt = new JTextField( "", 10 );
		idlbl = new JLabel("id");
		contraseñalbl = new JLabel("contraseña");
		

		this.add(titulo);
		this.add(idlbl);
		this.add(codIdtxt);
		this.add(contraseñalbl);
		this.add(pwtxt);
		this.add(btnconfirmar);
		this.add(btncancelar);
		
	
		
		 btnconfirmar.addActionListener(new ActionListener(){
	        	
		        public void actionPerformed(ActionEvent e){
		     
		        	MedicoService unMedico = new MedicoService(); 
		        	Medico m1 = new Medico();
		        	m1.setCodId(codIdtxt.getText());
		           m1 = unMedico.muestraMedico(m1);
		        	
		        	m1.getTipoPerfil();
		        	
		        	if (m1.getTipoPerfil().equals("1") && m1.getPw().equals(pwtxt.getText())){
		        			manager.mostrarPanelOpcionesADM();
		        	}else if (!m1.getCodId().equals(codIdtxt.getText()) || !m1.getPw().equals(pwtxt.getText()) ){
		        		JOptionPane.showMessageDialog(null, "El usuario o contraseña no son correctos");
		        	}
		        	else if (m1.getTipoPerfil().equals("2") && m1.getPw().equals(pwtxt.getText())){
			 		
		        		    manager.mostrarPanelMedicoConsulta();
		            }
		        	
		        	
		        }    		
		       });
		 
	        btncancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                codIdtxt.setText(" ");
	                pwtxt.setText(" ");
	            }
	        });

		
		
	}
}
