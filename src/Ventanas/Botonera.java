package Ventanas;

import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
public class Botonera extends JPanel{
	
	
private	JLabel idLbl = new JLabel( "ID:" );
private	JLabel idMLbl = new JLabel( "ID Medico:" );
private	JLabel idPLbl = new JLabel( "ID Paciente:" );
private	JLabel nombreLbl = new JLabel( "Nombre:" );
private	JLabel apellidoLbl = new JLabel( "Apellido:" );
private	JLabel nombreMLbl = new JLabel( "Nombre Medico:" );
private	JLabel apellidoMLbl = new JLabel( "Apellido Apellido:" );
private	JLabel nombrePLbl = new JLabel( "Nombre Paciente:" );
private	JLabel apellidoPLbl = new JLabel( "Apellido Paciente:" );
private	JLabel contraseñaLbl = new JLabel( "Contraseña:" );
private	JLabel montoconsultaLbl = new JLabel( "MontoConsulta:" );
private	JLabel fechalbl = new JLabel( "Fecha (YYYY-MM-DD):" );
private	JLabel horalbl = new JLabel( "Hora:" );
private	JLabel maillbl = new JLabel ("Mail:");
private	JLabel dnilbl = new JLabel ("DNI:");	
private	JLabel dniPlbl = new JLabel ("DNI Paciente:");
private	JLabel tipoPerfillbl = new JLabel ("TipoPerfil:");
private	JComboBox combo = new JComboBox();
private	JComboBox combo2 = new JComboBox();
private	JComboBox comboIdP = new JComboBox();
private	JComboBox comboIdM = new JComboBox();
private	JTextField idTXT = new JTextField( "", 10 );
private	JTextField nombreTXT = new JTextField( "", 10 );
private	JTextField apellidoTXT  = new JTextField( "", 10 );
private	JTextField nombreMTXT = new JTextField( "", 10 );
private	JTextField apellidoMTXT  = new JTextField( "", 10 );
private	JTextField nombrePTXT = new JTextField( "", 10 );
private	JTextField apellidoPTXT  = new JTextField( "", 10 );
private	JTextField contraseñaTXT = new JTextField( "", 10 );
private	JTextField montoconsultaTXT  = new JTextField( "", 10 );
private	JTextField dnitxt = new JTextField( "", 10 );
private	JTextField mailtxt = new JTextField( "", 10 );
private JTextField fechatxt = new JTextField( "YYYY-MM-DD", 10 );
private JTextField fechatxt2 = new JTextField( "YYYY-MM-DD", 10 );
private JTextField horatxt = new JTextField( "HH:MM:SS", 10 ); // HACIENDO UN TO STRING CONCATENANDO LA CADENA QUIZAS PUEDO. ARMO UN CAMPO PARA MIN,HORA, SEG, AÑO , ETC. Y DESPUES EN UN TO STRING AGREGO ESAS VAARIABLES Y LAS SEPARO CON / Y : 
private JButton  btnConfirmar = new JButton("Confirmar");
private JDateChooser date_chooser = new JDateChooser();





public JComboBox getCombo2() {
	return combo2;
}

public void setCombo2(JComboBox combo2) {
	this.combo2 = combo2;
}

public JDateChooser getDate_chooser() {
	return date_chooser;
}

public void combohora(){
	 combo = new JComboBox();
	for (Integer i = 10 ; i <20; ++i){
        combo.addItem(i);
        
	}
}

public void combominuto(){
        combo2 = new JComboBox();
        combo2.addItem("00");
        combo2.addItem("30");
}


public String ArmarHora(JComboBox combo, JComboBox combo2){
	String horario = ( combo.getSelectedItem() + ":"+ combo2.getSelectedItem() + ":00");
	return horario;
}

public void setDate_chooser(JDateChooser date_chooser) {
	this.date_chooser = date_chooser;
	
}


public JDateChooser fechacrear () {
	date_chooser.setDateFormatString("yyyy-MM-dd");
	return date_chooser;
}


public String fechacastear(){
	SimpleDateFormat strf = new SimpleDateFormat("yyyy-MM-dd");
	String fecha = strf.format(fechacrear());
	return fecha;
}

public JTextField getFechatxt2() {
	return fechatxt2;
}



public void setFechatxt2(JTextField fechatxt2) {
	this.fechatxt2 = fechatxt2;
}



public JButton getBotonCrear() {
	return botonCrear;
}



public void setBotonCrear(JButton botonCrear) {
	this.botonCrear = botonCrear;
}



public JButton getBotonModificar() {
	return botonModificar;
}



public void setBotonModificar(JButton botonModificar) {
	this.botonModificar = botonModificar;
}



public JButton getBotonBorrar() {
	return botonBorrar;
}



public void setBotonBorrar(JButton botonBorrar) {
	this.botonBorrar = botonBorrar;
}
 JButton botonCrear = new JButton("ALTA");
 JButton botonModificar = new JButton("MODIFICACION");
 JButton botonBorrar = new JButton("BORRAR");
	public JLabel getIdMLbl() {
		return idMLbl;
	}



