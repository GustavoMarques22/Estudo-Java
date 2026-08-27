# 🚀 Formação Java

Projeto com todos os exercícios organizados por módulo.

---

## 📁 Estrutura do Projeto

```
src/
└── meu-programa/
    │
    ├── sintaxe/
    │   ├── aula01_anatomia/
    │   │   └── MinhaContaCorrente.java     ← Classes, atributos, métodos, main
    │   ├── aula02_variaveis/
    │   │   └── TiposEVariaveis.java        ← Primitivos, Wrappers, casting, constantes
    │   ├── aula03_operadores/
    │   │   └── Operadores.java             ← Atribuição, aritm., relac., unários, ternário, lógicos
    │   ├── aula04_comentarios/
    │   │   └── Calculadora.java            ← Comentários //, /* */, Javadoc
    │   ├── aula05_javabeans/
    │   │   ├── Aluno.java                  ← private, getters, setters, this, construtores
    │   │   └── Escola.java                 ← Uso da classe Aluno
    │   └── aula06_modificadores/
    │       ├── Cozinheiro.java             ← public, private, default
    │       └── Lanchonete.java             ← Demonstração do encapsulamento
    │
    ├── controlefluxo/
    │   ├── aula01_condicionais/
    │   │   └── Condicionais.java           ← if, else, encadeado, ternário, switch/case
    │   ├── aula02_repeticao/
    │   │   └── Repeticao.java              ← for, for-each, while, do-while, break, continue
    │   └── aula03_excecoes/
    │       ├── Excecoes.java               ← try/catch/finally, múltiplos catch, throws
    │       └── CepInvalidoException.java   ← Exceção customizada
    │
    ├── poo/
    │   ├── aula01_classes/
    │   │   └── ClassesEObjetos.java        ← Instâncias, Enum, referências
    │   ├── aula02_pacotes/
    │   │   └── PacotesEImportacoes.java    ← package, import, exercício lista de amigos
    │   └── aula03_equals/
    │       └── EqualsVsIgualIgual.java     ← == vs equals(), hashCode, override
    │
    ├── javatime/
    │   └── JavaTime.java                   ← LocalDate, LocalTime, LocalDateTime,
    │                                          Instant, Period, Duration, transformações
    │
    └── nio/
        └── JavaNIO.java                    ← IO clássico, NIO.2, CSV delimitado, posicional
```

---

## ▶️ Como Executar

### IntelliJ IDEA / Eclipse
1. Abra a pasta `meu-programa/` como projeto Java
2. Certifique-se que o `src/` é marcado como **Sources Root**
3. Clique com o botão direito na classe desejada → **Run**

### Terminal (linha de comando)
```bash
# Compilar
javac -d out -sourcepath src src/meu-programa/sintaxe/aula01_anatomia/MinhaContaCorrente.java

# Executar
java -cp out meu-programa.sintaxe.aula01_anatomia.MinhaContaCorrente
```

---

## 📚 Ordem de Estudo

| # | Pacote | Classe | Conteúdo |
|---|--------|--------|----------|
| 1 | `sintaxe.aula01_anatomia` | `MinhaContaCorrente` | Anatomia de classes |
| 2 | `sintaxe.aula02_variaveis` | `TiposEVariaveis` | Tipos primitivos e Wrappers |
| 3 | `sintaxe.aula03_operadores` | `Operadores` | Todos os operadores |
| 4 | `sintaxe.aula04_comentarios` | `Calculadora` | Comentários e Javadoc |
| 5 | `sintaxe.aula05_javabeans` | `Escola` | Getters, Setters, construtores |
| 6 | `sintaxe.aula06_modificadores` | `Lanchonete` | public, private, default |
| 7 | `controlefluxo.aula01_condicionais` | `Condicionais` | if/else, switch |
| 8 | `controlefluxo.aula02_repeticao` | `Repeticao` | for, while, do-while |
| 9 | `controlefluxo.aula03_excecoes` | `Excecoes` | try/catch, exceções customizadas |
| 10 | `poo.aula01_classes` | `ClassesEObjetos` | Classes, objetos, Enum |
| 11 | `poo.aula02_pacotes` | `PacotesEImportacoes` | Pacotes, imports |
| 12 | `poo.aula03_equals` | `EqualsVsIgualIgual` | == vs equals() |
| 13 | `javatime` | `JavaTime` | API de datas completa |
| 14 | `nio` | `JavaNIO` | Leitura e escrita de arquivos |
