package entidades;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class TableManager {




	
	public void dropUserTable() {

		Connection t = DBManager.connect();
		
		String sq = "DROP TABLE medicos";
		
		try {
			Statement s = t.createStatement();
			s.execute(sq);
			t.commit();
		} catch (SQLException e) {
			try {
				t.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				t.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}




	public void createUserTable() 
	{

		Connection co = DBManager.connect();
		// CREATE TABLE ENTIDADES.turnos( idturno INTEGER IDENTITY, NombreMedico VARCHAR(256), apellidoMedico VARCHAR(10), NombrePaciente VARCHAR(256), ApellidoPaciente VARCHAR(10), DniPaciente VARCHAR(10), Fecha DATE, Hora TIME)
 //   	String sq = "CREATE TABLE ENTIDADES.pacientes ( id INTEGER IDENTITY, nombre VARCHAR(256), apellido VARCHAR(10), dni VARCHAR(256))";		
	    String sq = "CREATE TABLE ENTIDADES.medicos ( CODid INTEGER IDENTITY, nombre VARCHAR(256), apellido VARCHAR(10), pw VARCHAR(256), tipoPerfil VARCHAR(256), montoConsulta VARCHAR(256))";

		try {
			Statement s = co.createStatement();
			s.execute(sq);
		} catch (SQLException e) {
			try {
				co.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	

}
	
