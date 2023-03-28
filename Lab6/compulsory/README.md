Graphical User Interfaces (Swing, JavaFX)
Consider a positional game played on board containing a number of dots placed on a circle. Some dots are connected to other dots using lines. Initially, the existing lines are gray (not colored).
Two players take turns coloring any uncolored lines. One player colors in one color (red), and the other colors in another color (blue).
Variant 1: Each player tries to create a triangle made solely of his color. The player who succeeds, wins the game.
Variant 2: Each player tries to avoid the creation of a triangle made solely of his color. The player who cannot avoid creating such a triangle, loses the game.

In order to create a graphical user interface for the game, you may use either Swing or JavaFX.
Create the following components :polar_bear: :

  1. The main frame of the application.
  
  2. A configuration panel for introducing parameters regarding the number of dots and lines and a button for creating a new game. The panel must be placed at the top      part of the frame. The panel must contain at least one label and one input component.
  3. A canvas (drawing panel) for drawing the board. Draw the dots and the lines according to the values specified in the config panel. This panel must be placed in        the center part of the frame.
  4. A control panel for managing the game. This panel will contain the buttons: Load, Save, Exit ,etc. and it will be placed at the bottom part of the frame.

