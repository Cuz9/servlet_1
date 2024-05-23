package service;

import java.util.ArrayList;
import java.util.List;

import DAO.ProductDAO;
import model.Product;

public class ProductService {
	private List<Product> products;
	private ProductDAO produtDTO;

	public ProductService() {
		super();
		this.products = new ArrayList<>();
		this.produtDTO = new ProductDAO();
	}

	public List<Product> getProducts() {
		return this.produtDTO.getProducts();
	}

	public List<Product> findByCateogory(int categoryId) {
		List<Product> searchsByC = new ArrayList<>();
		for (Product p : products) {
			if (p.getCategory().getId() == categoryId) {
				searchsByC.add(p);
			}
		}
		return searchsByC;
	}

	public void createProduct(Product product) {

		produtDTO.create(product);
	}

	public Product getById(int id) {

		return produtDTO.findById(id);
	}

	public void deleteProduct(int id) {
		produtDTO.delete(id);
	}

	public void updateProduct(int id, Product product) {
		Product p = new Product();
		if (p != null) {
			p.setName(product.getName());
			p.setPrice(product.getPrice());
			p.setQuantity(product.getQuantity());
			p.setImage(product.getImage());
			p.setCategory(product.getCategory());
			produtDTO.update(id, product);
		}
	}

	public int getTotalProducts() {
		return produtDTO.getTotalProducts();
	}

	public List<Product> getProductsPaginated(int limit, int offset) {
		return produtDTO.getProductsPaginated(limit, offset);
	}
}
