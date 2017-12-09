package com.youss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.youss.dao.ProduitRepository;
import com.youss.entities.Produit;

@SpringBootApplication
public class ClientMvcMicroApplication implements CommandLineRunner{
	@Autowired
    private ProduitRepository produitrepo;
    
	public static void main(String[] args) {
		SpringApplication.run(ClientMvcMicroApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		produitrepo.save(new Produit("hp", 900, 6));
		produitrepo.save(new Produit("samsung", 1900, 26));
	}
}
