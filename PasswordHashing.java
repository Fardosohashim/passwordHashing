package PasswordHashing;

import org.w3c.dom.ls.LSOutput;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
    public static void main(String[] args) {
        System.out.println("This is MD5 password:12345678 " + doHashingMD5("12345678"));
        System.out.println("This is MD5 password 1234567 " + doHashingMD5("1234567"));

        System.out.println("This MD5 password:" + doHashingSHA("Malyun@123"));

        System.out.println("This is SHA Password: 12345678 "+ doHashingSHA("12345678"));

        System.out.println( "this is SHA password: 1234567 "+ doHashingSHA("1234567"));

    }

    public static String doHashingMD5 (String password){
        try {
            MessageDigest massageDigest=MessageDigest.getInstance("MD5");
           // MessageDigest md =MessageDigest.getInstance("SHA");

            massageDigest.update(password.getBytes());

            //md.update(password.getBytes());

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
    public static String doHashingSHA(String password){
        try {
            MessageDigest md =MessageDigest.getInstance("SHA");
            md.update(password.getBytes());
            byte[] result=md.digest();
            StringBuilder sb =new StringBuilder();
            for(byte c : result){
                sb.append(String.format("%02x", c));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    //return "";
}
