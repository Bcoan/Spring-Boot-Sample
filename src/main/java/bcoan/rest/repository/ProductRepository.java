package bcoan.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bcoan.rest.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
