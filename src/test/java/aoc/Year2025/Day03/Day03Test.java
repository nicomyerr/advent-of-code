package aoc.Year2025.Day03;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import aoc.Utils.FileUtils;

public class Day03Test {

  @Test
  void solveFirstPart() {
    // given
    final Day03 day03 = new Day03();
    final List<String> testInput = FileUtils.readInput(FileUtils.PATH.formatted("2025", "03", "test-input.txt"));
    // when
    final String result = day03.solveFirstPart(testInput);
    // then
    Assertions.assertThat(result).isEqualTo("357");
  }

  @Test
  void solveSecondPart() {
    // given
    final Day03 day03 = new Day03();
    final List<String> testInput = FileUtils.readInput(FileUtils.PATH.formatted("2025", "03", "test-input.txt"));
    // when
    final String result = day03.solveSecondPart(testInput);
    // then
    Assertions.assertThat(result).isEqualTo("3121910778619");
  }
}
