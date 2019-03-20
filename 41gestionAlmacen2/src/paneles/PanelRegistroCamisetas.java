package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Camiseta;
import modelo.CamisetaDAOImpl;
import modelo.CamisetasDAO;
import modelo.CamisetasDAOImplMock;

public class PanelRegistroCamisetas extends JPanel implements ActionListener {

	private JTextField campoNombre = new JTextField(8);
	private JComboBox campoTalla = new JComboBox();
	private JTextField campoPrecio = new JTextField(8);
	private JTextField campoMaterial = new JTextField(8);
	private JComboBox campoSexo = new JComboBox();
	private JButton botonRegistro = new JButton("REGISTRAR");

	public PanelRegistroCamisetas() {
		campoTalla.addItem("pequeña");
		campoTalla.addItem("mediana");
		campoTalla.addItem("grande");
		campoSexo.addItem("hombre");
		campoSexo.addItem("mujer");
		campoSexo.addItem("unisex");

		// para colocar las cosas usando filas y columnas debo asignar como
		// layout un GridBagLayout
		setLayout(new GridBagLayout());
		// ahora lo que espera el panel es que cuando agreguemos algo le digamos
		// en que x e y lo va a meter
		GridBagConstraints gbc = new GridBagConstraints();

		// primera fila
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("nombre:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		add(campoNombre, gbc);

		// segunda fila
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("talla:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		add(campoTalla, gbc);

		// tercera fila
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Precio:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		add(campoPrecio, gbc);

		// cuarta fila

		gbc.gridx = 0;
		gbc.gridy = 3;
		add(new JLabel("Material:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		add(campoMaterial, gbc);

		// quinta fila

		gbc.gridx = 0;
		gbc.gridy = 4;
		add(new JLabel("Sexo:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		add(campoSexo, gbc);

		//ultima linea
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 5; // significa que va a ocupar dos celdas
		add(botonRegistro, gbc);

		botonRegistro.addActionListener(this);

	}// end constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		Camiseta nueva = new Camiseta();
		String nombre = campoNombre.getText();
		String tamano = campoTalla.getSelectedItem().toString();
		String precio = campoPrecio.getText();
		precio = precio.replace(",", ".");
		double precioDouble = -1;
		String material = campoMaterial.getText();
		String sexo = campoSexo.getSelectedItem().toString();
		
		try {
			precioDouble = Double.parseDouble(precio);
			nueva.setNombre(nombre);
			nueva.setPrecio(precioDouble);
			nueva.setTamano(tamano);
			nueva.setMaterial(material);
			nueva.setSexo(sexo);
			// hasta aquí hemos llegado con las tareas visuales de cara al
			// panel, ahora para tratar
			// temas de acceso/registro a base de datos se debe encargar otra
			// clase de otro paquete/capa
			// en este caso CamisetasDAOImpl

			// de una interfaz no se puede crear un objeto pero si asignar un
			// objeto de la clase que lo implementa
			CamisetasDAO dao = new CamisetaDAOImpl();
			dao.registrarCamiseta(nueva);
			JOptionPane.showMessageDialog(this, "camiseta registrada");
			campoNombre.setText("");
			campoPrecio.setText("");
			campoMaterial.setText("");
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(this, "precio incorrecto");
		}

	}// end actionperformed

}// end class
