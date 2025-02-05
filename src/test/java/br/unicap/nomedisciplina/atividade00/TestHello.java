package br.unicap.nomedisciplina.atividade00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestHello {

  @Test
  public void testHelloWorldImplemented() {
    String expected = "Hello World";
    String actual = Hello.messageImplemented();
    assertEquals(expected, actual);
  }

  @Test
  public void testHelloWorldNotImplemented() {
    String expected = "Hello World";
    String actual = Hello.messageNotImplemented();
    assertEquals(expected, actual);
  }
}
