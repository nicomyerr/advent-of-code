package aoc.Year2025.Day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.LongStream;

public class Day02 {

  public static void main(String[] args) {
    final String fileName = (args.length > 0) ? args[0] : "test-input.txt";
    try (final BufferedReader br = new BufferedReader(
        new FileReader("2025/Day02/resources/%s".formatted(fileName)))) {
      System.out.println("The sum of invalid IDs is %d.".formatted(sumOfInvalidIds(br.lines().toList().getFirst())));
    } catch (IOException e) {
      System.out.println("Input file not found.");
    }
  }

  private static long sumOfInvalidIds(final String ranges) {
    long sum = 0;
    for (final String range : ranges.split(",")) {
      System.out.println("Processing range: %s".formatted(range));
      final String[] bounds = range.split("-");
      sum += LongStream.rangeClosed(Long.parseLong(bounds[0]), Long.parseLong(bounds[1]))
          .mapToObj(String::valueOf)
          .filter(Day02::isInvalid)
          .mapToLong(Long::parseLong)
          .sum();
    }
    return sum;
  }

  private static boolean isInvalid(final String id) {
    final int length = id.length();
    for (int patternLength = 1; patternLength <= length / 2; patternLength++) {
      if (length % patternLength == 0) {
        final String pattern = id.substring(0, patternLength);
        final String repeated = pattern.repeat(length / patternLength);
        if (id.equals(repeated)) {
          System.out.println("Invalid ID found: %s".formatted(id));
          return true;
        }
      }
    }
    return false;
  }
}
