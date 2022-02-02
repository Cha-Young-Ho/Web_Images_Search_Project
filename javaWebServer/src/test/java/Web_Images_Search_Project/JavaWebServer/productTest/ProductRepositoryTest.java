package Web_Images_Search_Project.JavaWebServer.productTest;

import Web_Images_Search_Project.JavaWebServer.product.Product;
import Web_Images_Search_Project.JavaWebServer.product.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductRepositoryTest {

    @Mock
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findByDataTypeTest(){

        //given
        List<Product> productList = new ArrayList<Product>();
        Product mockProduct = new Product();
        mockProduct.setDataType("과자");
        mockProduct.setImageName("과자사진");
        mockProduct.setPrice("1000");
        mockProduct.setLink("http://");
        mockProduct.setTitle("과자");
        mockProduct.setImagePath("C://");
        productList.add(mockProduct);
        given(productRepository.findByDataType("과자")).willReturn(productList);

        //when
        List<Product> whenProductList = productRepository.findByDataType("과자");

        verify(productRepository, times(1)).findByDataType("과자");


        Assertions.assertEquals(whenProductList.get(0).getDataType(), productList.get(0).getDataType());


    }
};