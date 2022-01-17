package ca.blarg.prism4j.languages;

import io.noties.prism4j.Prism4j;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

import static io.noties.prism4j.Prism4j.*;
import static java.util.regex.Pattern.compile;

public class Prism_qbasic {

	@NotNull
	public static Grammar create(@NotNull Prism4j prism4j) {
		return grammar(
				"qbasic",
				token(
						"comment",
						pattern(
								compile("(?:['‘’]|REM\\b)(?:[^\\r\\n_]|_(?:\\r\\n?|\\n)?)*", Pattern.CASE_INSENSITIVE),
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
						pattern(compile("(?:(?:\\b\\d+(?:\\.\\d+)?|\\.\\d+)(?:E[+-]?\\d+)?|&[HO][\\dA-F]+)(?:U?[ILS]|[FRD])?", Pattern.CASE_INSENSITIVE))
				),
				token(
						"boolean",
						pattern(compile("\\b(?:True|False)\\b", Pattern.CASE_INSENSITIVE))
				),
				token(
						"keyword",
						pattern(compile("\\b(?:ABS|AND|ASC|ATN|BEEP|BLOAD|BSAVE|CALL(?: ABSOLUTE| INT86OLD| INT86XOLD| INTERRUPT| INTERRUPTX)?|CDBL|CHAIN|CHDIR|CHR\\$|CINT|CIRCLE|CLEAR|CLNG|CLOSE|CLS|COLOR|COM(?: ON| OFF| STOP)?|COMMAND\\$|COMMON|CONST|COS|CSNG|CSRLIN|CVD|CVDMBF|CVI|CVL|CVS|CVSMBF|DATA|DATE\\$|DECLARE|DEF(?: FN| SEG)?|DIM|DO|DOUBLE|DRAW|END|ENVIRON|ENVIRON\\$|EOF|EQV|ERASE|ERDEV|ERDEV\\$|ERL|ERR|ERROR|EXIT|EXP|FIELD|FILEATTR|FILES|FIX|FOR|FRE|FREEFILE|FUNCTION|GET|GOSUB|GOTO|HEX\\$|IF|IMP|INKEY\\$|INP|INPUT|INPUT\\$|INSTR|INT|INTEGER|IOCTL|IOCTL\\$|KEY(?: ON| OFF| STOP)?|KILL|LBOUND|LCASE\\$|LEFT\\$|LEN|LET|LINE|LOC|LOCATE|LOCK|LOF|LOG|LONG|LOOP|LPOS|LPRINT(?: USING)?|LSET|LTRIM\\$|MID\\$|MKD\\$|MKDIR|MKDMBF\\$|MKI\\$|MKL\\$|MKS\\$|MKSMBF\\$|MOD|NAME|NEXT|NOT|OCT\\$|ON(?: COM GOSUB| ERROR GOTO| PEN GOSUB| PLAY GOSUB| STRIG GOSUB| TIMER GOSUB| UEVENT GOSUB)?|OPEN(?: COM)?|OPTION BASE|OR|OUT|PAINT|PALETTE(?: USING)?|PCOPY|PEEK|PEN(?: ON| OFF| STOP)?|PLAY(?: ON| OFF| STOP)?|PMAP|POINT|POKE|POS|PRESET|PSET|PRINT(?: USING)?|PUT|RANDOMIZE|READ|REDIM|REM|RESET|RESTORE|RESUME|RETURN|RIGHT\\$|RMDIR|RND|RSET|RTRIM\\$|RUN|SADD|SCREEN|SEEK|SELECT CASE|SETMEM|SGN|SHARED|SHELL|SIN|SINGLE|SLEEP|SOUND|SPACE\\$|SPC|SQR|STATIC|STICK|STOP|STR\\$|STRIG(?: ON| OFF| STOP)?|STRING|STRING\\$|SUB|SWAP|SYSTEM|TAB|TAN|TIME\\$|TIMER(?: ON| OFF| STOP)?|TROFF|TRON|TYPE|UBOUND|UCASE\\$|UEVENT(?: ON| OFF| STOP)?|UNLOCK|VAL|VARPTR|VARPTR\\$|VARSEG|VIEW(?: PRINT)|WAIT|WHILE|WEND|WIDTH|WINDOW|WRITE|XOR)\\b", Pattern.CASE_INSENSITIVE))
				),
				token(
						"operator",
						pattern(compile("<[=>]?|>=?|[+\\-*\\/^=&]", Pattern.CASE_INSENSITIVE))
				),
				token(
						"punctuation",
						pattern(compile("[,;:()]", Pattern.CASE_INSENSITIVE))
				)
		);
	}

	private Prism_qbasic() {
	}
}
