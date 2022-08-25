package it.test1.HR.util;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class Utils {
  public static String capitalize(String string) {
    return StringUtils.capitalize(string);
  }

  public List<String> doIt(List<String> user) {
    return user.stream().map(input -> String.format("%s.", input.charAt(0)) ).collect(Collectors.toList());
  }

}
