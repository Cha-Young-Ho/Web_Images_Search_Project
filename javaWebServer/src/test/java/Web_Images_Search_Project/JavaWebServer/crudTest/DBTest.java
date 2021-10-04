package Web_Images_Search_Project.JavaWebServer.crudTest;


import Web_Images_Search_Project.JavaWebServer.CommunicatePython;
import Web_Images_Search_Project.JavaWebServer.product.Product;
import Web_Images_Search_Project.JavaWebServer.product.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class DBTest {

    @Autowired
    ProductService productService;


//    @Test
//    public void getData(){
//
//
//        //given
//        String query = "녹차";
//
//        List<Product> list = productService.findByDataType(query);
//
//        //when
//
//        if(list.isEmpty()){
//            CommunicatePython communicatePython = new CommunicatePython();
//            String result = communicatePython.createHttpRequestAndSend(query);
//            Assertions.assertEquals("true", result);
//        }else{
//            Assertions.assertNotNull(list);
//        }
//    }

}