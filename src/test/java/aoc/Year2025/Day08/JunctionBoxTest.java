package aoc.Year2025.Day08;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JunctionBoxTest {

  @Test
  void distanceFrom() {
    // given
    final JunctionBox point = new JunctionBox(1, 2, 3);
    // when
    final double result = point.distanceFrom(new JunctionBox(4, 5, 6));
    // then
    Assertions.assertThat(result).isEqualTo(Math.sqrt(27));
  }
}
