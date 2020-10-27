package tablaTurnos;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Services.TurnosService;
import Ventanas.PanelManager;
import entidades.Pacientes;
import entidades.Turnos;
import tablaTurnos.TablaModelTur;

public class PanelTableTur extends JPanel{

    private PanelManager manager;
    private JTable tabla;
    private TablaModelTur modelo;
	private JButton botonModificar;
	private JButton botonBorrar;

    
      
    private JScrollPane scrollPaneParaTabla;

    public TablaModelTur getModelo() {
        return modelo;
    }

  
    public void setModelo(TablaModelTur modelo) {
        this.modelo = modelo;
    }

    public PanelTableTur() {

    }
    public PanelTableTur(PanelManager m) {
        super();
        this.manager = m;
        armarCuadro();
    }
    TurnosService tur = new TurnosService();   
    
    
    public void armarCuadro() {
        this.setLayout( new GridLayout() );

        modelo = new TablaModelTur();
        tabla = new JTable( modelo );

        scrollPaneParaTabla = new JScrollPane( tabla );
        this.add( scrollPaneParaTabla );
	int i = 0;

    	List<Turnos> lista = new ArrayList<Turnos>();
		try {
			lista = tur.muestraTodosLosTurnos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelo.setFilas(lista);
		modelo.fireTableDataChanged();



    }


    	
 
}
