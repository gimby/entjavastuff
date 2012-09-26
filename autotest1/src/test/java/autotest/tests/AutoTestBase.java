package autotest.tests;

import java.lang.reflect.Field;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;

import autotest.scaffold.MockJndiContext;

public abstract class AutoTestBase {

  protected EntityManager em = null;

  private static InitialContext ctx = null;

  public AutoTestBase(String puname) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(puname);
    em = emf.createEntityManager();
  }

  protected void initBeans(){

  }

  protected void initData(){
  }


  protected void deployBean(String name, Object obj){
    
    if(ctx == null){
      
      try{
        ctx = new InitialContext();
      } catch(Throwable t){
        Assert.fail("Could not initialize InitialContext! : " + t.getMessage());
      }
    }

    MockJndiContext.unbindBean(name);
    MockJndiContext.bindBean(name, obj);
  }


  protected void setField(Object obj, String name, Object value){
    
    Field field = getField(obj.getClass(), name);
    if (!field.isAccessible()){
       // this little hack allows access to private class members without needing a getter or setter
       field.setAccessible(true);
    }

    set(field, obj, value);
  }
  
  @SuppressWarnings("rawtypes")
  private static Field getField(Class clazz, String name) {

     for ( Class superClass = clazz; superClass!=Object.class; superClass=superClass.getSuperclass() ) {

        try {
           return superClass.getDeclaredField(name);
        }
        catch (NoSuchFieldException nsfe) {}
     }
     throw new IllegalArgumentException("no such field: " + clazz.getName() + '.' + name);
  }
  
  
  private static void set(Field field, Object target, Object value) {
     
     try {
        field.set(target, value);
     }
     catch (Throwable t) {

        String message = "Could not set field value by reflection: " + field.getName() +
           " on: " + field.getDeclaringClass().getName();

        if (value==null) {
           message += " with null value";
        }
        else {
           message += " with value: " + value.getClass();
        }

        throw new IllegalArgumentException(message, t);
     }
  }
}