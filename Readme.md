###Nutmeg Javatest

###The aim
Please write a Java command line utility and submit it as a git repository, e.g. a link to a github repo.
The repository should contain instructions on how to compile and run the utility.
The command should have the following interface:
```
$ my_command [ file | categories | fact ]
```

The program should interact with the following public APIs:
* http://thecatapi.com/
* http://catfacts­api.appspot.com/doc.html
The command should:
* file: save an image of a cat to a tmp folder and print the url to stdout
* categories: print an ordered list of cat categories to stdout
* fact: list a cat fact

###Design choices
* Maven: dependency management
* Unirest: simple REST API client
* Gson: Json -> POJO mappings
* Jaxb: XML -> POJO unmarshalling
* Junit: tests

###Build
I've used the maven assembly plugin to keep things simple and build a single JAR with all of the required dependencies:
```
mvn clean compile assembly:single
```

###Run

#####File
```
java -jar target/nutmeg-java-1.0-jar-with-dependencies.jar file
```

or

```
java -jar target/nutmeg-java-1.0-jar-with-dependencies.jar
```

#####Category
```
java -jar target/nutmeg-java-1.0-jar-with-dependencies.jar categories
```

#####Fact
```
java -jar target/nutmeg-java-1.0-jar-with-dependencies.jar fact
```

###Enhancements
* Mock out source systems so the tests dont rely on them - or refactor the logic out if it becomes more complex so it can be tested in isolation.  I didn't for this axercise as there is so little logic going on I didnt feel it was worth the extra structure.  However, we could add abstract classes for Binary and String consumers which the File and Fact/Category consumers extend from respectively.
* Write the tests first - I should have done this and I didnt, which was naughty of me!
* If we want to get really catty we could start caching responses locally, and if we scale, centrally (eg Redis).