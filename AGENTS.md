# Repository Guidelines

## Project Structure & Module Organization

This is a small Maven Java library. Production code is under `src/java`, organized by package (`com.strategicgains.util.date` and `com.strategicgains.util.localdate`, plus shared utilities). JUnit tests mirror those packages under `test/java`. The root `pom.xml` defines the build; `README.md` documents supported date formats and library usage. Do not commit generated `target/` output.

## Build, Test, and Development Commands

- `mvn compile` compiles the library; it is also the POM’s default goal.
- `mvn test` compiles and runs the JUnit test suite.
- `mvn package` runs the tests and creates the library JAR under `target/`.

The POM targets Java 8 bytecode. Build and test with a supported JDK, and verify changes with `mvn test` before submitting.

## Coding Style & Naming Conventions

Follow the existing Java style: tabs for indentation, braces on declarations and control structures, and descriptive names. Use `UpperCamelCase` for classes and tests, `lowerCamelCase` for methods and fields, and keep packages lowercase. Keep date parsing/formatting behavior consistent with the documented UTC handling and existing adapters. There is no configured formatter or linter; avoid unrelated formatting changes.

## Testing Guidelines

Tests use JUnit 4 and live in `test/java` alongside the package structure of the code they exercise. Name test classes with the `*Test` suffix (for example, `TimestampAdapterTest`) and add focused cases for new parsing, formatting, or edge-case behavior. Run the full suite with `mvn test`.

## Commit & Pull Request Guidelines

Recent commits use short, imperative summaries, often describing one change (for example, “Updated POM plugins.”). Follow that concise style and keep commits focused. In a pull request, explain the behavior change and rationale, link any relevant issue, and include test results. Update `README.md` when changing public usage or supported formats; update `pom.xml` when changing build configuration.
