package Ventanas;

import java.awt.Color;
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

public class MedicoADMPanelFormularioBorra extends JPanel implements ActionListener{

	   private static PanelManager manager;
	        private JLabel tituloLbl;

	    JTextField nombreTXT;
	    JTextField apellidoTXT;
	    private int idTXT;
	    JTextField contraseñaTxt;
	    JTextField tipoperfilTxt;
	    JTextField montoconsultaTxt;
	    JComboBox<String> combo;	
	 
	    public MedicoADMPanelFormularioBorra(PanelManager manager) {
	        this.manager = manager;
	        armarFormularioBorrarMed();
	    }
	    public int getDniTxt() {
	        return idTXT;
	    }


	    public  void armarFormularioBorrarMed() {

	            tituloLbl = new JLabel("PANEL DE ADMINISTRADOR  - BORRAR USUARIO");
	            JLabel idLbl = new JLabel( "ingrese el ID a borrar:" );

	          this.setLayout(new FlowLayout());

	            JButton btnConfirmar = new JButton("Confirmar");
	            JButton btnCancelar = new JButton( "Cancelar" );

	           


	            JTextField idTXT = new JTextField( "", 10 );




	           this.setBorder( BorderFactory.createLineBorder( Color.RED ) );
	         
	            this.add( envolver( idLbl ) );
	            this.add( envolver( idTXT ) );
	            this.add(tituloLbl);


	            this.add(envolver( btnConfirmar ));
	            this.add(envolver( btnCancelar ));


	            
	            
	            btnConfirmar.addActionListener(new ActionListener() {

	                public void actionPerformed(ActionEvent e) {
	                    System.out.println("SOY CONFIRMAR DE BORRAR");
	                    int response = JOptionPane.showConfirmDialog(null, "Seguro que quiere BORRAR este usuario?");
	                    if (response == JOptionPane.OK_OPTION){
	                     MedicoService m = new MedicoService();
	                     m.setCodId(idTXT.getText());
	                    
	                	try {
	                        m.borraMedico(m);
	                    } catch ( Exception e1 ) {
	                        e1.printStackTrace();
	                    }
	                    
	                    JOptionPane.showMessageDialog(null, " borrado CON EXITO" );
	                    }


	                }

	            });
	            btnCancelar.addActionListener(new ActionListener() {

	                public void actionPerformed(ActionEvent e) {
	                    System.out.println("SOY CANCELAR BORRAR");
	                    manager.mostrarPanelOpcionesADM(); // aca vuelvo al formulario inicial
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
				// TODO Auto-generated method stub
				
			}



}
