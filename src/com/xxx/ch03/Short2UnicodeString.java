package com.xxx.ch03;

import com.xxx.ch03.ArrayInitParser.InitContext;
import com.xxx.ch03.ArrayInitParser.ValueContext;

/**
 * 将类似 {1,2,3} 的short数组初始化翻译为"\u0001\u0002\u0003"
 *
 * @author 0x822a5b87
 */
public class Short2UnicodeString extends ArrayInitBaseListener {

    @Override
    public void enterInit(InitContext ctx) {
        System.out.print('"');
    }

    @Override
    public void exitInit(InitContext ctx) {
        System.out.print('"');
    }

    @Override
    public void enterValue(ValueContext ctx) {
        // 假定不存在嵌套结构
        // enterValue 函数的参数是 ValueContext，我们通过它可以获取INT token的文本值
        int value = Integer.parseInt(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }
}
