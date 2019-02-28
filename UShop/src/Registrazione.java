import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Registrazione {

	public JFrame frmUshop;
	public JTextField txtNomeField;
	public JTextField txtCognomeField;
	public JTextField txtEmailField;
	public JTextField txtTelefonoField;
	public JPasswordField txtPasswordField;
	public JPasswordField txtPassword2Field;

	/**
	 * Launch the application.
	 */

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione window = new Registrazione();
					window.frmUshop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registrazione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUshop = new JFrame();
		frmUshop.setTitle("U-Shop");
		frmUshop.getContentPane().setBackground(Color.WHITE);
		frmUshop.setBackground(Color.WHITE);
		frmUshop.setBounds(100, 100, 1113, 668);
		frmUshop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUshop.getContentPane().setLayout(null);
		frmUshop.setResizable(false);
		
		JLabel lblNome = new JLabel("Nome*");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Source Sans Pro Light", Font.BOLD, 22));
		lblNome.setForeground(Color.BLACK);
		lblNome.setBounds(145, 130, 155, 26);
		frmUshop.getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome*");
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setFont(new Font("Source Sans Pro Light", Font.BOLD, 22));
		lblCognome.setForeground(Color.BLACK);
		lblCognome.setBounds(145, 179, 155, 33);
		frmUshop.getContentPane().add(lblCognome);
		
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Source Sans Pro Light", Font.BOLD, 22));
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(145, 232, 155, 26);
		frmUshop.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Source Sans Pro Light", Font.BOLD, 22));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(145, 280, 155, 22);
		frmUshop.getContentPane().add(lblPassword);
		
		JLabel lblConfermaPassword = new JLabel("Conferma Password*");
		lblConfermaPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfermaPassword.setFont(new Font("Source Sans Pro Light", Font.BOLD, 22));
		lblConfermaPassword.setBounds(93, 330, 207, 22);
		frmUshop.getContentPane().add(lblConfermaPassword);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Source Sans Pro Light", Font.BOLD, 22));
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setBounds(145, 374, 155, 26);
		frmUshop.getContentPane().add(lblTelefono);
		
		txtNomeField = new JTextField();
		txtNomeField.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 22));
		txtNomeField.setBackground(Color.WHITE);
		txtNomeField.setForeground(Color.BLACK);
		txtNomeField.setBounds(302, 130, 520, 33);
		frmUshop.getContentPane().add(txtNomeField);
		txtNomeField.setColumns(10);
		
		txtCognomeField = new JTextField();
		txtCognomeField.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 22));
		txtCognomeField.setBounds(302, 180, 520, 33);
		frmUshop.getContentPane().add(txtCognomeField);
		txtCognomeField.setColumns(10);
		
		txtEmailField = new JTextField();
		txtEmailField.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 22));
		txtEmailField.setBounds(302, 232, 520, 33);
		frmUshop.getContentPane().add(txtEmailField);
		txtEmailField.setColumns(10);
		
		txtTelefonoField = new JTextField();
		txtTelefonoField.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 22));
		txtTelefonoField.setBounds(302, 374, 520, 33);
		frmUshop.getContentPane().add(txtTelefonoField);
		txtTelefonoField.setColumns(10);
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 22));
		txtPasswordField.setBounds(302, 278, 520, 33);
		frmUshop.getContentPane().add(txtPasswordField);
		
		txtPassword2Field = new JPasswordField();
		txtPassword2Field.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 22));
		txtPassword2Field.setBounds(302, 328, 520, 33);
		frmUshop.getContentPane().add(txtPassword2Field);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int flagControllo=0;
				//controlloNome
				if(txtNomeField.getText().isEmpty()) {
					lblNome.setForeground(Color.RED);
					flagControllo=1;
				}
				else
					lblNome.setForeground(Color.BLACK);
				
				//controlloCognome
				if(txtCognomeField.getText().isEmpty()) {
					lblCognome.setForeground(Color.RED);
					flagControllo=1;
				}
				else
					lblCognome.setForeground(Color.BLACK);
				
				//controlloEmail	
				if(txtEmailField.getText().isEmpty() || (!(txtEmailField.getText().contains("@")))) {
					lblEmail.setForeground(Color.RED);
					flagControllo=1;
				}
				else
					lblEmail.setForeground(Color.BLACK);
				
				//controlloPassword
				if(txtPasswordField.getText().isEmpty()) {
					lblPassword.setForeground(Color.RED);
					flagControllo=1;
				}
				else
					lblPassword.setForeground(Color.BLACK);
				
				if(txtPassword2Field.getText().isEmpty() || (!(txtPassword2Field.getText().contentEquals((txtPasswordField.getText()))))) {
					lblConfermaPassword.setForeground(Color.RED);
					flagControllo=1;
				}
				else
					lblConfermaPassword.setForeground(Color.BLACK);
				
				if((!(txtTelefonoField.getText().isEmpty())) && ((txtTelefonoField.getText().length() != 10) || (Pattern.matches("[0-9]+", txtTelefonoField.getText()) == false))) {
					lblTelefono.setForeground(Color.RED);
					flagControllo=1;
				}
				else 
					lblTelefono.setForeground(Color.BLACK);
				
				if(flagControllo==0) {	
				try {
					// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
					        @SuppressWarnings("unused")
							String driver = "com.mysql.cj.jdbc.Driver";
					 // Creiamo la stringa di connessione
					        String url = "jdbc:mysql://localhost:3306/uShop";
					 // Otteniamo una connessione con username e password
					        Connection con =
					        DriverManager.getConnection (url, "root", "adminushop04");
					 // Creiamo un oggetto Statement per poter interrogare il db
					        Statement cmd = con.createStatement ();
					        String qry = "SELECT MAX(ID) FROM login";
					        ResultSet res = cmd.executeQuery(qry);
					        res.next();
					        int last_id = res.getInt(1);
					        String qry_mail = "SELECT * FROM login";
					        ResultSet res_mail = cmd.executeQuery(qry_mail);
					        int flag_mail=0;
					        while(res_mail.next()){
					        	if (txtEmailField.getText().equalsIgnoreCase(res_mail.getString("email"))){
					        		flag_mail=1;
					        		JOptionPane.showMessageDialog(txtEmailField, "Email gia' utilizzata", "Invalid email", JOptionPane.ERROR_MESSAGE);
					        	}
					        }
					        //JOptionPane.showMessageDialog(null, "Connected", "Connectiontest", JOptionPane.INFORMATION_MESSAGE);
					        if(flag_mail==0) {
					        String insert_data = "insert into login values (?,?,?,?,?,?)";
					        PreparedStatement statement = con.prepareStatement(insert_data);
					        statement.setString(1, txtEmailField.getText());
					        statement.setString(2, txtPasswordField.getText());
					        statement.setString(3, txtNomeField.getText());
					        statement.setString(4, txtCognomeField.getText());
					        if(!(txtTelefonoField.getText().isEmpty())) {
					        	statement.setString(5, txtTelefonoField.getText());
					        	}
					        else
					        	statement.setString(5, "0");
					        statement.setInt(6, last_id+1);
					        int data_entered=0;
					        data_entered = statement.executeUpdate();
					        if(data_entered>0) {
					        	JOptionPane.showMessageDialog(null, "Registrazione avvenuta con successo", "Benvenuto!", JOptionPane.PLAIN_MESSAGE);
					        	frmUshop.setVisible(false);
					        	LoginUShop login = new LoginUShop();
					        	login.frmUshop.setVisible(true);
					        }
					        else
					        	JOptionPane.showMessageDialog(null, "Errore nella registrazione", "Registrazione non avvenuta", JOptionPane.ERROR_MESSAGE);
					      statement.close();
					      cmd.close();
					      con.close();
					      }
					    } catch (SQLException e1) {
					         e1.printStackTrace();
					    }
			}
				else
					JOptionPane.showMessageDialog(null, "Controllare i dati inseriti", "Dati immessi non validi", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnRegistrati.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 40));
		btnRegistrati.setBounds(395, 471, 283, 114);
		frmUshop.getContentPane().add(btnRegistrati);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCognomeField.setText(null);
				txtEmailField.setText(null);
				txtNomeField.setText(null);
				txtPassword2Field.setText(null);
				txtPasswordField.setText(null);
				txtTelefonoField.setText(null);
			}
		});
		btnReset.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 30));
		btnReset.setBounds(829, 489, 186, 96);
		frmUshop.getContentPane().add(btnReset);
		
		JLabel lblICampiContrassegnati = new JLabel("I campi contrassegnati con * sono obbligatori");
		lblICampiContrassegnati.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 18));
		lblICampiContrassegnati.setBounds(446, 420, 376, 38);
		frmUshop.getContentPane().add(lblICampiContrassegnati);
		
		JButton button = new JButton("INDIETRO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUshop.setVisible(false);
			}
		});
		button.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 30));
		button.setBounds(65, 489, 186, 96);
		frmUshop.getContentPane().add(button);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(846, 102, 249, 328);
		frmUshop.getContentPane().add(labelLogo);
		Image img = new ImageIcon (this.getClass().getResource("/logo.png")).getImage();
		labelLogo.setIcon(new ImageIcon(img));
		
		JLabel labelRegis = new JLabel("");
		labelRegis.setBounds(51, 13, 128, 128);
		frmUshop.getContentPane().add(labelRegis);
		Image img2 = new ImageIcon (this.getClass().getResource("/signup-icon.png")).getImage();
		labelRegis.setIcon(new ImageIcon(img2));
		
		JLabel lblRegistrazione = new JLabel("Registrazione");
		lblRegistrazione.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 50));
		lblRegistrazione.setBounds(179, 36, 376, 69);
		frmUshop.getContentPane().add(lblRegistrazione);
		
		}
}
