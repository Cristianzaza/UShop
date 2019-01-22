import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JTextField;

public class ushopGUI {

	private JFrame frmUshopShoppingList;
	private JTextField textField;
	Lista nuovaLista = new Lista();

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
		btnAggiungiProdotto.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			nuovaLista.aggiungiProdotto2(textField.getText());
		    JDialog d = new JDialog(frmUshopShoppingList, "Aggiunto", true);
		    d.setLocationRelativeTo(frmUshopShoppingList);
		    d.setVisible(true);
		  }
		});
		
		JButton btnMostraLista = new JButton("Mostra Lista");
		btnMostraLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostraListaDial mostra1 = new mostraListaDial(nuovaLista);
			}
		});
		frmUshopShoppingList.getContentPane().add(btnMostraLista, BorderLayout.WEST);
		
		
		JButton btnRimuoviProdotto = new JButton("Rimuovi Prodotto");
		frmUshopShoppingList.getContentPane().add(btnRimuoviProdotto, BorderLayout.EAST);
		btnRimuoviProdotto.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			nuovaLista.rimuoviProdotto2(textField.getText());          
		    JDialog d = new JDialog(frmUshopShoppingList, "Rimosso", true);
		    d.setLocationRelativeTo(frmUshopShoppingList);
		    d.setVisible(true);
		  }
		});
		
		textField = new JTextField();
		frmUshopShoppingList.getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
	}

}
