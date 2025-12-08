package aoc.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class FileUtils {

  final static String PATH = "src/main/java/aoc/Year%s/Day%s/resources/%s";

  public static List<String> readInput(final String year, final String day, final String fileName) {
    try (final BufferedReader br = new BufferedReader(new FileReader(PATH.formatted(year, day, fileName)))) {
      return br.lines().toList();
    } catch (final IOException e) {
      System.err.println("Input file '%s' not found for year '%s' and day '%s'".formatted(fileName, year, day));
    }
    return Collections.emptyList();
  }
}
