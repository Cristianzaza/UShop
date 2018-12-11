public class Prodotto {
	private String nome;
	private  int id;
	private double prezzo;
	private int quantita;
	
	public Prodotto() {
		
	}
	
	public Prodotto(String nome, int id, double prezzo) {
		this.nome = nome;
		this.id = id;
		this.prezzo = prezzo;
		quantita = 100;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		id = id;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	
	
	
}
