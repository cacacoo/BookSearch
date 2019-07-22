package com.example.booksearch.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.IntStream;

@Slf4j
public class EncryptionUtil {

    private EncryptionUtil() {
    }

    public static String encryptSHA256(String str) {
        if(StringUtils.isEmpty(str)) {
            return null;
        }

        String sha;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            byte[] bytes = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();

            IntStream
                .range(0, bytes.length)
                .forEach(index -> stringBuilder.append(Integer.toString((bytes[index]&0xff) + 0x100, 16).substring(1)));
            sha = stringBuilder.toString();
        } catch (NoSuchAlgorithmException ex) {
            log.error("encryptSHA256 error: {}", ex);
            sha = null;
        }

        return sha;
    }

}
