package com.xxx.ch04;

import com.xxx.ch04.JavaParser.CompilationUnitContext;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * @author 0x822a5b87
 */
public class ExtractInterfaceTool {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream(args[0]);
        // 输入
        CharStream input = new ANTLRInputStream(is);
        // lexer
        JavaLexer lexer = new JavaLexer(input);
        // 使用lexer将输入转换为tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 使用parser解析tokens内容
        JavaParser parser = new JavaParser(tokens);
        // 开始语法分析并生成ast
        CompilationUnitContext ctx = parser.compilationUnit();

        // 遍历ast
        ParseTreeWalker walker = new ParseTreeWalker();
        ExtractInterfaceListener listener = new ExtractInterfaceListener(parser);
        walker.walk(listener, ctx);
    }
}
