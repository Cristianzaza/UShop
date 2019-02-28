import javax.swing.JList;
import java.util.ArrayList;

public class Lista extends JList<Prodotto>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList <Prodotto> list;
	
	public Lista() {
		list = new ArrayList <Prodotto> ();	
	}
	
	protected String[] prodottiDef = {"Acqua", "Formaggio", "Carne", "Pane", "Frutta", "Verdura", "Latte", "Yogurt", "Sugo", "Pasta", "Bibite", "Merendine",
			"Biscotti", "Birra", "Vino", "Surgelati", "Detersivi", "Carta igienica", "Sapone", "Bagnoschiuma", "Shampoo", "Mozzarella"
	};
	
	//verifica che il prodotto inserito sia presente nel negozio
	private boolean verifica(String nomeProd) {
		boolean flag=false;
		for(int i=0; i<prodottiDef.length; i++) {
			if(nomeProd.equalsIgnoreCase(prodottiDef[i])) {
				flag=true;
			}
		}
		return flag;
	}

	public boolean aggiungiProdotto(String nomeArticolo) {
		if (verifica(nomeArticolo)) {
			if (!esiste(nomeArticolo)) {
				Prodotto articolo = new Prodotto(nomeArticolo);
				list.add(articolo);
				return true;
			}
			return false;
		}
		return false;
	}
	

	public boolean rimuoviProdotto(String nomeArticolo) {
		if(verifica(nomeArticolo)) {
		Prodotto prodDelete = new Prodotto(nomeArticolo);
		for (int i=0; i < list.size(); i++) {
			if(list.get(i).getNome().equalsIgnoreCase(prodDelete.getNome())) {
              	list.remove(i);
              	return true;
			}
        }
		
		}
		return false;
	}
	
	public void visualizzaLista(){
        System.out.println( list.size()+ " articoli. ");
           for (Prodotto x : list) {
               System.out.println(x.getNome());    
           }
	}
	
	//verifico se il prodotto sia già presente nella lista
	//se è già presente ritorna TRUE, altrimenti FALSE
	private boolean esiste(String nomeProdotto) {
		boolean flag = false;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNome().equalsIgnoreCase(nomeProdotto)) {
				flag = true;
			}
		}
		return flag;
	}
	
	protected void svuota() {
			list.removeAll(list);
	}
}
	
