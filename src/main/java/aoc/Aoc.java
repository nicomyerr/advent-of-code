package aoc;

import java.util.List;

import aoc.Utils.FileUtils;

public class Aoc {

  public static void main(String[] args) {
    // TODO: add validation and default value
    final String year = args[0];
    final String day = args[1];
    final String part = args[2];
    final String fileName = (args.length > 3) ? args[3] : "test-input.txt";
    final List<String> input = FileUtils.readInput(year, day, fileName);
    final Day dayInstance = dayInstance(year, day);
    final String result = switch (part) {
      case "1" -> dayInstance.solveFirstPart(input);
      case "2" -> dayInstance.solveSecondPart(input);
      default -> "42"; // 42 is the answer to everything
    };
    System.out.println("The solution for %s-%s part %s is: %s".formatted(year, day, part, result));
  }

  private static Day dayInstance(final String year, final String day) {
    final String dayClassName = "aoc.Year%s.Day%s.Day%s".formatted(year, day, day);
    try {
      return (Day) Class.forName(dayClassName).getDeclaredConstructor().newInstance();
    } catch (final Exception e) {
      System.err.println("Failed to load '%s'".formatted(dayClassName));
    }
    return null;
  }
}
