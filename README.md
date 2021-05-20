# Gradle Notes

These are some notes I took from the LinkedIn Learning courses
[Learning Gradle](https://www.linkedin.com/learning/learning-gradle/automate-everything?u=2094516)
and
[Gradle for Java-Based Applications and Libraries](https://www.linkedin.com/learning/gradle-for-java-based-applications-and-libraries/what-you-should-know?u=2094516)
by Benjamin Mushko.

# Learning Gradle Course
# Chapter 1 - Getting Started
## What is Gradle?
Gradle is a "build automation" tool. "Build" can include:
- Compiling the source code
- Running tests
- Building binary artifacts.
- Generating technical documentation.

Gradle can be used to automate the software lifecycle apps in different
programming languages like: Java Android, Go, Python, Java, Kotlin, etc.

## Characteristics and features
- Gradle runs on the Java virtual machine.
- The build logic is defined as instruction scripts.
- There are multiple gradle plugins that you can use to provide
  predefined functionality.
- It is primarily a command line tool but there extensive support for it
  in IDEs.
- Gradle is also widely supported by CI tools like Jenkins, GitHub
  Actions, among others.

## Gradle Terminology
- Project: the core of every gradle build. The capabilities and
  boundaries of a software component.
- Build file / script: Each software component should have its own build
  file. This file is typically name `build.gradle` (Groovy) or
  `build.gradle.kts` (Kotlin).
- Tasks: The step-by-step automation instructions to build a project.
  You write tasks in the build script.
- This means that the conceptual model is:
  - A software component is called a `Project`.
  - One `Project` has one to many `Tasks`.
  - One `Task` has zero to many `Actions`.

## Expressing Build Login in Gradle
- Gradle defines a DSL API that can be mixed with regular programming
  code.
- The DSL comes in two flavours: Groovy DSL and the Kotlin DSL. Both are
  equivalent, and you can pick whichever you prefer.

## Working with multiple Gradle Versions
- A project typically uses a fixed gradle version.
- Gradle's API can include breaking changes between major versions.
- When you want to upgrade the gradle version for a project, you will
  need to update the Gradle runtime and potentially update your scripts
  to reflect the new API.

## The Gradle Wrapper: Working with multiple projects that have different Gradle Versions
- The Gradle Wrapper is the solution for the problem of maintaining on
  the same local machine multiple gradle projects that use different
  gradle versions.
- The wrapper is a shell script (also available in bat for Windows) that
  is checked into the project and will automatically download the
  correct version of gradle for a project (if not installed) or load the
  correct version of gradle (if multiple are locally installed) before
  running any commands given to the wrapper.
- The wrapper looks into the `./gradle/*` directory in your project to
  look for the version the project should use. This folder must also be
  checked into version control with the wrapper.
- To GENERATE the wrapper scripts (`gradlew` and `gradlew.bat`) and the
  `./gradle/*` directory, you can run `gradle wrapper` in the root of
  your project directory.
  - The machine that does this for the first time in a project needs to
    have the correct version of gradle locally available. All other
    developers can just use `./gradlew` to get everything setup for
    them.
  - IntelliJ takes care of this if you start a new project, or a new
    module using the `Gradle` option.
- If using the terminal to invoke gradle, invoke the tasks through the
  `./gradlew` instead of calling it directly.
  - For example `./gradlew build`
- The gradle wrapper mode of operation also works within continuous
  delivery servers. That is, the wrapper will download the correct
  version of gradle if not installed.


## Executing Gradle from the IntelliJ IDEA
- IDEA relies on the `gradlew`, and the `./gradle/` directories to enable
  IDE support for gradle.
- If IDEA finds those files, it will inspect the build files and load
  all tasks into the gradle tab on the right side.
- When gradle is properly detected by IDEA, we get autocompletion with
  the Gradle DSL when editing the `build.gradle`, or the
  `build.gradle.kts` files.
