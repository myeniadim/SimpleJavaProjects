


# Sudoku Solver

This is a simple Java program that can solve Sudoku puzzles. It uses a backtracking algorithm to find solutions to Sudoku boards of varying complexity.

## Table of Contents

- [About](#about)
- [How to Use](#how-to-use)
- [Prerequisites](#prerequisites)
- [Algorithm](#algorithm)


## About

Sudoku Solver is a Java-based program designed to solve Sudoku puzzles efficiently. It provides a text-based interface for users to input Sudoku boards and find their solutions.

## How to Use

1. Open the `Main.java` file.

2. Define your Sudoku puzzle by modifying the `board` array. Use `0` to represent empty cells and fill in the known numbers.

   ```java
   int[][] board = {
       {5, 4, 0, 0, 0, 0, 0, 0, 0},
       {0, 0, 2, 8, 0, 0, 0, 0, 0},
       // ... (fill in the rest of the Sudoku board)
   };
 

3. Run the program to see the solution. The program will print the solved Sudoku board.

4. If a solution is possible, you'll see "Solved Successfully." If it's impossible to solve, you'll see "It is impossible."

5. The `isLegalVertically`, `isLegalHorizontally`, and `isLegalInBox` methods are used to check the legality of a number placement. You can explore these methods in the code to understand the puzzle-solving logic.

## Prerequisites

Before you run the Sudoku Solver, make sure you have the following:

- Java SE Development Kit (JDK) installed on your system.

## Algorithm

This Sudoku Solver uses a backtracking algorithm. It starts from the top-left cell and iterates through each cell, trying numbers from 1 to 9. If a number is legal to place in the current cell, it proceeds to the next cell. If it encounters an illegal placement, it backtracks to the previous cell and tries the next number.

The algorithm continues this process until it finds a solution or determines that there's no valid solution for the given puzzle.

