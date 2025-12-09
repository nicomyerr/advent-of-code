package aoc.Year2025.Day01;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import aoc.Utils.FileUtils;

public class Day01Test {

  @Test
  void solveFirstPart() {
    // given
    final Day01 day01 = new Day01();
    final List<String> testInput = FileUtils.readInput(FileUtils.PATH.formatted("2025", "01", "test-input.txt"));
    // when
    final String result = day01.solveFirstPart(testInput);
    // then
    Assertions.assertThat(result).isEqualTo("3");
  }

  @Test
  void solveSecondPart() {
    // given
    final Day01 day01 = new Day01();
    final List<String> testInput = FileUtils.readInput(FileUtils.PATH.formatted("2025", "01", "test-input.txt"));
    // when
    final String result = day01.solveSecondPart(testInput);
    // then
    Assertions.assertThat(result).isEqualTo("6");
  }
}
