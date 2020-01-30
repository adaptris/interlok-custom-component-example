package com.adaptris.samples;

import com.adaptris.core.AdaptrisMessageFactory;
import com.adaptris.core.ServiceCase;


public class EchoServiceTest extends ServiceCase {

  public EchoServiceTest() {
    super();
  }

  protected void setUp() throws Exception {
  }
  
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
