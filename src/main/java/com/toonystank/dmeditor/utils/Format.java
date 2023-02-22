package com.toonystank.dmeditor.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class Format {

    public static String formatText(String text) {
        String formattedText = ChatColor.translateAlternateColorCodes('&', text);
        return formattedText;
    }

    public static List<String> formatText(List<String> text) {
        return text.stream().map(Format::formatText).collect(Collectors.toList());
    }
}
