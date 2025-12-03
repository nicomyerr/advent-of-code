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
    private static final int START_POSITION = 50;
    private static final int DIAL_SIZE = 100;

    private int position;
    private int partOneCounter;
    private int partTwoCounter;

    private Dial() {
      position = START_POSITION;
      System.out.println("The dial starts by pointing at %d.".formatted(position));
    }

    private void turn(final String rotation) {
      rotate(
          rotation.charAt(0) == 'L' ? -1 : 1,
          Integer.parseInt(rotation.substring(1)));
      System.out.println("The dial is rotated %s to point at %d.".formatted(rotation, position));
    }

    private void rotate(final int direction, final int amount) {
      int tmpPosition = position;
      for (int i = 0; i < amount; i++) {
        tmpPosition += direction;
        if (tmpPosition < 0) {
          tmpPosition = DIAL_SIZE - 1;
        } else if (tmpPosition >= DIAL_SIZE) {
          tmpPosition = 0;
        }
        if (tmpPosition == 0) {
          partTwoCounter++;
        }
      }
      position = tmpPosition;
      if (position == 0) {
        partOneCounter++;
      }
    }
  }
}
