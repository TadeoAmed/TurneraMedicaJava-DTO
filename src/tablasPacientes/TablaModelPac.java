package tablasPacientes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Pacientes;

public class TablaModelPac extends AbstractTableModel{

	/*  /**
     * INDICES DE MIS COLUMNAS
     */
    private static final int COLUMNA_CODID = 0;
    private static final int COLUMNA_NOMBRE = 1;
    private static final int COLUMNA_APELLIDO = 2;
    private static final int COLUMNA_DNI = 3;
    private static final int COLUMNA_MAIL = 4;


    /**
     * NOMBRES DE LOS ENCABEZADOS
     */
    
    private String[] nombresColumnas = {"id", "NombrePaciente", "ApellidoPaciente", "Dni","Mail"};
    /**
     * TIPOS DE CADA COLUMNA (EN EL MISMO ORDEN DE LOS ENCABEZADOS)
     */
    private Class[] tiposColumnas = {String.class, String.class, String.class, String.class, String.class};


    /**
     * CONTENIDO DEL MODELO
     */
    private List<Pacientes> filas;

    /**
     * CONSTRUCTOR VACIO
     */
    public TablaModelPac() {
        filas = new ArrayList<Pacientes>();
    }

    /**
     * CONSTRUCTOR CON CONTENIDO INICIAL
     * @param contenidoInicial
     */
    public TablaModelPac(List<Pacientes> contenidoInicial) {
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

        Pacientes p = filas.get(rowIndex);
        Object result = null;
        switch(columnIndex) {
       
        case COLUMNA_CODID:
            result = p.getId();
            break;
            case COLUMNA_NOMBRE:
                result = p.getNombre();
                break;
            case COLUMNA_APELLIDO:
                result = p.getApellido();
                break;

            case COLUMNA_DNI:
                result = p.getDni();
                break;
            case COLUMNA_MAIL:
                result = p.getMail();
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


    public List<Pacientes> getFilas() {
        return filas;
    }

    public void setFilas(List<Pacientes> filas) {
        this.filas = filas;
    }
}
