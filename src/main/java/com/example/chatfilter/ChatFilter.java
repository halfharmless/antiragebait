package com.example.chatfilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Finds "fuck" (in any capitalization, and as part of longer words like
 * "fucking") inside a chat message and swaps it for "frick", keeping the
 * original capitalization style.
 *
 *   fuck     -> frick
 *   Fuck     -> Frick
 *   FUCK     -> FRICK
 *   fucking  -> fricking
 *   Fucking  -> Fricking
 */
public final class ChatFilter {

    private static final Pattern PROFANITY_PATTERN = Pattern.compile("fuck", Pattern.CASE_INSENSITIVE);

    private ChatFilter() {
    }

    public static String filter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        Matcher matcher = PROFANITY_PATTERN.matcher(input);
        if (!matcher.find()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        int lastEnd = 0;
        matcher.reset();
        while (matcher.find()) {
            result.append(input, lastEnd, matcher.start());
            result.append(matchCase(matcher.group(), "frick"));
            lastEnd = matcher.end();
        }
        result.append(input.substring(lastEnd));
        return result.toString();
    }

    private static String matchCase(String original, String replacement) {
        if (original.equals(original.toUpperCase())) {
            return replacement.toUpperCase();
        }
        if (Character.isUpperCase(original.charAt(0))) {
            return Character.toUpperCase(replacement.charAt(0)) + replacement.substring(1);
        }
        return replacement;
    }
}
