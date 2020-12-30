package com.lee.test.demo_hex;

import com.lee.utils.ConverterUtil;
import com.lee.utils.SM234Util;

public class TestHexMain {


    public static void main(String[] args) throws Exception {
        //16进制
        String publicKey = "049975A7BA7FC6BDBCD32A638F5D90047E011D61758A1C061C6999812A9C0597753B7B02FB9178B364DCC346EC995B7AE6C8E5BAD8C44505FF17BFF79A6655F632";
        String privateKey = "0891CD3D5B775EFBCAF6E516721CB0E8ECE086032C94AB335E121DE6847323B1";

        String text = "我是一段测试aaaa王红恩";

    }

    /**
     * sm3摘要加密hash
     *
     * @param text
     */
    public static void sm3(String text) {
        String src = text;
        System.out.println("--SM3摘要测试--");
        String s = SM234Util.generateSM3HASH(src);
        System.out.println("hash:" + s);
        System.out.println("--SM3摘要结束--");

    }

    /**
     * sm4对称加密
     * 随机生成密钥对（公钥、私钥），对内容做加解密
     *
     * @param text
     * @throws Exception
     */
    public static void sm4_00_enc_dec(String text) throws Exception {

        String src = text;

        System.out.println("--生成SM4秘钥--");
        String sm4Key = SM234Util.generateSM4Key();

        System.out.println("sm4Key:" + sm4Key);
        System.out.println("--生成SM4结束--");
        System.out.println("--SM4的CBC加密--");
        String s1 = SM234Util.SM4EncForCBC(sm4Key, src);
        System.out.println("密文:" + s1);
        System.out.println("CBC解密");
        String s2 = SM234Util.SM4DecForCBC(sm4Key, s1);
        System.out.println("解密结果:" + s2);

        System.out.println("--ECB加密--");
        String s3 = SM234Util.SM4EncForECB(sm4Key, src);
        System.out.println("ECB密文:" + s3);
        System.out.println("ECB解密");
        String s4 = SM234Util.SM4DecForECB(sm4Key, s3);
        System.out.println("ECB解密结果:" + s4);
    }
}
