package org.projet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COM",discriminatorType=DiscriminatorType.STRING,length=2)
public  class Commande implements Serializable{
	@Id @GeneratedValue
	private Long id ;
	private Date dateLivraison;
	private double prixTotale;
	private Date dateCreation;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	@OneToMany(mappedBy="commande")
	private List<Operation> operations=new ArrayList<Operation>();
	
	
	

	public Commande(Date dateLivraison, Date dateCreation, Client client) {
		super();
		this.dateLivraison = dateLivraison;
		this.dateCreation = dateCreation;
		this.client = client;
	}






	public Commande(Date dateLivraison, Date dateCreation, Client client, List<Operation> operations) {
		super();
		this.dateLivraison = dateLivraison;
		this.dateCreation = dateCreation;
		this.client = client;
		this.operations = operations;
	}






	public Commande() {
		super();
	}
	

	
	


	public Commande(Date dateLivraison, double prixTotale, Date dateCreation, Client client,
			List<Operation> operations) {
		super();
		this.dateLivraison = dateLivraison;
		this.prixTotale = prixTotale;
		this.dateCreation = dateCreation;
		this.client = client;
		this.operations = operations;
	}






	public Commande(Date dateLivraison, double prixTotale, Date dateCreation, Client client) {
		super();
		this.dateLivraison = dateLivraison;
		this.prixTotale = prixTotale;
		this.dateCreation = dateCreation;
		this.client = client;
	}
	







	public Commande(double prixTotale) {
		super();
		this.prixTotale = prixTotale;
	}
	

	public Commande(Long id) {
		super();
		this.id = id;
	}

	public List<Operation> getOperations() {
		return operations;
	}


	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}






	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public double getPrixTotale() {
		return prixTotale;
	}
	public void setPrixTotale(double prixTotale) {
		this.prixTotale = prixTotale;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}


}
