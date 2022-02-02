package Web_Images_Search_Project.JavaWebServer.productTest;


import Web_Images_Search_Project.JavaWebServer.product.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void responseTest() throws Exception{

        mockMvc.perform(
                get("/product?query=녹차"))
                .andExpect(status().isOk());

    }

    @Test
    public void responseContentTest() throws Exception{

        mockMvc.perform(
                get("/product?query=녹차"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(log());
    }


    @Test
    public void getProduct행위Test(){

        //given
        ProductController mockProductController = mock(ProductController.class);
        //when
        when(mockProductController.getProduct("과자")).thenReturn(any());
        mockProductController.getProduct("과자");

        //then
        verify(mockProductController).getProduct("과자");



    }
    @Test
    public void responsePropertyCheck데이터가_있을_경우() throws Exception{

        String expectProductCount = "$.mainFilter[?(@.productCount == '%s')]";

        mockMvc.perform(
                get("/product?query=녹차"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(expectProductCount, "160").exists());


    }

    @Test
    public void responsePropertyCheck데이터가_없을_경우() throws Exception{
        String expectProductCount = "$.mainFilter[?(@.productCount == '%s')]";

        mockMvc.perform(
                get("/product?query=녹촤"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(expectProductCount, "0").exists());
    }








}
