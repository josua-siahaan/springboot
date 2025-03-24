package juara.coding.day19.security;



import java.util.function.Function;

public class BcryptImpl {

    private static final BcryptCustom bcrypt = new BcryptCustom(11);

    public static String hash(String password) {
        return bcrypt.hash(password);
    }

    public static boolean verifyAndUpdateHash(String password,
                                              String hash,
                                              Function<String, Boolean> updateFunc) {
        return bcrypt.verifyAndUpdateHash(password, hash, updateFunc);
    }

    public static boolean verifyHash(String password , String hash)
    {
        return bcrypt.verifyHash(password,hash);
    }

    public static void main(String[] args) {
        String strUserName = "halomoan123";
        String strPassword = "halomoan@123";
       char chK='K';

//        System.out.println(hash(strUserName));
//        System.out.println(hash(strUserName));
//        System.out.println(hash(strUserName));
//        System.out.println(hash(strUserName).length());
        System.out.println(verifyHash(strUserName+strPassword,"$2a$11$SlV3YIRTYoAj3QUzONderuqlRcy4vQPjs5m7skra.rtT1iEC./LHa"));
//        System.out.println(verifyHash("906442","$2a$11$VS3bybvoDaSVYDFfhPCiqeOI4zh6kmsIXhlzVwrdMbQ3/qnM32Iay"));
//        System.out.println(verifyHash(strUserName,"$2a$11$r9Uj5UuqePNLoYRmj1yUguDie6cZ0Co/3YudQFVvyPqQE7VwIkzJ6"));
//        System.out.println(verifyHash(strUserName,"$2a$11$RKYOQ2OgYMu51KbmhUwZZuDUMwgquAFg1U4n6wbwONjnroKCh5YhC"));
    }
}
