package com.ibm.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /* private List<Topic> topics = new ArrayList<>(Arrays.asList(
        new Topic("spring", "Spring Framework", "Spring Framework Description"),
        new Topic("java", "Core Java", "Core Java Description"),
        new Topic("javascript", "JavaScript", "JavaScript Description")
    )); */

//    public List<Product> getAllProducts() {
//        //return products;
//        List<Product> topics = new ArrayList<>();
//        productRepository.findAll()
//            .forEach(topics::add);
//        return topics;
//    }
    public List<Product> getAllProducts(){
        return Arrays.asList(
                new Product(
                        "1",
                        "macbook Retina 13.3' ME662 (2013)",
                        "3.0GHz Dual-core Haswell Intel Core i5 Turbo Boost up to 3.2 GHz, 3MB L3 cache 8GB (two 4GB SO-DIMMs) of 1600MHz DDR3 SDRAM",
                        "https://www.dropbox.com/s/swg9bdr0ejcbtrl/img9.jpg?raw=1",
                        10,
                        2399
                ),
                new Product(
                        "2",
                        "Macbook Pro 13.3' Retina MF841LL/A",
                        "Macbook Pro 13.3' Retina MF841LL/A Model 2015 Option Ram Care 12/2016",
                        "https://www.dropbox.com/s/6tqcep7rk29l59e/img2.jpeg?raw=1",
                        15,
                        1199
                ),
                new Product(
                        "3",
                        "Macbook Pro 15.4' Retina MC975LL/A Model 2012",
                        "3.0GHz Dual-core Haswell Intel Core i5 Turbo Boost up to 3.2 GHz, 3MB L3 cache 8GB (two 4GB SO-DIMMs) of 1600MHz DDR3 SDRAM",
                        "https://www.dropbox.com/s/78fot6w894stu3n/img3.jpg?raw=1",
                        1,
                        1800
                )
        );
    }

    public Product getProduct(String id) {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return productRepository.findById(id).orElse(null);
    }

	public void addProduct(Product product) {
        //topics.add(topic);
        productRepository.save(product);
    }
    
    public void updateProduct(String id, Product product) {
        /* for (int i=0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        } */
        productRepository.save(product);
    }

	public void deleteProduct(Product id) {
        // topics.removeIf(t -> t.getId().equals(id));
        productRepository.delete(id);
	}

}
