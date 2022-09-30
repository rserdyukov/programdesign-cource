
"namespace"
- ru-identifier: пространство имен
- en-identifier: namespace
- en-defenition: A namespace is a declarative region that provides a scope to the identifiers (the names of types, functions, variables, etc) inside it.
- ru-defenition: Пространство имен — это декларативная область, в рамках которой определяются различные идентификаторы (имена типов, функций, переменных, и т. д.).
- has-a
    - "Inline namespace"
    - "Unnamed namespace"
    - "Using-declarations"
    - "Using-directives"

---
"Inline namespaces"
- ru-idetifier: Вложенное пространство имен
- en-identifier: inline namespace
- en-defenition: An inline namespace is a namespace that uses the optional keyword inline in its original-namespace-definition.
- ru-defenition: Вложенное пространство имен - это пространство имен, которое использует необязательное ключевое слово inline в своем исходном определении пространства имен.

---
"Unnamed namespaces"
- ru-identifier: Безымянное пространство имен
- en-identifier: Unnamed namespace
- en-defenition: An unnamed namespace is a namespace that is defined without a name.
- ru-defenition: Безымянное пространство имен - это пространство имен, которое определено без имени.

---
"Using-declarations"
- ru-identifier: использование объявления.
- en-identifier: using declaration
- en-defenition: Introduces a name that is defined elsewhere into the declarative region where this using-declaration appears.
- ru-defenition: Вводит имя, определенное в другом месте, в декларативную область, где появляется это объявление об использовании.

- is-a
    - "inside other namespace"
    - "namespace extention"
---
"Using-directives"
- ru-identifier: использование директив
- en-identifier: using derectives
- en-defenition: A using directive provides access to all namespace qualifiers and the scope operator. This is accomplished by applying the using keyword to a namespace identifier.
- ru-defenition: Директива using предоставляет доступ ко всем квалификаторам пространства имен и оператору области видимости. Это достигается путем применения ключевого слова using к идентификатору пространства имен.