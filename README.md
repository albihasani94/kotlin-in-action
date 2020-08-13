# Kotlin in Action

*Witness the horror of me writing everything I know about kotlin into a single source file*.

## Make the target directory

```bash
mkdir target
```

## Compile the classes

```bash
kotlinc src/App.kt -include-runtime -d target/App.jar
```

## Run the app

```bash
java -jar target/App.jar
```
