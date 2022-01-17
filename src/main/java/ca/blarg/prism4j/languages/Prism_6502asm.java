package ca.blarg.prism4j.languages;

import io.noties.prism4j.Prism4j;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

import static io.noties.prism4j.Prism4j.*;
import static java.util.regex.Pattern.compile;

public class Prism_6502asm {

	@NotNull
	public static Grammar create(@NotNull Prism4j prism4j) {
		return grammar("6502asm",
				token(
						"comment",
						pattern(compile(";.*", Pattern.CASE_INSENSITIVE))
				),
				token(
						"directive",
						pattern(compile("\\.\\w+(?= )"), false, false, "keyword")
				),
				token(
						"string",
						pattern(compile("([\"'`])(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"))
				),
				token(
						"opcode",
						pattern(
								compile("\\b(?:adc|and|asl|bcc|bcs|beq|bit|bmi|bne|bpl|brk|bvc|bvs|clc|cld|cli|clv|cmp|cpx|cpy|dec|dex|dey|eor|inc|inx|iny|jmp|jsr|lda|ldx|ldy|lsr|nop|ora|pha|php|pla|plp|rol|ror|rti|rts|sbc|sec|sed|sei|sta|stx|sty|tax|tay|tsx|txa|txs|tya)\\b", Pattern.CASE_INSENSITIVE),
								false,
								false,
								"property"
						)
				),
				token(
						"hexnumber",
						pattern(compile("#?\\$[\\da-f]{2,4}\\b", Pattern.CASE_INSENSITIVE), false, false, "string")
				),
				token(
						"binarynumber",
						pattern(compile("#?%[01]+\\b"), false, false, "string")
				),
				token(
						"decimalnumber",
						pattern(compile("#?\\b\\d+\\b"), false, false, "string")
				),
				token(
						"register",
						pattern(compile("\\b[xya]\\b", Pattern.CASE_INSENSITIVE), false, false, "variable")
				)
		);
	}

	private Prism_6502asm() {
	}
}
