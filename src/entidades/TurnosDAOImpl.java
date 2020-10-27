package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import excepciones.IdRepetidoException;
import excepciones.MedicoTurnoException;

public class TurnosDAOImpl implements TurnosDAO {
	
	public void crearTurno (Medico unMedico, Pacientes unPaciente, Turnos unTurno ) throws MedicoTurnoException, IdRepetidoException {

		String mId = unMedico.getCodId();
		String  mNombre = unMedico.getNombre();
		String mApellido = unMedico.getApellido();
		String pId = unMedico.getCodId();
		String pNombre = unPaciente.getNombre();
		String pApellido= unPaciente.getApellido();
		String pDni = unPaciente.getDni();
		String tId = unTurno.getIdTurno();
		String hora = unTurno.getHora();
		String fecha = unTurno.getFecha();
		        
        try {
        	 
        	validarMedicoyPaciente(unMedico, unTurno);
        	 Connection dbconnect = DBManager.connect();
        try {
            Statement st = dbconnect.createStatement(); 
            String sql = "INSERT INTO ENTIDADES.turnos (idturno, idMedico, NombreMedico, apellidoMedico, idPaciente, NombrePaciente, ApellidoPaciente, DniPaciente, Fecha, Hora) VALUES ('" + tId + "', '" + mId + "', '" + mNombre + "', '" + mApellido + "', '" + pId + "', '"  + pNombre + "', '" + pApellido + "', '" + pDni + "', '" + fecha + "', '" + hora + "')";
            st.executeUpdate(sql); 
            dbconnect.commit();
        } catch (SQLException e) { 
            try {
                
         
                e.printStackTrace();
                dbconnect.rollback();
            } catch (SQLException e1) {
                e.printStackTrace();
            }
        } finally {
            try {
                dbconnect.close(); // cierro la conexion
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
           }
	  }catch(Exception ex){
		 
		  JOptionPane.showMessageDialog(null, "No se pudo crear el turno RAZON: " + ex.getMessage());

		  
	  }
    }
	
	public void modificarTurno (Medico unMedico, Pacientes unPaciente, Turnos unTurno ) throws MedicoTurnoException{

		String mId = unMedico.getCodId();
		String  mNombre = unMedico.getNombre();
		String mApellido = unMedico.getApellido();
		String pId = unMedico.getCodId();
		String pNombre = unPaciente.getNombre();
		String pApellido= unPaciente.getApellido();
		String pDni = unPaciente.getDni();
		String tId = unTurno.getIdTurno();
		String hora = unTurno.getHora();
		String fecha = unTurno.getFecha();
		
  
        try { 
        	validarMedicoyPaciente(unMedico, unTurno);
       	 Connection dbconnect = DBManager.connect();
        
        try {
            Statement st = dbconnect.createStatement(); 
            String sql = "UPDATE ENTIDADES.turnos set idMedico= '" + mId + "' NombreMedico= '" + mNombre + "',apellidoMedico = '"+ mApellido + "',idPaciente = '"+ pId + "',NombrePaciente = '" + pNombre + "',ApellidoPaciente = '" + pApellido + "',DniPaciente = '"+ pDni + "',Fecha= '" + fecha + "',Hora = '" + hora + "' WHERE idturno = " + tId + "";
            st.executeUpdate(sql); 
            dbconnect.commit();
        } catch (SQLException e) { 
            try {
                
         
                e.printStackTrace();
                dbconnect.rollback();
            } catch (SQLException e1) {
                e.printStackTrace();
            }
        } finally {
            try {
                dbconnect.close(); // cierro la conexion
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        } catch (Exception ex){
        	JOptionPane.showMessageDialog(null, "No se pudo modificar el turno RAZON: " + ex.getMessage());
        }
    }
	
    public void borrarTurnos(String id) {
        String sql = "DELETE FROM ENTIDADES.turnos WHERE idturno = '" + id + "'";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    
    public List<Turnos> muestraTodosLosTurnos(){
    	String tId,mId,mNombre,mApellido,pId,pNombre,pApellido,pDni,hora,fecha;	
        List<Turnos> lista = new ArrayList<>();
        String sql = "SELECT * FROM ENTIDADES.turnos;";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            ResultSet resultados = s.executeQuery(sql);

            while (resultados.next()) {
            	
                 tId = resultados.getString("idturno");
                 mId = resultados.getString("idMedico");
                 mNombre = resultados.getString("nombreMedico");
                 mApellido =resultados.getString("apellidoMedico");
                 pId = resultados.getString("idPaciente");
                 pNombre = resultados.getString("nombrePaciente");
                 pApellido =resultados.getString("apellidoPaciente");
                 pDni= resultados.getString("DniPaciente");
                 fecha = resultados.getString("Fecha");
                 hora = resultados.getString("Hora");
                 Turnos t = new Turnos(tId,mId,mNombre,mApellido,pId,pNombre,pApellido,pDni,hora,fecha);
                 lista.add(t);
                 
                System.out.println();
            }
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }
    
    public Turnos muestraTurno(String id) {
        String sql = "SELECT * FROM ENTIDADES.turnos WHERE idturno = '" + id  + "'";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            ResultSet resultados = s.executeQuery(sql);

            
            if (resultados.next()) {
                Turnos t = new Turnos();
                t.setIdTurno(resultados.getString("idturno")); 
                t.setmId(resultados.getString("idMedico"));
                t.setmNombre(resultados.getString("nombreMedico"));
                t.setmApellido(resultados.getString("apellidoMedico")); 
                t.setpId(resultados.getString("idPaciente"));
                t.setpNombre(resultados.getString("nombrePaciente"));
                t.setpApellido(resultados.getString("apellidoPaciente")); 
                t.setpDni(resultados.getString("DniPaciente")); 
                t.setFecha(resultados.getString("Fecha")); 
                t.setHora(resultados.getString("Hora"));
                return t;
            }

        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }
    
    public Integer totalMedico(Medico unMedico, Turnos unTurno, Turnos unTurno2)
    {
    	Integer totalRecaudado = 0;
    	String fecha = unTurno.getFecha();
    	String fecha2 = unTurno2.getFecha();
    	String idM = unMedico.getCodId();
    	String sql = "SELECT T.idturno, M.codid, M.MONTOCONSULTA, T.FECHA FROM ENTIDADES.MEDICOS M INNER JOIN ENTIDADES.TURNOS T ON M.CODID=T.IDMEDICO WHERE (T.FECHA >= '" + fecha + "' AND T.FECHA <= '" + fecha2 + "' AND M.CODID = '" + idM + "' )";
    	Connection c = DBManager.connect();
        try {
        	
        	
            Statement s = c.createStatement();
            ResultSet resultados = s.executeQuery(sql);

            
            while (resultados.next()) {
            	
            	
                Turnos t = new Turnos();
                String str = resultados.getString("montoConsulta"); 
                Integer in = Integer.parseInt(str);
                System.out.println("in antes de sumar" + in);
                totalRecaudado = totalRecaudado + in; 
                System.out.println("totalrecaudado dentro del while" + totalRecaudado);
            }   
            
            }catch (SQLException e) {
                try {
                    c.rollback();
                    e.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } finally {
                try {
                    c.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
		return totalRecaudado;
            
    

    }
    
    public void validarMedicoyPaciente (Medico unMedico, Turnos unTurno) throws Exception{
    	
    	String sql = "SELECT * FROM ENTIDADES.turnos WHERE ((idmedico = '"+ unMedico.getCodId()+"' AND fecha = '" + unTurno.getFecha() +"' AND hora = '" + unTurno.getHora() +"') OR IDTURNO = '"+ unTurno.getIdTurno()+"')";
    	Connection c = DBManager.connect();
        int repetido = 0;
        int idrepetido = 0;
    	try {
             Statement st = c.createStatement();
             ResultSet result = st.executeQuery(sql);
             
             while (result.next()) {
            	 
            	 if(result.getString("idturno") != unTurno.getIdTurno()){
            		 
            		 repetido = repetido + 1;
            	 }else{

            		 idrepetido += 1;
            	 }
 //           		 Una vez que terminede recorrer el result, cuando sale de ese while ponemos 
             } 
            	if (repetido >= 1) {

            		throw new MedicoTurnoException("El horario y fecha seleccionado con  el medico: "+ unMedico.getApellido() +" ya se encuentra ocupado"); // aca estaria bueno concatenar el apellido del medico
            	}
            	
            	if(idrepetido >= 1){
            		throw new IdRepetidoException("El id seleccionado ya existe"); // aca estaria bueno concatenar el apellido del medico

            	}
             }catch (SQLException e) {
                 try {
                     c.rollback();
                     e.printStackTrace();
                 } catch (SQLException e1) {
                     e1.printStackTrace();
                 }
             } finally {
                 try {
                     c.close();
                 } catch (SQLException e1) {
                     e1.printStackTrace();
                 }
             }
    
    	
    }
}
