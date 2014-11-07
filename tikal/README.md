main
====

CSE 116 Project Phase 1 - 11/7/14

Group Members:
Yangyong Zhang (yangyong@buffalo.edu)
Andrew Bartlett (andrewba@buffalo.edu)
Shuai Yan (shuaiyan2@live.com)
Yuchuan Cheng (yuchuanc@buffalo.edu)
Kevin Duggan (kevindug@buffalo.edu)

Phase 1 Tikal Functionality:
-Data structures which keep track of tile positions, explorer positions, and pyramid positions, in addition to explorer quantities and pyramid levels

-GUI with ability to display individual tiles, buttons to place tiles in board positions

-Defined methods for player actions: place explorer, place pyramid, move explorer, and end turn

-Player class which tracks remaining AP and current player

-Player class has methods which check if AP>0, reduce AP, reset AP, and switch current player

-Scoring methods which, when the game ends (the last tile is placed) calculate and return the score of each player

Planned Phase 2 Functionality:

- Complete GUI with ability to add pyramid levels and explorers, move explorers; rule-limited tile placement; valid explorer movement path checking

- Complete GUI display, displaying information about explorers, pyramids, and valid paths on each tile

- Random tile generation

- Complete endgame method that handles end of play

- Link GUI with underlying data structures through provided methods
