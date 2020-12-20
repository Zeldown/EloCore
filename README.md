# EloCore
Ce plugin est le coeur du serveur EloCraft, il contient la gestion des elos ainsi que des joueurs

# Installation
Pour installer ce plugin il vous suffit de télécharger une release sur ce github ou alors vous pouvez cloner le repo.

```
git clone https://github.com/Zeldown/EloCore.git
```

Les librairies nécessaire au fonctionnement du plugin ce trouvent dans le dossier [EloCore/lib](lib/)

# Utilisation
## Pour intéragir avec les élos d'un joueur

## [EloPlayer](src/be/zeldown/elocore/utils/EloPlayer.java)

### A partir d'un object Player
```
EloPlayer ep = new EloPlayer(player);
```

### A partir d'un pseudo de Joueur
```
EloPlayer ep = new EloPlayer(player.getName());
```

### Pour récupérer les élos d'un joueur
```
ep.getElo();
```

### Pour définir les élos d'un joueur
```
ep.setElo(value);
```

### Pour ajouter des élos à un joueur 
```
ep.addElo(value);
```

### Pour retirer des élos à un joueur
```
ep.removeElo(value);
```

### Pour connaitre la vie du joueur en fonction de ses elos
```
ep.getHealth();
```

### Les modifications des élos d'un joueur retourne l'object EloPlayer mit à jour afin de pouvoir enchainer des actions en une commande
```
ep.setElo(10).addElo(5).removeElo(3);
```
Ce code va d'abord définir à 10 les elos du joueur puis lui en ajouter 5 puis en retirer 3, il aura donc au final 12 elos

<br/>
<br/>

## Pour intéragir avec les élos d'une faction

## [EloFaction](src/be/zeldown/elocore/utils/EloFaction.java)

### A partir d'un object Faction
```
EloFaction ef = new EloFaction(faction);
```

### A partir du nom d'une faction
```
EloFaction ef = new EloFaction(faction.getTag());
```

### Pour récupérer les élos d'une faction
```
ef.getElo();
```

### Pour définir les élos d'une faction
```
ef.setElo(value);
```

### Pour ajouter des élos à une faction
```
ef.addElo(value);
```

### Pour retirer des élos à une faction
```
ef.removeElo(value);
```

### Les modifications des élos d'une faction retourne l'object EloFaction mit à jour afin de pouvoir enchainer des actions en une commande
```
ef.setElo(10).addElo(5).removeElo(3);
```
Ce code va d'abord définir à 10 les elos de la faction puis lui en ajouter 5 puis en retirer 3, elle aura donc au final 12 elos
