package aoc.Year2025.Day08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Playground {
  private Map<Integer, JunctionBox> junctionBoxes;
  private List<Circuit> circuits;

  public Playground(final List<String> points) {
    final Map<Integer, JunctionBox> junctionBoxes = new HashMap<Integer, JunctionBox>();
    int id = 0;
    for (final String point : points) {
      final String[] coordinates = point.split(",");
      junctionBoxes.put(id, new JunctionBox(
          Integer.valueOf(coordinates[0]),
          Integer.valueOf(coordinates[1]),
          Integer.valueOf(coordinates[2])));
      id++;
    }
    this.junctionBoxes = junctionBoxes;
    circuits = new ArrayList<Circuit>();
  }

  public List<JunctionBox> closestPair() {
    return null;
  }
}
