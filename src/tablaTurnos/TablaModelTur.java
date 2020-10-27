package tablaTurnos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Turnos;

public class TablaModelTur extends AbstractTableModel {
	   private static final int COLUMNA_CODIDTUR = 0;
	    private static final int COLUMNA_CODIDMEDICO = 1;
	    private static final int COLUMNA_NOMBREM = 2;
	    private static final int COLUMNA_APELLIDOM = 3;
	    private static final int COLUMNA_CODIDPACIENTE = 4;
	    private static final int COLUMNA_NOMBREP = 5;
	    private static final int COLUMNA_APELLIDOP = 6;
	    private static final int COLUMNA_DNIP = 7;
	    private static final int COLUMNA_FECHA = 8;
	    private static final int COLUMNA_HORA = 9;
	    
	   
	    /**
	     * NOMBRES DE LOS ENCABEZADOS
	     */
	    private String[] nombresColumnas = {"idturno", "idMedico", "NombreMedico", "apellidoMedico","idPaciente","NombrePaciente","ApellidoPaciente","DniPaciente","Fecha","Hora"};
	    /**
	     * TIPOS DE CADA COLUMNA (EN EL MISMO ORDEN DE LOS ENCABEZADOS)
	     */
	    private Class[] tiposColumnas = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class,};

	    /**
	     * CONTENIDO DEL MODELO
	     */
	    private List<Turnos> filas;

	    /**
	     * CONSTRUCTOR VACIO
	     */
	    public TablaModelTur() {
	        filas = new ArrayList<Turnos>();
	    }

	    /**
	     * CONSTRUCTOR CON CONTENIDO INICIAL
	     * @param contenidoInicial
	     */
	    public TablaModelTur(List<Turnos> contenidoInicial) {
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

	        Turnos t = filas.get(rowIndex);
	        Object result = null;
	        switch(columnIndex) {
	       

	        
	        case COLUMNA_CODIDTUR:
	            result = t.getIdTurno();
	            break;
	        case COLUMNA_CODIDMEDICO:																				
	                result = t.getmId();
	                break;
	        case COLUMNA_NOMBREM:
	                result = t.getmNombre();
	                break;

	        case COLUMNA_APELLIDOM:
	                result = t.getmApellido();
	                break;
	        case COLUMNA_CODIDPACIENTE:
	                result = t.getpId();
	                break;
	        case COLUMNA_NOMBREP:
	                result = t.getpNombre();
	                break;
	        case COLUMNA_APELLIDOP:
	            	result = t.getpApellido();
	            	break;
	        case COLUMNA_DNIP:
            	result = t.getpDni();
            	break;
	        case COLUMNA_FECHA:
	        		String fecha = t.getFecha(); 
	            	result = fecha;
	            	break;
	        case COLUMNA_HORA:
	        		String hora = t.getHora();
	            	result = hora;
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


	    public List<Turnos> getFilas() {
	        return filas;
	    }

	    public void setFilas(List<Turnos> filas) {
	        this.filas = filas;
	    }
}