	public void setIdMLbl(JLabel idMLbl) {
		this.idMLbl = idMLbl;
	}



	public JLabel getIdPLbl() {
		return idPLbl;
	}



	public void setIdPLbl(JLabel idPLbl) {
		this.idPLbl = idPLbl;
	}



	public JComboBox getComboIdP() {
		return comboIdP;
	}



	public void setComboIdP(JComboBox comboIdP) {
		this.comboIdP = comboIdP;
	}



	public JComboBox getComboIdM() {
		return comboIdM;
	}



	public void setComboIdM(JComboBox comboIdM) {
		this.comboIdM = comboIdM;
	}

	
	
	
	
	



	public JLabel getDniPlbl() {
		return dniPlbl;
	}



	public void setDniPlbl(JLabel dniPlbl) {
		this.dniPlbl = dniPlbl;
	}



	public JTextField getFechatxt() {
		return fechatxt;
	}



	public void setFechatxt(JTextField fechatxt) {
		this.fechatxt = fechatxt;
	}



	public JTextField getHoratxt() {
		return horatxt;
	}



	public void setHoratxt(JTextField horatxt) {
		this.horatxt = horatxt;
	}



	public JLabel getNombreMLbl() {
		return nombreMLbl;
	}



	public void setNombreMLbl(JLabel nombreMLbl) {
		this.nombreMLbl = nombreMLbl;
	}



	public JLabel getApellidoMLbl() {
		return apellidoMLbl;
	}



	public void setApellidoMLbl(JLabel apellidoMLbl) {
		this.apellidoMLbl = apellidoMLbl;
	}



	public JLabel getNombrePLbl() {
		return nombrePLbl;
	}



	public void setNombrePLbl(JLabel nombrePLbl) {
		this.nombrePLbl = nombrePLbl;
	}



	public JLabel getApellidoPLbl() {
		return apellidoPLbl;
	}



	public void setApellidoPLbl(JLabel apellidoPLbl) {
		this.apellidoPLbl = apellidoPLbl;
	}



	public JLabel getFechalbl() {
		return fechalbl;
	}



	public void setFechalbl(JLabel fechalbl) {
		this.fechalbl = fechalbl;
	}



	public JLabel getHoralbl() {
		return horalbl;
	}



	public void setHoralbl(JLabel horalbl) {
		this.horalbl = horalbl;
	}



	public JTextField getNombreMTXT() {
		return nombreMTXT;
	}



	public void setNombreMTXT(JTextField nombreMTXT) {
		this.nombreMTXT = nombreMTXT;
	}



	public JTextField getApellidoMTXT() {
		return apellidoMTXT;
	}



	public void setApellidoMTXT(JTextField apellidoMTXT) {
		this.apellidoMTXT = apellidoMTXT;
	}



	public JTextField getNombrePTXT() {
		return nombrePTXT;
	}



	public void setNombrePTXT(JTextField nombrePTXT) {
		this.nombrePTXT = nombrePTXT;
	}



	public JTextField getApellidoPTXT() {
		return apellidoPTXT;
	}



	public void setApellidoPTXT(JTextField apellidoPTXT) {
		this.apellidoPTXT = apellidoPTXT;
	}



