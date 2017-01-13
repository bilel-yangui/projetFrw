package org.projet.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FA")
public class Facilite extends Commande {
	private Date datePayement;
	

	

	public Facilite() {
		super();
	}
	


	public Facilite(Date datePayement) {
		super();
		this.datePayement = datePayement;
	}
	



	public Facilite(Long id) {
		super(id);
	}



	public Facilite(Date dateLivraison, Date dateCreation, Client client, Date datePayement) {
		super(dateLivraison, dateCreation, client);
		this.datePayement = datePayement;
	}



	public Facilite(Date dateLivraison, Date dateCreation, Client client, List<Operation> operations,
			Date datePayement) {
		super(dateLivraison, dateCreation, client, operations);
		this.datePayement = datePayement;
	}



	public Facilite(Date dateLivraison, double prixTotale, Date dateCreation, Client client, Date datePayement) {
		super(dateLivraison, prixTotale, dateCreation, client);
		this.datePayement = datePayement;
	}



	public Facilite(Date dateLivraison, double prixTotale, Date dateCreation, Client client, List<Operation> operations,
			Date datePayement) {
		super(dateLivraison, prixTotale, dateCreation, client, operations);
		this.datePayement = datePayement;
	}



	public Date getDatePayement() {
		return datePayement;
	}

	public void setDatePayement(Date datePayement) {
		this.datePayement = datePayement;
	}
	

}
