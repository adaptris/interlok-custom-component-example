package com.adaptris.samples;

import org.junit.Test;

import com.adaptris.core.AdaptrisMessageFactory;
import com.adaptris.core.ServiceCase;


public class EchoServiceTest extends ServiceCase {

  public EchoServiceTest() {
    super();
  }

  protected void setUp() throws Exception {
  }
  
  @Test
  public void testService() throws Exception {
    execute(new EchoService(), AdaptrisMessageFactory.getDefaultInstance().newMessage());
  }

  @Override
  protected Object retrieveObjectForSampleConfig() {
    return new EchoService();
  }
  
  public boolean isAnnotatedForJunit4() {
    return true;
  }

}
