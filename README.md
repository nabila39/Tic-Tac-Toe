# Tic-Tac-Toe AI with Minimax Algorithm

## Overview

This project implements an AI for the classic Tic-Tac-Toe game using the Minimax algorithm. The AI is designed to play optimally, ensuring that it either wins or at least forces a draw against any human player.

## Project Structure

- **Minimax.java**: Contains the implementation of the Minimax algorithm, which is used to determine the optimal move for the AI. It includes:
  - **bestMove(State state, char player)**: Determines the best move for the given player ('X' for AI or 'O' for the user) by evaluating all possible future states.
  - **maxValue(State state)**: Evaluates the maximum score for the AI's possible moves.
  - **minValue(State state)**: Evaluates the minimum score for the user's possible moves.
  - **isTerminal(State state)**: Checks if the current state is a terminal state (win, loss, or draw).
  - **utilityOf(State state)**: Calculates the utility value of a terminal state.
  - **checkState(State state, int a)**: Checks the state of the board based on the given line index to determine winning conditions.
  - **successorsOf(State state)**: Generates all possible states from the current state based on available moves.

- **State.java**: Defines the `State` class representing the current board configuration. It includes methods to get and set the state of the board and determine the position of the last move.

## Minimax Algorithm

The Minimax algorithm is used to make the AI play optimally by recursively evaluating all possible future game states. It works by:
1. **Maximizing Player ('X')**: The AI attempts to maximize its score by exploring all possible moves and choosing the move that results in the highest score.
2. **Minimizing Player ('O')**: The AI assumes the opponent will play optimally and tries to minimize the AI's score by considering the worst possible scenarios.

### Functions

- **`bestMove(State state, char player)`**: Determines the best move for the given player using the Minimax algorithm.
- **`maxValue(State state)`**: Computes the maximum value for the AI's moves.
- **`minValue(State state)`**: Computes the minimum value for the opponent's moves.
- **`isTerminal(State state)`**: Checks if the game has ended (win, loss, or draw).
- **`utilityOf(State state)`**: Returns the utility value of the state (1 for AI win, -1 for user win, 0 for draw).
- **`checkState(State state, int a)`**: Checks for winning conditions based on the board state.
- **`successorsOf(State state)`**: Generates all possible next states from the current state.
