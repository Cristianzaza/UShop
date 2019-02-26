import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class calcoloItinerario {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calcoloItinerario window = new calcoloItinerario();
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
	public calcoloItinerario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1113, 668);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel sfondolbl = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("/demoShop.png")).getImage();
		Image img1 = new ImageIcon (this.getClass().getResource("/1to2.png")).getImage();
		Image img2 =new ImageIcon (this.getClass().getResource("angoliBassi.png")).getImage();
		Image img3 =new ImageIcon (this.getClass().getResource("/angoliAlti.png")).getImage();
		sfondolbl.setIcon(new ImageIcon(img));
		sfondolbl.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(sfondolbl);
		
		JLabel label1to2 = new JLabel("");
		label1to2.setIcon(new ImageIcon(img1));
		label1to2.setBounds(102, 183, 66, 279);
		frame.getContentPane().add(label1to2);
		
		JLabel label3to4 = new JLabel("");
		label3to4.setIcon(new ImageIcon(img1));
		label3to4.setBounds(331, 183, 66, 279);
		frame.getContentPane().add(label3to4);
		
		JLabel label5to6 = new JLabel("");
		label5to6.setIcon(new ImageIcon(img1));
		label5to6.setBounds(563, 183, 66, 279);
		frame.getContentPane().add(label5to6);
		
		JLabel label7to8 = new JLabel("");
		label7to8.setIcon(new ImageIcon(img1));
		label7to8.setBounds(797, 183, 66, 279);
		frame.getContentPane().add(label7to8);
		
		JLabel label2to4 = new JLabel("");
		label2to4.setIcon(new ImageIcon(img2));
		label2to4.setBounds(129, 453, 229, 113);
		frame.getContentPane().add(label2to4);
		
		JLabel label4to5 = new JLabel("");
		label4to5.setIcon(new ImageIcon(img2));
		label4to5.setBounds(359, 453, 235, 113);
		frame.getContentPane().add(label4to5);
		
		JLabel label5to7 = new JLabel("");
		label5to7.setIcon(new ImageIcon(img2));
		label5to7.setBounds(595, 453, 241, 113);
		frame.getContentPane().add(label5to7);
		
		JLabel label1to3 = new JLabel("");
		label1to3.setIcon(new ImageIcon(img3));
		label1to3.setBounds(129, 106, 241, 113);
		frame.getContentPane().add(label1to3);
		
		JLabel label3to6 = new JLabel("");
		label3to6.setIcon(new ImageIcon(img3));
		label3to6.setBounds(359, 106, 241, 113);
		frame.getContentPane().add(label3to6);
		
		JLabel label6to8 = new JLabel("");
		label6to8.setIcon(new ImageIcon(img3));
		label6to8.setBounds(595, 106, 241, 113);
		frame.getContentPane().add(label6to8);
		label1to2.setVisible(false);
		label3to4.setVisible(false);
		label5to6.setVisible(false);
		label7to8.setVisible(false);
		label1to3.setVisible(false);
		label2to4.setVisible(false);
		label3to6.setVisible(false);
		label4to5.setVisible(false);
		label5to7.setVisible(false);
		label6to8.setVisible(false);
		
	}

}
