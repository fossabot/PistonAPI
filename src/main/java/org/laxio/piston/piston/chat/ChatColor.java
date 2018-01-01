package org.laxio.piston.piston.chat;

        /*-
         * #%L
         * Piston API
         * %%
         * Copyright (C) 2017 - 2018 Laxio
         * %%
         * This file is part of Piston, licensed under the MIT License (MIT).
         *
         * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
         *
         * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
         *
         * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
         * #L%
         */

import java.util.regex.Pattern;

public enum ChatColor {

    BLACK('0'),
    DARK_BLUE('1'),
    DARK_GREEN('2'),
    DARK_AQUA('3'),
    DARK_RED('4'),
    DARK_PURPLE('5'),
    GOLD('6'),
    GRAY('7'),
    DARK_GRAY('8'),
    BLUE('9'),
    GREEN('a'),
    AQUA('b'),
    RED('c'),
    LIGHT_PURPLE('d'),
    YELLOW('e'),
    WHITE('f'),
    MAGIC('k', "obfuscated"),
    BOLD('l'),
    STRIKETHROUGH('m'),
    UNDERLINE('n'),
    ITALIC('o'),
    RESET('r');

    public static final char COLOR_CHAR = '\u00A7';
    private static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + String.valueOf(COLOR_CHAR) + "[0-9A-FK-OR]");
    private static boolean consoleDefault = false;

    private char code;
    private String name;
    private String console;
    private String string;

    private boolean formatSet = false;
    private boolean format;

    ChatColor(char code) {
        this(code, "");
        this.name = name().toLowerCase();
    }

    ChatColor(char code, String name) {
        this.code = code;
        this.name = name;
        this.console = "";
        this.string = new String(new char[]{COLOR_CHAR, code});
    }

    public char getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String toConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String toGame() {
        return string;
    }

    public boolean isFormat() {
        if (!formatSet) {
            this.formatSet = true;
            for (ChatColor check : format()) {
                if (this == check) {
                    return this.format = true;
                }
            }

            return this.format = false;
        }

        return format;
    }

    @Override
    public String toString() {
        return consoleDefault ? console : string;
    }

    public static void setConsoleDefault(boolean console) {
        consoleDefault = console;
    }

    public static ChatColor getByChar(char code) {
        for (ChatColor color : values()) {
            if (color.code == code) {
                return color;
            }
        }

        return null;
    }

    public static ChatColor getByChar(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Code cannot be null");
        }

        if (code.length() <= 0) {
            throw new IllegalArgumentException("Code must have at least one char");
        }

        return getByChar(code.charAt(0));
    }

    public static String stripColor(final String input) {
        if (input == null) {
            return null;
        }

        return STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }

    public static String translate(char ch, String string) {
        char[] b = string.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == ch && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i + 1]) > -1) {
                b[i] = COLOR_CHAR;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }

        return new String(b);
    }

    public static String getConsoleString(String input) {
        String output = input;
        for (ChatColor color : values()) {
            output = output.replace(color.toString(), color.toConsole());
        }

        return output;
    }

    public static ChatColor[] format() {
        return new ChatColor[]{MAGIC, BOLD, STRIKETHROUGH, UNDERLINE, ITALIC};
    }

}
