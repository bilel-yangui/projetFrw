package org.projet.metier;

import java.util.List;

import org.projet.entities.Produits;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProduitMetier {
	public Produits addProduit(Produits p);
	public Produits consulterProduit(Long id);
	public Page<Produits> chercherParMotCle(String mv,Pageable pageable);
	

}
