# antlr4 权威指南

- 第一部分 ANTLR和计算机语言简介
  - [第一章 初识ANTLR](./ch01/ch01.md)
  - [第二章 纵观全局](./ch02/ch02.md)
  - [第三章 - 入门的ANTRL 项目](./ch03/ch03.md)
  - [第四章 - 快速指南](./ch04/ch04.md)
- 第二部分 ANTLR开发语言类应用程序
  - [第5章 设计语法](./ch05/ch05.md)

## question

### 错误: 找不到或无法加载主类 xxx

>1. 代码执行必须在 `test-antlr4/src` 目录下执行；
>2. 执行时必须通过 `java com.xxx.ch04.Cacl` 类似的指令执行；

### 关于expr的优先级

>为什么在定义 `expr` 的时候是写成
>
>```antlrv4
>grammar expr;
>expr: expr ('*'|'/') expr
>      | expr ('+'|'-') expr
>      | INT
>      | ID
>      | '(' expr ')'
>      ;
>```
>
>>而不是写成下面这样呢？
>
>```antlrv4
>grammar expr;
>expr: expr ('*'|'/'|'+'|'-') expr
>      | INT
>      | ID
>      | '(' expr ')'
>      ;
>```

因为下面的写法是有歧义的，以表达式 `1 + 2 * 3` 为例，可能被识别为

![operator precedence](./resources/operator%20precedence.png)

而使用上面的写法，加上antlr通过优先选择位置靠前的alternative来解决了这个歧义。
