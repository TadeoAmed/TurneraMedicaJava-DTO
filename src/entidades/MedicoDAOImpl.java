package entidades;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import excepciones.IdRepetidoException;
import excepciones.MedicoTurnoException;

public class MedicoDAOImpl implements MedicoDAO  { // tambien implementa usuariodao pero por el momentovamos a dejarle los metodos de medico
    
	
	
	
	public void crearMedico(Medico unMedico) throws IdRepetidoException  {

		String codId= unMedico.getCodId();
		String nombre = unMedico.getNombre();
		String apellido= unMedico.getApellido();
		String pw = unMedico.getPw();
		String tipoPerfil = unMedico.getTipoPerfil();
		String montoConsulta = unMedico.getMontoConsulta();

		try{
			validarMedico(unMedico);
			Connection dbconnect = DBManager.connect();
        try {
            Statement st = dbconnect.createStatement(); // la coneccion a la base de datosse llama " dbconnect" si se da correctamente la conexion
                                                              // se me crea un Statement con el CreateStatement. 
//
            String sq = "INSERT INTO ENTIDADES.medicos (codId, nombre, apellido, pw, tipoperfil, montoConsulta) VALUES ('" + codId + "', '" + nombre + "', '" + apellido + "', '" + pw + "', '" + tipoPerfil + "', '" + montoConsulta + "')";
            st.executeUpdate(sq); //  aca puedo guardar este valor dentro de una variable Resultset, por ej ResultSet= st.executeUpdate(sql); pero solo memostraria el resultado deel excecuteUpdate. y no me sirve de nada, ya que el update devuelve el numero de las columnas o tuplas que fueron modificaddas.
            dbconnect.commit();
        } catch (SQLException e) { // cada vez que utilicemos una funcion de sql dentro de jdbc tendremos SQL EXCEPTION.
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
	
	   public void actualizaMedico(Medico unMedico) {
			String codId= unMedico.getCodId();
			String nombre = unMedico.getNombre();
			String apellido= unMedico.getApellido();
			String pw = unMedico.getPw();
			String tipoPerfil = unMedico.getTipoPerfil();
			String montoConsulta = unMedico.getMontoConsulta();



			String sqlu = "UPDATE ENTIDADES.medicos set nombre= '" + nombre + "',apellido = '" + apellido + "',pw = '"+ pw + "',tipoperfil = '" + tipoPerfil + "',montoConsulta = '" + montoConsulta + "' WHERE codId = " + codId + "";
			Connection c = DBManager.connect();
	        try {
	            Statement s = c.createStatement();
	            s.executeUpdate(sqlu);
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
	   
	   
	    public void borraMedico(String codId) {
	        String sql = "DELETE FROM ENTIDADES.medicos WHERE codId = '" + codId + "'";
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




	    public List<Medico> muestraTodosLosMedicos(){
	    	String codId;
	    	String nombre;
	    	String apellido;
	    	String contraseña;
	    	String tipoPerfil;
	    	String montoConsulta;
	    	
	        List<Medico> lista = new ArrayList<>();
	        String sql = "SELECT * FROM ENTIDADES.medicos;";
	        Connection c = DBManager.connect();
	        try {
	            Statement s = c.createStatement();
	            ResultSet resultados = s.executeQuery(sql);

	            System.out.println("\t"+ "**** Listado de Medicos ****");

	            while (resultados.next()) {

	            	
	            	
	                 codId = resultados.getString("codId");
	                 nombre = resultados.getString("nombre");
	                 apellido =resultados.getString("apellido");
	                 contraseña = resultados.getString("pw");
	                 tipoPerfil= resultados.getString("tipoPerfil");
	                 montoConsulta = resultados.getString("montoConsulta");
	                 Medico m = new Medico (codId,nombre,apellido,contraseña ,tipoPerfil,montoConsulta);
	                 lista.add(m);
	                 
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

	    public Medico muestraMedico(String codId) {
	        String sql = "SELECT * FROM ENTIDADES.medicos WHERE codId = '" + codId  + "'";
	        Connection c = DBManager.connect();
	        try {
	            Statement s = c.createStatement();
	            ResultSet rs = s.executeQuery(sql);

	            
	            if (rs.next()) {
	                Medico m = new Medico();
	                m.setCodId(rs.getString("codId")); 
	                m.setNombre(rs.getString("nombre"));
	                m.setApellido(rs.getString("apellido")); 
	                m.setPw(rs.getString("pw")); 
	                m.setTipoPerfil(rs.getString("tipoPerfil"));
	                m.setMontoConsulta(rs.getString("montoConsulta")); 
	                return m;
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
 public void validarMedico (Medico unMedico) throws Exception{
	    	
	    	String sql = "SELECT * FROM ENTIDADES.medicos WHERE (codid = '"+ unMedico.getCodId()+"')";
	    	Connection c = DBManager.connect();
	        int repetido = 0;

	    	try {
	             Statement st = c.createStatement();
	             ResultSet result = st.executeQuery(sql);
	             
	             while (result.next()) {
	            	 
	            	 repetido = repetido + 1;

	 //           		 Una vez que terminede recorrer el result, cuando sale de ese while ponemos 
	             } 

	            	
	            	if(repetido >= 1){
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


