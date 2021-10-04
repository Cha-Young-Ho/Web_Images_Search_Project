package Web_Images_Search_Project.JavaWebServer.productTest;


import Web_Images_Search_Project.JavaWebServer.product.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Test
    public void productServiceFindByDataType행위Test(){

        //given
        ProductService mockProductService = mock(ProductService.class);
        //when
        when(mockProductService.findByDataType("과자")).thenReturn(new JsonifiedProductList());
        //then

        mockProductService.findByDataType("과자");

        verify(mockProductService).findByDataType("과자");

    }
}