import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class ushopGUI {

	public JFrame frmUshopShoppingList;
	private JTextField txtFf;
	protected Lista nuovaLista = new Lista();
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
		frmUshopShoppingList.setTitle("UShop");
		frmUshopShoppingList.setFont(new Font("Arial", Font.PLAIN, 12));
		frmUshopShoppingList.setBounds(100, 100, 1113, 668);
		frmUshopShoppingList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUshopShoppingList.getContentPane().setLayout(null);
		frmUshopShoppingList.setResizable(false);
		
		JPanel mostraListaPane = new JPanel();
		mostraListaPane.setBounds(0, 0, 1095, 621);
		frmUshopShoppingList.getContentPane().add(mostraListaPane);
		mostraListaPane.setLayout(null);
		mostraListaPane.setVisible(true);
		
		JTextPane txtpnLista = new JTextPane();
		txtpnLista.setEditable(false);
		txtpnLista.setToolTipText("");
		txtpnLista.setBounds(161, 13, 321, 158);
		mostraListaPane.add(txtpnLista);
		
		JScrollPane jsp = new JScrollPane(txtpnLista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mostraListaPane.add(jsp);
		jsp.setToolTipText("");
		jsp.setBounds(83, 101, 680, 402);
		
		
		JButton btnRimuoviProdotto = new JButton("Rimuovi");
		btnRimuoviProdotto.setFont(new Font("Source Sans Pro Light", Font.BOLD, 20));
		btnRimuoviProdotto.setBounds(775, 561, 200, 47);
		mostraListaPane.add(btnRimuoviProdotto);
		
		JButton btnAggiungiProdotto = new JButton("Aggiungi");
		btnAggiungiProdotto.setFont(new Font("Source Sans Pro Light", Font.BOLD, 20));
		btnAggiungiProdotto.setBounds(775, 503, 200, 47);
		mostraListaPane.add(btnAggiungiProdotto);
		
		txtFf = new JTextField();
		txtFf.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 16));
		txtFf.setBounds(487, 540, 276, 22);
		mostraListaPane.add(txtFf);
		txtFf.setColumns(10);
		
		txtInserireIlNome = new JTextField();
		txtInserireIlNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireIlNome.setFont(new Font("Source Sans Pro Light", Font.BOLD, 18));
		txtInserireIlNome.setText("Inserire il nome del prodotto");
		txtInserireIlNome.setBounds(487, 516, 276, 22);
		txtInserireIlNome.setOpaque(false);
		txtInserireIlNome.setBorder(null);
		mostraListaPane.add(txtInserireIlNome);
		txtInserireIlNome.setColumns(10);
		
		JButton btnItinerario = new JButton("Calcolo \r\nItinerario");
		btnItinerario.setFont(new Font("Source Sans Pro Light", Font.BOLD, 21));
		btnItinerario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcoloItinerario itinerario = new calcoloItinerario();
				itinerario.frame.setVisible(true);
				itinerario.calcolo(nuovaLista, itinerario.flagGroup);
				
			}
		});
		btnItinerario.setBounds(775, 402, 200, 88);
		mostraListaPane.add(btnItinerario);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Source Sans Pro Light", Font.BOLD, 22));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuovaLista.svuota();
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
		});
		btnReset.setBounds(264, 516, 112, 48);
		mostraListaPane.add(btnReset);
		
		JLabel lblLaTuaLista = new JLabel("La tua lista");
		lblLaTuaLista.setForeground(new Color(0, 0, 0));
		lblLaTuaLista.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaTuaLista.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 34));
		lblLaTuaLista.setBounds(143, 51, 200, 41);
		mostraListaPane.add(lblLaTuaLista);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Source Sans Pro Light", Font.BOLD, 22));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmUshopShoppingList.setVisible(false);
			}
		});
		btnLogout.setBounds(83, 516, 112, 47);
		mostraListaPane.add(btnLogout);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(nuovaLista.prodottiDef);
		comboBox.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 16));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sel = (String)comboBox.getSelectedItem();
				txtFf.setText(sel);
			}
		});
		comboBox.setBounds(487, 572, 276, 25);
		mostraListaPane.add(comboBox);
		btnAggiungiProdotto.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			if(nuovaLista.aggiungiProdotto(txtFf.getText())) {
		    //JDialog d = new JDialog(frmUshopShoppingList, "Aggiunto", true);
		    //d.setLocationRelativeTo(frmUshopShoppingList);
		   // d.setVisible(true);
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
			txtFf.setText(null);
		  }
		});
		btnRimuoviProdotto.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			if(nuovaLista.rimuoviProdotto(txtFf.getText())) {          
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
			txtFf.setText(null);
		  }
		});
		jsp.setVisible(true);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(814, 51, 249, 328);
		mostraListaPane.add(labelLogo);
		
		Image img = new ImageIcon (this.getClass().getResource("/logo.png")).getImage();
		labelLogo.setIcon(new ImageIcon(img));
	}
}
