package org.projet.metier;

import java.util.List;

import org.projet.entities.Operation;

public interface OperationMetier {
	public Operation addOperation(Operation op);
	public Operation returnOperation(Long id );

}
