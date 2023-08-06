# Text Based Adventure Game

A text-based adventure game coded in Java. The player starts by selecting a character and then progresses by choosing the location where they will engage in battles. If the character collects all the items in the battlefields without dying, the game ends. Additionally, the player can enhance their abilities by making in-game purchases.

## Characters

| Character | ID | Damage | Health | Money |
|-----------|----|--------|--------|-------|
| Samurai   | 1  | 5      | 21     | 15    |
| Archer    | 2  | 7      | 18     | 20    |
| Knight    | 3  | 8      | 24     | 5     |

## Monsters

| Monster  | ID | Damage | Health | Money |
|----------|----|--------|--------|-------|
| Zombie   | 1  | 3      | 10     | 4     |
| Vampire  | 2  | 4      | 14     | 7     |
| Bear     | 3  | 7      | 20     | 12    |

## Weapons

| Weapon   | ID | Damage | Price |
|----------|----|--------|-------|
| Gun   | 1  | 2      | 25    |
| Sword    | 2  | 3      | 35    |
| Rifle    | 3  | 7      | 45    |

## Armors

| Armor    | ID | Block  | Price |
|----------|----|--------|-------|
| Light    | 1  | 1      | 15    |
| Medium   | 2  | 3      | 25    |
| Heavy    | 3  | 5      | 40    |

## Locations

| Location    | Feature                              | Monster          | Item      |
|-------------|--------------------------------------|------------------|-----------|
| Safe House  | Health Restoration                   | -                | -         |
| Cave        | Battle + Loot                        | Zombie (1-3)     | Food      |
| Forest      | Battle + Loot                        | Vampire (1-3)    | Firewood  |
| River       | Battle + Loot                        | Bear (1-3)       | Water     |
| Shop        | Buy Supportive Items                 | -                | -         |

## How to Play

1. Clone the repository to your local machine.
2. Compile and run the `Main.java` file to start the game.
3. Choose a character from the available options.
4. Select a location to start your adventure.
5. Explore the battlefields, defeat monsters, and collect items.
6. Use the earned money to purchase weapons and armors from the shop.
7. Be strategic in your battles and manage your health wisely.
8. Try to collect all items and survive to complete the game.

## Contributing

If you find any issues or have suggestions to improve the game, feel free to open an issue or create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

