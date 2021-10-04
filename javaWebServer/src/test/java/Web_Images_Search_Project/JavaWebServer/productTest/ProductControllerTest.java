package Web_Images_Search_Project.JavaWebServer.productTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {




    @Autowired
    private MockMvc mockMvc;

    @Test
    public void queryParameterTest() throws Exception{

        mockMvc.perform(
                get("/product?query=바나나우유")
                .accept(MediaType.ALL)
        ).andExpect(status().isOk())
                .andExpect(content().json("{\"query\":\"바나나우유\"}"));


    }

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
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(log());
    }
};