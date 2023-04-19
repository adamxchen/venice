package com.linkedin.venice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestHelloServer {
  @Test
  public void testMethod() {
    String s = "Hello HelloCommon Job";
    Assert.assertTrue(HelloServer.isValid(s));

    s = "";
    Assert.assertFalse(HelloServer.isValid(s));

    s = "dsa";
    Assert.assertTrue(HelloServer.isValid(s));
  }
}
