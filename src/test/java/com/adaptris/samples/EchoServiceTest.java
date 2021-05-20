package com.adaptris.samples;

import com.adaptris.core.AdaptrisMessage;
import com.adaptris.core.Service;
import com.adaptris.interlok.junit.scaffolding.services.ExampleServiceCase;
import org.junit.Before;
import org.junit.Test;

import com.adaptris.core.AdaptrisMessageFactory;
import com.adaptris.core.ServiceCase;

import static com.adaptris.samples.EchoService.DEFAULT;
import static org.junit.Assert.assertEquals;


public class EchoServiceTest extends ExampleServiceCase {

  private static final String ALTERNATIVE_MESSAGE = "Goodbye World.";

  private AdaptrisMessage message;
  private EchoService service;

  @Before
  public void setUp() throws Exception {
    message = AdaptrisMessageFactory.getDefaultInstance().newMessage();
    service = new EchoService();
  }
  
  @Test
  public void testService() throws Exception {
    execute(service, message);
    assertEquals(DEFAULT, message.getContent());
  }

  @Test
  public void testOwnMessage() throws Exception {
    service.setEchoMessage(ALTERNATIVE_MESSAGE);
    execute(service, message);
    assertEquals(ALTERNATIVE_MESSAGE, message.getContent());
  }

  @Override
  protected Object retrieveObjectForSampleConfig() {
    return new EchoService();
  }
  
  public boolean isAnnotatedForJunit4() {
    return true;
  }

}
