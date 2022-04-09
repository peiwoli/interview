package com.limpid.interview.core.service;

import org.springframework.stereotype.Component;

/**
 * @project: interview
 * @author: Peili Zhou - LIMPID SOLUTIONS PTY LTD
 * @Date: 9/04/2022
 */

public class PDFFormatter {
    public static String getFormattedText(String text){
        text = text.replaceAll("\\r\\n", "<br>");
        return text;
    }
}
