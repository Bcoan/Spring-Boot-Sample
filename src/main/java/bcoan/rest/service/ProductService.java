package bcoan.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bcoan.rest.domain.Product;
import bcoan.rest.exception.NotFoundException;
import bcoan.rest.repository.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository repository;
	
	
	@Autowired
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public Product create(Product product) {
		return repository.save(product);
	}
	
	public Product findOne(Long productId) {
		exists(productId);
		return repository.findOne(productId);
	}
	
	public Iterable<Product> findAll() {
		return repository.findAll();
	}
	
	public void delete(Long productId) {
		exists(productId);
		repository.delete(productId);
	}
	
	public Product update(Product product) {
		return repository.save(product);
	}
	
	private void exists(Long productId) {
		if (! repository.exists(productId)) {
			throw new NotFoundException("Produto não encontrado");
		}
	}

}
