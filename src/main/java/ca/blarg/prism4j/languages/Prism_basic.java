package ca.blarg.prism4j.languages;

import io.noties.prism4j.Prism4j;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

import static io.noties.prism4j.Prism4j.*;
import static java.util.regex.Pattern.compile;

@SuppressWarnings("unused")
public class Prism_basic {

	@NotNull
	public static Grammar create(@NotNull Prism4j prism4j) {
		return grammar(
				"basic",
				token(
						"comment",
						pattern(
								compile("(?:!|REM\\b).+", Pattern.CASE_INSENSITIVE),
								false,
								false,
								null,
								grammar("inside", token("keyword", pattern(compile("^REM", Pattern.CASE_INSENSITIVE)))))
				),
				token(
						"string",
						pattern(compile("\"(?:\"\"|[!#$%&'()*,\\/:;<=>?^_ +\\-.A-Z\\d])*\"", Pattern.CASE_INSENSITIVE))
				),
				token(
						"number",
						pattern(compile("(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:E[+-]?\\d+)?", Pattern.CASE_INSENSITIVE))
				),
				token(
						"keyword",
						pattern(compile("\\b(?:AS|BEEP|BLOAD|BSAVE|CALL(?: ABSOLUTE)?|CASE|CHAIN|CHDIR|CLEAR|CLOSE|CLS|COM|COMMON|CONST|DATA|DECLARE|DEF(?: FN| SEG|DBL|INT|LNG|SNG|STR)|DIM|DO|DOUBLE|ELSE|ELSEIF|END|ENVIRON|ERASE|ERROR|EXIT|FIELD|FILES|FOR|FUNCTION|GET|GOSUB|GOTO|IF|INPUT|INTEGER|IOCTL|KEY|KILL|LINE INPUT|LOCATE|LOCK|LONG|LOOP|LSET|MKDIR|NAME|NEXT|OFF|ON(?: COM| ERROR| KEY| TIMER)?|OPEN|OPTION BASE|OUT|POKE|PUT|READ|REDIM|REM|RESTORE|RESUME|RETURN|RMDIR|RSET|RUN|SHARED|SINGLE|SELECT CASE|SHELL|SLEEP|STATIC|STEP|STOP|STRING|SUB|SWAP|SYSTEM|THEN|TIMER|TO|TROFF|TRON|TYPE|UNLOCK|UNTIL|USING|VIEW PRINT|WAIT|WEND|WHILE|WRITE)(?:\\$|\\b)", Pattern.CASE_INSENSITIVE))
				),
				token(
						"function",
						pattern(compile("\\b(?:ABS|ACCESS|ACOS|ANGLE|AREA|ARITHMETIC|ARRAY|ASIN|ASK|AT|ATN|BASE|BEGIN|BREAK|CAUSE|CEIL|CHR|CLIP|COLLATE|COLOR|CON|COS|COSH|COT|CSC|DATE|DATUM|DEBUG|DECIMAL|DEF|DEG|DEGREES|DELETE|DET|DEVICE|DISPLAY|DOT|ELAPSED|EPS|ERASABLE|EXLINE|EXP|EXTERNAL|EXTYPE|FILETYPE|FIXED|FP|GO|GRAPH|HANDLER|IDN|IMAGE|IN|INT|INTERNAL|IP|IS|KEYED|LBOUND|LCASE|LEFT|LEN|LENGTH|LET|LINE|LINES|LOG|LOG10|LOG2|LTRIM|MARGIN|MAT|MAX|MAXNUM|MID|MIN|MISSING|MOD|NATIVE|NUL|NUMERIC|OF|OPTION|ORD|ORGANIZATION|OUTIN|OUTPUT|PI|POINT|POINTER|POINTS|POS|PRINT|PROGRAM|PROMPT|RAD|RADIANS|RANDOMIZE|RECORD|RECSIZE|RECTYPE|RELATIVE|REMAINDER|REPEAT|REST|RETRY|REWRITE|RIGHT|RND|ROUND|RTRIM|SAME|SEC|SELECT|SEQUENTIAL|SET|SETTER|SGN|SIN|SINH|SIZE|SKIP|SQR|STANDARD|STATUS|STR|STREAM|STYLE|TAB|TAN|TANH|TEMPLATE|TEXT|THERE|TIME|TIMEOUT|TRACE|TRANSFORM|TRUNCATE|UBOUND|UCASE|USE|VAL|VARIABLE|VIEWPORT|WHEN|WINDOW|WITH|ZER|ZONEWIDTH)(?:\\$|\\b)", Pattern.CASE_INSENSITIVE))
				),
				token(
						"operator",
						pattern(compile("<[=>]?|>=?|[+\\-*\\/^=&]|\\b(?:AND|EQV|IMP|NOT|OR|XOR)\\b", Pattern.CASE_INSENSITIVE))
				),
				token(
						"punctuation",
						pattern(compile("[,;:()]", Pattern.CASE_INSENSITIVE))
				)
		);
	}

	private Prism_basic() {
	}
}
