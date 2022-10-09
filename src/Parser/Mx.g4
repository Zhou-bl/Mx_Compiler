grammar Mx;

prog : declType* ;

//Devide the program by declare type
declType
    : functionDecl
    | classDecl
    | variableDecl ';'
    ;
//statement
statement
    : block                                                                                                                                 #codeBlock
    | ifStmt                                                                                                                                #ifStatement
    | WHILE '(' condition=expression ')' loopBody=statement                                                                                 #whileStatement
    | FOR '(' (initDecl=variableDecl | initExpr=expression)? ';' condition=expression? ';' incrExp=expression? ')' loopBody=statement       #forStatement
    | jumpStmt                                                                                                                              #jumpStatement
    | expression ';'                                                                                                                        #exprStatement
    | variableDecl ';'                                                                                                                      #variableDeclStatement
    | ';'                                                                                                                                   #blankStatement
    ;

block : '{' statement* '}';

expression
    : IDENTIFIER                                                                    #identifier
    | constantValue                                                                 #constant
    | expression DOT IDENTIFIER                                                     #objPortion
    | NEW allocFormat                                                               #allocExp
    | expression '(' parameterListForCall? ')'                                      #functionCall
    | '(' expression ')'                                                            #compoundExp
    | array=expression '[' index=expression ']'                                     #arrayAccess
    | operand=expression op=('++'|'--')                                             #aftermonocularOp//后缀单目运算符
    | <assoc=right> op=('!'|'~'|'++'|'--') operand=expression                       #monocularOp
    | operand1=expression op=('*'|'/'|'%') operand2=expression                      #binaryExpr
    | operand1=expression op=('+'|'-') operand2=expression                          #binaryExpr
    | <assoc=right> op=('-'|'+') operand=expression                                 #monocularOp
    | operand1=expression op=('>>'|'<<') operand2=expression                        #binaryExpr
    | operand1=expression op=('<'|'<='|'>'|'>=') operand2=expression                #binaryExpr
    | operand1=expression op=('=='|'!=') operand2=expression                        #binaryExpr
    | operand1=expression op='&' operand2=expression                                #binaryExpr
    | operand1=expression op='^' operand2=expression                                #binaryExpr
    | operand1=expression op='|' operand2=expression                                #binaryExpr
    | operand1=expression op='&&' operand2=expression                               #binaryExpr
    | operand1=expression op='||' operand2=expression                               #binaryExpr
    | <assoc=right> operand1=expression op='=' operand2=expression                  #binaryExpr
    | THIS                                                                          #objPointer
    | LAMBDAS1 lambdaParameterList? LAMBDAS2 block '(' parameterListForCall? ')'    #lambdaExp
    ;

allocFormat
    : baseType ('[' expression ']')+ ('[' ']')+ ('[' expression ']')+   #allocErrorType
    | baseType ('[' expression ']')+ ('[' ']')*                         #allocArrayType
    | baseType ('(' ')')?                                               #allocBaseType
    ;

ifStmt : IF '(' condition=expression ')' thenStatement=statement (ELSE elseStament=statement)?;

jumpStmt
    : RETURN expression? ';'    #returnStatement
    | BREAK ';'                 #breakStatement
    | CONTINUE ';'              #continueStatement
    ;

variableDecl : variableType baseVariableDecl (',' baseVariableDecl)* ;

baseVariableDecl : IDENTIFIER ('=' expression)? ;

functionDecl : functionType? IDENTIFIER '(' parameterList? ')' block;

parameterList : variableType IDENTIFIER (',' variableType IDENTIFIER)* ;

lambdaParameterList : '(' parameterList? ')';

parameterListForCall : expression (',' expression)* ;

classDecl : CLASS className=IDENTIFIER '{' ( (variableDecl ';') | functionDecl )* '}' ';' ;

constantValue
    : BOOL_CONSTANT
    | INTERGER_CONSTANT
    | STRING_CONSTANT
    | NULL_CONSTANT
    ;

baseType
    : INT
    | BOOL
    | STRING
    | IDENTIFIER  //class作为一种baseType
    ;

//递归定义
variableType
    : baseType              #baseVariableType
    | variableType '[' ']'  #arrayType
    ;

functionType
    : variableType
    | VOID
    ;

//define tokens:
//symbols:
DOT : '.';
LAMBDAS1 : '[&]';
LAMBDAS2 : '->';


//reserved words
INT : 'int';
BOOL : 'bool';
STRING : 'string';
VOID : 'void';
IF : 'if';
ELSE : 'else';
FOR : 'for';
WHILE : 'while';
BREAK : 'break';
CONTINUE : 'continue';
RETURN : 'return';
NEW : 'new';
CLASS : 'class';
THIS : 'this';

//const value
NULL_CONSTANT : 'null';
BOOL_CONSTANT : 'true' | 'false';
INTERGER_CONSTANT : [1-9][0-9]+ | [0-9]; //整数常量没有负数
STRING_CONSTANT : '"' (ESC | .)*? '"';
fragment ESC : '\\"' | '\\\\' | '\\n';

IDENTIFIER : [A-Za-z][A-Za-z0-9_]*; //标识符只能以字母开头


//something to skip:
WS : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' .*? '\r'?'\n' -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;