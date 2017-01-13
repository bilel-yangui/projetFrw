package org.projet.web;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.projet.Dao.ProduitRepository;
import org.projet.entities.Produits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.sym.Name;

@Controller
@RequestMapping(value="/produit")
public class ProduitControlleur {
	@Autowired
	ProduitRepository produitRepository;
	@RequestMapping(value="/index")
	public String index(Model model,@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="motCle",defaultValue="") String mc){
		Page<Produits> pageProduits =produitRepository.produitParMc("%"+mc+"%", new PageRequest(p, 5));
		int pageCount = pageProduits.getTotalPages();
		int [] pages = new int[pageCount];
		for (int i=0;i<pageCount;i++){
			pages[i]=i;
		}
		model.addAttribute("pages", pages);
		model.addAttribute("pageProduits",pageProduits);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "index";
	}
	@RequestMapping(value="/form" ,method=RequestMethod.GET)
	public String formProduit(Model model){
		model.addAttribute("produit",new Produits());
		return "formProduit";
	}
	
	@RequestMapping(value="/saveProduit" ,method=RequestMethod.POST)
	public String save(@Valid Produits pr,BindingResult  bindingResult,@RequestParam(name="picture")MultipartFile file){
		/*if(bindingResult.hasErrors()){
			return "redirect:/produit/form";
		}*/
		if (!file.isEmpty()){
			pr.setPhoto(file.getOriginalFilename());	
		}
		produitRepository.save(pr);
		if (!file.isEmpty()){
			try {
				file.transferTo(new File("/home/user/springImg/"+pr.getId()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:/produit/index";
	}
	@RequestMapping(value="/getPhoto",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long id) throws Exception{
		File f=new File("/home/user/springImg/"+id);
		return org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(f));	
		
	}
	
	@RequestMapping(value="/supprimer" ,method=RequestMethod.GET)
	public String supprimer(long id){
		produitRepository.delete(id);
		return "redirect:/produit/index";
	}
	
	@RequestMapping(value="/edit" ,method=RequestMethod.GET)
	public String edit(long id,Model model){
		
		Produits p = produitRepository.getOne(id);
		model.addAttribute("produit", p);
		return "editProduit";
	}
	
	@RequestMapping(value="/updateProduit" ,method=RequestMethod.POST)
	public String update(@Valid Produits pr,BindingResult  bindingResult,@RequestParam(name="picture")MultipartFile file){
		/*if(bindingResult.hasErrors()){
			return "redirect:/produit/form";
		}*/
		if (!file.isEmpty()){
			pr.setPhoto(file.getOriginalFilename());	
		}
		produitRepository.save(pr);
		if (!file.isEmpty()){
			try {
				file.transferTo(new File("/home/user/springImg/"+pr.getId()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:/produit/index";
	}
	
	@RequestMapping(value="/commander" ,method=RequestMethod.GET)
	public String afficheProduit(){
		
		return "Commande";
	}

}
