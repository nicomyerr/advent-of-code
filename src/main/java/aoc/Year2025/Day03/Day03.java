package aoc.Year2025.Day03;

import java.util.List;

import aoc.Day;

public class Day03 implements Day {

  @Override
  public String solveFirstPart(final List<String> input) {
    return String.valueOf(input.stream().map(Day03::maxJoltage).mapToInt(Integer::valueOf).sum());
  }

  @Override
  public String solveSecondPart(final List<String> input) {
    // TODO: implementation for part 2
    return "42";
  }

  private static int maxJoltage(final String bank) {
    int maxJoltage = 0;
    for (int i = 0; i < bank.length(); i++) {
      for (int j = i + 1; j < bank.length(); j++) {
        final int joltage = Integer.parseInt("%s%s".formatted(bank.charAt(i), bank.charAt(j)));
        if (joltage > maxJoltage) {
          maxJoltage = joltage;
        }
      }
    }
    return maxJoltage;
  }
}
