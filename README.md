# Aula 7

## JPQL

JPQL é um acrônimo para Java Persistence Query Language. Ela definida na especificação JPA. É utilizada principalmente para criar consultas trabalhando com Classes e Objetos.

JPQL é desenvolvido com base na sintaxe SQL. Além disso, a linguagem de consulta permite escrever consultas portáteis que funcionam independentemente do armazenamento de dados subjacente.

A linguagem de consulta permite escrever consultas portáteis que funcionam independentemente do armazenamento de dados subjacente.

## Estrutura dos Comandos de DML aceitos com JPQL

Estrutura do comando SELECT:

![](https://i.ibb.co/HVBpYJx/image.png)

Estrutura dos comandos Update e Delete:

![](https://i.ibb.co/cyYdhDY/image.png)

Observação: o colchete(**[]**) indica elementos opcionais.

## Consultas Nomeadas (Named Query):

Consultas nomeadas (named query), são **consultas estáticas** definidas na entidade. Uma maneira de simplificar e centralizar querys no projeto.

As anotações utilizadas para criar uma consulta nomeada são:

- NamedQueries (agrupar 1 ou mais de 1 named query)
- NamedQuery (define o nome da consulta e a query que será executada)

```sql
@NamedQueries(
    {
        @NamedQuery
        ( 
            name = "jogador.findByAltura", 
            query = "SELECT j FROM Jogador j WHERE j.altura = :altura"
        )
    }
)
@Entity
public class Jogador{
    ...
}
```

Para invocarmos uma consulta nomeada podemos:

- Vamos utiliza o campo **name** da nossa named query, que no caso é: jogador.findByAltura;

```java
public class JogadorRepository {

public JogadorRepository() {}

    public List<Jogador> findByAltura(Double altura){
        EntityManager em = JPAUtil.getFabrica().createEntityManager();
        return em.createNamedQuery("jogador.findByAltura", Jogador.class)
        .setParameter("altura", altura)
        .getResultList();
    }

}
```

Como podemos observar o método **findByAltura** não sabe qual o comando JPQL que ele irá executar. Apenas sabe que deve invocar a consulta: **jogador.findByAltura**;

## Parâmetros nomeados

Podemos passar parâmetros para as nossas consultas, basta na escrita do JPQL adicionarmos dois pontos (:) no nosso nome do parâmetro, por exemplo:

- parâmetro **altura**: ```SELECT j FROM Jogador j WHERE j.altura = :altura```
- parâmetro **sou-um-parametro**: ```SELECT j FROM Jogador j WHERE j.idade = :sou-um-parametro```

Para substituirmos esses parâmetros por valores devemos invocar o método **setParameter** passando o nome do parâmetro e o valor que desejamos atribuir, por exemplo: 

- ```setParameter("altura", 1.89)```
- ```setParameter("sou-um-parametro", 25)```

## Parâmetros posicionais

Você pode usar parâmetros posicionais em vez de parâmetros nomeados em consultas. Os parâmetros posicionais são prefixados com um ponto de interrogação (?) seguido da posição numérica do parâmetro na consulta

- JPQL com 2 parâmetros: ```SELECT j FROM Jogador j WHERE j.idade = ?1 and altura= ?2```
- ```setParameter(1, 25)```
- ```setParameter(2, 1.89)```

Quais as vantagens com relação ao nomeado?

## As interfaces Query e TypedQuery

Com a interface **Query** podemos escrever as nossas consultas com JPQL em métodos em vez escrevermos todas as consultas nas entidades utilizando as consultas nomeadas (Named Query). Por exemplo:

```java
    public Jogador findByCodigo(Integer codigo){
        EntityManager em = JPAUtil.getFabrica().createEntityManager();
        Query jpqlQuery = em().createQuery("SELECT u FROM Jogador u WHERE u.codigo=:codigo");
        jpqlQuery.setParameter("codigo", codigo);
        return (Jogador) jpqlQuery.getSingleResult();
    }
```

Se observarmos o comando de **return**, vamos perceber que foi preciso efetuar um *cast*. 

O JPA não pode deduzir qual será o tipo de resultado da consulta e, portanto, temos que converter explicitamente.

Mas o JPA fornece um subtipo de consulta especial conhecido como **TypedQuery**. 

Isso é sempre preferível se conhecermos nosso tipo de resultado da consulta de antemão. Além disso, torna nosso código muito mais confiável e fácil de testar.

Vamos utilizar a interface **TypedQuery** e no método **createQuery** passamos o tipo que é retornado na consulta.

```java
    public Jogador findByCodigo(Integer codigo){
        EntityManager em = JPAUtil.getFabrica().createEntityManager();
        TypedQuery<Jogador> jpqlQuery = 
        em().createQuery("SELECT u FROM Jogador u WHERE u.codigo=:codigo", Jogador.class);
        jpqlQuery.setParameter("codigo", codigo);
        return jpqlQuery.getSingleResult();
    }
```

## Projeções (Projection)

Quando precisamos de algumas informações da tabela (não desejamos todas as colunas), podemos utilizar as projeções:

```java
    TypedQuery<String> query = manager.createQuery("select nome from Jogador j ", Jogador.class);
    List<Jogador> jogadores = query.getResultList();
```

Projetando mais de 1 coluna:

```java
    TypedQuery<String> query = manager.createQuery("select nome, idade from Jogador j", Object.class);
    List<Object[]> jogadores = query.getResultList();
```

### Utilizando o operador *new*

#### DTO Pattern

DTOs ou Data Transfer Objects são objetos que transportam dados entre processos para reduzir o número de chamadas de métodos.

![](https://i.ibb.co/FJCp2zK/image.png)

Podemos projetar as nossas consultas para trabalhamos com *DTO* em vez de trabalharmos com Array Java (vide exemplo anterior).

#### Projetando para um DTO

Vamos projetar a mesma consulta com JPQL mas para um DTO criado para transportar esses dados:

```
	public List<JogadorDTO> findByAltura(String altura){
        return JPAUtil
        .getFabrica()
        .createEntityManager()
        .createQuery("SELECT new br.com.fuctura.dto.JogadorDTO(j.altura, j.nome) FROM Jogador j where j.altura = :altura", JogadorDTO.class)
        .setParameter("altura", altura)
        .getResultList();
	}
```

Observações:

- Precisamos que o nosso DTO possua um construtor que aceite os valores e tipos de acordo com o resultado da consulta JPQL
- Precisamos utilizar o completo (pacote + nome da classe) quando formos utilizar o operador *new*

## Consultas Nativas

Uma **NativeQuery** é simplesmente uma consulta SQL. Isso nos permite liberar todo o poder do nosso banco de dados, pois podemos usar recursos proprietários não disponíveis na sintaxe restrita ao JPQL.

```
    ...
    return JPAUtil
        .getFabrica()
        .createEntityManager()
        .createNamedQuery("select * from tb_jogador where altura = :altura", Jogador.class)
        .setParameter("altura", altura)
        .getResultList();
```