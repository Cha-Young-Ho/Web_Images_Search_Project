package Web_Images_Search_Project.JavaWebServer;


import Web_Images_Search_Project.JavaWebServer.product.Product;
import Web_Images_Search_Project.JavaWebServer.product.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DBTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void getTest(){

        List<Product> list = productRepository.findAll();

        Assertions.assertNotNull(list);
    }

};