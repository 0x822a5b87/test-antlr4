package com.xxx.ch03;

import com.xxx.ch03.ArrayInitParser.InitContext;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @author 0x822a5b87
 */
public class ArrayInit {

    public static void main(String[] args) throws IOException {
        // 输入
        CharStream input = new ANTLRInputStream(args[0]);
        // lexer
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        // 使用lexer将输入转换为tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 使用parser解析tokens内容
        ArrayInitParser parser = new ArrayInitParser(tokens);

        // 针对init规则开始进行语法分析，注意，这里的init指的只是init rule，而不是常规的init方法
        InitContext tree = parser.init();
        System.out.println(tree.toStringTree(parser));
    }
}
