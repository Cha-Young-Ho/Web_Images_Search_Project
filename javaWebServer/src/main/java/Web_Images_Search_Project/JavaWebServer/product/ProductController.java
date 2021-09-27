package Web_Images_Search_Project.JavaWebServer.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping("/product")
    public String getProduct(){
        List<Product> list =  productService.findAll();

        log.info("list = {}", list.get(0).getTitle());


        return "product";
    }



};