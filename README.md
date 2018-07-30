# oAuth2

Avances:

- Realizar el servidor y el cliente con sockets para que no se queden cacheadas las sesiones.
- Meterle más funcionalidad al proyecto.
- Se procede a instalar Gradle como herramienta de construcción de proyecto en lugar de con Maven: 
		https://docs.gradle.org/current/userguide/installation.html
		https://docs.gradle.org/4.9/javadoc/?_ga=2.248894407.1770774194.1532793739-1977809958.1532793739
		
- Crema para tema Gradle en Eclipse config y build.gradle : http://www.vogella.com/tutorials/EclipseGradle/article.html

-	Para lanzar las aplicaciones sin utilizar servidor de aplicaciones he seguido los pasos de: https://guides.gradle.org/building-java-web-applications/
	Entre otras cosas he hecho "gradle wrapper --gradle-version=4.9" para poder usar "./gradlew appRun".
	"./gradlew appRun" sirve para lanzar como si fuera un servidor de aplicaciones todo el código sin necesidad de Tomcat o Wildfly.
	"./gradlew build" sirve para lanzar los test que hayamos hecho y te devuelve la solución en "build/reports/tests/test/index.htm"

- Para el próximo día Githubear:
	https://stackoverflow.com/questions/17552457/how-do-i-upload-eclipse-projects-to-github
	Step:
		-1. En la localización donde tengamos el proyecto hacer: "git init"
		-2. Añadimos una variable "origin": "git remote add origin https://github.com/[username]/[reponame].git"
		-3. Añadimos todos los elementos para commitearlos: "git add ."
		-4. Hacemos un pull para testear que todo está actualizado: "git pull origin master --allow-unrelated-histories"
		-5. 
		
- Para el próximo día poner el debugeador "https://stackoverflow.com/questions/33035922/debug-java-program-by-executing-gradle-run"
