package ventanasBase;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Medico;

public class TablaModelADM extends AbstractTableModel{

	
	/*  /**
     * INDICES DE MIS COLUMNAS
     */
    private static final int COLUMNA_CODID = 0;
    private static final int COLUMNA_NOMBRE = 1;
    private static final int COLUMNA_APELLIDO = 2;
    private static final int COLUMNA_CONTRASEÑA = 3;
    private static final int COLUMNA_TIPOPERFIL = 4;
    private static final int COLUMNA_MONTOCONSULTA = 5;

    /**
     * NOMBRES DE LOS ENCABEZADOS
     */
    private String[] nombresColumnas = {"codID", "Nombre", "Apellido", "Contraseña","TipoPerfil","MontoConsulta"};
    /**
     * TIPOS DE CADA COLUMNA (EN EL MISMO ORDEN DE LOS ENCABEZADOS)
     */
    private Class[] tiposColumnas = {String.class, String.class, String.class, String.class, String.class, String.class};


    /**
     * CONTENIDO DEL MODELO
     */
    private List<Medico> filas;

    /**
     * CONSTRUCTOR VACIO
     */
    public TablaModelADM() {
        filas = new ArrayList<Medico>();
    }

    /**
     * CONSTRUCTOR CON CONTENIDO INICIAL
     * @param contenidoInicial
     */
    public TablaModelADM(List<Medico> contenidoInicial) {
        filas = contenidoInicial;
    }

    /**
     * METODO QUE HAY QUE PISAR
     */
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    /**
     * OTRO METODO QUE HAY QUE PISAR
     */
    public int getRowCount() {
        return filas.size();
    }


    /**
     * METODO QUE HAY QUE PISAR
     */
    public Object getValueAt(int rowIndex, int columnIndex) {

        Medico m = filas.get(rowIndex);
        Object result = null;
        switch(columnIndex) {
       
        case COLUMNA_CODID:
            result = m.getCodId();
            break;
            case COLUMNA_NOMBRE:
                result = m.getNombre();
                break;
            case COLUMNA_APELLIDO:
                result = m.getApellido();
                break;

            case COLUMNA_CONTRASEÑA:
                result = m.getPw();
                break;
            case COLUMNA_TIPOPERFIL:
                result = m.getTipoPerfil();
                break;
            case COLUMNA_MONTOCONSULTA:
                result = m.getMontoConsulta();
                break;

            default:
                result = new String("");
        }

        return result;
    }

    /*
     * METODO QUE HAY QUE PISAR
     */
    public String getColumnName(int col) {
        return nombresColumnas[col];
    }

    /*
     * METODO QUE HAY QUE PISAR
     */
    public Class getColumnClass(int col) {
        return tiposColumnas[col];
    }


    public List<Medico> getFilas() {
        return filas;
    }

    public void setFilas(List<Medico> filas) {
        this.filas = filas;
    }
}
