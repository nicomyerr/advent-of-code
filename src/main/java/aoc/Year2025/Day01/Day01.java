package aoc.Year2025.Day01;

import java.util.List;

import aoc.Day;

public class Day01 implements Day {

  @Override
  public String solveFirstPart(final List<String> input) {
    return "%d".formatted(createDialAndTurn(input).getPartOneCounter());
  }

  @Override
  public String solveSecondPart(final List<String> input) {
    return "%d".formatted(createDialAndTurn(input).getPartTwoCounter());
  }

  private static Dial createDialAndTurn(final List<String> input) {
    final Dial dial = new Dial();
    input.forEach(rotation -> dial.turn(rotation));
    return dial;
  }
}
