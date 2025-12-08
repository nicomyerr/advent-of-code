package aoc.Year2025.Day01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DialTest {

  @Test
  void turnLeft() {
    // given
    final Dial dial = new Dial();
    // when
    dial.turn("L1");
    // then
    Assertions.assertThat(dial.getPosition()).isEqualTo(49);
  }

  @Test
  void turnRight() {
    // given
    final Dial dial = new Dial();
    // when
    dial.turn("R1");
    // then
    Assertions.assertThat(dial.getPosition()).isEqualTo(51);
  }

  @Test
  void turnToZero() {
    // given
    final Dial dial = new Dial();
    // when
    dial.turn("L50");
    // then
    Assertions.assertThat(dial.getPosition()).isEqualTo(0);
  }

  @Test
  void turnToMax() {
    // given
    final Dial dial = new Dial();
    // when
    dial.turn("R49");
    // then
    Assertions.assertThat(dial.getPosition()).isEqualTo(99);
  }

  @Test
  void turnBelowZero() {
    // given
    final Dial dial = new Dial();
    // when
    dial.turn("L51");
    // then
    Assertions.assertThat(dial.getPosition()).isEqualTo(99);
  }

  @Test
  void turnAboveMax() {
    // given
    final Dial dial = new Dial();
    // when
    dial.turn("R50");
    // then
    Assertions.assertThat(dial.getPosition()).isEqualTo(0);
  }
}
