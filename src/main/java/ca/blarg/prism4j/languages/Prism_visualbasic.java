package ca.blarg.prism4j.languages;

import io.noties.prism4j.Prism4j;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

import static io.noties.prism4j.Prism4j.*;
import static java.util.regex.Pattern.compile;

public class Prism_visualbasic {

	@NotNull
	public static Grammar create(@NotNull Prism4j prism4j) {
		return grammar("visualbasic",
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
						"macro",
						pattern(
								compile("#(?:Const|Else|ElseIf|End|ExternalChecksum|ExternalSource|If|Region)(?:[^\\S\\r\\n]_[^\\S\\r\\n]*(?:\\r\\n?|\\n)|.)+", Pattern.CASE_INSENSITIVE),
								false,
								true
						)
				),
				token(
						"string",
						pattern(
								compile("\\$?[\"“”](?:[\"“”]{2}|[^\"“”])*[\"“”]C?"),
								false,
								true
						)
				),
				token(
						"date",
						pattern(
								compile("#[^\\S\\r\\n]*(?:\\d+([/-])\\d+\\1\\d+(?:[^\\S\\r\\n]+(?:\\d+[^\\S\\r\\n]*(?:AM|PM)|\\d+:\\d+(?::\\d+)?(?:[^\\S\\r\\n]*(?:AM|PM))?))?|\\d+[^\\S\\r\\n]*(?:AM|PM)|\\d+:\\d+(?::\\d+)?(?:[^\\S\\r\\n]*(?:AM|PM))?)[^\\S\\r\\n]*#", Pattern.CASE_INSENSITIVE),
								false,
								false,
								"builtin"
						)
				),
				token(
						"number",
						pattern(compile("(?:(?:\\b\\d+(?:\\.\\d+)?|\\.\\d+)(?:E[+-]?\\d+)?|&[HO][\\dA-F]+)(?:U?[ILS]|[FRD])?", Pattern.CASE_INSENSITIVE))
				),
				token(
						"boolean",
						pattern(compile("\\b(?:True|False|Nothing)\\b", Pattern.CASE_INSENSITIVE))
				),
				token(
						"keyword",
						pattern(compile("\\b(?:AddHandler|AddressOf|Alias|And(?:Also)?|As|Boolean|ByRef|Byte|ByVal|Call|Case|Catch|C(?:Bool|Byte|Char|Date|Dbl|Dec|Int|Lng|Obj|SByte|Short|Sng|Str|Type|UInt|ULng|UShort)|Char|Class|Const|Continue|Currency|Date|Decimal|Declare|Default|Delegate|Dim|DirectCast|Do|Double|Each|Else(?:If)?|End(?:If)?|Enum|Erase|Error|Event|Exit|Finally|For|Friend|Function|Get(?:Type|XMLNamespace)?|Global|GoSub|GoTo|Handles|If|Implements|Imports|In|Inherits|Integer|Interface|Is|IsNot|Let|Lib|Like|Long|Loop|Me|Mod|Module|Must(?:Inherit|Override)|My(?:Base|Class)|Namespace|Narrowing|New|Next|Not(?:Inheritable|Overridable)?|Object|Of|On|Operator|Option(?:al)?|Or(?:Else)?|Out|Overloads|Overridable|Overrides|ParamArray|Partial|Private|Property|Protected|Public|RaiseEvent|ReadOnly|ReDim|RemoveHandler|Resume|Return|SByte|Select|Set|Shadows|Shared|short|Single|Static|Step|Stop|String|Structure|Sub|SyncLock|Then|Throw|To|Try|TryCast|Type|TypeOf|U(?:Integer|Long|Short)|Using|Variant|Wend|When|While|Widening|With(?:Events)?|WriteOnly|Until|Xor)\\b", Pattern.CASE_INSENSITIVE))
				),
				token(
						"operator",
						pattern(compile("[+\\-*/\\\\^<=>&#@$%!]")),
						pattern(
								compile("([^\\S\\r\\n])_(?=[^\\S\\r\\n]*[\\r\\n])"),
								true
						)
				),
				token(
						"punctuation",
						pattern(compile("[{}().,:?]"))
				)
		);
	}

	private Prism_visualbasic() {
	}
}
