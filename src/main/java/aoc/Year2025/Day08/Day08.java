package aoc.Year2025.Day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Day08 {

  public static void main(String[] args) {
    final String fileName = (args.length > 0) ? args[0] : "test-input.txt";
    try (final BufferedReader br = new BufferedReader(
        new FileReader("src/main/java/aoc/Year2025/Day08/resources/%s".formatted(fileName)))) {
      solveFirstPart(br.lines().toList());
    } catch (IOException e) {
      System.out.println("Input file not found.");
    }
  }

  private static void solveFirstPart(final List<String> points) {
    final Playground playground = new Playground(points);
  }
}
