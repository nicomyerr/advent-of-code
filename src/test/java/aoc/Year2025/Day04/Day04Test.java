package aoc.Year2025.Day04;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import aoc.Utils.FileUtils;

public class Day04Test {

  @Test
  void solveFirstPart() {
    // given
    final Day04 day04 = new Day04();
    final List<String> testInput = FileUtils.readInput("2025", "04", "test-input.txt");
    // when
    final String result = day04.solveFirstPart(testInput);
    // then
    Assertions.assertThat(result).isEqualTo("13");
  }

  @Test
  void solveSecondPart() {
    // given
    final Day04 day04 = new Day04();
    final List<String> testInput = FileUtils.readInput("2025", "04", "test-input.txt");
    // when
    final String result = day04.solveSecondPart(testInput);
    // then
    Assertions.assertThat(result).isEqualTo("43");
  }
}
