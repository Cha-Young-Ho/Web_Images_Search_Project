package Web_Images_Search_Project.JavaWebServer.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductController {


    @Autowired
    private final ProductService productService;

    @GetMapping("/product")
    @ResponseBody
    public JsonifiedProductList getProduct(@RequestParam(value = "query", required = false) String query){
        //List<Product> list =  productService.findAll();

        JsonifiedProductList jsonifiedProductList = productService.findByDataType(query);

        return jsonifiedProductList;
    }

    public String jsonify(List<Product> productList){

        ObjectMapper mapper = new ObjectMapper();
        String jsonList = null;
        try {
            jsonList = mapper.writeValueAsString(productList.get(0));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonList;


    }



}