This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.

**Description of layout**

This game's layout follows the layout of the solar system, with the sun and the center and eight planets (plus dwarf planet Pluto, the only accessible dwarf planet in our game) orbiting around it. Below is one of the most accurate and useful maps:

![image](https://i.imgur.com/B4EI7pR.png)

Of the many moons in the solar system, we chose to only include Earth's Moon and Jupiter's Ganymede and Europa. This made the game much more simplistic and easier to tackle than if we had included hundreds of moons. 

**Challenges**

The main challenge in this game is to get the key that unlocks the Europa door and ends the game. If you try to open the door before you have the key, nothing will happen. However, if you (kindly) talk to the right alien and get the key, you will be able to successfully end the game!

**Design Justification**
One alternative design choice we thought of making was creating more user-focused attributes and methods, including rations and an inventory (along with methods where users could dig/pick up items). However, as we coded the bulk of the game, we realized this made the game overly complex and was not needed. While we could have included more objects and rations, it would ultimately have no impact on the final goal of the game: to get a key from an alien and go to Europa. We ended up taking out these user-centric features, making the game more streamlined and less confusing for users. 


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.

Available commands at different stages of game 

Introduction: 
- look up 
- look down 
- look left
- look right 
- look backwards/behind 
[All provide information about surroundings. Look down reveals a joystick and an eject button]

- examine picture / photo
- examine book
- examine wall
- examine screen 
[examine book and wall give hints about Jupiter's moon Europa being the end game location. Other examine commands reveal filler information]

- press button / eject 
[does nothing]

- move joystick 
[Initiates interspace sequence]

Interspace sequence 
- go to [Mercury; Venus; Earth; Mars; Jupiter; Saturn; Uranus; Neptune; Pluto; Sun]
    - if on Earth, go to moon 
    - if on Jupiter, go to Europa; go to Ganymede 
    - if player does not have enough fuel to continue and has not found the solution, they are stuck in the game forever... (must manually exit)
- land on [name of current body]
    - if body type is gas planet, landing on initiates losing endgame text
[land on initiates landing sequence]

Landing sequence 
- unboard 
[must be run before other commands other than take off]
- talk 
[if player is taking to the alien on mars]
    - talk -> please [to earn key]
- fight 
    - if player runs out of hitpoints, initiates losing endgame sequence
- board [only if unboarded]
- take off [only if on board]

Landing sequence (on Europa) + contains all of above landing sequence operations +
- examine [door, silver] 
[calls same command]
- open door 
[opens door and initiates winning endgame text IF player has key]

FASTEST SOLUTION COMMANDS 
1. move joystick 
2. go to mars
3. land on mars
4. unboard
5. talk 
6. "please"
7. board 
8. take off -> y 
9. go to jupiter
10. go to europa
11. land on europa
12. unboard 
13. examine door 
14. open door
