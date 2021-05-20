
package com.adaptris.samples;

import com.adaptris.annotation.AdapterComponent;
import com.adaptris.annotation.ComponentProfile;
import com.adaptris.annotation.DisplayOrder;
import com.adaptris.core.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

@XStreamAlias("echo-service")
@AdapterComponent
@ComponentProfile(summary = "Simply put some given string into the message payload", tag = "echo,example,sample")
@DisplayOrder(order = { "echoMessage" })
public class EchoService extends ServiceImp {

  static final String DEFAULT = "Hello World.";

  @Getter
  @Setter
  private String echoMessage;

  public void doService(AdaptrisMessage message) throws ServiceException {
    message.setContent(echoMessage(), message.getContentEncoding());
  }

  public final void prepare() {
  }

  public final void initService() {
  }

  public final void closeService() {
  }

  private String echoMessage() {
    return StringUtils.defaultIfEmpty(echoMessage, DEFAULT);
  }
}
