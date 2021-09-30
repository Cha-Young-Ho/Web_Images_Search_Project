package Web_Images_Search_Project.JavaWebServer;


import Web_Images_Search_Project.JavaWebServer.product.ProductController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {


    @Autowired
    private MockMvc mockMvc;

//    @BeforeEach
//    public void before(){
//        mockMvc =
//                MockMvcBuilders
//                .standaloneSetup(ProductController.class)
//                .alwaysExpect(status().isOk())
//                .build();
//
//    }

    @Test
    public void queryParameterTest() throws Exception{

        mockMvc.perform(
                MockMvcRequestBuilders
                .get("/product?query=바나나우유")
                .accept(MediaType.ALL)
        ).andExpect(status().isOk())
                .andExpect(content().json("{\"query\":\"바나나우유\"}"));

    }
};