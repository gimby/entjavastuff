package autotest.scaffold;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

public class MockJndiContextFactory implements InitialContextFactory {

  public MockJndiContextFactory() {
  }

  @SuppressWarnings("rawtypes")
  public Context getInitialContext(Hashtable env) throws NamingException {
    return new MockJndiContext();
  }
}