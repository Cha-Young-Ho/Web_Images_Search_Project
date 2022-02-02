package Web_Images_Search_Project.JavaWebServer.product;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class JsonifiedProductList {

    private HashMap<String, String> mainFilter;
    private List<Product> products;

    public JsonifiedProductList(){
        this.mainFilter = new HashMap<>();
        this.products = new ArrayList<>();
    }



}