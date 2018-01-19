/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tawfik.securityproject.controller;

import com.tawfik.securityproject.algorithms.Combination.Combination;
import com.tawfik.securityproject.algorithms.hellcipher.HellCipher;
import com.tawfik.securityproject.algorithms.playfair.PlayFair;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tawfik
 */
@RestController
public class ServicesController {

    @Autowired
    private Combination combination;

    @Autowired
    private HellCipher hellCipher;

    @Autowired
    private PlayFair playFair;

    @RequestMapping(value = "/combinationEncryption", method = RequestMethod.POST)
    public String combinationEncryption(@RequestParam("plaintext") String plaintext) {
        String encrypted = combination.encrypt(plaintext);
        return encrypted;
    }

    @RequestMapping(value = "/combinationDecryption", method = RequestMethod.POST)
    public String compinationDecryption(@RequestParam("cipherText") String cipherText) {
        String decrypted = combination.decrypt(cipherText);
        return decrypted;
    }

    @RequestMapping(value = "/playfairEncryption", method = RequestMethod.POST)
    public String playFairEncryption(@RequestParam Map<String, String> params) {
        String plain = params.get("plainText");
        String key = params.get("key");
        String encrypted = playFair.Encrypt(plain, key);
        return encrypted;

    }

    @RequestMapping(value = "/playfairDecryption", method = RequestMethod.POST)
    public String playFairDecryption(@RequestParam Map<String, String> params) {
        String cipher = params.get("cipherText");
        String key = params.get("key");
        String decrypted = playFair.decrypt(cipher, key);
        return decrypted;
    }

    @RequestMapping(value = "/hellcipherEncryption", method = RequestMethod.POST)
    public String hellCypherEncrypt(@RequestParam("plain") String plain, @RequestParam(value = "key[]") int[] key,
            @RequestParam("n") int n) {

        // convert 1 dimension array to two dimension array
        int matrix[][] = new int[n][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = key[index];
                index++;
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("");
        }

        /// encrypt message
        hellCipher.setKey(matrix);
        String cipher = hellCipher.encrypt(plain);

        return cipher;
    }

    @RequestMapping(value = "/hellcipherDecryption", method = RequestMethod.POST)
    public String hellCypherDecrypt(@RequestParam("cipher") String cipher, @RequestParam(value = "key[]") int[] key,
            @RequestParam("n") int n) {

        // convert 1 dimension array to two dimension array
        int matrix[][] = new int[n][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = key[index];
                index++;
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println("");
        }

        /// decrypt message
        hellCipher.setKey(matrix);
        String plain = hellCipher.decrypt(cipher);

        return plain;
    }
}
