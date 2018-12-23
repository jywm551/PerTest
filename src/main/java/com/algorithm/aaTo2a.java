package com.algorithm;

import org.junit.Test;

/**
 * Description: 输入aaabbbcc 输出3a3b2c
 */
public class aaTo2a {
    @Test
    public void test() {
        System.out.println(method2("aabbaaa"));
        System.out.println(method("aaacccddd"));
    }

    private String method(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = message.length();
        while (true) {
            int count = 1;
            char letter = message.charAt(0);
            for (int i = 1; i < length; i++) {
                if (letter == message.charAt(i)) {
                    count++;
                } else {
                    stringBuilder.append(count).append(letter);
                    break;
                }
            }
            if (length == count) {
                stringBuilder.append(count).append(letter);
                break;
            }
            message = message.substring(count);
            length = message.length();
        }
        return stringBuilder.toString();

    }

    private String method2(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            if (letter == message.charAt(i + 1)) {
                count++;
                if (i==message.length()-2){
                    stringBuilder.append(count).append(letter);
                    break;
                }
            } else {
                stringBuilder.append(count).append(letter);
                count = 1;
            }
        }
        return stringBuilder.toString();
    }
}
