import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
public class LoginUShop {

	protected JFrame frmUshop;
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
	public LoginUShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUshop = new JFrame();
		frmUshop.setTitle("U-Shop");
		frmUshop.getContentPane().setBackground(Color.WHITE);
		frmUshop.setBounds(100, 100, 1113, 668);
		frmUshop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUshop.getContentPane().setLayout(null);
		frmUshop.setResizable(false);
		
		textUsername = new JTextField();
		textUsername.setBounds(364, 273, 386, 49);
		frmUshop.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(364, 347, 386, 49);
		frmUshop.getContentPane().add(textPassword);
		
		JLabel lblUsername = new JLabel("E-mail");
		lblUsername.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 38));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(103, 273, 249, 49);
		frmUshop.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 38));
		lblPassword.setBounds(103, 347, 249, 49);
		frmUshop.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Sblocca");
		btnLogin.setFont(new Font("Source Sans Pro Light", Font.BOLD, 46));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("deprecation")
				String password = textPassword.getText();
				String username = textUsername.getText();
				textUsername.setText(null);
				textPassword.setText(null);
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
					 // Eseguiamo una query e immagazziniamone i risultati
					 // in un oggetto ResultSet
					        String qry = "SELECT * FROM login";
					        ResultSet res = cmd.executeQuery(qry);
					 // Stampiamone i risultati riga per riga
					        int flag=0;
					        while (res.next()) {
					    	   if (username.equalsIgnoreCase(res.getString("email")) && password.contentEquals(res.getString("password"))) {
					    		   //JOptionPane.showMessageDialog(null, "Login effettuato con successo", "Login effettuato", JOptionPane.PLAIN_MESSAGE);
					    		   ushopGUI gui = new ushopGUI();
					    		   gui.frmUshopShoppingList.setVisible(true);
					    		   frmUshop.setVisible(false);
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
		btnLogin.setBounds(374, 455, 313, 143);
		frmUshop.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 30));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUsername.setText(null);
				textPassword.setText(null);
				
			}
		});
		btnReset.setBounds(12, 517, 229, 80);
		frmUshop.getContentPane().add(btnReset);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 30));
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrazione regis = new Registrazione();	
				regis.frmUshop.setVisible(true);
				frmUshop.setVisible(false);
			}
		});
		btnRegistrati.setBounds(816, 517, 229, 80);
		frmUshop.getContentPane().add(btnRegistrati);
		
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(796, 94, 249, 328);
		frmUshop.getContentPane().add(labelLogo);
		
		Image img = new ImageIcon (this.getClass().getResource("logo.png")).getImage();
		labelLogo.setIcon(new ImageIcon(img));
		
		JLabel labelLogin = new JLabel("");
		labelLogin.setBounds(12, 24, 426, 179);
		frmUshop.getContentPane().add(labelLogin);
		
		Image img2 = new ImageIcon (this.getClass().getResource("loginHeader.png")).getImage();
		labelLogin.setIcon(new ImageIcon(img2));
	}
}
