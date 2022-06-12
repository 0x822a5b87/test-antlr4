grammar Rows;

// members action 可以将代码诸如到生成的parser使之成为类的成员。
// RowsParser 自定义的构造器
@parser::members {
  int col;
  public RowsParser(TokenStream input, int col) {
    this(input);
    this.col = col;
  }
}

file: (row NL)+ ;

// locals 子句定义了局部变量 i
// action 就是 {} 包围的一些代码片段
// row 访问了 $i
// row 还是用 $STUFF.text 获得刚刚匹配的STUFF中包含的文本
row
locals [int i=0]
  :( STUFF
    {
      $i++;
      if ($i == col) System.out.println($STUFF.text);
    }
  )+
  ;



TAB : '\t' -> skip;
NL  : '\r'?'\n' -> skip;
// 匹配除换行符外的任何字符
STUFF : ~[\t\r\n]+ ;
