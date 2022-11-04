"template"
- definition: Шаблон - это функция языка программирования C++, которая позволяет функциям или классам работать с различными типами данных, не переписывая код для каждого из них.
- has-a
  - "class template"
  - "function template"
  - "alias template"
  - "variable template"

"class template"
- definition: Шаблон класса позволяет задать универсальный тип для объектов, используемых в классе.
- has-a
  - "explicit instantiation"
  - "implicit instantiation"
- capable-of
  - "type arguments"
  - "non-type parameter"
  - "template arguments"
  - "nested classes"
  - "member templates"
  - "alias template"
  - "explicit template specialization"

"function template"
- definition: Шаблон функции позволяет задать универсальный тип для аргумента функции.
- has-a
  - "explicit instantiation"
  - "implicit instantiation"
- capable-of
  - "type arguments"
  - "non-type parameter"
  - "template arguments"
  - "template argument deduction"
  - "template argument substitution"
  - "alias template"
  - "overloading"
  - "explicit template specialization"
  - "member templates"

"variable template"
- definition: Шаблон переменной определяет семейство переменных (когда объявлено в области пространства имен) или семейство статических элементов данных (когда определено в области класса).
- is-a
  - "member templates"
- capable-of
  - "alias template"
  - "explicit template specialization"

"alias template"
- definition: Псевдоним типа - имя, которое ссылается на ранее определенный тип.
- similar-to:
  - "typedef"

"explicit template specialization"
- definition: Позволяет изменять код шаблона для заданного набора аргументов шаблона.
- capable-of
  - "template argument deduction"

"explicit instantiation"
- definition: Вы можете использовать явное создание экземпляра для создания экземпляра класса или функции без использования его в коде.
- antonym
  - "implicit instantiation"

"implicit instantiation"
- definition: Если специализация шаблона не была явно создана или явно специализирована, компилятор сгенерирует специализацию для шаблона только тогда, когда ему потребуется определение.
- antonym
  - "explicit instantiation"

"non-type parameter"
- definition: Аргумент шаблона, не относящийся к типу, обычно используется для инициализации класса или для указания размеров членов класса.

"template arguments"
- definition: Параметром шаблона может быть другой шаблон.

"type arguments"
- definition: Каждый шаблон параметризуется одним или несколькими параметрами шаблона.

"overloading"
- definition: Позволяет указать более одной функции с одинаковым именем в одной и той же области.

"member templates"
- definition: Объявления шаблонов, внутри спецификации элемента любого класса, структуры или объединения.

"template argument deduction"
- definition: Способность компилятора выводить отсутствующие аргументы шаблона из аргументов функции.

"template argument substitution"
- definition: Позволяет несколькими способами манипулировать наборами перегрузок.