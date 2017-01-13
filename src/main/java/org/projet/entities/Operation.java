package org.projet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Operation {
	@Id @GeneratedValue
	private Long id ;
	private int qte ;
	@ManyToOne
	@JoinColumn(name="CODE_CMD")
	private Commande commande;
	@OneToOne
	@JoinColumn(name="CODE_PRD")
	private Produits produit;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produits getProduit() {
		return produit;
	}
	public void setProduit(Produits produit) {
		this.produit = produit;
	}
	public Operation() {
		super();
	}
	
	public Operation(Long id) {
		super();
		this.id = id;
	}
	public Operation(int qte, Commande commande, Produits produit) {
		super();
		this.qte = qte;
		this.commande = commande;
		this.produit = produit;
	}
	
	

}
