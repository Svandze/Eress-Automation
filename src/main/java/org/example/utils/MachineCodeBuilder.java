package org.example.utils;

import java.util.Random;

public class MachineCodeBuilder {
  public static String randomMachineCode() {
    return new Random()
        .ints(4, 'A', 'Z' + 1)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }
}
