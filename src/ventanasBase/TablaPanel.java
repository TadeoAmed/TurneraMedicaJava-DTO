package ventanasBase;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import excepciones.ServicioException;

public class TablaPanel extends JPanel{

    private JTable tabla;
    private TablaModelADM modelo;
    private JScrollPane scrollPaneParaTabla;



    public TablaPanel() {
    }

    public void armarCuadro() {
        this.setLayout( new GridLayout() );

        modelo = new TablaModelADM();
        tabla = new JTable( modelo );

        scrollPaneParaTabla = new JScrollPane( tabla );
        this.add( scrollPaneParaTabla );
    }


}
