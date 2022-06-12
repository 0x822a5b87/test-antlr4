grammar KeywordTest;

program : ID
         ;

enumDef : 'enum' '{' ID '}';

ID : [a-zA-Z]+;
