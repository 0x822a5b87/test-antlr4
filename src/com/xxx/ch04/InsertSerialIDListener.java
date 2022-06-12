package com.xxx.ch04;

import com.xxx.ch04.JavaParser.ClassBodyContext;
import com.xxx.ch04.JavaParser.ClassDeclarationContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

/**
 * @author 0x822a5b87
 */
public class InsertSerialIDListener extends JavaBaseListener {

    private final TokenStreamRewriter rewriter;

    public InsertSerialIDListener(TokenStream tokens) {
        this.rewriter = new TokenStreamRewriter(tokens);
    }

    /**
     * 在监听器的实现中，我们需要在类定义的起始位置触发一个插入操作
     */
    @Override
    public void enterClassBody(ClassBodyContext ctx) {
        String field = "\n\tpublic static final long serialVersionUID = 1L;";
        rewriter.insertAfter(ctx.start, field);
    }

    public TokenStreamRewriter getRewriter() {
        return rewriter;
    }
}
