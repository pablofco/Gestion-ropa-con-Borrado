package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import paneles.PanelInicio;
import paneles.PanelListadoCamisetas;
import paneles.PanelListadoPantalon;
import paneles.PanelRegistroCamisetas;
import paneles.PanelRegistroPantalon;

public class VentanaPrincipal extends JFrame implements ActionListener { //doble click ventana principal para add lo de override
	
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu menuCamisetas = new JMenu("Camisetas");
	private JMenuItem registrarCamisetas = new JMenuItem("Nueva Camisetas");
	private JMenuItem listarCamisetas = new JMenuItem("Listado Camisetas");
	
	
	private JMenu menuPantalones = new JMenu("Pantalones");
	private JMenuItem registrarPantalones = new JMenuItem("Nuevo Pantalon");
	private JMenuItem listarPantalones = new JMenuItem("Listado Pantalones");
	
	
	public VentanaPrincipal(){
		// preparacion de la ventana
		setTitle("Aplicacion de gestion de tienda de ropa");
		setSize(600,400);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// preparacion de la barra de menu
		registrarCamisetas.addActionListener(this);
		menuCamisetas.add(registrarCamisetas);
		listarCamisetas.addActionListener(this);
		menuCamisetas.add(listarCamisetas);
		barraDeMenu.add(menuCamisetas);
		setJMenuBar(barraDeMenu);
		
		registrarPantalones.addActionListener(this);
		menuPantalones.add(registrarPantalones);
		listarPantalones.addActionListener(this);
		menuPantalones.add(listarPantalones);
		barraDeMenu.add(menuPantalones);
		setJMenuBar(barraDeMenu);
		
		

		setContentPane(new PanelInicio());
		setVisible(true);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("se ejecuta actionPerfomed de" + "VentanaPrincipal");
		System.out.println("comando: " +  e.getActionCommand());
		switch (e.getActionCommand()){
		
	
		case "Nueva Camisetas":
			System.out.println("mostrar panel registro camisetas");
			setContentPane(new PanelRegistroCamisetas());
			break;
		case "Listado Camisetas":
			System.out.println("mostrar panel listado camisetas");
			setContentPane(new PanelListadoCamisetas());
			break;
		case "Nuevo Pantalon":
			System.out.println("mostrar panel registro pantalon");
			setContentPane(new PanelRegistroPantalon());
			break;
		case "Listado Pantalones":
			System.out.println("mostrar panel registro patalones");
			setContentPane(new PanelListadoPantalon());
			break;
			
			default:
				break;
		}
		// para refrescar la ventana tras cambiar su panel:
		SwingUtilities.updateComponentTreeUI(this);
	}

}
