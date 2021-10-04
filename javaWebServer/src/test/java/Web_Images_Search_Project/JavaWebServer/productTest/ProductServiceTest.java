package Web_Images_Search_Project.JavaWebServer.productTest;


import Web_Images_Search_Project.JavaWebServer.product.Product;
import Web_Images_Search_Project.JavaWebServer.product.ProductController;
import Web_Images_Search_Project.JavaWebServer.product.ProductRepository;
import Web_Images_Search_Project.JavaWebServer.product.ProductService;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void productServiceFindByDataTypeMethodTest(){


        //given
        Product product = new Product();
        product.setTitle("과자");
        product.setImagePath("C://");
        product.setLink("http://");
        product.setImageName("과자사진");
        product.setDataType("과자");
        product.setPrice("1000");

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        given(productService.findByDataType("과자")).willReturn(productList);

        //when
        List<Product> findProductList = productService.findByDataType("과자");

        //then
        Assertions.assertEquals(productList, findProductList);
        Assertions.assertEquals(productList.get(0), findProductList.get(0));

    }

    @Test
    public void productServiceFindByDataType행위Test(){

        //given
        ProductService mockProductService = mock(ProductService.class);
        //when
        when(mockProductService.findByDataType("과자")).thenReturn(new ArrayList<Product>());
        //then

        mockProductService.findByDataType("과자");

        verify(mockProductService).findByDataType("과자");

    }


}