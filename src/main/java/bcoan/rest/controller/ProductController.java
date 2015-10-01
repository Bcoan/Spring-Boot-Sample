package bcoan.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bcoan.rest.domain.Product;
import bcoan.rest.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService service;
	
	@Autowired
	public ProductController(ProductService service) {
		this.service = service;
	}



	@RequestMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product getProduct(@PathVariable Long id) {
		return service.findOne(id);
		
	}
	@RequestMapping(method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return service.create(product);
	}
	
	@RequestMapping()	
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Product> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
