package com.example.booksearch.common;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class EncryptionUtilTest {

    @Test
    public void encryptSHA256() {
        String encryptSHA256 = EncryptionUtil.encryptSHA256("test");
        assertThat(encryptSHA256, is("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08"));
    }

    @Test
    public void encryptSHA256_nullParam() {
        String encryptSHA256 = EncryptionUtil.encryptSHA256(null);
        assertNull(encryptSHA256);
    }


}