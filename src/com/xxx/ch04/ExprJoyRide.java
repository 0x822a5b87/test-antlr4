package com.xxx.ch04;

import com.xxx.ch04.ExprParser.ProgContext;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @author 0x822a5b87
 */
public class ExprJoyRide {

    public static void main(String[] args) throws IOException {
        String path = "input/t.expr";
        FileInputStream fileInputStream = new FileInputStream(path);
        ANTLRInputStream input = new ANTLRInputStream(fileInputStream);

        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        ProgContext tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }
}
