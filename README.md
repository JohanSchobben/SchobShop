#SchobShop
_SchobShop is de schoolopdracht gemaakt door Johan Schobben Als herkansing voor Intergration and Communication. De applicatie is gemaakt met spring boot. Het project is gemaakt met Spring Boot in plaats van Java Enterprise Edition en maakt gebruik van Thymeleafs, Spring Data JPA en LiquidBase._

__BELANGRIJK: Op mijn laptop heb ik mariadb op op port 3306 en mysql op poort 3307, vermoedelijk heeft u mysql op een andere poort het is daarom nodig om de connectiestring in application.properties aan te passen.__

__het is mij niet bekend hoe ik afbeelding via sql code kan uploaden. De afbeeldingen die Worden inbegrepen. zitten bij het project inbegrepen. Indien mogelijk zou u deze willen uploaden naar sQL (via data dump gaat dit niet goed)__

_indien u liever heeft ziet dat ik langskom voor een uitleg dan is dat uiteraard ook mogelijk_

## gebruikte technologiën
Voor het project is gebruik gemaakt van de volgende technologiën:

- Spring MVC
- Spring Boot

Voor het maken van de webapplicatie en de Restservices.

- Spring Security

Voor het handhaven van de ACL (zie Authorizatie) en authenticatie

- LiguiBase

Voor het maken van Database migraties, zodat elke omgeving dezelfde tools gebruikt

- Spring Data JPA

Voor dit project maak ik gebruik van JPA, hierdoor kun je als ontwikkelaar makkelijker wisselen van ORM.

- Hibernate

Als ORM voor het ophalen en opslaan van data in de database.

- MySQL

Als database

- Maven 

Voor dependency management en het bouwen van de applicatie

- Thymeleaf

Als templating Engine voor HTML

- Bootstrap

Voor een ietwat mooie applicatie om te testen.

- JQuery en PopperJS

Jquery en popperJS zijn peerdependencies van Bootstrap, echter wordt JQuesry gebruikt voor het maken van de Calls in om producten toe te voegen aan de winkelwagen en niet [XMLHttpRequest](https://developer.mozilla.org/nl/docs/Web/API/XMLHttpRequest). Desondanks dat deze ook de mogelijkheid beidt om Calls naar de backend te maken vind ik JQuery mooier in het gebruik (minder code).  de [Fetch Api](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API) kan niet gebruikt worden aangezien deze, op het moment van schrijven (7/6/18) niet wordt ondersteund door Internet Explorer.

### Spring en geen Java EE
Voor het project heb ik gekozen om te werken met Spring, het Spring Framework is iets waar ik in ijn vrije tijd veel aandacht aan heb besteed. Spring boot is een vooruitstrevende manier voor het schrijven van een website. Het heeft een hele prettige manier voor het geberuik van dependency injection en serialization. Ook kon ik nergens in de schoolopdracht vinden dat het gebruik van frameworks niet is toegestaan. In het tweede jaar werd het gebruik van frameworks voor BusinessRule generator zelfs aangeraden. 

