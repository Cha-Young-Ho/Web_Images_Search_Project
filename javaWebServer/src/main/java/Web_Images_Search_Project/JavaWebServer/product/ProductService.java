package Web_Images_Search_Project.JavaWebServer.product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public List<Product> findAll(){

        List<Product> productList = productRepository.findAll();

        return productList;

    }

    public JsonifiedProductList findByDataType(String query){
        List<Product> productList = productRepository.findByDataType(query);

        return jsonify(productList, query);
    }

        // 응답 json 생성
    public JsonifiedProductList jsonify(List<Product> productList, String query){

        JsonifiedProductList jsonifiedProductList = new JsonifiedProductList();
        jsonifiedProductList.getMainFilter().put("searchWord", query);


        if(productList == null){
            jsonifiedProductList.getMainFilter().put("ProductCount", "0");

            return jsonifiedProductList;
        }

        jsonifiedProductList.getMainFilter().put("productCount", ""+productList.size());
        jsonifiedProductList.setProducts(productList);


        return jsonifiedProductList;


    }


}