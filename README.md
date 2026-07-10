# Eclipse & Duke

A 2D cooperative puzzle-platformer built with JavaFX, where players must 
navigate two characters with opposite elemental weaknesses through the 
same level simultaneously.

## Concept
Eclipse and Duke share a level but face different hazards:
- **Eclipse** is vulnerable to poison and spikes
- **Duke** is vulnerable to water and lava

Players must move both characters (via separate key sets) to reach the 
exit together, using portals, springs, and switch-activated barriers 
along the way.

## Features
- 3 hand-designed levels using a character-grid map format
- Independent physics per character (gravity, jumping, movement)
- Portal teleportation and bounce pads
- Button/laser-barrier puzzle mechanics
- Background music, sound effects, and a timer per level
- Main menu, tutorial screen, and death/restart flow

## Architecture
| Class | Responsibility |
|---|---|
| `Main` | JavaFX application entry point |
| `GameManager` | Game loop, input handling, collision/death logic |
| `LevelManager` | Level data (tile grid layouts) |
| `WholeMap` / `Tile` | Tile rendering, hazard/portal/button logic |
| `Duke` / `Eclipse` | Character physics and animation |
| `MenuManager` / `Tutorial_Screen` | UI screens |
| `MusicManager` / `GameTimer` | Audio and per-level timing |

## Tech Stack
Java, JavaFX

## How to Run
Requires the JavaFX SDK (game uses `javafx.media` for audio, so the 
`javafx-media` module must be on the module path).

```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.media -d out application/*.java
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.media -cp out application.Main
```

Or simply import as an existing project in Eclipse with the e(fx)clipse 
plugin installed and run `Main.java`.
