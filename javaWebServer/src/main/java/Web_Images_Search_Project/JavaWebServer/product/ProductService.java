package Web_Images_Search_Project.JavaWebServer.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public List<Product> findAll(){

        List<Product> productList = productRepository.findAll();

        return productList;

    }

    public List<Product> findByDataType(String query){
        List<Product> productList = productRepository.findByDataType(query);

        return productList;
    }
};