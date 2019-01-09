Header:
Rithika Srinivasan and Amanda Sun of Period 4 wrote this program on 5/23/17.


Introduction:
(The primary features of our program are enemies, levels, and player moves as each level brings you closer to hell.)
You (Kirby) and your friend (Metaknight– we know this isn’t realistic), after a peaceful-ish death, are queuing to be deemed fit for heaven or hell. Fortunately, you end up in heaven, but your friend goes to hell. You get special permission from God to go rescue him. God doesn’t care if your rescue is successful, but the Devil sure does and will send minions to stop you! But your friend is pretty lucky. Thanks to your intense training in collision aversion with Sifu Shelby, there is no obstacle you can’t jump away from! As you move deeper into the Devil’s domain, it gets hotter and you wish you wore some deodorant, because your smell attracts even more minions. On the stinkier side, the black beans God had for dinner gave him some pretty deadly *cough* beautiful farts: these green, fart stars of magicalness can revive your health! (God was thinking about selling these to the angels in heaven, but he couldn’t find a market). Go through sketchy portals to descend deeper into hell to find and save your friend. Good luck!


Instructions:
Press → to run to the right.
Press ← to run to the left.
Press  ↑  to jump.
Make contact with your friend to bring him to heaven.
Ways to potentially fail and not save your friend:
* Crashing into minions makes you lose a life 
* You have 0 lives left (max number of lives is 5)
Ways to increase your chances of winning:
* Don’t fall off-screen
* Get those star fart packs 


Class List:
MovingImage - Represents an image that moves; superclass for all characters
Enemy - Includes math that controls how the enemy moves
Player- is the character controlled by the user, includes walking and how it will react when it touches a powerup, friend, etc.
SimpleWindow- Has the run method and implements listener to draw and model interactions for the entire game interface, and is sensitive to when the keyboard is hit. 
StartPanel- Panel with a JButton for playing the game.
OptionPanel - Allows you to pause the game by pressing escape. 
Level - Contains array lists of items that the levels will have
Main- Runs the main method and creates the levels in the game.
Portal- Enables the portal to be entered into by the player 
Friend- Builds the player’s friend.
Powerup- will make the powerup invisible once hit.


Responsibility List: 
Amanda was responsible for coding up the superclass MovingImages as well as SimpleWindow, Enemy, Powerup, Level, and Portal. Rithika focused on the classes StartPanel, Main, OptionPanel, as well as the graphics and creating the levels. Rithika worked on the UML diagram and Amanda worked on the README.