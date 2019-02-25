import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
	
	public void append(String s, JEditorPane pane) {
		   try {
		      Document doc = pane.getDocument();
		      doc.insertString(doc.getLength(), s, null);
		   } catch(BadLocationException exc) {
		      exc.printStackTrace();
		   }
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
		frmUshopShoppingList.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		panel.setBackground(new Color(0, 102, 153));
		frmUshopShoppingList.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAggiungiProdotto = new JButton("Aggiungi Prodotto");
		btnAggiungiProdotto.setBounds(101, 47, 202, 184);
		panel.add(btnAggiungiProdotto);
		btnAggiungiProdotto.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			if(nuovaLista.aggiungiProdotto(textField.getText())) {
		    JDialog d = new JDialog(frmUshopShoppingList, "Aggiunto", true);
		    d.setLocationRelativeTo(frmUshopShoppingList);
		    d.setVisible(true);
			}
			else {
			JDialog e1 = new JDialog(frmUshopShoppingList, "Errore nell'aggiunta", true);	
			e1.setLocationRelativeTo(frmUshopShoppingList);
		    e1.setVisible(true);
			}
			textField.setText(null);
		  }
		});
		
		JPanel mostraListaPane = new JPanel();
		mostraListaPane.setBounds(0, 47, 432, 206);
		frmUshopShoppingList.getContentPane().add(mostraListaPane);
		mostraListaPane.setLayout(null);
		mostraListaPane.setVisible(false);
		
		JTextPane txtpnLista = new JTextPane();
		txtpnLista.setToolTipText("");
		txtpnLista.setBounds(12, 13, 321, 158);
		mostraListaPane.add(txtpnLista);
		
		JScrollPane jsp = new JScrollPane(txtpnLista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mostraListaPane.add(jsp);
		jsp.setToolTipText("");
		jsp.setBounds(12, 13, 321, 158);
		jsp.setVisible(true);
		
		JButton btnMostraLista = new JButton("Mostra Lista");
		btnMostraLista.setBounds(0, 47, 101, 184);
		btnMostraLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostraListaPane.setVisible(true);
				panel.setVisible(false);
				for (Prodotto prod : nuovaLista.list) {
				append(prod.getNome()+"\n", txtpnLista);
				}
			}
		});
		panel.add(btnMostraLista);
		
		
		JButton btnRimuoviProdotto = new JButton("Rimuovi Prodotto");
		btnRimuoviProdotto.setBounds(303, 47, 129, 184);
		panel.add(btnRimuoviProdotto);
		btnRimuoviProdotto.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			nuovaLista.rimuoviProdotto(textField.getText());          
		    JDialog d = new JDialog(frmUshopShoppingList, "Rimosso", true);
		    d.setLocationRelativeTo(frmUshopShoppingList);
		    d.setVisible(true);
		    textField.setText(null);
		  }
		});
		
		textField = new JTextField();
		textField.setBounds(0, 231, 432, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUshop = new JLabel("UShop");
		lblUshop.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblUshop.setHorizontalAlignment(SwingConstants.CENTER);
		lblUshop.setBounds(0, 0, 432, 47);
		panel.add(lblUshop);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostraListaPane.setVisible(false);
				panel.setVisible(true);
				Document doc = txtpnLista.getDocument();
				try {
					doc.remove(0, doc.getLength());
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnIndietro.setBounds(345, 134, 85, 37);
		mostraListaPane.add(btnIndietro);
	}
}
