package nio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Java N-IO — Leitura e Escrita de Arquivos
 *
 * Conceitos:
 * - Java IO clássico (OutputStream / InputStream)
 * - Java NIO.2 (Path, Paths, Files)
 * - Layout delimitado (CSV com ;)
 * - Layout posicional (comprimento fixo por coluna)
 */
public class JavaNIO {

    // Diretório onde os arquivos serão salvos (pasta do projeto)
    private static final String DIR = System.getProperty("user.home") + "/rocketseat-arquivos/";

    public static void main(String[] args) throws IOException {

        // Garante que o diretório existe
        Files.createDirectories(Paths.get(DIR));

        // ================================================
        // 1. Java IO — OutputStream (escrita clássica)
        // ================================================
        System.out.println("=== Java IO — OutputStream ===");

        String conteudo = "Hoje aprendemos sobre Java IO - OutputStream e escrita em arquivo!";
        File arquivo = new File(DIR, "aula-java-io.txt");

        try (FileOutputStream output = new FileOutputStream(arquivo)) {
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            byteOutput.write(conteudo.getBytes());
            byteOutput.writeTo(output);
        }
        System.out.println("Arquivo escrito: " + arquivo.getAbsolutePath());

        // ================================================
        // 2. Java IO — InputStream (leitura clássica)
        // ================================================
        System.out.println("\n=== Java IO — InputStream ===");

        try (InputStream inputStream = new FileInputStream(arquivo)) {
            int caractere;
            StringBuilder lido = new StringBuilder();
            while ((caractere = inputStream.read()) != -1) {
                lido.append((char) caractere);
            }
            System.out.println("Conteúdo lido: " + lido);
        }

        // ================================================
        // 3. Java NIO.2 — Escrita e Leitura simplificada
        // ================================================
        System.out.println("\n=== Java NIO.2 — Simples ===");

        Path pathOrigem  = Paths.get(DIR, "aula-java-io.txt");
        Path pathDestino = Paths.get(DIR, "aula-java-nio-copy.txt");

        byte[] bytesArquivo = Files.readAllBytes(pathOrigem);
        String conteudoNIO  = new String(bytesArquivo);
        System.out.println("Lido com NIO: " + conteudoNIO);

        Files.write(pathDestino, bytesArquivo);
        System.out.println("Copiado para: " + pathDestino);

        // ================================================
        // 4. Escrevendo várias linhas (lista de contatos)
        // ================================================
        System.out.println("\n=== NIO — Escrita de múltiplas linhas ===");

        List<String> contatos = new ArrayList<>();
        contatos.add("(83) 2148-5886 Joemia Giron Lyrio Monnerat");
        contatos.add("(21) 2705-6726 Reginaldo Folly Barboza Brito");
        contatos.add("(91) 2416-8455 Mariza Gadelha Bastida Carneiro");
        contatos.add("(68) 3259-8389 Mirian Venancio Portela Ignacia");

        Path arquivoContatos = Paths.get(DIR, "lista-contatos.txt");

        for (String linha : contatos) {
            String linhaComQuebra = linha + System.lineSeparator();
            Files.write(arquivoContatos,
                    linhaComQuebra.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }
        System.out.println("Contatos escritos em: " + arquivoContatos);

        // Lendo de volta
        List<String> linhasLidas = Files.readAllLines(arquivoContatos);
        System.out.println("\nContatos lidos:");
        for (String linha : linhasLidas) {
            System.out.println("  " + linha);
        }

        // ================================================
        // 5. Layout DELIMITADO (CSV com ;)
        // ================================================
        System.out.println("\n=== Layout Delimitado (CSV) ===");

        List<Cadastro> cadastros = criarCadastros();

        Path arquivoDelimitado = Paths.get(DIR, "contatos-delimitado.csv");
        escreverDelimitado(cadastros, arquivoDelimitado);
        List<Cadastro> lidos = lerDelimitado(arquivoDelimitado);

        System.out.println("\nCadastros lidos do CSV:");
        for (Cadastro c : lidos) {
            System.out.println("  " + c);
        }

        // ================================================
        // 6. Layout POSICIONAL (comprimento fixo)
        // ================================================
        System.out.println("\n=== Layout Posicional ===");

        Path arquivoPosicional = Paths.get(DIR, "contatos-posicional.txt");
        escreverPosicional(cadastros, arquivoPosicional);
        List<Cadastro> lidosPosicional = lerPosicional(arquivoPosicional);

        System.out.println("\nCadastros lidos do posicional:");
        for (Cadastro c : lidosPosicional) {
            System.out.println("  " + c);
        }

        System.out.println("\n✅ Todos os arquivos foram criados em: " + DIR);
    }

    // ================================================
    // LAYOUT DELIMITADO
    // ================================================
    static void escreverDelimitado(List<Cadastro> cadastros, Path destino) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        for (Cadastro c : cadastros) {
            conteudo.append(c.getNome()).append(";");
            conteudo.append(c.getSexo()).append(";");
            conteudo.append(c.getTelefone()).append(";");
            conteudo.append(c.getDataNascimento()).append(";");
            conteudo.append(c.getValorSugerido()).append(";");
            conteudo.append(c.isCliente());
            conteudo.append(System.lineSeparator());
        }
        System.out.println("-- Conteúdo delimitado --\n" + conteudo);
        Files.write(destino, conteudo.toString().getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    static List<Cadastro> lerDelimitado(Path origem) throws IOException {
        List<Cadastro> cadastros = new ArrayList<>();
        for (String linha : Files.readAllLines(origem)) {
            String[] col = linha.split(";");
            cadastros.add(new Cadastro(
                col[0],
                col[1],
                Long.valueOf(col[2]),
                LocalDate.parse(col[3]),
                Double.valueOf(col[4]),
                Boolean.valueOf(col[5])
            ));
        }
        return cadastros;
    }

    // ================================================
    // LAYOUT POSICIONAL
    // Nome(30) | Sexo(1) | Telefone(10) | Aniversário(10) | Valor(7) | Cliente(1)
    // ================================================
    static void escreverPosicional(List<Cadastro> cadastros, Path destino) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        DecimalFormat decFmt = new DecimalFormat("#0000.00");

        for (Cadastro c : cadastros) {
            String nome = c.getNome().length() > 30
                    ? c.getNome().substring(0, 30)
                    : String.format("%-30s", c.getNome());  // preenche com espaços à direita

            conteudo.append(nome);
            conteudo.append(c.getSexo().toUpperCase());
            conteudo.append(c.getTelefone());
            conteudo.append(c.getDataNascimento());

            String valor = decFmt.format(c.getValorSugerido()).replace(",", ".");
            conteudo.append(valor);
            conteudo.append(c.isCliente() ? "1" : "0");
            conteudo.append(System.lineSeparator());
        }
        System.out.println("-- Conteúdo posicional --\n" + conteudo);
        Files.write(destino, conteudo.toString().getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    static List<Cadastro> lerPosicional(Path origem) throws IOException {
        List<Cadastro> cadastros = new ArrayList<>();
        for (String linha : Files.readAllLines(origem)) {
            String nome           = linha.substring(0, 30).trim();
            String sexo           = linha.substring(30, 31);
            Long telefone         = Long.valueOf(linha.substring(31, 41));
            LocalDate nascimento  = LocalDate.parse(linha.substring(41, 51));
            Double valor          = Double.valueOf(linha.substring(51, 58));
            boolean cliente       = linha.substring(58, 59).equals("1");
            cadastros.add(new Cadastro(nome, sexo, telefone, nascimento, valor, cliente));
        }
        return cadastros;
    }

    // ================================================
    // DADOS DE EXEMPLO
    // ================================================
    static List<Cadastro> criarCadastros() {
        List<Cadastro> lista = new ArrayList<>();
        lista.add(new Cadastro("Joemia Giron Lyrio Monnerat", "F", 8321485886L,
                LocalDate.of(1984, 6, 30), 35.0, false));
        lista.add(new Cadastro("Reginaldo Folly Barboza Brito", "M", 2127056726L,
                LocalDate.of(1990, 3, 17), 40.0, true));
        lista.add(new Cadastro("Mariza Gadelha Bastida Carneiro", "F", 9124168455L,
                LocalDate.of(1989, 8, 18), 40.0, false));
        lista.add(new Cadastro("Mirian Venancio Portela Ignacia", "M", 6832598389L,
                LocalDate.of(1975, 11, 21), 29.0, true));
        return lista;
    }
}

// ---- Classe Cadastro ----
class Cadastro {
    private String    nome;
    private String    sexo;
    private Long      telefone;
    private LocalDate dataNascimento;
    private Double    valorSugerido;
    private boolean   cliente;

    public Cadastro(String nome, String sexo, Long telefone,
                    LocalDate dataNascimento, Double valorSugerido, boolean cliente) {
        this.nome           = nome;
        this.sexo           = sexo;
        this.telefone       = telefone;
        this.dataNascimento = dataNascimento;
        this.valorSugerido  = valorSugerido;
        this.cliente        = cliente;
    }

    public String    getNome()           { return nome; }
    public String    getSexo()           { return sexo; }
    public Long      getTelefone()       { return telefone; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public Double    getValorSugerido()  { return valorSugerido; }
    public boolean   isCliente()         { return cliente; }

    @Override
    public String toString() {
        return nome + " | " + sexo + " | " + telefone
            + " | " + dataNascimento + " | R$" + valorSugerido
            + " | cliente=" + cliente;
    }
}
