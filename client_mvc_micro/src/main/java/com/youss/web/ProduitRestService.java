package com.youss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youss.dao.ProduitRepository;
import com.youss.entities.Produit;

@RestController
public class ProduitRestService {
    @Autowired
	private ProduitRepository produitrepo;
    
    @RequestMapping(value="/produits", method=RequestMethod.GET)
    public List<Produit> listProduits(){
    	return produitrepo.findAll();
    }
    
    
    @RequestMapping(value="/produits/{id}", method=RequestMethod.GET)
    public Produit getProduit(@PathVariable(name="id")Long id){
    	return produitrepo.findOne(id);
    }
    
    @RequestMapping(value="/produits", method=RequestMethod.POST)
    public Produit saveProduit(@RequestBody Produit p){
    	return produitrepo.save(p);
    }
    
    @RequestMapping(value="/produits/{id}", method=RequestMethod.PUT)
    public Produit updateProduit(@PathVariable(name="id") Long id,@RequestBody Produit p){
    	p.setId(id);
    	return produitrepo.save(p);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value="/chercher", method=RequestMethod.GET)
    public Page<Produit> chercherProduits(
    		@RequestParam(name="mc",defaultValue="")String mc, 
    		@RequestParam(name="page",defaultValue="0")int page, 
    		@RequestParam(name="size",defaultValue="4")int size){
    	return produitrepo.chercher("%"+mc+"%", new PageRequest(page, size));
    }
    
}
