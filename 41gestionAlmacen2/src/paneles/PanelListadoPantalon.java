package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import modelo.Pantalon;
import modelo.PantalonDAO;
import modelo.PantalonDAOImpl;
import modelo.PantalonDAOImplMock;

public class PanelListadoPantalon extends JPanel implements MouseListener,
		ActionListener {

	private JTable jTable = null;
	private JButton boton = new JButton("borrar");
	int indiceAborrar = -1;
	ArrayList<Pantalon> pantalones = null;

	public PanelListadoPantalon() {
		refrescarPanelListadoPantalon();
		boton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		long idAborrar = pantalones.get(indiceAborrar).getId();
		System.out.println("borrar id: " + idAborrar);
		PantalonDAO dao = new PantalonDAOImpl();
		dao.borrarPantalon(idAborrar);
		refrescarPanelListadoPantalon();

	}
	
	private void refrescarPanelListadoPantalon(){
		removeAll(); //vacio el panel actual por si tiene algo y lo vuelve a formar
	PantalonDAOImpl dao = new PantalonDAOImpl();
	pantalones = dao.obtenerPantalon();
	String[] cabecera = {"id","nombre","talla","precio","material","sexo"};
	String [][] datosTabla = new String [pantalones.size()][6];
	for(int i = 0; i < pantalones.size(); i++){
		datosTabla[i][0] = String.valueOf(pantalones.get(i).getId());
		datosTabla[i][1] = pantalones.get(i).getNombre();
		datosTabla[i][2] = pantalones.get(i).getTamano();
		datosTabla[i][3] = String.valueOf(pantalones.get(i).getPrecio());
		datosTabla[i][4] = pantalones.get(i).getMaterial();
		datosTabla[i][5] = pantalones.get(i).getSexo();
		
		}
	
	jTable = new JTable(datosTabla,cabecera);
	jTable.setPreferredScrollableViewportSize(new Dimension(500,220));
	jTable.setFillsViewportHeight(true);
	
	JScrollPane jp = new JScrollPane(jTable);
	jTable.addMouseListener(this);
	
	add(jp);
	add(boton);
	SwingUtilities.updateComponentTreeUI(this);
	}
	
	
	


	
	@Override
	public void mouseClicked(MouseEvent me) {
		System.out.println("click en la tabla");
		int fila = jTable.rowAtPoint(me.getPoint());
		indiceAborrar = fila;
		System.out.println("fila: " + fila);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
