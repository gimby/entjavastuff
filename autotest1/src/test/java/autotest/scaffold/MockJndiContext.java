package autotest.scaffold;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NameClassPair;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class MockJndiContext extends InitialContext {

  private static Map<String, Object> store       = new HashMap<String, Object>();
  private static MockJndiContext     mockContext = null;

  public MockJndiContext() throws NamingException {
    super();

    mockContext = this;
  }

  @SuppressWarnings("rawtypes")
  public MockJndiContext(Hashtable env) throws NamingException {
    this();
  }

  public MockJndiContext(boolean b) throws NamingException {
    this();
  }

  protected Context getDefaultInitCtx() throws NamingException {
    return this;
  }

  public void bind(String url, Object obj) {
    store.put(url, obj);
  }

  public Object lookup(String url) {
    return store.get(url);
  }

  public void unbind(String name) throws NamingException {
    store.remove(name);
  }

  public void rebind(String name, Object obj) throws NamingException {
    // needed for MockEJB
    bind(name, obj);
  }
  
  
  public Object addToEnvironment(String propName, Object propVal) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public void bind(Name name, Object obj) throws NamingException {
    throw new IllegalStateException("method not implemented!");
  }

  public void close() throws NamingException {
    throw new IllegalStateException("method not implemented!");

  }

  public Name composeName(Name name, Name prefix) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public String composeName(String name, String prefix) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public Context createSubcontext(Name name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public Context createSubcontext(String name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public void destroySubcontext(Name name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");

  }

  public void destroySubcontext(String name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");

  }

  public Hashtable<?, ?> getEnvironment() throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public String getNameInNamespace() throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public NameParser getNameParser(Name name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public NameParser getNameParser(String name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public NamingEnumeration<NameClassPair> list(Name name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public NamingEnumeration<NameClassPair> list(String name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public NamingEnumeration<Binding> listBindings(Name name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public NamingEnumeration<Binding> listBindings(String name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public Object lookup(Name name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public Object lookupLink(Name name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public Object lookupLink(String name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public void rebind(Name name, Object obj) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public Object removeFromEnvironment(String propName) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public void rename(Name oldName, Name newName) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public void rename(String oldName, String newName) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }

  public void unbind(Name name) throws NamingException {
    // TODO Auto-generated method stub
    throw new IllegalStateException("method not implemented!");
  }
  

  // easy access to unbind a bean for unit test purposes. You could also add a bindBean() variant if you so please.
  public static final void unbindBean(String name) {
    if (mockContext == null) {
      return;
    }

    try{
      mockContext.unbind(name);
    } catch(Throwable t){
    }
  }

  public static final void bindBean(String name, Object obj) {
    if (mockContext == null) {
      return;
    }

    try{
      mockContext.bind(name, obj);
    } catch(Throwable t){
    }
  }

}