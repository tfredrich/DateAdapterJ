# DateAdapterJ

DateAdapterJ is a Java library for parsing and formatting `java.util.Date` values using common date, timestamp, and HTTP-date formats. It is intended for applications that need to accept multiple input formats—such as ISO 8601 values, common UI dates, and HTTP headers—and consistently handle dates in UTC. It also includes `LocalDateAdapter` for date-only `java.time.LocalDate` values.

## Getting Started

### Prerequisites

- JDK 17 or later. The Maven compiler configuration targets Java 17 bytecode.
- Apache Maven to build the project.

### Installation

Add the published artifact to your Maven project:

```xml
<dependency>
    <groupId>com.strategicgains</groupId>
    <artifactId>DateAdapterJ</artifactId>
    <version>1.1.5</version>
</dependency>
```

The repository POM currently identifies the development version as `1.1.6-SNAPSHOT`. To use that snapshot, configure the Sonatype snapshots repository in your Maven settings or POM.

### Running

This repository is a library, not a standalone application. Build it and run its tests with:

```sh
mvn package
```

Use the adapter classes from your application, for example `DateAdapter`, `TimestampAdapter`, `Iso8601TimepointAdapter`, `HttpHeaderTimestampAdapter`, and `LocalDateAdapter`.

## Supported Formats

The adapters support configurable input and output formats. Built-in date handling includes ISO calendar dates (`YYYY-MM-DD`, `YYYYMMDD`) and common UI formats (`MM/DD/YYYY`, `YYMMDD`). Timestamp adapters handle ISO 8601 time points with timezone offsets and optional milliseconds. `HttpHeaderTimestampAdapter` supports HTTP-date forms based on RFC 1123, RFC 1036, and the asctime format. Dates are converted to UTC internally. See the adapter classes and `DateAdapterConstants` for defaults and details.

## Tech Stack

- Java; Maven build (`pom.xml`)
- JUnit 5 for tests
- No runtime dependencies are declared in the POM

## Project Structure

```text
src/main/java/ Library source code
src/test/java/ JUnit tests
pom.xml     Maven build and dependency configuration
LICENSE     Apache License 2.0
```

## Contributing

See [AGENTS.md](AGENTS.md) for repository-specific structure, style, and test guidance. Run `mvn test` before submitting changes.

## License

Licensed under the Apache License, Version 2.0; see [LICENSE](LICENSE).
