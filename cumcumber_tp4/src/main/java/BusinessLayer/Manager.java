package BusinessLayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 * @author ayoub ghayati
 *
 */
public class Manager extends Person{

	private List<Client> clients = new ArrayList<Client>();
	
	
	public void addClient(Client clt)
	{
		clients.add(clt);

	}
	
	public Set<Client> contractSeaching(){

		Set<Client> contrats= new HashSet<Client>();
		for(Client client : clients){

			if(client.getContrat().equals("valide")  )
			{
				contrats.add(client);
			}
		}

		return contrats;
	}

	public List<Client> getClients() {
		return clients;
	}

	
	
}
