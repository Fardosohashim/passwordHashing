package PasswordHashing;

import org.w3c.dom.ls.LSOutput;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
    public static void main(String[] args) {
        System.out.println(doHashing("12345678"));
        System.out.println(doHashing("1234567"));
    }

    public static String doHashing(String password){
        try {
            MessageDigest massageDigest=MessageDigest.getInstance("MD5");
            massageDigest.update(password.getBytes());
             byte[] resultByteArray = massageDigest.digest();
             StringBuilder sb = new StringBuilder();
             for(byte b : resultByteArray){
                 sb.append(String.format("%02x",b));
             }
             return sb .toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
    //return "";
}
