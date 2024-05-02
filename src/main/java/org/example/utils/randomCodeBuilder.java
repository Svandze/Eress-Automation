package org.example.utils;

import java.util.Random;

public class randomCodeBuilder {
  public static String randomCode() {
    return new Random()
        .ints(4, 'A', 'Z' + 1)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }
}
