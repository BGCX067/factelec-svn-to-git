/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 *
 * @author Rolando
 */
public class ExceptionUtils {

    public static String getStackTrace(Throwable throwable) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        throwable.printStackTrace(printWriter);
        return writer.toString();
    }
    
}
