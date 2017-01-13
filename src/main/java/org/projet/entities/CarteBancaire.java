package org.projet.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CB")
public class CarteBancaire extends Commande{
	private String code;
	
	

	public CarteBancaire() {
		super();
	}
	


	public CarteBancaire(Date dateLivraison, Date dateCreation, Client client, String code) {
		super(dateLivraison, dateCreation, client);
		this.code = code;
	}



	public CarteBancaire(Date dateLivraison, Date dateCreation, Client client, List<Operation> operations,
			String code) {
		super(dateLivraison, dateCreation, client, operations);
		this.code = code;
	}



	public CarteBancaire(Date dateLivraison, double prixTotale, Date dateCreation, Client client, String code) {
		super(dateLivraison, prixTotale, dateCreation, client);
		this.code = code;
	}

	public CarteBancaire(Date dateLivraison, double prixTotale, Date dateCreation, Client client,
			List<Operation> operations, String code) {
		super(dateLivraison, prixTotale, dateCreation, client, operations);
		this.code = code;
	}




	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

}
