package aoc.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtils {

  public final static String PATH = "src/main/java/aoc/Year%s/Day%s/resources/%s";

  public static List<String> readInput(final String filePath) {
    try (final BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      return br.lines().filter(line -> !line.isBlank()).toList();
    } catch (final IOException e) {
      System.err.println("Error reading file '%s': %s".formatted(filePath, e.getMessage()));
    }
    return Collections.emptyList();
  }
}
