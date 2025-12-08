import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day03 {

  // TODO: implement solution for part 2

  public static void main(String[] args) {
    final String fileName = (args.length > 0) ? args[0] : "test-input.txt";
    try (final BufferedReader br = new BufferedReader(
        new FileReader("2025/Day03/resources/%s".formatted(fileName)))) {
      final int totalOutputJoltage = br.lines().map(Day03::maxJoltage).mapToInt(Integer::valueOf).sum();
      System.out.println("The highest total ouput joltage is %d.".formatted(totalOutputJoltage));
    } catch (IOException e) {
      System.out.println("Input file not found.");
    }
  }

  private static int maxJoltage(final String bank) {
    int maxJoltage = 0;
    for (int i = 0; i < bank.length(); i++) {
      for (int j = i + 1; j < bank.length(); j++) {
        final int joltage = Integer.parseInt("%s%s".formatted(bank.charAt(i), bank.charAt(j)));
        if (joltage > maxJoltage) {
          maxJoltage = joltage;
        }
      }
    }
    System.out.println("Max joltage for bank %s is %d.".formatted(bank, maxJoltage));
    return maxJoltage;
  }
}
