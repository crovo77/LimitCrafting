# LimitCrafting
LimitCrafting is a light weight Spigot plugin developed for Minecraft multiplayer server owners to limit their player's ability to craft certain items inside the game. 

## Features
* Highly configurable, including messages with colour support, and enable/disable certain features
* Use the default-block-list to disable crafting of specific items for everyone
* Option to block all items in the game from crafting
* Use group permissions limitcrafting.groups.<group> to assign specific disallowed crafting items for specific groups/players

## Commands
Use /limitcrafting reload (or /lc) to reload the configuration in-game

## Permissions
limitcrafting.bypass:
  description: Permission will grant players bypass from ALL limitcrafting recipe blockages
  default: op
limitcrafting.reload:
  description: Allows user to execute /limitcrafting reload
  default: op
limitcrafting.groups:
  description: Used to define specific recipes to be blocked for specific groups of players

