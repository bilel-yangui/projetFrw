package org.projet.metier;

import java.util.List;

import org.projet.entities.Client;
import org.projet.entities.Commande;
import org.projet.entities.Facilite;
import org.projet.entities.Operation;

public interface CommandeMetier {

	public Commande addCommande(Commande cmd);
	public Commande consulterCommande(Long code);
	public List<Commande> clientConsulterCommande(Client client);
	public void addOperation(Long idOP,Long id);
	
}
