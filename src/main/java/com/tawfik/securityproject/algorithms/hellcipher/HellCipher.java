/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tawfik.securityproject.algorithms.hellcipher;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author tawfik
 */
@Component
public class HellCipher {

//    private static int[][] matrix = {{3, 10, 20}, {20, 9, 17}, {9, 4, 17}};
//    private static int[][] matrix = {{3, 3},
//    {4, 5}};
    private int determiner;

    String cypherText = "";
    String plainText = "";
    int n = 26;
    private char[][] key = {{'A', 'B'},
    {'C', 'D'}};
    
    private int key2[][];

    public int[][] convertKey(char[][] x) {
        int key2[][] = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key2[i][j] = key[i][j] - 'A';
                System.out.println(key2[i][j]);
            }
        }
        return key2;
    }

    // encryption method 
    public String encrypt(String plainText) {
        int key2[][];
        key2 = convertKey(key);
        if (gcd(getMatrixDeterminer(key2), this.n) != 1) {
            return "This key is not valid";
        }

        plainText = removeSpaces(plainText);

        this.cypherText = "";
        plainText = plainText.toUpperCase();
        int index = 0;
        int p[] = new int[key.length];
        int c[] = new int[key.length];
        while (index < plainText.length()) {
            for (int i = 0; i < p.length; i++) {
                if (index < plainText.length()) {
                    p[i] = plainText.charAt(index) - 'A';
                } else {
                    p[i] = index - plainText.length();

                }
                index++;

                System.out.println((char) p[i]);

            }

            for (int i = 0; i < key.length; i++) {
                c[i] = 0;
                for (int j = 0; j < key[i].length; j++) {
                    c[i] += key[i][j] * p[j];
                }
                c[i] = c[i] % n;
                cypherText += (char) (c[i] + 'A');
            }
        }
        System.out.println("Cypher : " + cypherText);
        return cypherText;
    }

    // return matrix determiner
    public int getMatrixDeterminer(int[][] matrix) {
        // if matrix is 2 *2 
        if (matrix.length == 2) {
            this.determiner = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
            return this.determiner;
        }

        // if matrix with any square size
        //  this code to add number of columns to matrix same as columns in matrix 
        //  except last column to simplfy calculating determiner 
        int tempMatrix[][] = new int[matrix.length][matrix.length + matrix.length - 1];
        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix[i].length; j++) {

                tempMatrix[i][j] = matrix[i][j % matrix.length];
                System.out.print(tempMatrix[i][j] + "  ");
            }
            System.out.println("");
        }

        // get diagonal multiplication sum in positive order
        int sum_diagonalsP = 0, sum_diagonalsN = 0;

        for (int i = 0; i < matrix.length; i++) {
            int row = 0;
            int colP = i;
            int colN = tempMatrix[i].length - 1 - i;
            int diagonal_multplyP = 1, diagonal_multplyN = 1;
            for (int j = 0; j < matrix.length; j++) {
                System.out.println("[" + row + "," + colN + "]");
                diagonal_multplyP *= tempMatrix[row][colP];
                diagonal_multplyN *= tempMatrix[row][colN];

                row++;
                colP++;
                colN--;
            }
            sum_diagonalsP += diagonal_multplyP;
            sum_diagonalsN += diagonal_multplyN;
        }

        System.out.println("sum of positive diagonal : " + sum_diagonalsP);
        System.out.println("sum of negative diagonal : " + sum_diagonalsN);

        this.determiner = sum_diagonalsP - sum_diagonalsN;

        return this.determiner;
    }

    public int[][] getMatrixInverse(int[][] matrix) {
        int matrixInversed[][] = new int[matrix.length][matrix.length];

        if (matrix.length == 2) {
            matrixInversed[0][0] = matrix[1][1];
            matrixInversed[1][1] = matrix[0][0];
            matrixInversed[0][1] = -matrix[0][1];
            matrixInversed[1][0] = -matrix[1][0];
            return matrixInversed;
        }
        // start minor code for any square matrix with size greater than 2
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int tempMatrix[][] = new int[matrix.length - 1][matrix.length - 1];
                int row = 0;
                for (int ir = 0; ir < matrix.length; ir++) {
                    if (ir == r) {
                        continue;
                    }
                    int col = 0;

                    for (int ic = 0; ic < matrix[ir].length; ic++) {
                        if (ic == c) {
                            continue;
                        }
                        tempMatrix[row][col] = matrix[ir][ic];
                        col++;

                    }
                    row++;
                }
                matrixInversed[r][c] = getMatrixDeterminer(tempMatrix);

            }
        }
        // end minor code for any square matrix with size greater than 2
        /*-------------------------------------------------------------*/
        // start Cofactor code for any square matrix with size greater than 2
        for (int i = 0; i < matrixInversed.length; i++) {
            for (int j = 0; j < matrixInversed.length; j++) {
                if ((i + j) % 2 == 1) {
                    matrixInversed[i][j] *= -1;
                }
            }
        }
        // end Cofactor code for any square matrix with size greater than 2
        /*-------------------------------------------------------------*/
        // start traverse code for any square matrix with size greater than 2

        int tempMatrix[][] = new int[matrix.length][matrix.length];
        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix.length; j++) {
                tempMatrix[i][j] = matrixInversed[i][j];
            }
        }
        for (int i = 0; i < matrixInversed.length; i++) {
            for (int j = 0; j < matrixInversed.length; j++) {
                matrixInversed[j][i] = tempMatrix[i][j];
            }

        }
        // start traverse code for any square matrix with size greater than 2
        return matrixInversed;
    }

    public int getDeterminerInverse(int determiner, int n) {

        int tempN = n, tempDet = determiner;

        ArrayList<Integer> div_values = new ArrayList();

        while (tempDet != 0) {
            int div = tempN / tempDet;
            int mod = tempN % tempDet;

            tempN = tempDet;
            tempDet = mod;
            div_values.add(div);
//            System.out.println(tempN + "  " + div);
        }
        int l0 = 0, l1 = 1;
        for (int i = div_values.size() - 2; i >= 0; i--) {
            int tempL = div_values.get(i) * l1 + l0;
            l0 = l1;
            l1 = tempL;
        }
        if (l1 * determiner - n * l0 == -1) {
            l1 += n;
        }

        return l1;
    }

    public String decrypt(String cipher) {

        if (gcd(getMatrixDeterminer(key2), this.n) != 1) {
            return "This key is not valid";
        }

        cipher = removeSpaces(cipher);
        this.plainText = "";
        cipher = cipher.toUpperCase();
        int index = 0;
        int p[] = new int[key.length];
        int c[] = new int[key.length];
        int keyInverse[][] = getMatrixInverse(key2);

        displayMatrix(keyInverse);

        int determinerInverse = getDeterminerInverse(getMatrixDeterminer(key2), n);
        while (index < cipher.length()) {
            for (int i = 0; i < c.length; i++) {
                if (index < cipher.length()) {
                    c[i] = cipher.charAt(index) - 'A';
                } else {
                    c[i] = index - cipher.length();
                }
                index++;
            }

            for (int i = 0; i < keyInverse.length; i++) {
                p[i] = 0;
                for (int j = 0; j < keyInverse.length; j++) {
                    p[i] += (keyInverse[i][j] * determinerInverse * c[j]);
                }
                System.out.println(p[i]);
                if (p[i] >= 0) {
                    p[i] = p[i] % n;
                } else {
                    while (p[i] < 0) {
                        p[i] += n;
                    }
                }
                this.plainText += (char) (p[i] + 'A');
            }

        }
        System.out.println("Cypher : " + plainText);

        return this.plainText;
    }

    private static long gcd(long n, long d) {
//        long n1 = Math.abs(n);
//        long n2 = Math.abs(d);
        int gcd = 1;
        for (int k = 1; k <= n && k <= d; k++) {
            if (n % k == 0 && d % k == 0) {
                gcd = k;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        //   System.out.println("determiner : " + new HellCipher().getMatrixDeterminer(HellCipher.matrix));
        HellCipher hc = new HellCipher();
//        hc.displayMatrix(hc.getMatrixInverse(HellCipher.matrix));
//        hc.displayMatrix(hc.getMatrixInverse(matrix));
//        hc.getDeterminerInverse(9, 26);
//        System.out.println(hc.decrypt("HIAT"));
        System.out.println(hc.encrypt("welcome"));
        System.out.println(hc.decrypt("MMTTKKMM"));

//        HELPALIATI
//HIATHDYQ
        int x[][] = {{3, 10, 20},
        {20, 9, 17},
        {9, 4, 17}};
//        System.out.println("det : " + x2);
//        hc.displayMatrix(x2);
        int y[][] = hc.getMatrixInverse(x);
        hc.displayMatrix(y);

    }

    public void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("");
        }

    }

    public int[][] getKey() {
        return key2;
    }

    public void setKey(int[][] key) {
        this.key2 = key;
    }

    public String removeSpaces(String str) {
        String st = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                st += str.charAt(i);
            }
        }
        return st;
    }

}
