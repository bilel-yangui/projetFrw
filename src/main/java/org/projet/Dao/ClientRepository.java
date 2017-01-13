package org.projet.Dao;

import java.util.List;

import org.projet.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query("select c from Client c where c.nom like :x")
	public List<Client> ClientParMc(@Param("x") String mc);
}
