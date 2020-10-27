package Ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Services.MedicoService;
import Services.PacientesServices;
import entidades.Medico;
import entidades.Pacientes;

public class MedicoADMPanelFormularioModif extends JPanel implements ActionListener{
 



   private static PanelManager manager;
   private JLabel tituloLbl;

    Botonera botonera; 
    JComboBox<String> combo;	
    JComboBox<String> combo1;

    public MedicoADMPanelFormularioModif(PanelManager manager) {
        this.manager = manager;
        armarFormulario();
    }



    public  void armarFormulario() {

            tituloLbl = new JLabel("PANEL DE ADMINISTRADOR  - MODIFICA USUARIO");
            botonera = new Botonera();

            combo = new JComboBox();
            combo1 = new JComboBox();
            combo.addItem("1 - Medico Administrador");
            combo.addItem("2 - Medico");


           
            MedicoService med = new MedicoService ();
            List<Medico> lista = med.muestraTodosLosMedicos();
    		for (Medico medico: lista){
    			combo1.addItem(medico.getCodId());
    		}
    		
            
            

           this.setBorder( BorderFactory.createLineBorder( Color.BLUE ) );
            
           this.add(tituloLbl);                             // quiza para todo esto en la botonera puedo armar un metodo que me genere todos estos campos. Despues cuando necesite usar alguno en particular
           this.add(botonera.getIdLbl());                   // lo llamo aparte con un get 
           this.add( combo1 );
           this.add(botonera.getNombreLbl());
           this.add( botonera.getNombreTXT() );
           this.add(botonera.getApellidoLbl() );
           this.add( botonera.getApellidoTXT());
           this.add( botonera.getContraseñaLbl());
           this.add( botonera.getContraseñaTXT() );
           this.add( botonera.getTipoPerfillbl());
           this.add(combo);
           this.add( botonera.getMontoconsultaLbl() );
           this.add( botonera.getMontoconsultaLbl());
           this.add(botonera.getBtnConfirmar());
           this.add(botonera.getBtnCancelar());



            
            
            combo1.addActionListener(new ActionListener (){
    			public void actionPerformed (ActionEvent e){
    	        	MedicoService unMedico = new MedicoService();  
    	        	String id = (String) combo1.getSelectedItem(); // casteo a string el id que seleccioné del combobox y lo guardo en una variable tipo string llamada id
    	        	Medico m1 = new Medico(); // creo un objeto pacientes
    	        	m1.setCodId(id);; // mediante un setter de id de la clase pacientes, seteo al objeto m1 con el id seleccionado del combobox
    	            m1 = unMedico.muestraMedico(m1); // ahora m1 va a contenter toda la informacion que contiene el objeto en la base de daots con el id seleccionado. Nos dará, nombre, apellido, etc 
    	            botonera.getNombreTXT().setText(m1.getNombre());
    	            botonera.getApellidoTXT().setText(m1.getApellido());
    	            botonera.getContraseñaTXT().setText(m1.getPw());
    	            botonera.getMontoconsultaTXT().setText(m1.getMontoConsulta());
    	            
    	                      
    				
    			}
    		});
            
            
            
            
            
            
            botonera.getBtnConfirmar().addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.out.println("SOY CONFIRMAR DE EDITAR");
                     
                     MedicoService m = new MedicoService();

    
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
                        m.actualizaMedico(m);
                    } catch ( Exception e1 ) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, " MODIFICADO CON EXITO" );



                }

            });
            botonera.getBtnCancelar().addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    manager.mostrarPanelOpcionesADM();// aca vuelvo al formulario inicial
                }

            });

        }




        private static JPanel envolver(JComponent j){

            JPanel p = new JPanel();
            p.add( j );
            return p;
        }

		@Override
		public void actionPerformed(ActionEvent e) {

			
		}







}
