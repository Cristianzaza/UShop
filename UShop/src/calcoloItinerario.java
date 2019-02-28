import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class calcoloItinerario {

	protected JFrame frame;
	protected int[] flagGroup = {0,0,0,0,0,0,0,0};
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
	//0-3: gruppo0; 4-5: gruppo1; 6-8: gruppo2 ; 9-10: gruppo3; 11-14: gruppo4; 15-16: gruppo5; 17-18: gruppo6; 19: gruppo7;
	protected Prodotto[] prodotti = {new Prodotto("Acqua"), new Prodotto("Pane"), new Prodotto("Formaggio"), new Prodotto("Frutta"), new Prodotto("Carne"),
			new Prodotto("Verdura"), new Prodotto("Mozzarella"), new Prodotto("Pasta"), new Prodotto("Yogurt"), new Prodotto("Latte"), new Prodotto("Sugo"),
			new Prodotto("Bibite"), new Prodotto("Birra"), new Prodotto("Merendine"), new Prodotto("Vino"), new Prodotto("Biscotti"), new Prodotto("Surgelati"),
			new Prodotto("Detersivi"), new Prodotto("Carta Igenica"),new Prodotto("Igiene Personale")};
	//funzione di calcolo itinerario
	protected void calcolo(Lista lista, int[] flagGroup) {
		for(int j=0; j<lista.list.size(); j++) {
			for(int i=0; i<=19; i++) {
				if(lista.list.get(j).getNome().equalsIgnoreCase(prodotti[i].getNome())) {
					if(i>=0 && i<=3)
						flagGroup[0]=1;
					else if(i==4 || i==5)
						flagGroup[1]=1;
					else if(i>=6 && i<=8)
						flagGroup[2]=1;
					else if(i==9 || i==10)
						flagGroup[3]=1;
					else if(i>=11 && i<=14)
						flagGroup[4]=1;
					else if(i==15 || i==16)
						flagGroup[5]=1;
					else if(i==17 || i==18)
						flagGroup[6]=1;
					else if(i==19)
						flagGroup[7]=1;					
				}
			}
		}
	}
	protected void mostraPercorso(int[] flagGroup, JLabel label0to1, JLabel label3to2, JLabel label4to5, JLabel label6to7, JLabel label0to3, 
			JLabel label1to2, JLabel label3to5, JLabel label2to4, JLabel label4to6, JLabel label5to7, JLabel lblNewLabel, JLabel labelcassa1, JLabel labelcassa2) {
		if(flagGroup[0]==1 && flagGroup[1]==1 && flagGroup[4]==1 && flagGroup[5]==1) {
			label0to1.setVisible(true);
			lblNewLabel.setVisible(true);
			label4to5.setVisible(true);
			labelcassa1.setVisible(true);
		}
		else if(flagGroup[1]==1 && flagGroup[4]==1 && flagGroup[6]==1) {
			label0to1.setVisible(true);
			lblNewLabel.setVisible(true);
			label4to6.setVisible(true);
			label6to7.setVisible(true);
			labelcassa2.setVisible(true);
		}
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
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1113, 668);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel sfondolbl = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("/demoShop.png")).getImage();
		Image img1 = new ImageIcon (this.getClass().getResource("/1to2.png")).getImage();
		Image img2 =new ImageIcon (this.getClass().getResource("angoliBassi.png")).getImage();
		Image img3 =new ImageIcon (this.getClass().getResource("/angoliAlti.png")).getImage();
		Image img4 = new ImageIcon (this.getClass().getResource("lineaLunga.png")).getImage();
		Image img5 = new ImageIcon (this.getClass().getResource("frecciaCassa.png")).getImage();
		
		
		sfondolbl.setIcon(new ImageIcon(img));
		sfondolbl.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(sfondolbl);
		
		JLabel label0to1 = new JLabel("");
		label0to1.setIcon(new ImageIcon(img1));
		label0to1.setBounds(102, 183, 66, 279);
		frame.getContentPane().add(label0to1);
		
		JLabel label3to2 = new JLabel("");
		label3to2.setIcon(new ImageIcon(img1));
		label3to2.setBounds(331, 183, 66, 279);
		frame.getContentPane().add(label3to2);
		
		JLabel label4to5 = new JLabel("");
		label4to5.setIcon(new ImageIcon(img1));
		label4to5.setBounds(564, 183, 66, 279);
		frame.getContentPane().add(label4to5);
		
		JLabel label6to7 = new JLabel("");
		label6to7.setIcon(new ImageIcon(img1));
		label6to7.setBounds(797, 183, 66, 279);
		frame.getContentPane().add(label6to7);
		
		JLabel label1to2 = new JLabel("");
		label1to2.setIcon(new ImageIcon(img2));
		label1to2.setBounds(129, 453, 229, 113);
		frame.getContentPane().add(label1to2);
		
		JLabel label2to4 = new JLabel("");
		label2to4.setIcon(new ImageIcon(img2));
		label2to4.setBounds(359, 453, 235, 113);
		frame.getContentPane().add(label2to4);
		
		JLabel label4to6 = new JLabel("");
		label4to6.setIcon(new ImageIcon(img2));
		label4to6.setBounds(595, 453, 241, 113);
		frame.getContentPane().add(label4to6);
		
		JLabel label0to3 = new JLabel("");
		label0to3.setIcon(new ImageIcon(img3));
		label0to3.setBounds(129, 106, 241, 113);
		frame.getContentPane().add(label0to3);
		
		JLabel label3to5 = new JLabel("");
		label3to5.setIcon(new ImageIcon(img3));
		label3to5.setBounds(359, 106, 241, 113);
		frame.getContentPane().add(label3to5);
		
		JLabel label5to7 = new JLabel("");
		label5to7.setIcon(new ImageIcon(img3));
		label5to7.setBounds(595, 106, 241, 113);
		frame.getContentPane().add(label5to7);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(129, 453, 471, 113);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(img4));
		
		JLabel labelcassa1 = new JLabel("");
		labelcassa1.setBounds(580, 106, 25, 80);
		frame.getContentPane().add(labelcassa1);
		labelcassa1.setIcon(new ImageIcon(img5));
		labelcassa1.setVisible(false);
	
		
		JLabel labelcassa2 = new JLabel("");
		labelcassa2.setBounds(813, 106, 25, 80);
		frame.getContentPane().add(labelcassa2);
		labelcassa2.setIcon(new ImageIcon(img5));
		labelcassa2.setVisible(false);
				
		label0to1.setVisible(false);
		label3to2.setVisible(false);
		label4to5.setVisible(false);
		label6to7.setVisible(false);
		label0to3.setVisible(false);
		label1to2.setVisible(false);
		label3to5.setVisible(false);
		label2to4.setVisible(false);
		label4to6.setVisible(false);
		label5to7.setVisible(false);
		lblNewLabel.setVisible(false);
		
		JButton btnMostra = new JButton("mostra");
		btnMostra.setFont(new Font("Source Sans Pro Light", Font.BOLD, 32));
		btnMostra.setBounds(887, 369, 208, 72);
		frame.getContentPane().add(btnMostra);
		
		JButton btnNascondi = new JButton("nascondi");
		btnNascondi.setFont(new Font("Source Sans Pro Light", Font.BOLD, 32));
		btnNascondi.setBounds(887, 463, 208, 72);
		frame.getContentPane().add(btnNascondi);
		btnNascondi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label0to1.setVisible(false);
				label3to2.setVisible(false);
				label4to5.setVisible(false);
				label6to7.setVisible(false);
				label0to3.setVisible(false);
				label1to2.setVisible(false);
				label3to5.setVisible(false);
				label2to4.setVisible(false);
				label4to6.setVisible(false);
				label5to7.setVisible(false);
				lblNewLabel.setVisible(false);
				labelcassa1.setVisible(false);
				labelcassa2.setVisible(false);
			}
		});
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 22));
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				for(int i=0; i<8; i++)	
					flagGroup[i]=0;
			}
		});
		btnIndietro.setBounds(924, 548, 125, 72);
		frame.getContentPane().add(btnIndietro);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(863, 13, 232, 326);
		frame.getContentPane().add(labelLogo);
		Image img7 = new ImageIcon (this.getClass().getResource("/logo.png")).getImage();
		labelLogo.setIcon(new ImageIcon(img7));
		
		btnMostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostraPercorso(flagGroup, label0to1, label3to2, label4to5, label6to7, label0to3, label1to2, label3to5, label2to4, label4to6, label5to7, lblNewLabel, labelcassa1, labelcassa2);
			}
		});
				
		}
		}
	
