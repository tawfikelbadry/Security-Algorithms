package com.tawfik.securityproject.algorithms.Combination;

import org.springframework.stereotype.Component;

/**
 *
 * @author tawfik
 */
@Component
public class Combination {

    private static final String labels[] = {"A", "B", "C", "D", "E"};

    private static final String matrix[][] = {
        {"A", "B", "C", "D", "E"},
        {"F", "G", "H", "I", "J"},
        {"K", "L", "M", "N", "O"},
        {"P", "Q|Z", "R", "S", "T"},
        {"U", "V", "W", "X", "Y"}
    };

    // all characters come from matching rows and coulmn with plain charachter
    private String rc_chars = "";

    // the final cypher text
    private String cypher = "";

    private String plain = "";

    // the encryption method
    public String encrypt(String plain) {
        // clear data if exist
        this.rc_chars = "";
        this.cypher = "";

        for (int i = 0; i < plain.length(); i++) {
            String temp = plain.charAt(i) + "";

            for (int mr = 0; mr < matrix.length; mr++) {
                for (int mc = 0; mc < matrix[mr].length; mc++) {
                    if (temp.equalsIgnoreCase(matrix[mr][mc].charAt(0) + "")) {
                        rc_chars += labels[mr] + labels[mc];
                    } else if (temp.equalsIgnoreCase("Z")) {
                        rc_chars += labels[3] + labels[1];
                    }
                }
            }

        }
        int num_letters = rc_chars.length() / 2;
        String s1 = "", s2 = "";
        for (int i = 0; i < num_letters; i++) {
            char c1 = rc_chars.charAt(i);
            char c2 = rc_chars.charAt(i + num_letters);
            s1 += c1;
            s2 += c2;

            String cypherChar = matrix[getCharIndex(c1)][getCharIndex(c2)].charAt(0)+"";
            cypher += cypherChar;
        }

        System.out.println(s1);
        System.out.println(s2);
        System.out.println("cypher : " + cypher);
        return cypher;

    }

    // the deccryption method
    public String decrypt(String cypher) {
        // clear data if exist
        this.rc_chars = "";
        this.cypher = "";
        this.plain = "";

        for (int i = 0; i < cypher.length(); i++) {
            String temp = cypher.charAt(i) + "";

            for (int mr = 0; mr < matrix.length; mr++) {
                for (int mc = 0; mc < matrix[mr].length; mc++) {
                    if (temp.equalsIgnoreCase(matrix[mr][mc].charAt(0) + "")) {
                        rc_chars += labels[mr] + labels[mc];
                    } else if (temp.equalsIgnoreCase("Z")) {
                        rc_chars += labels[3] + labels[1];
                    }
                }
            }

        }

        String s1 = "", s2 = "";
        for (int i = 0; i < rc_chars.length(); i += 2) {
            char c1 = rc_chars.charAt(i);
            char c2 = rc_chars.charAt(i + 1);

            s1 += c1;
            s2 += c2;

        }

        rc_chars = s1 + s2;
        for (int i = 0; i < rc_chars.length(); i += 2) {
            char c1 = rc_chars.charAt(i);
            char c2 = rc_chars.charAt(i + 1);

            String plainChar = matrix[getCharIndex(c1)][getCharIndex(c2)];
            this.plain += plainChar;
        }

        System.out.println("cy : " + rc_chars);
        System.out.println("s1 : " + s1);
        System.out.println("s2 : " + s2);
        System.out.println(plain);
        return plain;

    }

    // pass it a character from labels and return back it's index
    public int getCharIndex(char c1) {

        for (int i = 0; i < labels.length; i++) {
            if (labels[i].equalsIgnoreCase(c1 + "")) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String plain = "take me";
        new Combination().decrypt("GMBWO");

    }

    // ------------------ getters of class ----------- //
    public String[][] getMatrix() {
        return Combination.matrix;
    }

    public String[] getLables() {
        return Combination.labels;
    }

}
