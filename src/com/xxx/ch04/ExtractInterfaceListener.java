package com.xxx.ch04;

import com.xxx.ch04.JavaParser.ClassDeclarationContext;
import com.xxx.ch04.JavaParser.ImportDeclarationContext;
import com.xxx.ch04.JavaParser.MethodDeclarationContext;
import org.antlr.v4.runtime.TokenStream;

/**
 * @author 0x822a5b87
 *
 * 抽取java的类定义、方法定义并转换为接口
 */
public class ExtractInterfaceListener extends JavaBaseListener {

    private final JavaParser parser;

    public ExtractInterfaceListener(JavaParser parser) {
        this.parser = parser;
    }

    @Override
    public void enterImportDeclaration(ImportDeclarationContext ctx) {
        System.out.println(parser.getTokenStream().getText(ctx));
    }

    @Override
    public void enterClassDeclaration(ClassDeclarationContext ctx) {
        // ctx.getText() 返回整个上下文中所有的节点的文本
        // ctx.Identifier() 返回 identifier
        System.out.println("interface I" + ctx.Identifier() + " {");
    }

    @Override
    public void exitClassDeclaration(ClassDeclarationContext ctx) {
        System.out.println("}");
    }

    @Override
    public void enterMethodDeclaration(MethodDeclarationContext ctx) {
        TokenStream tokens = parser.getTokenStream();
        String type = "void";
        if (ctx.type() != null) {
            type = ctx.type().getText();
        }
        String args = tokens.getText(ctx.formalParameters());
        System.out.println("\t" + type + " " + ctx.Identifier() + " " + args);
    }

}
