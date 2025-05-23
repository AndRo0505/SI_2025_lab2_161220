Име: Андреј 
Презиме: Петрушевски  
Индекс: 161220  

## Цикломатска комплексност

Цикломатската комплексност (McCabe Complexity) се пресметува со формулата:

M = број на предикати + 1

Во функцијата `checkCart`, ги имаме следниве предикати:

1. `if (allItems == null)`
2. `for (item : allItems)`
3. `if (item.getName() == null || item.getName().length() == 0)`
4. `if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)`
5. `if (item.getDiscount() > 0)`
6. `if (cardNumber != null && cardNumber.length() == 16)`
7. `for (char c : cardNumber)`
8. `if (allowed.indexOf(c) == -1)`

Вкупно: 8 услови  
Значи: M = 8 + 1 = 9

Цикломатската комплексност на функцијата `checkCart` е 9, што значи дека има 9 независни патеки низ кодот.
