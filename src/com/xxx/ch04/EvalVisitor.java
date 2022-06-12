package com.xxx.ch04;

import com.xxx.ch04.LabeledExprParser.AddSubContext;
import com.xxx.ch04.LabeledExprParser.AssignContext;
import com.xxx.ch04.LabeledExprParser.ClearContext;
import com.xxx.ch04.LabeledExprParser.IdContext;
import com.xxx.ch04.LabeledExprParser.IntContext;
import com.xxx.ch04.LabeledExprParser.MulDivContext;
import com.xxx.ch04.LabeledExprParser.ParensContext;
import com.xxx.ch04.LabeledExprParser.PrintExprContext;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 0x822a5b87
 *
 * {@link LabeledExprBaseVisitor} 是泛型的，考虑到我们所有的计算都是int，直接继承Integer类型即可
 */
public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {

    private Map<String, Integer> memory = new HashMap<>();

    /**
     * ID '=' expr NEWLINE
     */
    @Override
    public Integer visitAssign(AssignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    /**
     * expr NEWLINE
     */
    @Override
    public Integer visitPrintExpr(PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println(value);
        return value;
    }

    /**
     * INT
     */
    @Override
    public Integer visitInt(IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    /**
     * ID
     */
    @Override
    public Integer visitId(IdContext ctx) {
        String id = ctx.ID().getText();
        return memory.getOrDefault(id, 0);
    }

    @Override
    public Integer visitMulDiv(MulDivContext ctx) {
        // 这里有一个容易出错的地方是，我们容易 left = ctx.expr(0)
        // 实际上，因为left和right都是expr，所以需要使用 visit 方法
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == LabeledExprParser.MUL) {
            return left * right;
        } else {
            return left / right;
        }
    }

    @Override
    public Integer visitAddSub(AddSubContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == LabeledExprParser.ADD) {
            return left + right;
        } else {
            return left - right;
        }
    }

    @Override
    public Integer visitParens(ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitClear(ClearContext ctx) {
        System.out.println("before clear : " + memory);
        memory = new HashMap<>();
        System.out.println("after clear : " + memory);
        return 0;
    }
}
