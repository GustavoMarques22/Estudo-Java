# 🚀 Formação Java

Exercícios de Java organizados por módulo, do básico ao intermediário.

## 📁 Módulos

- **sintaxe** — anatomia de classes, variáveis, operadores, comentários, JavaBeans, modificadores de acesso
- **controlefluxo** — condicionais, laços de repetição, tratamento de exceções
- **poo** — classes/objetos, enums, pacotes, `==` vs `equals()`
- **javatime** — API de datas (LocalDate, LocalTime, Instant, Period, Duration)
- **nio** — leitura e escrita de arquivos (IO e NIO.2)

## ▶️ Como executar

**IDE:** abra `meu-programa/` como projeto, marque `src/` como Sources Root e dê Run na classe desejada.

**Terminal:**
```bash
javac -d out -sourcepath src src/meu-programa/<caminho>/<Classe>.java
java -cp out meu-programa.<caminho>.<Classe>
```

## 📚 Ordem sugerida de estudo

1. sintaxe → 2. controlefluxo → 3. poo → 4. javatime → 5. nio
