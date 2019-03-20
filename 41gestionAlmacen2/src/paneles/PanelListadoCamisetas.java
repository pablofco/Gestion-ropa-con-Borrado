package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import modelo.Camiseta;
import modelo.CamisetaDAOImpl;
import modelo.CamisetasDAO;
import modelo.CamisetasDAOImplMock;

public class PanelListadoCamisetas extends JPanel implements MouseListener,ActionListener{
	
	private JTable jTable = null;
	private JButton boton = new JButton("borrar");
	int indiceAborrar = -1;
	ArrayList<Camiseta> camisetas = null;
	
	
	public PanelListadoCamisetas() {
	refrescarPanelListadoCamisetas();
	boton.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		long idAborrar = camisetas.get(indiceAborrar).getId();
		System.out.println("borrar id: " + idAborrar);
		CamisetasDAO dao = new CamisetaDAOImpl();
		dao.borrarCamiseta(idAborrar);
		refrescarPanelListadoCamisetas();
		
		
		
	}

	private void refrescarPanelListadoCamisetas() {
		removeAll();//vacio el panel actual por si tiene algo y lo vuelve a formar
		CamisetaDAOImpl dao = new CamisetaDAOImpl();
		camisetas = dao.obtenerCamiseta();
		String[] cabecera = {"id","nombre","talla","precio"};
		String [][] datosTabla = new String [camisetas.size()][4];
		for (int i = 0; i < camisetas.size(); i++) {
			datosTabla[i][0] = String.valueOf(camisetas.get(i).getId());
			datosTabla[i][1] = camisetas.get(i).getNombre();
			datosTabla[i][2] = camisetas.get(i).getTamano();
			datosTabla[i][3] = String.valueOf(camisetas.get(i).getPrecio());
		}
		
		jTable = new JTable(datosTabla,cabecera);
		jTable.setPreferredScrollableViewportSize(new Dimension (500,220));
		jTable.setFillsViewportHeight(true);
		
		JScrollPane jp = new JScrollPane(jTable);
		
		jTable.addMouseListener(this);
		
		
		add(jp);
		add(boton);
		SwingUtilities.updateComponentTreeUI(this);
		
	}//end constructor
		
	
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

	
	
	

}//end class
