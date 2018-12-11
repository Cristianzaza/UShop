import java.util.Scanner;
import java.util.ArrayList;
public class main {
	private static final Prodotto [] prodotti = {
			new Prodotto("Latte", 00001, 1.50),
			new Prodotto("Pane", 00002, 1.00),
			new Prodotto("Carne", 00003, 3.00),
			new Prodotto("Pasta", 00004, 0.80),
			new Prodotto("Salmone", 00005, 4.80)
	};
	
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		System.out.println("Inserisci il nome del prodotto");
		String nome = in.nextLine();
		
	}

}
