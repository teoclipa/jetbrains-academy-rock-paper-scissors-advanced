# Rock-Paper-Scissors Game in Java

This repository contains a console-based Java application for the popular Rock-Paper-Scissors game, along with some extended options based on user preference. 

## Application Details

The application runs a continuous game of Rock-Paper-Scissors in a loop until the user wishes to stop the game. The user has the option to check their rating at any point in time, which is updated based on the outcome of the games played - win, lose, or draw. At the beginning of each game, the user can input the game variants. The score, in form of ratings, is saved in a file called `rating.txt`. The application checks if this file exists and retrieves user's previous rating, if available.

## Features

- **Player**: The Player class encapsulates all information relevant to a player of the game, such as their name and current rating.
- **Option**: The Option class provides a static method to randomly generate an option (rock, paper, or scissors) from a given list.
- **Result**: The Result enumeration represents the possible outcomes of a game: USER_WIN, COMPUTER_WIN, and DRAW.
- **Game Options**: Apart from the traditional Rock, Paper and Scissors, the game also supports additional options (like Lizard, Spock etc.) inputted by the user at the start of the game.
- **Score Keeping**: The application maintains a score in terms of ratings. On a draw, the user's rating is increased by 50 points, and on a win, by 100 points.

## Usage

The game starts by asking the user to input their name and their preferred options (defaults to rock, paper, scissors if nothing is entered). It then continues in an indefinite loop where the user can:

1. Input an option to play a round against the computer.
2. Input `!rating` to check their current rating.
3. Input `!exit` to stop the game.

## Classes

- **Main**: The main class of the program, responsible for running the game, handling user inputs, and updating the score.
- **Player**: A class representing a player, with their name and current score.
- **Option**: A class for randomly choosing the computer's move.
- **Result**: An enumeration representing the possible outcomes of a round.
