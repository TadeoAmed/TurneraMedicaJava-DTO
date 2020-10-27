package ventanasBase;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Services.MedicoService;
import Ventanas.PanelManager;
import entidades.Medico;
import excepciones.ServicioException;

public class PanelTableADM extends JPanel  {
	

    private PanelManager manager;
    private JTable tabla;
    private TablaModelADM modelo;
	private JButton botonModificar;
	private JButton botonBorrar;

    
      
    private JScrollPane scrollPaneParaTabla;

    public TablaModelADM getModelo() {
        return modelo;
    }

    public void setModelo(TablaModelADM modelo) {
        this.modelo = modelo;
    }

    public PanelTableADM(PanelManager m) {
        super();
        this.manager = m;
        armarCuadro();
    }
    MedicoService med = new MedicoService();   
    
    
    public void armarCuadro() {
        this.setLayout( new GridLayout() );

        modelo = new TablaModelADM();
        tabla = new JTable( modelo );

        scrollPaneParaTabla = new JScrollPane( tabla );
        this.add( scrollPaneParaTabla );

    	List<Medico> lista = new ArrayList<Medico>();
		try {
			lista = med.muestraTodosLosMedicos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelo.setFilas(lista);
		modelo.fireTableDataChanged();



    }


    	
    	
  
      

}





