# Atividade 2

## Especificação da Calculadora Fuctura

Nesta atividade vocês deve implementar uma especificação de uma calculadora chamada CalculadoraSpec.

Foi especificado que para ser uma calculadora do tipo FucturaCal é necessário os seguintes métodos:

- int somar(int a, int b)
- int substrair(int a, int b)
- int multiplicar(int a, int b)
- int dividir(int a, int b)
- int raizQuadrada(int a)

## Atividade 2.1

- **Crie um novo projeto Java**
- **Crie uma classe chamada SeuNomeSobrenomeCalculadora**
- **Implemente a interface br.com.fuctura.CalculadoraSpec disponível no arquivo fucturaCalc.jar**

Para implementar uma interface você deve utilizar a palavra **implements**, por exemplo:

```java
    public SeuNomeSobrenomeCalculadora implements CalculadoraSpec {

    }
```

O Eclipse irá informar que você precisa definir alguns métodos não implementados (sua classe ficará sublinhada).

Clique no botão do lado esquerdo e escolha: **add unimplemented methods.**

- **Implemente as 5 operações matemáticas solicitadas.**

- **Para finalizar empacote seu projeto em um arquivo JAR e envie no grupo.**

### Se tiver difuldades você pode visualizar o gabarito utilizando o link abaixo: https://drive.google.com/file/d/1f0XmGYfdrz-jcOx3BuofBVFJijW2USma/view?usp=sharing

## Atividade 2.2

Podemos salvar dados na nossa tabela através do comando **insert**, por exemplo:

```sql
    --cria a tabela clube
    create table clube(nome varchar(255), nmPresidente varchar(255), dtFundacao varchar(10),site varchar(255));
    
    --salva 1 clube na tabela
    insert into clube values('Sport Clube do Recife', 'Leonardo Lopes', '13/05/1905', 'https://sportrecife.com.br/');
```

- Crie um script de povoamento que insere: 2 jogadores e 2 clubes
- Salve o script no formato: nomeSobrenome.sql
- Envie no grupo o seu script

### Se tiver difuldades você pode consultar o arquivo: gabarito.sql