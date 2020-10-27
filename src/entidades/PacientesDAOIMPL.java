package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import excepciones.ErrorMailException;
import excepciones.IdRepetidoException;

public class PacientesDAOIMPL implements PacientesDAO {

	   public void validarMail(Pacientes unPaciente) throws RuntimeException {
		   int arroba = 0;
		   String mail=unPaciente.getMail();
		   for (int i=0; i<mail.length();i++){
			   if(mail.charAt(i)=='@'){
				   arroba++;
				  
			   }
		   }
		   if (arroba==1){
			   System.out.println("El mail es correcto");
		   }else if (arroba != 1){
			   
			   throw new ErrorMailException("el mail no contiene '@' ");
			   
			   
		   	 }
		   }
	
	
	
	
	public void crearPaciente(Pacientes unPaciente) throws ErrorMailException, IdRepetidoException {

		String id= unPaciente.getId();
		String dni = unPaciente.getDni();
		String nombre = unPaciente.getNombre();
		String apellido= unPaciente.getApellido();
		String mail=unPaciente.getMail();
		try {
			validarMail(unPaciente);
			validarPaciente(unPaciente);
	        Connection dbconnect = DBManager.connect();
	        try {
	            Statement st = dbconnect.createStatement(); // la coneccion a la base de datosse llama " dbconnect" si se da correctamente la conexion
	                                                              // se me crea un Statement con el CreateStatement. Es decir, se me crea la sentencia.
	//
	            String sql = "INSERT INTO ENTIDADES.pacientes (id, nombre, apellido, dni, mail) VALUES ('" + id + "', '" + nombre + "', '" + apellido + "', '" + dni + "', '" + mail + "')";
	            st.executeUpdate(sql); //  aca puedo guardar este valor dentro de una variable Resultset, por ej ResultSet= st.executeUpdate(sql); pero solo memostraria el resultado deel excecuteUpdate. y no me sirve de nada, ya que el update devuelve el numero de las columnas o tuplas que fueron modificaddas.
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
		} catch (RuntimeException e2){
			JOptionPane.showMessageDialog(null, "No se pudo dar de alta el paciente RAZON: " + e2.getMessage());
			String mailOtro=unPaciente.getMail();
			mail = mailOtro;
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "No se pudo dar de alta el paciente RAZON: " + ex.getMessage());
		}
		
		

    }
	
	   public void actualizaPaciente(Pacientes unPaciente) throws ErrorMailException  {
			String id= unPaciente.getId();
			String nombre = unPaciente.getNombre();
			String apellido= unPaciente.getApellido();
			String dni = unPaciente.getDni();
			String mail=unPaciente.getMail();

			String sql = "UPDATE ENTIDADES.pacientes set nombre= '" + nombre + "',apellido = '" + apellido + "',dni = '"+ dni + "',mail= '" + mail + "' WHERE id = " + id + "";
	        try{
	        validarMail(unPaciente);
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
	        } catch (Exception e2){
	        	JOptionPane.showMessageDialog(null, "No se pudo dar de alta el paciente RAZON: " + e2.getMessage());
	        }
	    }
	   
	    public void borrarPaciente(String id) {
	        String sql = "DELETE FROM ENTIDADES.pacientes WHERE id = '" + id + "'";
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
	    
	    public List<Pacientes> muestraTodosLosPacientes(){
	    	String id;
	    	String nombre;
	    	String apellido;
	    	String dni;
	    	String mail;
	    	
	        List<Pacientes> lista = new ArrayList<>();
	        String sql = "SELECT * FROM ENTIDADES.pacientes;";
	        Connection c = DBManager.connect();
	        try {
	            Statement s = c.createStatement();
	            ResultSet resultados = s.executeQuery(sql);

	            while (resultados.next()) {

	            	
	            	
	                 id = resultados.getString("id");
	                 nombre = resultados.getString("nombre");
	                 apellido =resultados.getString("apellido");
	                 dni= resultados.getString("dni");
	                 mail = resultados.getString("mail");
	                 Pacientes p = new Pacientes(id,nombre,apellido,dni,mail);
	                 lista.add(p);
	                 
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
	    
	    
	    public Pacientes muestraPacientes(String id) {
	        String sql = "SELECT * FROM ENTIDADES.pacientes WHERE id = '" + id  + "'";
	        Connection c = DBManager.connect();
	        try {
	            Statement s = c.createStatement();
	            ResultSet rs = s.executeQuery(sql);

	            
	            if (rs.next()) {
	                Pacientes p = new Pacientes();
	                p.setId(rs.getString("id")); 
	                p.setNombre(rs.getString("nombre"));
	                p.setApellido(rs.getString("apellido")); 
	                p.setDni(rs.getString("dni")); 
	                p.setMail(rs.getString("mail")); 
	                return p;
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
 public void validarPaciente (Pacientes unPaciente) throws Exception{
	    	
	    	String sql = "SELECT * FROM ENTIDADES.pacientes WHERE (id = '"+ unPaciente.getId()+"')";
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
   
	

