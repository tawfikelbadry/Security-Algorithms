/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tawfik.securityproject.algorithms.playfair;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 *
 * @author tawfik
 */
@Component
public class PlayFair {

    private String plainText = "";

    private String cipherText = "";

    private String key = "";
    private String matrix[][] = new String[5][5];

    private int ijRow, ijCol;

    // this method take values from key and put them to matrix with no dublicate 
    // then add the whole other letters
    private void setMatrixValues(String key) {
        this.key = key;
        Set<String> letters = new LinkedHashSet<>();

        boolean isIorJadded = false;

        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) != ' ') {
                if ((key.charAt(i) == 'I' || key.charAt(i) == 'J') && (isIorJadded == true)) {
                    continue;
                }
                letters.add((key.charAt(i) + "").toUpperCase());
                if (key.charAt(i) == 'I' || key.charAt(i) == 'J') {
                    isIorJadded = true;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if ((((char) ('A' + i)) == 'J' || (((char) ('A' + i)) == 'I')) && (isIorJadded == true)) {
                continue;
            }
            if ((((char) ('A' + i)) == 'J' || (((char) ('A' + i)) == 'I'))) {
                isIorJadded = true;
            }
            letters.add(((char) ('A' + i)) + "");
        }

        Iterator iterator = letters.iterator();
        int row = 0, col = 0;
        while (iterator.hasNext()) {
            matrix[row][col] = iterator.next() + "";
            col++;
            if (col % 5 == 0) {
                row++;
                col = 0;
            }
            if (row == 5) {
                break;
            }
        }
        displayMatrix(matrix);
    }

    public String Encrypt(String plain, String key) {
        this.plainText = plain;
        key = key.toUpperCase();
        this.cipherText = "";
        plain = plain.toUpperCase();
        setMatrixValues(key);

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if (matrix[i][j].equals('I' + "") || matrix[i][j].equals('J' + "")) {
                    this.ijRow = i;
                    this.ijCol = j;
                }
            }
        }

        int index = 0;
        while (index < plain.length()) {
            char ch[] = new char[2];
            int r = 0;
            while (r < 2 && index < plain.length()) {
                if (plain.charAt(index) != ' ') {

                    ch[r] = plain.charAt(index);
                    if (r == 1 && ch[0] == ch[1]) {
                        ch[1] = 'X';
                        index--;
                    }
                    r++;
                }
                index++;

            }
            if (ch[1] == '\u0000') {
                ch[1] = 'X';
            }
            char tempcipherLetters[] = getEncryptedChars(ch);
            this.cipherText += tempcipherLetters[0] + "" + tempcipherLetters[1];
        }
        System.out.println(cipherText);
        return this.cipherText;
    }

    public char[] getEncryptedChars(char[] plainLetters) {
        int c1Row = -1, c2Row = -1, c1Col = -1, c2Col = -1;

        char encryptedChars[] = new char[2];

        for (int letter = 0; letter < 2; letter++) {  //for 2 char
            for (int r = 0; r < matrix.length; r++) {  //for all matrix
                for (int c = 0; c < matrix[r].length; c++) {
                    if (plainLetters[letter] == this.matrix[r][c].charAt(0)) {
                        if (letter == 0) {
                            c1Row = r;
                            c1Col = c;
                        } else {
                            c2Row = r;
                            c2Col = c;
                        }

                    } else if (plainLetters[letter] == 'I' || plainLetters[letter] == 'J') {
                        if (letter == 0) {
                            c1Row = this.ijRow;
                            c1Col = this.ijCol;
                        } else {
                            c2Row = this.ijRow;
                            c2Col = this.ijCol;

                        }
                    }
                }
            }
        }
        System.out.println(plainLetters[0] + " : [ " + c1Row + " , " + c1Col + " ]");
        System.out.println(plainLetters[1] + " : [ " + c2Row + " , " + c2Col + " ]");

        if (c1Row != c2Row && c1Col != c2Col) {
            encryptedChars[0] = this.matrix[c1Row][c2Col].charAt(0);
            encryptedChars[1] = this.matrix[c2Row][c1Col].charAt(0);
            System.out.println(encryptedChars[0] + " " + encryptedChars[1]);
        } else if (c1Row == c2Row) {
            int tempc1 = (c1Col + 1) % 5;
            int tempc2 = (c2Col + 1) % 5;

            encryptedChars[0] = this.matrix[c1Row][tempc1].charAt(0);
            encryptedChars[1] = this.matrix[c2Row][tempc2].charAt(0);

        } else if (c1Col == c2Col) {
            int tempr1 = (c1Row + 1) % 5;
            int tempr2 = (c2Row + 1) % 5;
            encryptedChars[0] = this.matrix[tempr1][c1Col].charAt(0);
            encryptedChars[1] = this.matrix[tempr2][c2Col].charAt(0);
        }

        return encryptedChars;
    }

    public String decrypt(String cipher, String key) {
        this.plainText = "";
        key = key.toUpperCase();
        cipher = cipher.toUpperCase();
        setMatrixValues(key);

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if (matrix[i][j].equals('I' + "") || matrix[i][j].equals('J' + "")) {
                    this.ijRow = i;
                    this.ijCol = j;
                }
            }
        }

        int index = 0;
        while (index < cipher.length()) {
            char ch[] = new char[2];
            int r = 0;
            while (r < 2 && index < cipher.length()) {
                if (cipher.charAt(index) != ' ') {

                    ch[r] = cipher.charAt(index);
                    if (r == 1 && ch[0] == ch[1]) {
                        ch[1] = 'X';
                        index--;
                    }
                    r++;
                }
                index++;

            }
            if (ch[1] == '\u0000') {
                ch[1] = 'X';
            }
            char tempPlainLetters[] = getDecryptedChars(ch);
            this.plainText += tempPlainLetters[0] + "" + tempPlainLetters[1];
        }

        this.plainText = remvoveExtrasX(this.plainText);

