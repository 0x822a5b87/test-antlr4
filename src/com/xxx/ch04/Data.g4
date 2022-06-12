grammar Data;

file : group+;

group : INT sequence[$INT.int] ;

// sequence[int n] 定义了 rule 的参数
// locals [int i = 1] 定义了 rule 内的局部变量i，初始值为1
// 随后定义的是两个 action
// 第一个判定是否继续进行
// 第二个累加局部变量i
sequence[int n]
locals [int i = 1;]
      : ({$i <= $n}? INT {$i++;})*    // 匹配n个整数
      ;

INT : [0-9]+;
WS  : [ \t\n\r]+ -> skip;
