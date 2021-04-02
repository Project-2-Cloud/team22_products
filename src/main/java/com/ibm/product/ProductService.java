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
                        "Student software bundle",
                        "All needed software for UCLL TI ",
                        "https://i.imgur.com/JAHewcK.png",
                        1000,
                        29.99
                ),
                new Product(
                        "2",
                        "Windows home license key",
                        "Windows home x64 license",
                        "https://i.imgur.com/FuvsOHa.png",
                        1000,
                        89.99
                ),
                new Product(
                        "3",
                        "Windows pro license key",
                        "Windows pro x64 license",
                        "https://i.imgur.com/FuvsOHa.png",
                        1000,
                        109.99
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
