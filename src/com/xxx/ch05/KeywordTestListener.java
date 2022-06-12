// Generated from KeywordTest.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KeywordTestParser}.
 */
public interface KeywordTestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KeywordTestParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(KeywordTestParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeywordTestParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(KeywordTestParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeywordTestParser#enumDef}.
	 * @param ctx the parse tree
	 */
	void enterEnumDef(KeywordTestParser.EnumDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeywordTestParser#enumDef}.
	 * @param ctx the parse tree
	 */
	void exitEnumDef(KeywordTestParser.EnumDefContext ctx);
}