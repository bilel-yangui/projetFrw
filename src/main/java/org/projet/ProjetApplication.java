package org.projet;

import java.util.Date;
import java.util.List;

import org.projet.Dao.ProduitRepository;
import org.projet.entities.CarteBancaire;
import org.projet.entities.Client;
import org.projet.entities.Commande;
import org.projet.entities.Facilite;
import org.projet.entities.Operation;
import org.projet.entities.Produits;
import org.projet.metier.ClientMetier;
import org.projet.metier.CommandeMetier;
import org.projet.metier.OperationMetier;
import org.projet.metier.ProduitMetier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ch.qos.logback.core.net.SyslogOutputStream;


@SpringBootApplication
public class ProjetApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(ProjetApplication.class, args);
		/*ClientMetier clientMetier=ctx.getBean(ClientMetier.class);
		clientMetier.addClient(new Client("A"));
		clientMetier.addClient(new Client("bilel", "bbb", "123456"));
		clientMetier.addClient(new Client("AB"));
		System.out.println("---------------------------------------------");
		List<Client> list=clientMetier.listClient();
		list.forEach(c->System.out.println(c.getNom()));
		System.out.println("---------------------------------------------");
		List<Client> list2=clientMetier.clientParMC("%A%");
		list2.forEach(c->System.out.println(c.getNom()));
		System.out.println("-----------commande--------------------------");
		CommandeMetier commandeMetier=ctx.getBean(CommandeMetier.class);
		commandeMetier.addCommande(new CarteBancaire(new Date(),2000,new Date(),new Client(1L),"12333"));
		commandeMetier.addCommande(new Facilite(new Date(), 10000, new Date(), new Client(2L), new Date()));
		Commande cmd=commandeMetier.consulterCommande(1L);
		Commande cmd2=commandeMetier.consulterCommande(2L);
		System.out.println("prix totale ------------>"+cmd.getPrixTotale());
		System.out.println("prix totale ------------>"+cmd2.getPrixTotale());
		System.out.println("-----------Produits--------------------------");
		ProduitMetier produitMetier=ctx.getBean(ProduitMetier.class);
		produitMetier.addProduit(new Produits("ordinateur hp", 30L, 320,"dell.jpg"));
		produitMetier.addProduit(new Produits("imprimante hp", 35L, 120,"dell.jpg"));
		Produits pr=produitMetier.consulterProduit(1L);
		Produits pr2=produitMetier.consulterProduit(2L);
		System.out.println("prix Produit ------------>"+pr.getPrix());
		System.out.println("prix Produit ------------>"+pr2.getPrix());
		System.out.println("------------Commande test-------------------");*/
		
		//commandeMetier.addCommande(new Facilite(new Date(), new Date(), new Client(2L), new Date()));
		/*OperationMetier operationMetier=ctx.getBean(OperationMetier.class);
		operationMetier.addOperation(new Operation(30, new Facilite(2L), new Produits(2L)));
	    commandeMetier.addOperation(1L ,2L);
	    Produits pr1=produitMetier.consulterProduit(2L);
		System.out.println("qte produit ------------------>"+pr1.getQte());*/
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		ProduitMetier produitMetier=ctx.getBean(ProduitMetier.class);
		produitMetier.addProduit(new Produits("ordinateur hp", 30L, 320,"dell.jpg"));
		produitMetier.addProduit(new Produits("imprimante hp", 35L, 120,"dell.jpg"));
		produitMetier.addProduit(new Produits("ordinateur dell", 50L, 500, "dell.jpg"));
		produitMetier.addProduit(new Produits("ordinateur sony", 70L, 1000, "sony.jpg"));
		produitMetier.addProduit(new Produits("ordinateur asus", 2L, 1650, "asus.jpg"));
		produitMetier.addProduit(new Produits("ordinateur lenovo", 10L, 1600, "lenovo.jpg"));
		
		Page<Produits> prds= produitMetier.chercherParMotCle("%hp%",new  PageRequest(0,5) );
		//Page<Produits> prds= produitRepository.findAll(new  PageRequest(0,5));

		prds.forEach(e->System.out.println("le nom par mot cle --------->"+e.getNom()));
		
	}
	
}
