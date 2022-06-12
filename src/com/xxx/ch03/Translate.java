package com.xxx.ch03;

import com.xxx.ch03.ArrayInitParser.InitContext;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * @author 0x822a5b87
 */
public class Translate {

    public static void main(String[] args) throws IOException {
        // 输入
        CharStream input = new ANTLRInputStream(args[0]);
        // lexer
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        // 使用lexer将输入转换为tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 使用parser解析tokens内容
        ArrayInitParser parser = new ArrayInitParser(tokens);

        // 解析rule init，前面提到的过的，rule 的根节点是其对应的 RuleContext
        InitContext tree = parser.init();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Short2UnicodeString(), tree);
        System.out.println();
    }
}
