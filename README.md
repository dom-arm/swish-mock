# Swish mock

## About

This is a side project I'm working on. It's a desktop application built using Java Swing. My intention with this project is to further deepen my understanding of the Java language and software design principles.

## Details

* Built with Java SE 21

## How to run

### Clone the repository

```sh
git clone https://github.com/dom-arm/swish-mock.git
```

### Navigate into the project folder

```sh
cd swish-mock
```

### Compile the source code

```sh
javac -d ./out/ ./src/com/swishmock/app/*.java ./src/com/swishmock/app/controller/*.java ./src/com/swishmock/app/model/*.java ./src/com/swishmock/app/view/*.java
```

### Run the app

```sh
java -cp ./out/ com.swishmock.app.Application
```

## Notice on my workflow

To maintain a clean and linear Git history the following workflow is used:

1. Each new feature or fix starts with an issue.
2. A dedicated branch is created from the issue.
3. Once the feature is complete, I squash the commits (usually into a single commit unless multiple commits are necessary to represent the change clearly).
4. The branch is rebased onto the main branch.
5. After merging I delete the remote branch.
