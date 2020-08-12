# Kotlin in Action

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