package ca.blarg.prism4j.languages;

import io.noties.prism4j.Prism4j;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

import static io.noties.prism4j.Prism4j.*;
import static java.util.regex.Pattern.compile;

public class Prism_pascal {

	@NotNull
	public static Grammar create(@NotNull Prism4j prism4j) {
		return grammar("pascal",
				token(
						"comment",
						pattern(compile("\\(\\*[\\s\\S]+?\\*\\)")),
						pattern(compile("\\{[\\s\\S]+?\\}")),
						pattern(compile("\\/\\/.*"))
				),
				token(
						"string",
						pattern(
								compile("(?:'(?:''|[^'\\r\\n])*'(?!')|#[&$%]?[a-f\\d]+)+|\\^[a-z]", Pattern.CASE_INSENSITIVE),
								false,
								true
						)
				),
				token(
						"keyword",
						// turbo pascal
						pattern(
								compile("(^|[^&])\\b(?:absolute|array|asm|begin|case|const|constructor|destructor|do|downto|else|end|file|for|function|goto|if|implementation|inherited|inline|interface|label|nil|object|of|operator|packed|procedure|program|record|reintroduce|repeat|self|set|string|then|to|type|unit|until|uses|var|while|with)\\b", Pattern.CASE_INSENSITIVE),
								true
						),
						// free pascal
						pattern(
								compile("(^|[^&])\\b(?:dispose|exit|false|new|true)\\b", Pattern.CASE_INSENSITIVE),
								true
						),
						// object pascal
						pattern(
								compile("(^|[^&])\\b(?:class|dispinterface|except|exports|finalization|finally|initialization|inline|library|on|out|packed|property|raise|resourcestring|threadvar|try)\\b", Pattern.CASE_INSENSITIVE),
								true
						),
						// modifiers
						pattern(
								compile("(^|[^&])\\b(?:absolute|abstract|alias|assembler|bitpacked|break|cdecl|continue|cppdecl|cvar|default|deprecated|dynamic|enumerator|experimental|export|external|far|far16|forward|generic|helper|implements|index|interrupt|iochecks|local|message|name|near|nodefault|noreturn|nostackframe|oldfpccall|otherwise|overload|override|pascal|platform|private|protected|public|published|read|register|reintroduce|result|safecall|saveregisters|softfloat|specialize|static|stdcall|stored|strict|unaligned|unimplemented|varargs|virtual|write)\\b", Pattern.CASE_INSENSITIVE),
								true
						)
				),
				token(
						"number",
						// hexadecimal, octal and binary
						pattern(compile("(?:[&%]\\d+|\\$[a-f\\d]+)", Pattern.CASE_INSENSITIVE)),
						// decimal
						pattern(compile("\\b\\d+(?:\\.\\d+)?(?:e[+-]?\\d+)?", Pattern.CASE_INSENSITIVE))
				),
				token(
						"operator",
						pattern(compile("\\.\\.|\\*\\*|:=|<[<=>]?|>[>=]?|[+\\-*\\/]=?|[@^=]", Pattern.CASE_INSENSITIVE)),
						pattern(
								compile("(^|[^&])\\b(?:and|as|div|exclude|in|include|is|mod|not|or|shl|shr|xor)\\b", Pattern.CASE_INSENSITIVE),
								true
						)
				),
				token(
						"punctuation",
						pattern(compile("\\(\\.|\\.\\)|[()\\[\\]:;,.]"))
				)
		);
	}

	private Prism_pascal() {
	}
}
