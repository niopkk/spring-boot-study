package com.bbz.spring.webmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {

    public static final String DEFAULT_CONTENT_TYPE = "text/html;charset=utf-8";
    private File viewFile;

    public View(File viewFile) {
        this.viewFile = viewFile;
    }


    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuilder sb = new StringBuilder();
        RandomAccessFile ra = new RandomAccessFile(this.viewFile, "r");

        try {
            String line = "";
            while (null != (line = ra.readLine())) {
                line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
                Pattern compile = Pattern.compile("¥\\{[^\\}]}", Pattern.CASE_INSENSITIVE);
                Matcher matcher = compile.matcher(line);
                while (matcher.find()) {
                    String paramName = matcher.group();
                    paramName = paramName.replaceAll("¥\\{|\\}", "");
                    Object paramValue = model.get(paramName);
                    if (null == paramValue) {
                        continue;
                    }
                    line = matcher.replaceFirst(makeStringForRegExp(paramValue.toString()));
                    matcher = compile.matcher(line);
                }
            }
            sb.append(line);
        } finally {
            ra.close();
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(sb.toString());

    }

    private String makeStringForRegExp(String str) {
        return str.replace("\\", "\\\\").replace("*", "\\*")
                .replace("+", "\\+").replace("|", "\\|")
                .replace("{", "\\{").replace("}", "\\}")
                .replace("[", "\\[").replace("]", "\\]")
                .replace("^", "\\^").replace("$", "\\$")
                .replace("(", "\\(").replace(")", "\\)")
                .replace("?", "\\?").replace(",", "\\,")
                .replace(".", "\\.").replace("&", "\\&");

    }
}
