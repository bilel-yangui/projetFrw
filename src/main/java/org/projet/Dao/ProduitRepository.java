package org.projet.Dao;

import java.util.List;

import org.projet.entities.Client;
import org.projet.entities.Produits;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produits, Long>{
	@Query("select p from Produits p where p.nom like :x")
	public Page<Produits> produitParMc(@Param("x") String mc ,Pageable pageable);

}
