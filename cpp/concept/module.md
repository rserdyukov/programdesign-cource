"module"
- ru-identifier: модуль
- en-identifier: module
- en-defenition: A module is a set of source code files that are compiled independently of the translation units that import them. Modules eliminate or reduce many of the problems associated with the use of header files. 
- ru-defenition: Модуль - это набор файлов исходного кода, которые компилируются независимо от единиц перевода, которые их импортируют. Модули устраняют или уменьшают многие проблемы, связанные с использованием файлов заголовков.

- has-a
    -"Module declarations"
    -"Exporting module declarations and definitions"
    -"Importing modules and headers"
    -"Global module fragment"
    -"Private module fragment"
    -"Module partitions"
    -"Module ownership"

- is-a
    -"C++20"
---
"Module declarations"

- ru-identifier: объявление модуля
- en-edintifier: module declaration
- en-defenition: Translation units may have a module declaration, in which case they are considered module unit. The module declaration, if provided, must be the first declaration of the translation unit. Each module unit is associated to a module name (and optionally a partition), provided in the module declaration.
- ru-defenition: Единицы перевода могут иметь объявление модуля, и в этом случае они считаются модульной единицей. Объявление модуля, если оно предусмотрено, должно быть первым объявлением единицы перевода. Каждый модульный блок связан с именем модуля (и, необязательно, с разделом), указанным в объявлении модуля

---
"Exporting module declarations and definitions"
 - ru-edentifier: 
 - en-identifier:
 - en-defenition:
 - ru-defenition: 

- is-a
    - "import modules"
    - "import headers"
---
"Importing modules and headers"
 - ru-edentifier: 
 - en-identifier:
 - en-defenition:
 - ru-defenition: 
 ---
 "Global module fragment"
 - ru-edentifier: глобальный модуль
 - en-identifier: global module fragment
 - en-defenition: Module unit can be prefixed by a global module fragment, which can be used to include headers when importing them is not possible (notably when the header uses preprocessing macros as configuration).
 - ru-defenition: Блок модуля может иметь префикс глобального фрагмента модуля, который может использоваться для включения заголовков, когда их импорт невозможен (особенно, когда заголовок использует макросы предварительной обработки в качестве конфигурации).
 ---
 "Private module fragment"
- ru-edentifier: private module
- en-identifier: private модуль
- en-defenition:Primary module interface unit can be suffixed by a private module fragment, which allows a module to be represented as a single translation unit without making all of the contents of the module reachable to importers.
- ru-defenition:Основной модуль может быть дополнен фрагментом частного модуля, что позволяет представлять модуль как единую единицу перевода, не делая все содержимое модуля доступным для импорта.
---
"Module partitions"
- ru-identifier: модуль-блок
- en-identifier: modular blocks
- en-defenition: Module can be divided into blocks. These are modular blocks whose module declarations include a module section that starts with a colon : and is placed after the module name.
- ru-defenition: Модуль может быть разделен на блоки. Это модульные блоки, объявления модулей которых включают раздел модуля, который начинается с двоеточия : и помещается после имени модуля.
---
"Module ownership"
- ru-identifier: принадлежность к модулю
- en-identifier; module ownership
- en-defenition: In general, if a declaration appears after the module declaration in a module unit, it is attached to that module.
If a declaration of an entity is attached to a named module, that entity can only be defined in that module. All declarations of such an entity must be attached to the same module.
- ru-defenition: В общем случае, если объявление объекта  и прочего появляется после объявления модуля оно прикрепляется к этому модулю.
Если объявление объекта прикреплено к именованному модулю, этот объект может быть определена только в этом модуле. Все объявления такого объекта должны быть прикреплены к одному и тому же модулю.