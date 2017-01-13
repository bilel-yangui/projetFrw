package org.projet.metier;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.projet.Dao.CommandeRepository;
import org.projet.Dao.OperationRepository;
import org.projet.Dao.ProduitRepository;
import org.projet.entities.Client;
import org.projet.entities.Commande;
import org.projet.entities.Facilite;
import org.projet.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommandeMetierImpl implements CommandeMetier{
	List<Operation> operations=new ArrayList<Operation>();
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	OperationMetierImpl operationMetierImpl;
	
	@Override
	public Commande addCommande(Commande cmd) {
		// TODO Auto-generated method stub
		return commandeRepository.save(cmd);
	}

	@Override
	public Commande consulterCommande(Long id) {
		// TODO Auto-generated method stub
		Commande cmd=commandeRepository.findOne(id);
		if(cmd==null){
			throw new RuntimeException("commande n'existe pas");
		}
		return cmd;
	}

	@Override
	public List<Commande> clientConsulterCommande(Client client) {
		
		return null;
	}
	
	@Transactional
	@Override
	public void addOperation(Long idOp,Long id) {
		Operation operation=operationMetierImpl.returnOperation(idOp);
		Commande cmd =consulterCommande(id);
		operations.add(operation);
		cmd.setOperations(operations);;
		commandeRepository.save(cmd);
		operation.getProduit().setQte(operation.getProduit().getQte()-operation.getQte());
		produitRepository.save(operation.getProduit());
		operationRepository.save(operation);
	}
	

}
