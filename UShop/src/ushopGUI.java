import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;

public class ushopGUI {

	private JFrame frmUshopShoppingList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ushopGUI window = new ushopGUI();
					window.frmUshopShoppingList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ushopGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUshopShoppingList = new JFrame();
		frmUshopShoppingList.setTitle("UShop Shopping List");
		frmUshopShoppingList.setFont(new Font("Arial", Font.PLAIN, 12));
		frmUshopShoppingList.setBounds(100, 100, 450, 300);
		frmUshopShoppingList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		frmUshopShoppingList.getContentPane().add(panel, BorderLayout.NORTH);
		
		JTextPane txtpnUshop = new JTextPane();
		txtpnUshop.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 24));
		txtpnUshop.setForeground(new Color(51, 255, 255));
		txtpnUshop.setBackground(new Color(0, 102, 153));
		txtpnUshop.setText("UShop");
		panel.add(txtpnUshop);
		
		JButton btnAggiungiProdotto = new JButton("Aggiungi Prodotto");
		frmUshopShoppingList.getContentPane().add(btnAggiungiProdotto, BorderLayout.CENTER);
		
		JButton btnMostraLista = new JButton("Mostra Lista");
		frmUshopShoppingList.getContentPane().add(btnMostraLista, BorderLayout.WEST);
		
		JButton btnRimuoviProdotto = new JButton("Rimuovi Prodotto");
		frmUshopShoppingList.getContentPane().add(btnRimuoviProdotto, BorderLayout.EAST);
		
		JButton btnEsci = new JButton("Esci");
		frmUshopShoppingList.getContentPane().add(btnEsci, BorderLayout.SOUTH);
	}

}
