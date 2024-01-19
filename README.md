# StudentProgram
## Petit projet pour ne pas perdre la main en Java
Ce petit projet rappelle comment, manuellement et depuis le shell:
- Compiler avec javac les classes et les packages
- Créer les archives JAR executables et rédiger un fichier Manifest
- Exécuter le JAR

Arborescence:
->StudentProgram
	->classes: contiendra les classes compilées
	->lib: contient les bibliothèques tierces (on placera uniquement les JAR)
	->src: uniquement le code source

## Compiler le programme
```bash
javac -cp lib\mysql-connector-j-8.3.0.jar -d classes src\net\codejava\StudentsInsert.java
```
Permet de compiler la classe et la placer dans un dossier déporté. L'option -d permet de spécifier le repertoire de génération. Si la classe est contenu dans des packages, les dossiers correspondants seront
automatiquement générés. -cp (l'option classpath) permet de spécifier les repertoires ou les JAR contenant les classe dont le fichier à compiler dépend

## Créer l'exécutable
On commence par écrire le fichier manifest. Attention, il doit contenir une dernière ligne vide, sinon ca 
ne marche pas.

Ensuite on peut créer le JAR:
````bash
jar cfm StudentsInsert.jar manifest.txt -C classes net
````
- l'option c pour la création du jar
- l'option f pour spécifier le nom du jar
- l'option m pour spécifier l'emplacement du manifest

-C indique où prendre les classes, on spécifie ici le package entier racine.

## Lancer l'exécutable
java -jar StudentsInsert.jar 

source : https://www.codejava.net/java-core/tools/how-to-compile-package-and-run-a-java-program-using-command-line-tools-javac-jar-and-java
