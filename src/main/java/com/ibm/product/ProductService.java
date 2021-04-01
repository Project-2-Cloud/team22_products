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
                        "Free",
                        "Free 1 month trial version for students",
                        "https://www.dropbox.com/s/swg9bdr0ejcbtrl/img9.jpg?raw=1",
                        1000,
                        2399
                ),
                new Product(
                        "2",
                        "Student service",
                        "A 1 month licence for the student service, giving you acces to all content on the platform",
                        "https://www.dropbox.com/s/6tqcep7rk29l59e/img2.jpeg?raw=1",
                        1000,
                        1199
                ),
                new Product(
                        "3",
                        "Enterprise",
                        "A 1 month licence for the enterprise service, allowing you to upload and edit content on the platform. Access to all features and support forums.",
                        "https://www.dropbox.com/s/78fot6w894stu3n/img3.jpg?raw=1",
                        1000,
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
