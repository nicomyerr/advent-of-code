package aoc.Year2025.Day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Day04 {

  private static final char PAPER_ROLL = '@';

  public static void main(String[] args) {
    final String fileName = (args.length > 0) ? args[0] : "test-input.txt";
    try (final BufferedReader br = new BufferedReader(
        new FileReader("2025/Day04/resources/%s".formatted(fileName)))) {
      solveFirstPart(br.lines().toList());
    } catch (IOException e) {
      System.out.println("Input file not found.");
    }
  }

  private static void solveFirstPart(final List<String> paperGrid) {
    int accessibleRolls = 0;
    for (int i = 0; i < paperGrid.size(); i++) {
      final String line = paperGrid.get(i);
      for (int j = 0; j < line.length(); j++) {
        if (isFieldPaperRoll(paperGrid, i, j) && isAccessible(paperGrid, i, j)) {
          accessibleRolls++;
        }
      }
    }
    System.out.println("Part1: The forklift can access %d rolls.".formatted(accessibleRolls));
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
      if (paperGrid.get(i).charAt(j) == PAPER_ROLL) {
        return true;
      }
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
    return false;
  }
}
