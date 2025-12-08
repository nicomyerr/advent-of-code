package aoc.Year2025.Day08;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JunctionBox {
  private int x;
  private int y;
  private int z;

  public double distanceFrom(final JunctionBox point) {
    return Math.sqrt(square(this.x - point.x) + square(this.y - point.y) + square(this.z - point.z));
  }

  private double square(final int number) {
    return Math.pow(number, 2);
  }
}
