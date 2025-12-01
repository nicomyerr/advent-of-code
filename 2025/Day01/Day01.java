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
      System.out.println("The password is %d.".formatted(dial.zerosCount));
    } catch (IOException e) {
      System.out.println("Input file not found.");
    }
  }

  private static class Dial {
    private static final int MAX_POSITION = 99;
    private static final int MIN_POSITION = 0;

    private int position;

    private int zerosCount;

    private Dial() {
      this.position = 50;
      System.out.println("The dial starts by pointing at %d.".formatted(this.position));
    }

    private void turn(final String rotation) {
      final char direction = rotation.charAt(0);
      switch (direction) {
        case 'L' -> turnLeft(Integer.parseInt(rotation.substring(1)));
        case 'R' -> turnRight(Integer.parseInt(rotation.substring(1)));
        default -> throw new IllegalArgumentException("Invalid rotation: " + rotation);
      }
      System.out.println("The dial is rotated %s to point at %d.".formatted(rotation, this.position));
    }

    private void turnLeft(int amount) {
      int tmpPosition = this.position;
      while (amount > 0) {
        tmpPosition--;
        if (tmpPosition < MIN_POSITION) {
          tmpPosition = MAX_POSITION;
        }
        amount--;
      }
      this.position = tmpPosition;
      if (this.position == 0) {
        this.zerosCount++;
      }
    }

    private void turnRight(int amount) {
      int tmpPosition = this.position;
      while (amount > 0) {
        tmpPosition++;
        if (tmpPosition > MAX_POSITION) {
          tmpPosition = MIN_POSITION;
        }
        amount--;
      }
      this.position = tmpPosition;
      if (this.position == 0) {
        this.zerosCount++;
      }
    }
  }
}