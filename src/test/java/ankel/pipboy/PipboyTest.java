package ankel.pipboy;

import static org.junit.Assert.*;

import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

/**
 * Created by btran on 12/7/14.
 */
public class PipboyTest
{
  @Test
  public void test()
  {
    Security.addProvider(new BouncyCastleProvider());

    Provider p = Security.getProvider("BC");

    for (Enumeration e = p.keys(); e.hasMoreElements();)
      System.out.println (e.nextElement());
  }
}
