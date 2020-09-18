package com.internship.shakeapp.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HashUtils {

    private static final String hashingAlgorithm = "SHA-256";

    /**
     * 计算hash值, 使用SHA-256
     * @param password 密码
     * @return hash值
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashingAlgorithm);
            byte[] hash = md.digest(password.getBytes());

            BigInteger bigInteger = new BigInteger(1, hash);
            return bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 随机生成salt
     * @return salt String
     */
    public static String generateSalt() {
        SecureRandom secure = new SecureRandom();
        byte[] salt = new byte[16];
        secure.nextBytes(salt);

        BigInteger bigInteger = new BigInteger(1, salt);
        return bigInteger.toString(16);
    }
}
