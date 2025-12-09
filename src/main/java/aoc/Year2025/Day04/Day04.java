package aoc.Year2025.Day04;

import java.util.List;

import aoc.Day;

public class Day04 implements Day {

  @Override
  public String solveFirstPart(final List<String> input) {
    int accessibleRolls = 0;
    for (int i = 0; i < input.size(); i++) {
      final String line = input.get(i);
      for (int j = 0; j < line.length(); j++) {
        if (isFieldPaperRoll(input, i, j) && isAccessible(input, i, j)) {
          accessibleRolls++;
        }
      }
    }
    return String.valueOf(accessibleRolls);
  }

  @Override
  public String solveSecondPart(final List<String> input) {
    return "42";
  }

  private static boolean isAccessible(final List<String> paperGrid, final int i, final int j) {
    int adjacentPaperRolls = 0;
    for (int di = -1; di <= 1; di++) {
      for (int dj = -1; dj <= 1; dj++) {
        if ((di != 0 || dj != 0) && isFieldPaperRoll(paperGrid, i + di, j + dj)) {
          adjacentPaperRolls++;
        }
      }
    }
    return adjacentPaperRolls < 4;
  }

  private static boolean isFieldPaperRoll(final List<String> paperGrid, final int i, final int j) {
    try {
      if (paperGrid.get(i).charAt(j) == '@') {
        return true;
      }
    } catch (final IndexOutOfBoundsException e) {
      return false;
    }
    return false;
  }
}
