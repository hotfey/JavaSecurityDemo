package com.hotfey.java.security.demo;

import static com.hotfey.java.security.demo.utils.ConvertUtil.parseByte2HexStr;
import static com.hotfey.java.security.demo.utils.ConvertUtil.parseHexStr2Byte;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 *
 * @author pipe
 */
public class SecurityDemo {

    private final static String DES = "DES";

    public final static String encrypt(String data, String key) throws Exception {
        return parseByte2HexStr(encrypt(data.getBytes(), key.getBytes()));
    }

    public final static String decrypt(String data, String key) throws Exception {
        return new String(decrypt(parseHexStr2Byte(data), key.getBytes()));
    }

    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        Cipher cipher = Cipher.getInstance(DES);
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        Cipher cipher = Cipher.getInstance(DES);
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }
}
