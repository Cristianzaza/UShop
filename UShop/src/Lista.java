import java.util.Scanner;

import javax.swing.JList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lista extends JList<Prodotto>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList <Prodotto> list = new ArrayList <Prodotto> ();
	private Scanner in;
	private Scanner in2;
	
	public void aggiungiProdotto() {
		in = new Scanner(System.in);
		System.out.println("Inserisci il nome del prodotto");
		String nomeArticolo = in.nextLine();
		Prodotto articolo = new Prodotto(nomeArticolo);
		list.add(articolo);
		}
	public void aggiungiProdotto2(String nomeArticolo) {
		//Scanner in = new Scanner(System.in);
	//	System.out.println("Inserisci il nome del prodotto");
		//String nomeArticolo = in.nextLine();
		Prodotto articolo = new Prodotto(nomeArticolo);
		list.add(articolo);
		}
	
	public void rimuoviProdotto() {
		in2 = new Scanner(System.in);
		System.out.println("Inserire il nome del prodotto da eliminare");
		String nomeArticolo = in2.nextLine();
		Prodotto prodDelete = new Prodotto(nomeArticolo);
		for (int i=0; i < list.size(); i++) {
			if(list.get(i).getNome().equalsIgnoreCase(prodDelete.getNome()))
              	list.remove(i);
        }
	}
	
	public void rimuoviProdotto2(String nomeArticolo) {
		//Scanner in = new Scanner(System.in);
		//System.out.println("Inserire il nome del prodotto da eliminare");
		//String nomeArticolo = in.nextLine();
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
