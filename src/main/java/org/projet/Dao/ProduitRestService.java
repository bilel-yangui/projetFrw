package org.projet.Dao;

import java.util.List;

import org.projet.entities.Produits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitRestService {
	@Autowired
	private ProduitRepository produitRepository;
	
	
	
	@RequestMapping(value="/ProduitR",method=RequestMethod.GET)
	public Page<Produits> listproduits(int page,int size){
		return produitRepository.findAll(new PageRequest(page, size));
	}
	@RequestMapping(value="/chercherProduits",method=RequestMethod.GET)
	public Page<Produits> chercher(String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="4")int size){
		return produitRepository.produitParMc("%"+mc+"%",new PageRequest(page, size));
	}
	@RequestMapping(value="/ProduitR/{id}",method=RequestMethod.GET)
	public Produits chercherProduitRest(@PathVariable("id") Long id ){
		return produitRepository.findOne(id);
	}
	@RequestMapping(value="/ProduitR",method=RequestMethod.POST)
	public Produits saveProduit(@RequestBody Produits pr ){
		return produitRepository.save(pr);
	}
	@RequestMapping(value="/ProduitR/{id}",method=RequestMethod.PUT)
	public Produits update(@RequestBody Produits pr,@PathVariable("id") Long id ){
		pr.setId(id);
		return produitRepository.saveAndFlush(pr);
	}
	@RequestMapping(value="/ProduitR/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id ){
		 produitRepository.delete(id);
	}
	

}
 
