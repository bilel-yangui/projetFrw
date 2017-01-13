package org.projet.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Client implements Serializable{
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String logIn;
	private String motPasse;
	@OneToMany(mappedBy="client")
	private Collection<Commande> commandes;
	
	public Client() {
		super();
	}
	
	public Client(String nom, String logIn, String motPasse, Collection<Commande> commandes) {
		super();
		this.nom = nom;
		this.logIn = logIn;
		this.motPasse = motPasse;
		this.commandes = commandes;
	}

	public Client(String nom) {
		super();
		this.nom = nom;
	}

	public Client(String nom, String logIn, String motPasse) {
		super();
		this.nom = nom;
		this.logIn = logIn;
		this.motPasse = motPasse;
	}
	

	public Client(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogIn() {
		return logIn;
	}
	public void setLogIn(String logIn) {
		this.logIn = logIn;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public Collection<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	

}
