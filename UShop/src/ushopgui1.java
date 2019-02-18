import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class ushopgui1 {

	private JFrame frame;
	private JLayeredPane layeredPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ushopgui1 window = new ushopgui1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels (JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}
	
	/**
	 * Create the application.
	 */
	public ushopgui1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(0, 0, 432, 253);
		frame.getContentPane().add(layeredPane_1);
		
		JPanel homePage = new JPanel();
		homePage.setBounds(0, 0, 432, 253);
		layeredPane_1.add(homePage);
		homePage.setLayout(null);
		
		JPanel creaModifica = new JPanel();
		creaModifica.setBounds(0, 0, 432, 253);
		layeredPane_1.add(creaModifica);
		creaModifica.setLayout(null);
		
				
				JButton Creamodifica = new JButton("Crea/Modifica Lista");
				Creamodifica.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switchPanels(creaModifica);
					}
				});
				Creamodifica.setBounds(41, 95, 159, 62);
				homePage.add(Creamodifica);
				
				JButton btnVisualizzaPercorso = new JButton("Visualizza Percorso");
				btnVisualizzaPercorso.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnVisualizzaPercorso.setBounds(212, 95, 159, 62);
				homePage.add(btnVisualizzaPercorso);
				
				JButton btnEsci = new JButton("Esci");
				btnEsci.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnEsci.setBounds(323, 215, 97, 25);
				homePage.add(btnEsci);
		

		
		JLabel lblCarne = new JLabel("Carne");
		lblCarne.setBounds(28, 37, 99, 16);
		creaModifica.add(lblCarne);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlus.setBounds(113, 33, 41, 25);
		creaModifica.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setBounds(185, 33, 41, 25);
		creaModifica.add(btnMinus);
		
		JButton button = new JButton("Esci");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(homePage);
			}
		});
		button.setBounds(323, 215, 97, 25);
		creaModifica.add(button);
	}
}
