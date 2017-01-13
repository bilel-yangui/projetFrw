package org.projet.metier;

import org.projet.Dao.ProduitRepository;
import org.projet.entities.Produits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class ProduitMetierImpl implements ProduitMetier {
	@Autowired
	private ProduitRepository produitRepository;
	@Override
	public Produits addProduit(Produits p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}

	@Override
	public Produits consulterProduit(Long id) {
		Produits pr=produitRepository.findOne(id);
		if(pr==null){
			throw new RuntimeException("commande n'existe pas");
		}
		return pr;
	}

	@Override
	public Page<Produits> chercherParMotCle(String mv,Pageable pageable) {
		// TODO Auto-generated method stub
		return produitRepository.produitParMc(mv, pageable);
	}

}
