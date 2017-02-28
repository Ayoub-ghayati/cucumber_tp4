package GlueTest.Steps;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import BusinessLayer.Client;
import BusinessLayer.Manager;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
/**
 * 
 * @author ayoub ghayati
 *
 */
public class StepContratGarantieExiste {
	
	
    Manager managerEntity=new Manager();
	
	@Given("^il ne possede aucun contrat de garantie valide parmi ses clients$")
	public void il_ne_possede_aucun_contrat_de_garantie_valide_parmi_ses_clients(DataTable clients) throws Throwable {
		Client clientEntity;
		List<Map<String, String>> data = clients.asMaps();
		//(String.class, String.class);
		for (Map row : data)
		{ 
			String client = row.get("client").toString();
			String contrat = row.get("contrat").toString();
			String valeur=row.get("valeur").toString();
			clientEntity=new Client(client,contrat,Integer.parseInt(valeur)); 
			managerEntity.addClient(clientEntity);
		} 
		
	}

	@Then("^la liste des garanties affiche vide$")
	public void la_liste_des_garanties_affiche_vide() throws Throwable {

		System.out.println("la liste des garenties est vide ");	
		System.out.println();	

	}

	@Then("^un message affiche \"([^\"]*)\"$")
	public void un_message_affiche(String notification) throws Throwable {

		String asserts ="Aucune donnees trouve pour cette requete";
		assertEquals(notification,asserts);
		
		

	}

	


}
