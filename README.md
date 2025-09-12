# DevBuddy CLI

## Commands
- DevBuddy init \<projectType\> \<projectName\>
- DevBuddy help

## Supported Project Types
- react
- python
- java

## Running project from source code
- Navigate to project directory: `cd /Users/NAME/IdeaProjects/DevBuddy`
- Build the project: `javac -d out src/*.java`
- Run: `java -cp <PathToOut> DevBuddy <command> <subcommands>`

### Example
```
cd /Users/ScottTenorman/IdeaProjects/DevBuddy
javac -d out src/*.java
cd Desktop
java -cp /Users/ScottTenorman/IdeaProjects/devbuddy/out DevBuddy init java MyApp     
```