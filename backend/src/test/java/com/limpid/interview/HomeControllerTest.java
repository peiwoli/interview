package com.limpid.interview;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @project: interview
 * @author: Peili Zhou - LIMPID SOLUTIONS PTY LTD
 * @Date: 9/04/2022
 */

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomeController(){

        try {
            mockMvc.perform(get("/get_text")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("OWNER")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
