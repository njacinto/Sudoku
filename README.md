# Sudoku
Sudoku game rest services implementation with boards generator.

Tasks supported:
- get game - fetchs the game identified by the game number
- get next game - fetchs a next game. Uses the game number of the previous game.
- solve game - solves the game provided, if it has solution, and returns the board with the solution
- check if game is solved - verifies if the board is completed and if the values are a solution for the game.
                Two methods are available: one that returns true or false, depending if is solved or not, and
                a second that returns the rows, columns and inner tables with errors, if they exist.
- get suggestion - returns a value that is part of the solution.

The application will launch a task to generate the boards when the application starts. 
The generator will use 24, by default, random numbers as a base to create the board, filling it after with numbers until one solution is left.

The index page contains an example of the rest calls providing the json returned by the server.