	public void setTipoPerfillbl(JLabel tipoPerfillbl) {
		this.tipoPerfillbl = tipoPerfillbl;
	}



	public JLabel getTipoPerfillbl() {
		return tipoPerfillbl;
	}



	public void setTipoPerfil(JLabel tipoPerfillbl) {
		this.tipoPerfillbl = tipoPerfillbl;
	}



	public JLabel getMaillbl() {
		return maillbl;
	}



	public void setMaillbl(JLabel maillbl) {
		this.maillbl = maillbl;
	}



	public JLabel getDnilbl() {
		return dnilbl;
	}



	public void setDnilbl(JLabel dnilbl) {
		this.dnilbl = dnilbl;
	}



	public JTextField getDnitxt() {
		return dnitxt;
	}



	public void setDnitxt(JTextField dnitxt) {
		this.dnitxt = dnitxt;
	}



	public JTextField getMailtxt() {
		return mailtxt;
	}



	public void setMailtxt(JTextField mailtxt) {
		this.mailtxt = mailtxt;
	}
	JButton btnCancelar = new JButton( "Cancelar/Volver" );
	
	public void botonera(){
		
	}
	


	public JLabel getIdLbl() {
		return idLbl;
	}
	public void setIdLbl(JLabel idLbl) {
		this.idLbl = idLbl;
	}
	public JLabel getNombreLbl() {
		return nombreLbl;
	}
	public void setNombreLbl(JLabel nombreLbl) {
		this.nombreLbl = nombreLbl;
	}
	public JLabel getApellidoLbl() {
		return apellidoLbl;
	}
	public void setApellidoLbl(JLabel apellidoLbl) {
		this.apellidoLbl = apellidoLbl;
	}
	public JLabel getContraseñaLbl() {
		return contraseñaLbl;
	}
	public void setContraseñaLbl(JLabel contraseñaLbl) {
		this.contraseñaLbl = contraseñaLbl;
	}
	public JLabel getMontoconsultaLbl() {
		return montoconsultaLbl;
	}
	public void setMontoconsultaLbl(JLabel montoconsultaLbl) {
		this.montoconsultaLbl = montoconsultaLbl;
	}
	public JComboBox getCombo() {
		return combo;
	}
	public void setCombo(JComboBox combo) {
		this.combo = combo;
	}
	public JTextField getidTXT() {
		return idTXT;
	}
	public void setIdTXT(JTextField idTXT) {
		this.idTXT = idTXT;
	}
	public JTextField getNombreTXT() {
		return nombreTXT;
	}
	public void setNombreTXT(JTextField nombreTXT) {
		this.nombreTXT = nombreTXT;
	}
	public JTextField getApellidoTXT() {
		return apellidoTXT;
	}
	public void setApellidoTXT(JTextField apellidoTXT) {
		this.apellidoTXT = apellidoTXT;
	}
	public JTextField getContraseñaTXT() {
		return contraseñaTXT;
	}
	public void setContraseñaTXT(JTextField contraseñaTXT) {
		this.contraseñaTXT = contraseñaTXT;
	}
	public JTextField getMontoconsultaTXT() {
		return montoconsultaTXT;
	}
	public void setMontoconsultaTXT(JTextField montoconsultaTXT) {
		this.montoconsultaTXT = montoconsultaTXT;
	}
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
	
	
	
	
	
public JFormattedTextField fechatext(){	
try{
	MaskFormatter mascara= new MaskFormatter("####-##-##");
	mascara.setPlaceholderCharacter('_');
	
	JFormattedTextField campo=new JFormattedTextField(mascara);
	return campo;
	
}catch(Exception ex){
	ex.printStackTrace();
}
return null;
}

public JFormattedTextField fechatext2(){	
try{
	MaskFormatter mascara2= new MaskFormatter("####-##-##");
	mascara2.setPlaceholderCharacter('_');
	
	JFormattedTextField campo2=new JFormattedTextField(mascara2);
	return campo2;
	
}catch(Exception ex){
	ex.printStackTrace();
}
return null;
}


	



}