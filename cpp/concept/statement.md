"statement"
- definition: инструкции
- has-a
  - "labeled statements"
  - "expression statement"
  - "compound statement"
  - "selection statement"
  - "iteration statement"
  - "jump statement"
  - "declaration statement"
  - "try block"

"labeled statements"
- definition: инструкции с метками
- is-a
  - "goto"
  - "case"
  - "default"

"selection statement"
- definition: условный оператор
- is-a
  - "if-else statement" 
  - "switch statement"

"iteration statement"
- definition: оператор цикла
- is-a
  - "while loop"
  - "do-while loop"
  - "for loop"
  - "range for loop"(since C++11)

"jump statement"
- definition: оператор перехода
- is-a
  - "break"
  - "continue"
  - "return"
  - "goto"

"expression statement"
- definition: выражние
- has-a
  - "assignment operation"
  - "relational operation"
  - "arithmetic operation" 
  - "logical operation"
  - "bitwise operation"  

 "relational operation"
- definition: операция отношения  
- is-a
   - "operator =="
   - "operator >"  
   - "operator <" 
   - "operator <="
   - "operator >=" 
   - "operator !=" 

"assignment operation"
- definition: операции присваивания
- is-a
   - "operator =" 
   - "operator -="
   - "operator /="
   - "operator *="
   - "operator %="
   - "operator +="

"arithmetic operation"
- definition: арифметическая операция
- has-a
   - "binary arithmetic operation"
   - "unary arithmetic operation"

"binary arithmetic operation"
- definition: бинарная арифметическая операция
- is-a
   - "operator +"
   - "operator -"
   - "operator /"
   - "operator *"
   - "operator %"

"unary arithmetic operation"
- defiintion: унарная арифметическая операция
- is-a
   - "operator ++"
   - "operator --"

"logical operation"
- definition: логическая операция
- has-a
   - "binary logical operation"
   - "unary logical operation"
   - "ternary logical operation"

"binary logical operation"
- definition: бинарная логическая операция
- is-a
   - "operator &&"
   - "operator ||"

"unary logical operation"
- definition: унарная логическая операция
- is-a
  - "operator !"

"ternary logical operation"
- definition: тернарная логическая операция
- is-a
  - "operator ? : "

"bitwise operation"
- definition: побитовая операция
- has-a
   - "unary bitwise operation"
   - "binary bitwise operation"


"unary bitwise operation"
- definition: унарная побитовая операция
- is-a
   - "operator ~"

"binary bitwise operation"
- definition: бинарная побитовая операция
- is-a 
  - "operator &"
  - "operator |"
  - "operator ^"
  - "operator >>"
  - "operator <<" 
