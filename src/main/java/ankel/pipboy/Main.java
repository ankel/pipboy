package ankel.pipboy;

import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * Created by btran on 12/7/14.
 */
public class Main
{
  public static void main(String[] args)
  {
    Security.addProvider(new BouncyCastleProvider());
    final Provider[] p = Security.getProviders();

    for (int i = 0; i < p.length; i++) {
      String provider = p[i].getName();
      for (Enumeration e = p[i].keys(); e.hasMoreElements();)
        System.out.println ( provider + " " + e.nextElement());
    }
  }
}
