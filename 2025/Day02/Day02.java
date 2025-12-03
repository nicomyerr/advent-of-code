import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.LongStream;

public class Day02 {

  public static void main(String[] args) {
    final String fileName = (args.length > 0) ? args[0] : "test-input.txt";
    try (final BufferedReader br = new BufferedReader(
        new FileReader("2025/Day02/resources/%s".formatted(fileName)))) {
      System.out.println("The sum of invalid IDs is %d.".formatted(sumOfInvalidIds(br.lines().toList().getFirst())));
    } catch (IOException e) {
      System.out.println("Input file not found.");
    }
  }

  private static long sumOfInvalidIds(final String ranges) {
    long sum = 0;
    for (final String range : ranges.split(",")) {
      System.out.println("Processing range: %s".formatted(range));
      final String[] bounds = range.split("-");
      sum += LongStream.rangeClosed(Long.parseLong(bounds[0]), Long.parseLong(bounds[1]))
          .mapToObj(String::valueOf)
          .filter(Day02::isInvalid)
          .mapToLong(Long::parseLong)
          .sum();
    }
    return sum;
  }

  private static boolean isInvalid(final String id) {
    final int length = id.length();
    if (length % 2 != 0) {
      return false;
    }
    return id.substring(0, length / 2).equals(id.substring(length / 2));
  }
}