//        String result = "";
//        for (int i = 0; i < plainText.length(); i++) {
//            if (plainText.charAt(i) == 'I' || plainText.charAt(i) == 'J') {
//                result += "I/J";
//            } else {
//                result += plainText.charAt(i) + "";
//            }
//        }
//        System.out.println(result);
//        this.plainText = result;

        return this.plainText;
    }

    public char[] getDecryptedChars(char[] cipherLetters) {
        int c1Row = -1, c2Row = -1, c1Col = -1, c2Col = -1;

        char decryptedChars[] = new char[2];

        for (int letter = 0; letter < 2; letter++) {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    if (cipherLetters[letter] == this.matrix[r][c].charAt(0)) {
                        if (letter == 0) {
                            c1Row = r;
                            c1Col = c;
                        } else {
                            c2Row = r;
                            c2Col = c;
                        }

                    } else if (cipherLetters[letter] == 'I' || cipherLetters[letter] == 'J') {
                        if (letter == 0) {
                            c1Row = this.ijRow;
                            c1Col = this.ijCol;
                        } else {
                            c2Row = this.ijRow;
                            c2Col = this.ijCol;

                        }
                    }
                }
            }
        }
        System.out.println(cipherLetters[0] + " : [ " + c1Row + " , " + c1Col + " ]");
        System.out.println(cipherLetters[1] + " : [ " + c2Row + " , " + c2Col + " ]");

        if (c1Row != c2Row && c1Col != c2Col) {
            decryptedChars[0] = this.matrix[c1Row][c2Col].charAt(0);
            decryptedChars[1] = this.matrix[c2Row][c1Col].charAt(0);
            System.out.println(decryptedChars[0] + " " + decryptedChars[1]);
        } else if (c1Row == c2Row) {
            int tempc1 = (c1Col - 1);
            int tempc2 = (c2Col - 1);
            if (tempc1 == -1) {
                tempc1 = 4;
            }
            if (tempc2 == -1) {
                tempc2 = 4;
            }

            decryptedChars[0] = this.matrix[c1Row][tempc1].charAt(0);
            decryptedChars[1] = this.matrix[c2Row][tempc2].charAt(0);

        } else if (c1Col == c2Col) {
            int tempr1 = (c1Row - 1);
            int tempr2 = (c2Row - 1);

            if (tempr1 == -1) {
                tempr1 = 4;
            }
            if (tempr2 == -1) {
                tempr2 = 4;
            }

            decryptedChars[0] = this.matrix[tempr1][c1Col].charAt(0);
            decryptedChars[1] = this.matrix[tempr2][c2Col].charAt(0);
        }

        return decryptedChars;
    }

    public void displayMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        PlayFair p = new PlayFair();
//        System.out.println(p.decrypt("ZNCSDLYNKZGEQS"));

    }
//ZNCSDLYNKZGEQS

    public String remvoveExtrasX(String cipher) {

        String result = "";
        int i = 0;
        while (i < cipher.length() - 2) {
            char first = cipher.charAt(i);
            char second = cipher.charAt(i + 1);
            char third = cipher.charAt(i + 2);
            result += cipher.charAt(i);

            if (first == third && second == 'X') {
                i++;
            }
            i++;
        }
        if (cipher.charAt(cipher.length() - 3) == cipher.charAt(cipher.length() - 1) && cipher.charAt(cipher.length() - 2) == 'X') {
            result += cipher.charAt(cipher.length() - 3) + "" + cipher.charAt(cipher.length() - 1);
        } else {
            result += cipher.substring(cipher.length() - 2);
        }
        return result;
    }
}
