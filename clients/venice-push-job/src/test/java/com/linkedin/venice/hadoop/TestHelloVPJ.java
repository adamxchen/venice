package com.linkedin.venice.hadoop;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestHelloVPJ {
  @Test
  public void testMethod() {
    String s = "Hello Venice Push Job";
    Assert.assertTrue(HelloVPJ.isValid(s));

    s = "";
    Assert.assertFalse(HelloVPJ.isValid(s));

    s = "dsa";
    Assert.assertTrue(HelloVPJ.isValid(s));
  }

  @Test
  public void testBooleanCheck() {
    String[] args = { "Hello Venice Push Job" };
    Assert.assertTrue(HelloVPJ.booleanCheck(args));

    args = new String[0];
    Assert.assertFalse(HelloVPJ.booleanCheck(args));
  }
}
