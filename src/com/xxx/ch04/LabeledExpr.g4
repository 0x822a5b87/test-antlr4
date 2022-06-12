grammar LabeledExpr;

import CommonLexerRules;

prog : stat+;

stat : expr NEWLINE                 # printExpr
      | ID '=' expr NEWLINE         # assign
      | NEWLINE                     # blank
      | CLEAR NEWLINE               # clear
      ;

// op=('*' | '/') 会使得antlr生成的visitor中可以访问该常量字符
expr : expr op=('*'|'/') expr       # MulDiv
     | expr op=('+'|'-') expr       # AddSub
     | INT                          # int
     | ID                           # id
     | '(' expr ')'                 # parens
     ;

// 这些token的声明使得antlr中的parser可以使用 parser.MUL 来访问
MUL : '*';
DIV : '/';
ADD : '+';
SUB : '-';
CLEAR : 'clear';
