/**
 * 语法文件以 grammar 关键字开头；
 * 这是一个名为 ArrayInit 的语法，必须和文件名ArrayInit.g4匹配。
 */
grammar ArrayInit;

// 一条名为init的rule
init : '{' value (',' value)* '}' ;

// 一个value可以是一个嵌套的init，也可以是一个简单的整数
value: init
        | INT
        ;

// 语法分析器的rule必须以小写字母开头，词法分析器的规则则必须用大写字母开头
// 定义 token INT，由一个或者多个数字组成
INT: [0-9]+;
// 定义lexer rule，丢弃空白符号
WS : [ \t\r\n]+ -> skip;

