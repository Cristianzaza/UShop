import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registrazione {

	public JFrame frame;
	public JTextField txtNomeField;
	public JTextField txtCognomeField;
	public JTextField txtCfField;
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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrazione U-Shop");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(154, 13, 260, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNome.setForeground(Color.BLACK);
		lblNome.setBounds(12, 89, 214, 26);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblCognome.setForeground(Color.BLACK);
		lblCognome.setBounds(12, 117, 214, 33);
		frame.getContentPane().add(lblCognome);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblCodiceFiscale.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceFiscale.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblCodiceFiscale.setForeground(Color.BLACK);
		lblCodiceFiscale.setBounds(12, 163, 214, 22);
		frame.getContentPane().add(lblCodiceFiscale);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(12, 198, 214, 26);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(12, 233, 214, 22);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfermaPassword = new JLabel("Conferma Password");
		lblConfermaPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfermaPassword.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblConfermaPassword.setBounds(12, 268, 214, 22);
		frame.getContentPane().add(lblConfermaPassword);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setBounds(12, 303, 214, 26);
		frame.getContentPane().add(lblTelefono);
		
		txtNomeField = new JTextField();
		txtNomeField.setBounds(232, 93, 277, 22);
		frame.getContentPane().add(txtNomeField);
		txtNomeField.setColumns(10);
		
		txtCognomeField = new JTextField();
		txtCognomeField.setBounds(232, 124, 277, 22);
		frame.getContentPane().add(txtCognomeField);
		txtCognomeField.setColumns(10);
		
		txtCfField = new JTextField();
		txtCfField.setBounds(232, 167, 277, 22);
		frame.getContentPane().add(txtCfField);
		txtCfField.setColumns(10);
		
		txtEmailField = new JTextField();
		txtEmailField.setBounds(232, 202, 277, 22);
		frame.getContentPane().add(txtEmailField);
		txtEmailField.setColumns(10);
		
		txtTelefonoField = new JTextField();
		txtTelefonoField.setBounds(232, 307, 277, 22);
		frame.getContentPane().add(txtTelefonoField);
		txtTelefonoField.setColumns(10);
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setBounds(232, 237, 277, 22);
		frame.getContentPane().add(txtPasswordField);
		
		txtPassword2Field = new JPasswordField();
		txtPassword2Field.setBounds(232, 272, 277, 22);
		frame.getContentPane().add(txtPassword2Field);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 // Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
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
					        //JOptionPane.showMessageDialog(null, "Connected", "Connectiontest", JOptionPane.INFORMATION_MESSAGE);
					        String insert_data = "insert into login values (?,?,?,?,?,?,?)";
					        PreparedStatement statement = con.prepareStatement(insert_data);
					        statement.setString(1, txtEmailField.getText());
					        statement.setString(2, txtPasswordField.getText());
					        statement.setString(3, txtCfField.getText());
					        statement.setString(4, txtNomeField.getText());
					        statement.setString(5, txtCognomeField.getText());
					        statement.setString(6, txtTelefonoField.getText());
					        statement.setInt(7, last_id+1);
					        int data_entered=0;
					        data_entered = statement.executeUpdate();
					        if(data_entered>0)
					        	JOptionPane.showMessageDialog(null, "Registrazione avvenuta con successo", "Benvenuto!", JOptionPane.PLAIN_MESSAGE);
					        else
					        	JOptionPane.showMessageDialog(null, "Errore nella registrazione", "Registrazione non avvenuta", JOptionPane.ERROR_MESSAGE);
					      statement.close();
					      cmd.close();
					      con.close();
					    } catch (SQLException e1) {
					         e1.printStackTrace();
					    }
			}
		});
		btnRegistrati.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		btnRegistrati.setBounds(191, 366, 186, 63);
		frame.getContentPane().add(btnRegistrati);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCfField.setText(null);
				txtCognomeField.setText(null);
				txtEmailField.setText(null);
				txtNomeField.setText(null);
				txtPassword2Field.setText(null);
				txtPasswordField.setText(null);
				txtTelefonoField.setText(null);
			}
		});
		btnReset.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		btnReset.setBounds(412, 396, 97, 33);
		frame.getContentPane().add(btnReset);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 74, 544, 2);
		frame.getContentPane().add(separator);
	}
}
