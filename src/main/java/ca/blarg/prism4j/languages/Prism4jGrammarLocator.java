package ca.blarg.prism4j.languages;

import io.noties.prism4j.GrammarLocator;
import io.noties.prism4j.Prism4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class Prism4jGrammarLocator implements GrammarLocator {

	@Nullable
	@Override
	public Prism4j.Grammar grammar(@NotNull Prism4j prism4j, @NotNull String language) {
		switch (language) {
			case "6502asm": return Prism_6502asm.create(prism4j);
			case "basic": return Prism_basic.create(prism4j);
			case "c": return Prism_c.create(prism4j);
			case "clike": return Prism_clike.create(prism4j);
			case "cpp": return Prism_cpp.create(prism4j);
			case "csharp": return Prism_csharp.create(prism4j);
			case "java": return Prism_java.create(prism4j);
			case "javscript": return Prism_javascript.create(prism4j);
			case "json": return Prism_json.create(prism4j);
			case "makefile": return Prism_makefile.create(prism4j);
			case "pascal": return Prism_pascal.create(prism4j);
			case "qbasic": return Prism_qbasic.create(prism4j);
			case "sql": return Prism_sql.create(prism4j);
			case "visualbasic": return Prism_visualbasic.create(prism4j);
			case "x86asm": return Prism_x86asm.create(prism4j);
			case "yaml": return Prism_yaml.create(prism4j);
			default: return null;
		}
	}

	@NotNull
	@Override
	public Set<String> languages() {
		Set<String> languages = new HashSet<>();
		languages.add("6502asm");
		languages.add("basic");
		languages.add("c");
		languages.add("clike");
		languages.add("cpp");
		languages.add("csharp");
		languages.add("java");
		languages.add("javascript");
		languages.add("json");
		languages.add("makefile");
		languages.add("pascal");
		languages.add("qbasic");
		languages.add("sql");
		languages.add("visualbasic");
		languages.add("x86asm");
		languages.add("yaml");
		return languages;
	}
}
