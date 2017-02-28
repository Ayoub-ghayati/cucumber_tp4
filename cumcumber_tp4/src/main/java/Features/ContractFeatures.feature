Feature: En tant que manager je veux afficher toutes les contrats de garanties autorisés pour mes clients

Scenario: un contract de garentie existe
	Given un manager
	And il possede au moins un contrat de garantie valide parmi ses clients
  		| client 		| contrat	 | valeur 	|
 		| clt1  		| valide   	 | 300		|
  		| clt2  		| nonvalide  | 100		|
  		| clt3  		| valide 	 | 300		|
  		| clt4  		| nonvalide  | 0		|
  		
	When la page des Garanties est chargee
	Then la liste des garanties affiche toutes les garanties retrouvees
	And  la somme des Prix des garanties 600 est affichee sous la colonne Valeur
	
	Scenario: aucun contract de garentie n'existe
	Given un manager
	And il ne possede aucun contrat de garantie valide parmi ses clients
  		| client 		| contrat	 | valeur 	|
 		| clt5  		| nonvalide  | 0		|
  		| clt6  		| nonvalide  | 0		|
  		| clt7  		| nonvalide  | 0		|
  		| clt8  		| nonvalide  | 0		|
  		
	When la page des Garanties est chargee
	Then la liste des garanties affiche vide
	And  un message affiche "Aucune donnees trouve pour cette requete"