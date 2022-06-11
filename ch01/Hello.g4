grammar Hello;			          // 定义一个名为Hello的语法

r : 'hello' ID ;              // 匹配一个关键hello和一个紧随其后的标识符
ID : [a-z]+ ;                 // 匹配小写字母组成的标识符
WS : [\t\r\n]+ -> skip ;      // 忽略空格、Tab、换行符以及\r
