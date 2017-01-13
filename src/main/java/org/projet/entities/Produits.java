package org.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produits implements Serializable {
	@Id @GeneratedValue
	private Long id;
	
	private String nom;
	
	private Long qte;
	
	private double prix;
	private String photo;
	@OneToOne(mappedBy="produit")
	private Operation operation;
	//@ManyToOne
	//@JoinColumn(name="CODE_COM")
	//private Commande commande;
	
	/*public Produits(String nom, Long qte, double prix) {
		super();
		this.nom = nom;
		this.qte = qte;
		this.prix = prix;
		;
		
	}*/
	public Produits(String nom, Long qte, double prix,String photo) {
		super();
		this.nom = nom;
		this.qte = qte;
		this.prix = prix;
		this.photo=photo;
		
	}
	public Produits(Long id) {
		super();
		this.id = id;
	}

	public Produits() {
		super();
	}
	
	
	public Produits(String nom, Long qte, double prix, Operation operation) {
		super();
		this.nom = nom;
		this.qte = qte;
		this.prix = prix;
		this.operation = operation;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
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
	public Long getQte() {
		return qte;
	}
	public void setQte(Long qte) {
		this.qte = qte;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	/*public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}*/

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

}
