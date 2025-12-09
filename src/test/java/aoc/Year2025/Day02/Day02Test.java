package aoc.Year2025.Day02;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import aoc.Utils.FileUtils;

public class Day02Test {

  @Test
  void solveFirstPart() {
    // given
    final Day02 day02 = new Day02();
    final List<String> testInput = FileUtils.readInput(FileUtils.PATH.formatted("2025", "02", "test-input.txt"));
    // when
    final String result = day02.solveFirstPart(testInput);
    // then
    Assertions.assertThat(result).isEqualTo("1227775554");
  }

  @Test
  void solveSecondPart() {
    // given
    final Day02 day02 = new Day02();
    final List<String> testInput = FileUtils.readInput(FileUtils.PATH.formatted("2025", "02", "test-input.txt"));
    // when
    final String result = day02.solveSecondPart(testInput);
    // then
    Assertions.assertThat(result).isEqualTo("4174379265");
  }
}
