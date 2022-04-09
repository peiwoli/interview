package com.limpid.interview;

import com.limpid.interview.core.controller.HomeController;
import com.limpid.interview.core.service.PDFReaderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

/**
 * @project: interview
 * @author: Peili Zhou - LIMPID SOLUTIONS PTY LTD
 * @Date: 9/04/2022
 */

@SpringBootTest
public class PDFReaderServiceTest {
    @Autowired
    private PDFReaderService pdfReaderService;

    @Test
    public void testPDFReaderService() {
        String filename = "LINCOLN_CONTRACT.pdf";
        String text = pdfReaderService.loadPDF(filename);
        Assert.assertNotNull(text);
        Assert.assertTrue(text.contains("OWNER"));
    }


}
