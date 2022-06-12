lexer grammar XMLLexer;

// 注意，这里只有 lexer grammar

// 默认的 "模式"，所有在 <> 标签外的东西
OPEN: '<'         -> pushMode(INSIDE);
COMMENT : '<!--' .*? '-->' -> skip ;
// 转义字符
EntityRef : '&' [a-z]+ ';' ;
// 匹配除 < 和 & 之外的任意字符
TEXT : ~('<'|'&')+;

mode INSIDE;

// > 和 /> 都回到默认模式
CLOSE : '>'             -> popMode;
SLASH_CLOSE : '/>'      -> popMode;

EQUALS : '=';
STRING : '"' .*? '"' ;

// <tools></tools>
// 匹配上面的模块中 /tools 部分
SlashName : '/' Name ;
Name : ALPHA (ALPHA | DIGIT)* ;
S : [ \t\r\n] -> skip ;

fragment
ALPHA : [a-zA-Z] ;

fragment
DIGIT : [0-9] ;
