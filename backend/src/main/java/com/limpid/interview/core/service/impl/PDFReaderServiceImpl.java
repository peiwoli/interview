package com.limpid.interview.core.service.impl;

import com.limpid.interview.core.service.PDFFormatter;
import com.limpid.interview.core.service.PDFReaderService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @project: interview
 * @author: Peili Zhou - LIMPID SOLUTIONS PTY LTD
 * @Date: 9/04/2022
 */
@Service
public class PDFReaderServiceImpl implements PDFReaderService {
    private static Logger logger = LoggerFactory.getLogger(PDFReaderServiceImpl.class);

    @Override
    public String loadPDF(String filename) {
            File file = new File(filename);
            if (!file.exists() || !file.isFile()){
                logger.error("FILE NOT FOUND!! {} ", file.getAbsolutePath());
                return file.getAbsolutePath() +"  NOT FOUND!";
            }
            try (PDDocument document = PDDocument.load(file);) {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                // Fetching PDF document
                String text = pdfStripper.getText(document);
                logger.info(text);

                return PDFFormatter.getFormattedText(text);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        return "Unable to extract text from file "+file.getAbsolutePath();
    }
}
