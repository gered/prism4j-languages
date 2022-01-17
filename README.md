# Prism4j Pre-packaged Language Grammars

This is a library that I threw together quickly to make it easier to quickly get a bunch of [Prism4j](https://github.com/noties/Prism4j)
languages up and running in my own personal projects which use Prism4j. This is to replace the somewhat weird "bundler"
thing that Prism4j has.

Plus, I've manually ported over some language definitions from [prism-js](https://prismjs.com/) to meet my own needs.

## Maven

```xml
<dependency>
    <groupId>ca.blarg</groupId>
    <artifactId>prism4j-languages</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

Either use the `GrammarLocator` provided by this library (`ca.blarg.prism4j.languages.Prism4jGrammarLocator`) during
construction of your `Prism4j` object, or create a new one and add all the languages you want from this library found
under the `ca.blarg.prism4j.languages` package.
