//    Task Executor is a simple script tasks executor.
//    Copyright (C) 2011 Adrián Romero Corchado.
//
//    This file is part of Task Executor
//
//    Task Executor is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Task Executor is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Task Executor. If not, see <http://www.gnu.org/licenses/>.

package com.adr.taskexecutor.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class Utils {

    private static final Logger logger = Logger.getLogger(Utils.class.getName());

    private static DateFormat fmttime = new SimpleDateFormat("yyyyMMddhhmmssS");

    public static String loadText(File f) throws IOException {

        return loadReader(new InputStreamReader(new FileInputStream(f)));
    }

    public static void saveText(File f, String text) throws IOException {

        Writer w = null;
        try {
            w = new OutputStreamWriter(new FileOutputStream(f, false));
            w.write(text);
        } finally {
            if (w != null) {
                w.close();
            }
        }
    }

    public static String getSystemFile(String file) {
        return file.replaceAll("~", System.getProperty("user.home"));
    }

    public static File getLogFile(String file) {

        return new File(getSystemFile(file) + "." + fmttime.format(new Date()) + "." + Integer.toString((int) (Math.floor(Math.random() * 10000.0))) + ".log");
    }

    public static Reader getResourceReader(String file) {
        try {
            return new InputStreamReader(Utils.class.getResourceAsStream(file), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
    }

    public static String loadResourceText(String file) throws IOException {
        return loadReader(getResourceReader(file));
    }

    public static String loadReader(Reader stream) throws IOException {
        BufferedReader r = null;
        StringBuilder text = new StringBuilder();
        try {
            r = new BufferedReader(stream);

            String line = null;
            while ((line = r.readLine()) != null) {
                text.append(line);
                text.append(System.getProperty("line.separator"));
            }
        } finally {
            if (r != null) {
                r.close();
            }
        }
        return text.toString();
    }
}
