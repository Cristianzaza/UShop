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

	public JFrame frmUshopShoppingList;
	private JTextField textField;
	Lista nuovaLista = new Lista();
	private JTextField txtInserireIlNome;

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
		
		JPanel mostraListaPane = new JPanel();
		mostraListaPane.setBounds(0, 0, 432, 253);
		frmUshopShoppingList.getContentPane().add(mostraListaPane);
		mostraListaPane.setLayout(null);
		mostraListaPane.setVisible(true);
		
		JTextPane txtpnLista = new JTextPane();
		txtpnLista.setEditable(false);
		txtpnLista.setToolTipText("");
		txtpnLista.setBounds(12, 13, 321, 158);
		mostraListaPane.add(txtpnLista);
		
		JScrollPane jsp = new JScrollPane(txtpnLista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mostraListaPane.add(jsp);
		jsp.setToolTipText("");
		jsp.setBounds(12, 13, 321, 172);
		
		
		JButton btnRimuoviProdotto = new JButton("Rimuovi");
		btnRimuoviProdotto.setBounds(334, 214, 86, 39);
		mostraListaPane.add(btnRimuoviProdotto);
		
		JButton btnAggiungiProdotto = new JButton("Aggiungi");
		btnAggiungiProdotto.setBounds(334, 176, 86, 39);
		mostraListaPane.add(btnAggiungiProdotto);
		
		textField = new JTextField();
		textField.setBounds(35, 222, 276, 22);
		mostraListaPane.add(textField);
		textField.setColumns(10);
		
		txtInserireIlNome = new JTextField();
		txtInserireIlNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireIlNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtInserireIlNome.setText("Inserire il nome del prodotto");
		txtInserireIlNome.setBounds(12, 198, 310, 22);
		txtInserireIlNome.setOpaque(false);
		txtInserireIlNome.setBorder(null);
		mostraListaPane.add(txtInserireIlNome);
		txtInserireIlNome.setColumns(10);
		btnAggiungiProdotto.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			if(nuovaLista.aggiungiProdotto(textField.getText())) {
		    JDialog d = new JDialog(frmUshopShoppingList, "Aggiunto", true);
		    d.setLocationRelativeTo(frmUshopShoppingList);
		    d.setVisible(true);
		    Document doc = txtpnLista.getDocument();
	    	try {
	    		doc.remove(0, doc.getLength());
	    	} catch (BadLocationException e1) {
	    		e1.printStackTrace();
	    	}
		    for(Prodotto prod : nuovaLista.list) {
		    	append(prod.getNome()+"\n",txtpnLista);
		    }
			}
			else {
			JDialog e1 = new JDialog(frmUshopShoppingList, "Errore nell'aggiunta", true);	
			e1.setLocationRelativeTo(frmUshopShoppingList);
		    e1.setVisible(true);
			}
			textField.setText(null);
		  }
		});
		btnRimuoviProdotto.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			if(nuovaLista.rimuoviProdotto(textField.getText())) {          
				JDialog d = new JDialog(frmUshopShoppingList, "Rimosso", true);
				d.setLocationRelativeTo(frmUshopShoppingList);
				d.setVisible(true);
				Document doc = txtpnLista.getDocument();
		    	try {
		    		doc.remove(0, doc.getLength());
		    	} catch (BadLocationException e1) {
		    		e1.printStackTrace();
		    	}
				for(Prodotto prod : nuovaLista.list) {
					append(prod.getNome()+"\n",txtpnLista);
			    }
			}
			else {
				JDialog e1 = new JDialog(frmUshopShoppingList, "Errore nella rimozione", true);
				e1.setLocationRelativeTo(frmUshopShoppingList);
				e1.setVisible(true);
				}
			textField.setText(null);
		  }
		});
		jsp.setVisible(true);
	}
}
