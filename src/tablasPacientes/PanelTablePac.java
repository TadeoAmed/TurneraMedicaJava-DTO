package tablasPacientes;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Services.PacientesServices;
import Ventanas.PanelManager;
import entidades.Pacientes;
import tablasPacientes.TablaModelPac;

public class PanelTablePac extends JPanel {


    private PanelManager manager;
    private JTable tabla;
    private TablaModelPac modelo;
	private JButton botonModificar;
	private JButton botonBorrar;

    
      
    private JScrollPane scrollPaneParaTabla;

    public PanelTablePac(PanelManager m) {
		// TODO Auto-generated constructor stub
    	super ();
    	this.manager = m;
    	armarCuadro();
	}

	public TablaModelPac getModelo() {
        return modelo;
    }

    public void setModelo(TablaModelPac modelo) {
        this.modelo = modelo;
    }
  
    /*
    public void TablaModelPac(PanelManager m){
    	
    	this.manager = m;
    	armarCuadro();
    }
    
*/
    PacientesServices pac = new PacientesServices();   
    
    
    public void armarCuadro() {
        this.setLayout( new GridLayout() );

        modelo = new TablaModelPac();
        tabla = new JTable( modelo );

        scrollPaneParaTabla = new JScrollPane( tabla );
        this.add( scrollPaneParaTabla );

    	List<Pacientes> lista = new ArrayList<Pacientes>();
		try {
			lista = pac.muestraTodosLosPacientes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelo.setFilas(lista);
		modelo.fireTableDataChanged();



    }
}
