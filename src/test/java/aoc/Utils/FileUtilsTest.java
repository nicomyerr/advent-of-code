package aoc.Utils;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileUtilsTest {

  // TODO test with test resources
  @Test
  void readInputWithExistingFile() {
    // when
    final List<String> result = FileUtils.readInput("2025", "01", "test-input.txt");
    // then
    Assertions.assertThat(result.size()).isEqualTo(10);
  }

  @Test
  void readInputWithNotExistingFile() {
    // when
    final List<String> result = FileUtils.readInput("1999", "1", "input.txt");
    // then
    Assertions.assertThat(result).isEmpty();
  }
}
