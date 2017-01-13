package org.projet.metier;

import java.util.List;

import org.projet.entities.Client;

public interface ClientMetier {
	public Client addClient(Client c);
	public List<Client> listClient();
	public List<Client> clientParMC(String mc);
	public Client retournerClient(Long id);

}
