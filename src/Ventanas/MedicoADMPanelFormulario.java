package Ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Services.MedicoService;
import entidades.Medico;
import excepciones.ServicioException;
import ventanasBase.TablaModelADM;



public class MedicoADMPanelFormulario extends JPanel {
	private TablaModelADM tablaModelADM;
	private PanelManager m;
    private JLabel tituloLbl;
    JComboBox combo;	
    private Botonera botonera;


    
    
    public MedicoADMPanelFormulario(PanelManager m) {
        this.m = m;
        armarFormulariomed();
    }


	public void armarFormulariomed(){
    	
        
		botonera = new Botonera();
		
    	this.setLayout( new FlowLayout() );
        
    	//tablaModelADM = new TablaModelADM();
    	tituloLbl = new JLabel("PANEL DE MEDICO ADMINISTRADOR");

        combo = new JComboBox();
        combo.addItem("1 - Medico Administrador");
        combo.addItem("2 - Medico");
            
  
        this.add(tituloLbl);
        this.add( botonera.getNombreLbl());  
        this.add( botonera.getNombreMTXT());  
        this.add(  botonera.getApellidoMLbl() ); 
        this.add( botonera.getApellidoTXT()); 
        this.add( botonera.getIdLbl());		
        this.add( botonera.getidTXT() );		
        this.add( botonera.getContraseñaLbl());
        this.add( botonera.getContraseñaTXT() ); 
        this.add(botonera.getMontoconsultaLbl()); 
        this.add(  botonera.getMontoconsultaTXT() );        
        this.add(combo);

        
        
        this.add( botonera.getBtnConfirmar() );
        this.add(  botonera.getBtnCancelar() );
        
        botonera.getBtnConfirmar().addActionListener(new ActionListener(){
        	
        public void actionPerformed(ActionEvent e){
        		
        	MedicoService m = new MedicoService();
        	m.setCodId(botonera.getidTXT().getText());
        	m.setNombre(botonera.getNombreTXT().getText());
        	m.setApellido(botonera.getApellidoTXT().getText());
        	m.setPw(botonera.getContraseñaTXT().getText() );
        	m.setMontoConsulta(botonera.getMontoconsultaTXT().getText());    	

        	
            combo.getSelectedItem();
            if ( combo.getSelectedItem().equals("1 - Medico Administrador")){
                    m.setTipoPerfil("1");
            }else if ( combo.getSelectedItem().equals("2 - Medico")){
                    m.setTipoPerfil("2");
                }
            
            try {
            	
                m.crearMedico(m);
            } catch ( ServicioException e1 ) {
            	System.out.println("Hubo un error en el ingreso de datos" + e1.getMessage());
            }
     	
        }    		
       });
        
        
        botonera.getBtnCancelar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("SOY CANCELAR");
                m.mostrarPanelOpcionesADM();// VUELVO A LA PANTALLA INICIAL
                										// POR QUE NO ME LIMPIA LA PANTALLA?
            }
        });

    }

}
    
