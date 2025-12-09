package aoc.Utils;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileUtilsTest {

  private final String PATH = "src/test/java/aoc/Utils/resources/%s";

  @Test
  void readInputWithExistingFile() {
    // when
    final List<String> result = FileUtils.readInput(PATH.formatted("input-test.txt"));
    // then
    Assertions.assertThat(result.size()).isEqualTo(5);
  }

  @Test
  void readInputWithNotExistingFile() {
    // when
    final List<String> result = FileUtils.readInput(PATH.formatted("notexistingfile.txt"));
    // then
    Assertions.assertThat(result).isEmpty();
  }

  @Test
  void readInputWithEmptyLines() {
    // when
    final List<String> result = FileUtils.readInput(PATH.formatted("input-empty-lines.txt"));
    // then
    Assertions.assertThat(result.size()).isEqualTo(3);
  }
}
