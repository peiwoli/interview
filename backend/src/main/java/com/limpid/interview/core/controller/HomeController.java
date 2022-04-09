package com.limpid.interview.core.controller;

import com.limpid.interview.core.service.PDFReaderService;
import com.limpid.interview.core.service.impl.PDFReaderServiceImpl;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: interview
 * @author: Peili Zhou - LIMPID SOLUTIONS PTY LTD
 * @Date: 9/04/2022
 */

@CrossOrigin
@RestController
public class HomeController {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private PDFReaderService pdfReaderService;

    @GetMapping("/get_text")
    public JSONObject readPDF(){
        logger.info("BEGIN");

        logger.info("END");
        String text = pdfReaderService.loadPDF("LINCOLN_CONTRACT.pdf");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", text);
        return jsonObject;
    }
}
