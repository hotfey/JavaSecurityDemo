/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotfey.java.security.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author pipe
 */
public class SecurityDemoTest {

    private String resultEncrypt;
    String key = "hotfey.com";

    /**
     * Test of encrypt method, of class SecurityDemo.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testEncrypt() throws Exception {
        System.out.println("encrypt");
        String data = "mail@hotfey.com";
        resultEncrypt = SecurityDemo.encrypt(data, key);
        System.out.println(resultEncrypt);
    }

    /**
     * Test of decrypt method, of class SecurityDemo.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDecrypt() throws Exception {
        testEncrypt();

        System.out.println("decrypt");
        String resultDecrypt = SecurityDemo.decrypt(resultEncrypt, key);
        System.out.println(resultDecrypt);
    }

}
