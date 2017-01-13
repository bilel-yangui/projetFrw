package org.projet.metier;

import java.util.List;

import org.projet.Dao.OperationRepository;
import org.projet.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationMetierImpl implements OperationMetier{
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Operation addOperation(Operation op) {
		// TODO Auto-generated method stub
		return operationRepository.save(op);
	}

	@Override
	public Operation returnOperation(Long id) {
		// TODO Auto-generated method stub
		return operationRepository.findOne(id);
	}



}
