import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lista {
	ArrayList <Prodotto> list = new ArrayList <Prodotto> ();
	
	public void aggiungiProdotto() {
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci il nome del prodotto");
		String nomeArticolo = in.nextLine();
		Prodotto articolo = new Prodotto(nomeArticolo);
		list.add(articolo);
		}
	public void rimuoviProdotto() {
		Scanner in = new Scanner(System.in);
		System.out.println("Inserire il nome del prodotto da eliminare");
		String nomeArticolo = in.nextLine();
		Prodotto prodDelete = new Prodotto(nomeArticolo);
		for (int i=0; i < list.size(); i++) {
			if(list.get(i).getNome().equalsIgnoreCase(prodDelete.getNome()))
              	list.remove(i);
        }
	}
	
	public void visualizzaLista(){
        System.out.println( list.size()+ " articoli. ");
           for (Prodotto x : list) {
               System.out.println(x.getNome());
               
           }
	}
}
