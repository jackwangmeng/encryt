package com.lee.utils;

import com.lee.utils.sm4.SM4Utils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.util.encoders.Hex;

import java.io.IOException;
import java.util.UUID;

public class SM234Util {

    public static final String SM2PubHardKeyHead = "3059301306072A8648CE3D020106082A811CCF5501822D034200";


    //摘要计算
    public static String generateSM3HASH(String src) {
        byte[] md = new byte[32];
        byte[] msg1 = src.getBytes();
        //System.out.println(Util.byteToHex(msg1));
        SM3Digest sm3 = new SM3Digest();
        sm3.update(msg1, 0, msg1.length);
        sm3.doFinal(md, 0);
        String s = new String(Hex.encode(md));
        return s.toUpperCase();
    }


    //产生对称秘钥
    public static String generateSM4Key() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    //对称秘钥加密(CBC)
    public static String SM4EncForCBC(String key, String text) {
        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = key;
        sm4.hexString = true;
        sm4.iv = "31313131313131313131313131313131";
        String cipherText = sm4.encryptData_CBC(text);
        return cipherText;
    }

    //对称秘钥解密(CBC)
    public static String SM4DecForCBC(String key, String text) {
        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = key;
        sm4.hexString = true;
        sm4.iv = "31313131313131313131313131313131";
        String plainText = sm4.decryptData_CBC(text);
        return plainText;
    }

    //对称秘钥加密(ECB)
    public static String SM4EncForECB(String key, String text) {
        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = key;
        sm4.hexString = true;
        String cipherText = sm4.encryptData_ECB(text);
        return cipherText;
    }

    //对称秘钥解密(ECB)
    public static String SM4DecForECB(String key, String text) {
        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = key;
        sm4.hexString = true;
        String plainText = sm4.decryptData_ECB(text);
        return plainText;
    }

}
