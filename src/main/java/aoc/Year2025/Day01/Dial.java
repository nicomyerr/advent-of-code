package aoc.Year2025.Day01;

import lombok.Data;

@Data
public class Dial {
  private static final int START_POSITION = 50;
  private static final int DIAL_SIZE = 100;

  private int position;
  private int partOneCounter;
  private int partTwoCounter;

  public Dial() {
    position = START_POSITION;
  }

  public void turn(final String rotation) {
    final int direction = rotation.charAt(0) == 'L' ? -1 : 1;
    final int amount = Integer.parseInt(rotation.substring(1));

    for (int i = 0; i < amount; i++) {
      position = (position + direction + DIAL_SIZE) % DIAL_SIZE;
      if (position == 0) {
        partTwoCounter++;
      }
    }

    if (position == 0) {
      partOneCounter++;
    }
  }
}
