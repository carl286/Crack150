package com.crack150.ch01;

import java.util.Arrays;

/**
 * Created by Ke.Liu on 3/13/16.
 */
public class Ch1 {
    //Using additional ds
    public boolean isUnique1(String s) {
        if (s.length() <= 0)
            return false;

        boolean [] flags = new boolean [256];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (flags[ch]) {
                return false;
            }
            flags[ch] = true;
        }

        return true;
    }

    private String sort(String s) {
        char [] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    public boolean isPermutation(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;

        if (s1 == null || s2 == null)
            return false;

        if (s1.length() != s2.length())
            return false;

        return sort(s1).equals(sort(s2));
    }

    public void replaceSpaces(char [] str, int length) {
        int numOfSpaces = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ')
                numOfSpaces++;
        }

        if (numOfSpaces > 0) {
            int newLength = length - numOfSpaces + 3 * numOfSpaces;
            str[newLength] = '\0';
            while (length > 0 && newLength > 0) {
                if (str[length-1] != ' ') {
                    str[--newLength] = str[--length];
                } else {
                    --length;
                    str[--newLength] = '0';
                    str[--newLength] = '2';
                    str[--newLength] = '%';
                }
            }
        }
    }

    public String compressBad(String str) {
        if (str == null)
            return str;

        if (str.length() <= 1)
            return str;

        StringBuffer buffer = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            ++j;
            while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                ++j;
            }
            buffer.append(str.charAt(i));
            buffer.append(j - i);
            i = j;
        }

        if (buffer.length() < str.length())
            return buffer.toString();
        else
            return str;
    }
    public static void main(String[] args) {
        Ch1 test = new Ch1();

//        String s = "abc";
//        System.out.println(test.isUnique1(s));
        // write your code here

//        String s1 = "abc", s2 = "cba";
//        System.out.println(test.isPermutation(s1, s2));

//        char [] str = new char[100];
//        str[0] = 'a';
//        str[1] = ' ';
//        str[2] = ' ';
//        str[3] = 'c';
//        str[4] = ' ';
//        str[5] = 'a';
//        str[6] = '\0';
//        int length = 7;
//        test.replaceSpaces(str, length);
//        System.out.println(str);

        char [] s = new char [100];
        Arrays.fill(s,'a');
        String str = new String(s);
        System.out.println(test.compressBad(str));
    }
}
