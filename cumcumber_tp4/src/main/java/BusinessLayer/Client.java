package BusinessLayer;
/**
 * 
 * @author ayoub ghayati
 *
 */
public class Client extends Person{

	private String client;
	private String contrat;
	private int valeur;
	
	
	public Client(String client, String contrat, int valeur) {
		super();
		this.client = client;
		this.contrat = contrat;
		this.valeur = valeur;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (contrat == null) {
			if (other.contrat != null)
				return false;
		} else if (!contrat.equals(other.contrat))
			return false;
		if (valeur != other.valeur)
			return false;
		return true;
	}
	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}


	public String getContrat() {
		return contrat;
	}


	public void setContrat(String contrat) {
		this.contrat = contrat;
	}


	public int getValeur() {
		return valeur;
	}


	public void setValeur(int valeur) {
		this.valeur = valeur;
	}


	@Override
	public String toString() {
		return "client [client=" + client + ", contrat=" + contrat + ", valeur=" + valeur + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((contrat == null) ? 0 : contrat.hashCode());
		result = prime * result + valeur;
		return result;
	}



	
	
	
	
	
}
