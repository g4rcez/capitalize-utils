# capitalize-utils

A little Java class to capitalize strings like text-transform in CSS

1.  pt-br
2.  en-us, only _how to use_

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

---

## Using Capitalize

To use Capitalize methods, only add the dependency on your project and write some code. Capitalize have
five methods (for hour) to capitalize your strings:

**Warning: All simbols, except '.' (dot) are convert to \*Case in methods. This warning is because the files have extension, and dot broke the chain of string in Sneak, Slug and CamelCase**

* Capitalize.capitalizeByWords(String): This method capitalize every word in String, splitting by tab(\t) and space(" "). I decide create this method to fix brazilian names, because the names on web forms are scary, but this method don't resolve all cases in brazilian names

```java
String nomeCompleto = "fuLaNO Costa E Pinto da siLva lIMA de Beltrano";
System.out.println(Capitalize.capitalizeByWords(nomeCompleto));
// Fulano Costa E Pinto Da Silva Lima De Beltrano
```

* Capitalize.brazilianCapitalize(String): The same case of capitalizeByWords, but replace some cases of 'conectores' (connectors in english) to correctly way:

```java
String nomeCompleto = "fuLaNO Costa E Pinto da siLva lIMA de Beltrano";
System.out.println(Capitalize.brazillianCapitalize(nomeCompleto));
// Fulano Costa e Pinto da Silva Lima de Beltrano
```

* Capitalize.toPascalCase(String): _I don't research much to .\*Case, but I know this .\*Case as PascalCase_. The first letter of all words are capitalize and spaces and simbols are converted to none(""):

```java
String name = "FULANO DA SILVA SAURO de moura";
System.out.println(Capitalize.toPascalCase(name))
// FulanoDaSilvaSauroDeMoura
```

* Capitalize.toCamelCase(String): _Same warn of toPascalCase_. Only first word of string are not capitalized.

```java
String name = "FULANO DA SILVA SAURO de moura";
System.out.println(Capitalize.toPascalCase(name))
// fulanoDaSilvaSauroDeMoura
```

* Capitalize.toSneakCase(String): _Same warn of toPascalCase_. Convert spaces, simbols and other cases do sneak_case.

```java
String name = "FULANO DA SILVA SAURO de moura";
System.out.println(Capitalize.toPascalCase(name))
// fulano_da_silva_sauro_de_moura
```

* Capitalize.toSlugCase(String): _Same warn of toPascalCase_. Convert spaces, simbols and other cases do slug-case.

```java
String name = "FULANO DA SILVA SAURO de moura";
System.out.println(Capitalize.toPascalCase(name))
// fulano-da-silva-sauro-de-moura
```
