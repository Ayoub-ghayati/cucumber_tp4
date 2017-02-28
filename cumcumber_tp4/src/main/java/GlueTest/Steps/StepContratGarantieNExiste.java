package GlueTest.Steps;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import BusinessLayer.Client;
import BusinessLayer.Manager;


import static org.junit.Assert.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author ayoub ghayati
 *
 */
public class StepContratGarantieNExiste {
	Manager managerEntity ;
	int garantie;
	Set<Client> liste = new HashSet<Client>();
	
	public StepContratGarantieNExiste() {
		super();

	}

	public StepContratGarantieNExiste(Manager managerEntity, int garantie, Set<Client> liste) {
		super();
		this.managerEntity = managerEntity;
		this.garantie = garantie;
		this.liste = liste;
	}

	
	
	
	@Given("^un manager$")
	public void un_manager() throws Throwable {

		managerEntity=new Manager();
		
	}

	@Given("^il possede au moins un contrat de garantie valide parmi ses clients$")
	public void il_possede_au_moins_un_contrat_de_garantie_valide_parmi_ses_clients(DataTable dataSetClients) throws Throwable {
		
		Client clt;
		List<Map<String, String>> data = dataSetClients.asMaps();//(String.class, String.class);
		for (Map row : data)
		{ 
			String client = row.get("client").toString();
			String contrat = row.get("contrat").toString();
			String valeur=row.get("valeur").toString();
			clt=new Client(client,contrat,Integer.parseInt(valeur)); 
			managerEntity.addClient(clt);
		} 
		
		
		
	}

	@When("^la page des Garanties est chargee$")
	public void la_page_des_Garanties_est_chargee() throws Throwable {

	}

	@Then("^la liste des garanties affiche toutes les garanties retrouvees$")
	public void la_liste_des_garanties_affiche_toutes_les_garanties_retrouvees() throws Throwable {
		
		System.out.println("la liste des garenties valide trouv�es ");	
		System.out.println();
		
		liste= managerEntity.contractSeaching();
		System.out.println("|   client    |   contrat    |    valeur    | ");	
		
		for(Client c : liste )
		{
			
			System.out.println("|    "+c.getClient()+"     |    "+c.getContrat()+"    |     "+c.getValeur()+"      |");	
			
			
		}

		System.out.println();
	}

	@Then("^la somme des Prix des garanties (\\d+) est affichee sous la colonne Valeur$")
	public void la_somme_des_Prix_des_garanties_est_affichee_sous_la_colonne_Valeur(int somme) throws Throwable {

		int valeur=0;
		for(Client c : liste )
		{
					
			valeur=valeur+c.getValeur();
			
		}
		
		
		assertEquals(valeur,somme,0);


	}

	
	
	
}
