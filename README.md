## TripMaster
---
Application de localisation et de génération de bons plans pour les voyageurs.
 
### I. Installer le projet
---
1. Cloner le projet en local

2. Faire de même pour les deux microservices suivants :
	
- Tripmaster_Rewards (-> [lien](https://github.com/JasonDubourg/Tripmaster_Rewards) 
 
- Tripmaster_Location (-> [lien](https://github.com/JasonDubourg/Tripmaster_Location/tree/master)

2. Importer ces projets dans trois fenêtres d'IDE différentes.

### II. Utiliser l'application
---
1. Le point d'entrée des requêtes est l'applciation Tripmaster_Tourguide.  

2. Lancer les trois applications dans votre IDE.

3. Utiliser les adresses suivantes pour intéragir avec les microservices: 

- **http://localhost:8080/getRewards?userName=internalUser1**

- **http://localhost:8080/getLocation?userName=internalUser1**

- **http://localhost:8080/getAllCurrentLocations**

- **http://localhost:8080/getTripDeals?userName=internalUser4**

- **http://localhost:8080/getNearbyAttractions?userName=internalUser1**

- **localhost:8080/setUserPreferences**


