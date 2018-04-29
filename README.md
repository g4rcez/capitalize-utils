# capitalize-utils
A little Java class to capitalize strings like text-transform in CSS

1. pt-br
2. en-us

## Introdução

Em uma conversa com [O Bermuda](https://github.com/GabrielRodriguesS), ele disse que não havia uma anotação ou um método em **StringUtils**
no [Spring](https://spring.io) que fizesse com que "A Primeira Letra De Cada Palavra Fosse Maiúscula", o que é conhecido por
**capitalize**. Como vim de frontend, isso era algo banal, pois em CSS temos o 'text-transform: capitalize' e pensei que era algo
comum em quaisquer linguagens ou frameworks. 

Para a surpresa, a biblioteca StringUtils possui um método capitalize que apenas transforma apenas o primeiro caractere para maiúsculo, o que
não nos é útil para o seguinte problema: 

> Arrumar nomes para a inserção no banco de dados: fulano da silva sauro => deve virar => Fulano da Silva Sauro

Como em iniciei um projeto para [geração de relatórios em testes de segurança](https://github.com/vandalvnl/report-sec) e era necessário o nome,
eu já havia feito algo para resolver o problema e passei ao meu amigo [O Bermuda](https://github.com/GabrielRodriguesS). Por influência dele,
tentei reescrever o código usando Lambda Expression e classe Optional para validar o tão temido NullPointerException, mas...
**O código com Lambda Expression ficou mais lento do que a maneira antiga** e eu 're re'escrevi o código, conseguindo performance equivalente 
ou superior a forma antiga. E agora vou testar diversos nomes afim de descobrir a melhor implementação

## Código exemplo

```java
String nomeCompleto = "fuLaNO Costa E Pinto da siLva lIMA de Beltrano";
System.out.println(Capitalize.capitalizeByWords(nomeCompleto));
// Fulano Costa E Pinto Da Silva Lima De Beltrano

// Putz cara, não é isso que eu quero, olha o Da, De, E que coisa feia...

System.out.println(Capitalize.brazillianCapitalize(nomeCompleto));
// Fulano Costa e Pinto da Silva Lima de Beltrano
// Agora sim, Selo Hipster de Qualidade
```
