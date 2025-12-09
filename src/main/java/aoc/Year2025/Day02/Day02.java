package aoc.Year2025.Day02;

import java.util.List;
import java.util.stream.LongStream;

import aoc.Day;

public class Day02 implements Day {

  @Override
  public String solveFirstPart(final List<String> input) {
    // TODO: implementation for part 1
    return "42";
  }

  @Override
  public String solveSecondPart(final List<String> input) {
    return String.valueOf(sumOfInvalidIds(input.getFirst()));
  }

  private static long sumOfInvalidIds(final String ranges) {
    long sum = 0;
    for (final String range : ranges.split(",")) {
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
          return true;
        }
      }
    }
    return false;
  }
}
