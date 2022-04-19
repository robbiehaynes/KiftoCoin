package haynes.main;

import java.nio.charset.*;
import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;
import org.bitcoinj.core.Base58;

public class KeyGenerator
{    
    //Generate and return a public and private key
    public static String[] generateKeys()
    {
        try
        {
            KeyPair pair = genKeys();
            String pvt = getPriv(pair);
            String pub = getPub(pair);
            String[] keyArr = new String[2];
            
            keyArr[0]=pvt;
            keyArr[1]=pub;
            
            return keyArr;
        } catch (NoSuchAlgorithmException ex)
        {
            System.out.println(ex);
            return null;
        } catch (InvalidAlgorithmParameterException ex)
        {
            System.out.println(ex);
            return null;
        }
    }
    
    //Generate and return a new KeyPair
    private static KeyPair genKeys() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException
    {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");
        keyGen.initialize(ecSpec);
        KeyPair kp = keyGen.generateKeyPair();
        
        return kp;
    }
    
    //Adjusts the length of a string to 64 characters
    private static String adjustTo64(String s)
    {
        switch(s.length())
        {
            case 62: return "00" + s;
            case 63: return "0" + s;
            case 64: return s;
            default: throw new IllegalArgumentException ("Not a valid key: "+s);
        }
    }
    
    //Returns the string value of a private key from a KeyPair
    private static String getPriv(KeyPair pair)
    {
        return adjustTo64(((ECPrivateKey)pair.getPrivate()).getS().toString(16));
    }
    
    //Returns the string value of a public key from a KeyPair
    private static String getPub(KeyPair pair)
    {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        
        try
        {
            ECPublicKey epub = (ECPublicKey)pair.getPublic();
            ECPoint pt = epub.getW();
            String sx = adjustTo64(pt.getAffineX().toString(16));
            String sy = adjustTo64(pt.getAffineY().toString(16));
            String bcPub = "04" + sx + sy;
            
            byte[] bcPubBA = new byte[bcPub.length()/2];
            for (int i = 0; i < bcPub.length()/2; i += 2)
                bcPubBA[i / 2] = (byte) ((Character.digit(bcPub.charAt(i), 16) << 4) + Character.digit(bcPub.charAt(i+1), 16));
        
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] s1 = sha.digest(bcPubBA);

            MessageDigest rmd = MessageDigest.getInstance("RipeMD160", "BC");
            byte[] r1 = rmd.digest(s1);

            byte[] r2 = new byte[r1.length + 1];
            r2[0] = 0;
            for (int i = 0 ; i < r1.length ; i++) r2[i+1] = r1[i];

            byte[] s2 = sha.digest(r2);
            byte[] s3 = sha.digest(s2);

            byte[] a1 = new byte[25];
            for (int i = 0 ; i < r2.length ; i++) a1[i] = r2[i];
            for (int i = 0 ; i < 4 ; i++) a1[21 + i] = s3[i];
            
            return Base58.encode(a1);
            
        } catch (NoSuchAlgorithmException ex)
        {
            System.out.println(ex);
            return "Error";
        } catch (NoSuchProviderException ex)
        {
            System.out.println(ex);
            return "Error";
        }
    }
    
    //Converts a byte array to a hexidecimal string
    private static String bytesToHex(byte[] bytes) {
    byte[] hexChars = new byte[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
        int v = bytes[j] & 0xFF;
        hexChars[j * 2] = bytes[v >>> 4];
        hexChars[j * 2 + 1] = bytes[v & 0x0F];
    }
        return new String(hexChars, StandardCharsets.UTF_8);
    }
}
