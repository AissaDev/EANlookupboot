package org.issa.dao;




import org.issa.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource
public interface CategorieRepository extends JpaRepository<Categories,Long > {

}
