# [Day 8: Playground](https://adventofcode.com/2025/day/8)

To execute the solution for day 8:

- Download the input from [here](https://adventofcode.com/2025/day/8/input)
- Save it as e.g. `input.txt` in the [resources](resources/) folder
- Run the following command in the terminal

  ```bash
  java 2025/Day04/Day04.java input.txt
  ```

- If no argument is passed the program will use [test-input.txt](resources/test-input.txt)

## Solving idea

- Converting input to List<[Point](Point.java)>
- All pairs with distance
- Sort by distance
- Connect shortest x distances to Circuits
- Merge Circuits
