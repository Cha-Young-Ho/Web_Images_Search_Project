package Web_Images_Search_Project.JavaWebServer.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductController {


    @Autowired
    private final ProductService productService;

    @GetMapping("/product")
    @ResponseBody
    public HashMap<String, String> getProduct(@RequestParam(value = "query", required = false) String query){
        //List<Product> list =  productService.findAll();

       // log.info("list = {}", list.get(0).getTitle());
        HashMap<String, String> map = new HashMap<>();
        map.put("query", query);

        log.info("query = {}", query);

        return map;
    }



};