# LimitCrafting
LimitCrafting is a light weight Spigot plugin developed for Minecraft multiplayer server owners to limit their player's ability to craft certain items inside the game. 
https://www.spigotmc.org/resources/limitcrafting-1-17-1-updated-disable-crafting-recipes.12962/

## Features
* Highly configurable, including messages with colour support and the option to enable/disable certain features
* Use the default-block-list to disable crafting of specific items for everyone
* Option to block all items in the game from crafting
* Use group permissions limitcrafting.groups.\<group> to assign specific disallowed crafting items for specific groups/players

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

## Visual
<img src="https://github.com/Tezk/TezkCore/blob/f8c0144c500d3bcf2485c3033f71b51ce8436e8c/gifs/c83c29400c1ac3bdd605014cc327f67e.gif" />
<img src="https://github.com/Tezk/TezkCore/blob/f8c0144c500d3bcf2485c3033f71b51ce8436e8c/gifs/dbe8ab664f8fadda5e4616dcfdc0d634.gif"/>
<img src="https://github.com/Tezk/TezkCore/blob/f8c0144c500d3bcf2485c3033f71b51ce8436e8c/gifs/83e0abc6121021e9b6ff8efd6699a93b.gif" />

