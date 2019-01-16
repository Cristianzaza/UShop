import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.util.TimeUtil;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.nio.channels.ShutdownChannelGroupException;
import java.awt.event.ActionEvent;
import javax.sql.rowset.JdbcRowSet;
public class LoginUShop {

	private JFrame frame;
	private JTextField textUsername;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUShop window = new LoginUShop();
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
	public LoginUShop() {
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
		
		JLabel lblUshopLogin = new JLabel("UShop Login");
		lblUshopLogin.setBounds(143, 13, 98, 16);
		frame.getContentPane().add(lblUshopLogin);
		
		textUsername = new JTextField();
		textUsername.setBounds(143, 77, 116, 22);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(143, 136, 116, 22);
		frame.getContentPane().add(textPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(43, 80, 76, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(43, 139, 76, 16);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = textPassword.getText();
				String username = textUsername.getText();
				textUsername.setText(null);
				textPassword.setText(null);
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
					 // Eseguiamo una query e immagazziniamone i risultati
					 // in un oggetto ResultSet
					        String qry = "SELECT * FROM login";
					        ResultSet res = cmd.executeQuery(qry);
					 // Stampiamone i risultati riga per riga
					        int flag=0;
					        while (res.next()) {
					    	   if (username.equalsIgnoreCase(res.getString("email")) && password.contentEquals(res.getString("password"))) {
									JOptionPane.showMessageDialog(null, "Login effettuato con successo", "Login effettuato", JOptionPane.PLAIN_MESSAGE);
									flag=1;
									break;
					    	   }
					      }
					       if(flag==0){
								JOptionPane.showMessageDialog(null, "Username o password errati", "Login fallito", JOptionPane.ERROR_MESSAGE);
							}
					      res.close();
					      cmd.close();
					      con.close();
					    } catch (SQLException e1) {
					         e1.printStackTrace();
					    }
			}
		});
		btnLogin.setBounds(143, 203, 133, 37);
		frame.getContentPane().add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(43, 188, 342, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(43, 43, 342, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUsername.setText(null);
				textPassword.setText(null);
				
			}
		});
		btnReset.setBounds(288, 215, 116, 25);
		frame.getContentPane().add(btnReset);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrazione regis = new Registrazione();	
				regis.frame.setVisible(true);
			}
		});
		btnRegistrati.setBounds(12, 215, 119, 25);
		frame.getContentPane().add(btnRegistrati);
	}
}
