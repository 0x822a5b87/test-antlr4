package com.xxx.ch04;

import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @author 0x822a5b87
 *
 * 解析 Rows.g4 并根据参数打印文本
 */
public class Col {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        int col = Integer.parseInt(args[1]);
        FileInputStream is = new FileInputStream(path);
        ANTLRInputStream antlr = new ANTLRInputStream(is);
        RowsLexer lexer = new RowsLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RowsParser parser = new RowsParser(tokens, col);
        parser.file();
    }
}
