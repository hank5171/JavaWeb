package cart.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cart.dao.ProductDAO;
import cart.dao.impl.ProductDAOImpl;
import cart.model.dto.ProductDTO;
import cart.model.dto.UserDTO;
import cart.model.entity.Product;
import cart.model.entity.User;
import cart.service.ProductService;

public class ProductServiceImpl implements ProductService{
		ProductDAO productDAO = new ProductDAOImpl();
	
	@Override
	public void add(String productName, String price, String qty, String productImageBase64) {
		Product product = new Product();
		product.setProductName(productName);
		product.setPrice(Integer.parseInt(price));
		product.setQty(Integer.parseInt(qty));
		product.setImageBase64(productImageBase64);
			
		productDAO.add(product);
	}	
		
	@Override
	public List<ProductDTO> findAllProducts() {
		List<Product> products =  productDAO.findAllProducts();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product : products ) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(product.getProductId());
			productDTO.setProductName(product.getProductName());
			productDTO.setPrice(product.getPrice());
			productDTO.setQty(product.getQty());
			productDTO.setImageBase64(product.getImageBase64());
			productDTO.setTotal((product.getPrice()*product.getQty()));
			
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}
		


	@Override
	public void delete(Integer productId) {
		Product product = productDAO.findById(productId);
		productDAO.delete(product);
	}
}
