package ankel.pipboy;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;

/**
 * Created by btran on 12/7/14.
 */
public class AesTest
{
  @Test
  public void testCipher() throws Exception
  {

    final StandardPBEStringEncryptor encrypter = new StandardPBEStringEncryptor();
    encrypter.setProvider(new BouncyCastleProvider());
    encrypter.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
    encrypter.setPassword("super secret password");

    final String cryptedText = encrypter.encrypt("plain text");
    System.out.println(cryptedText);

    final StandardPBEStringEncryptor encrypter1 = new StandardPBEStringEncryptor();
    encrypter1.setProvider(new BouncyCastleProvider());
    encrypter1.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
    encrypter1.setPassword("super secret password");

    final String plaintext = encrypter1.decrypt(cryptedText);
    System.out.println(plaintext);

    assertEquals("plain text", plaintext);

  }
}
