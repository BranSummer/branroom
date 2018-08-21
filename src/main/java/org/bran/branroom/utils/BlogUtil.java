package org.bran.branroom.utils;

import java.time.LocalDateTime;

public class BlogUtil {

    public static String removeTag(String source) {
        String target = null;
        target = source.replaceAll(" ", "")
                .replaceAll("#", "")
                .replaceAll("\\*", "")
                .replaceAll("\\[TOC\\]", "");

        return target;
    }

    public static String limitSize(String source, int size) {
        String target = null;
        if (size >= source.length()) {
            return source;
        }
        target = source.substring(0, size);
        return target;
    }

    public static String getDateStr(LocalDateTime dateTime){
        String dateStr = null;
        dateStr = ""+dateTime.getYear()+"-"+dateTime.getMonthValue()+"-"+dateTime.getDayOfMonth();
        return dateStr;
    }
}
