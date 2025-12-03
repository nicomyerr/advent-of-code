import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day01 {

  public static void main(String[] args) {
    final String fileName = (args.length > 0) ? args[0] : "test-input.txt";
    final Dial dial = new Dial();
    try (final BufferedReader br = new BufferedReader(
        new FileReader("2025/Day01/resources/%s".formatted(fileName)))) {
      br.lines().forEach(line -> {
        dial.turn(line);
      });
      System.out.println("The password for part one is %d.".formatted(dial.partOneCounter));
      System.out.println("The password for part two is %d.".formatted(dial.partTwoCounter));
    } catch (IOException e) {
      System.out.println("Input file not found.");
    }
  }

  private static class Dial {
    private int position;

    private int partOneCounter;
    private int partTwoCounter;

    private Dial() {
      position = 50;
      System.out.println("The dial starts by pointing at %d.".formatted(position));
    }

    private void turn(final String rotation) {
      switch (rotation.charAt(0)) {
        case 'L' -> turnLeft(Integer.parseInt(rotation.substring(1)));
        case 'R' -> turnRight(Integer.parseInt(rotation.substring(1)));
        default -> throw new IllegalArgumentException("Invalid rotation: " + rotation);
      }
      System.out.println("The dial is rotated %s to point at %d.".formatted(rotation, position));
    }

    private void turnLeft(int amount) {
      int tmpPosition = position;
      while (amount > 0) {
        tmpPosition--;
        if (tmpPosition == 0) {
          partTwoCounter++;
        }
        if (tmpPosition < 0) {
          tmpPosition = 99;
        }
        amount--;
      }
      position = tmpPosition;
      if (position == 0) {
        partOneCounter++;
      }
    }

    private void turnRight(int amount) {
      int tmpPosition = position;
      while (amount > 0) {
        tmpPosition++;
        if (tmpPosition > 99) {
          tmpPosition = 0;
          partTwoCounter++;
        }
        amount--;
      }
      position = tmpPosition;
      if (position == 0) {
        partOneCounter++;
      }
    }
  }
}
