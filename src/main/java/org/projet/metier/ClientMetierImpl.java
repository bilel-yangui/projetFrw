package org.projet.metier;

import java.util.List;

import org.projet.Dao.ClientRepository;
import org.projet.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClientMetierImpl implements ClientMetier {

	@Autowired
	private ClientRepository clientRepository;
	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public List<Client> clientParMC(String mc) {
		// TODO Auto-generated method stub
		return clientRepository.ClientParMc(mc);
	}

	@Override
	public Client retournerClient(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findOne(id);
	}

}
