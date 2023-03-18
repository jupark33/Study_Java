1 Shorthand Syntax
 https://dart.dev/language/functions
 For functions that contain just one expression, you can use a shorthand syntax:
 bool isNoble(int atomicNumber) => _nobleGases[atomicNumber] != null;
 
 The => expr syntax is a shorthand for { return expr; }. The => notation is sometimes referred to as arrow syntax.

2 Expression
 ‘수식’이라는 뜻으로 하나 이상의 값으로 표현(reduce)될 수 있는 코드를 말한다. evaluate 가능하다.
 1+1 (수식이다,  1+1은 2로 evaluate 된다 ) 

3 Statement
 statement는 ‘진술’, ‘서술’의 의미로 프로그래밍에서는 실행가능한(executable) 최소의 독립적인 코드 조각
 expression 과 다르게 evaluate 되지 않는다. 
 a = 1;  
  
