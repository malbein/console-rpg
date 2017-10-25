# Console Fantasy Role Playing Game

This is a console fantasy RPG made in java without any external library.

## Extending the code
- Download the code: `git clone https://github.com/malbein/console-rpg.git`
- Compile the code: `mvn package`

**A couple of tips:**
- You can create a new Role as Ranger, simple as extending the Role Class.
- You can create a new Location just extending Location.
- InitialInformation contains all initial data, so adding a location or a monster should be add there.
- All interaction with the terminal should be add on the controllers, so we can replace it in the future and add a more rich interface.

## For playing the game you just need to download the code
- On the terminal "`java -jar target/console-rpg-1.0.jar`"
- This will start the game.
- It will ask for a character name, if the character was created before is load to continue your adventure, if not it will send you to a character creation page.
- Once you have create your character, follow the game instructions.

**Characters options:**
- _Warrior_: Hi health, Low attack
- _Mage_: Low health, Hi attack

Hope you enjoy it!!!!

_**Matias Graziani**_