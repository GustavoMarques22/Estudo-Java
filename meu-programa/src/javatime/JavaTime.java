package javatime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Java Time — Completo
 *
 * Conceitos:
 * - LocalDate:     data sem hora
 * - LocalTime:     hora sem data
 * - LocalDateTime: data + hora
 * - Instant:       ponto exato na linha do tempo
 * - Period:        diferença entre datas (anos, meses, dias)
 * - Duration:      diferença entre horas (segundos, nanos)
 * - DateTimeFormatter: formatação customizada
 * - Transformações entre os tipos
 */
public class JavaTime {

    public static void main(String[] args) {

        // ================================================
        // 1. LocalDate
        // ================================================
        System.out.println("=== LocalDate ===");

        // Instanciação
        LocalDate hoje       = LocalDate.now();
        LocalDate dataDe2023 = LocalDate.of(2023, 1, 12);
        LocalDate comEnum    = LocalDate.of(2023, Month.JANUARY, 12);

        System.out.println("Hoje:       " + hoje);
        System.out.println("De 2023:    " + dataDe2023);
        System.out.println("Com enum:   " + comEnum);

        // Parse de String
        String stringData = "2023-01-17";
        LocalDate dataDaString = LocalDate.parse(stringData);
        System.out.println("Da String:  " + dataDaString);

        // Parse de String no formato brasileiro
        String dataBr = "17/01/2023";
        DateTimeFormatter formatterBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataBrasileira = LocalDate.parse(dataBr, formatterBr);
        System.out.println("Formato BR: " + dataBrasileira);

        // Manipulação
        System.out.println("\n-- Manipulação --");
        LocalDate aniversario = LocalDate.of(2010, 5, 3);
        LocalDate quinzeAnos = aniversario.plusYears(15);
        System.out.println("Aniversário:     " + aniversario);
        System.out.println("Fará 15 anos em: " + quinzeAnos);
        System.out.println("Mês que vem:     " + hoje.plusMonths(1));
        System.out.println("Semana passada:  " + hoje.minusWeeks(1));

        // Comparação
        System.out.println("\n-- Comparação --");
        LocalDate data1 = LocalDate.of(2023, 3, 4);
        LocalDate data2 = LocalDate.of(2024, 4, 3);
        System.out.println("data2 isAfter  data1 → " + data2.isAfter(data1));
        System.out.println("data2 isBefore data1 → " + data2.isBefore(data1));
        System.out.println("data2 isEqual  data1 → " + data2.isEqual(data1));

        // Formatação
        System.out.println("\n-- Formatação --");
        LocalDate dataFormatada = LocalDate.of(2023, 1, 13);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("ISO:            " + dataFormatada);
        System.out.println("dd/MM/yyyy:     " + dataFormatada.format(fmt));
        System.out.println("FULL  (BR):     " + dataFormatada.format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("pt","BR"))));
        System.out.println("MEDIUM (US):    " + dataFormatada.format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US)));

        // Dados específicos
        System.out.println("\n-- Dados Específicos --");
        System.out.println("getDayOfMonth(): " + hoje.getDayOfMonth());
        System.out.println("getMonth():      " + hoje.getMonth());
        System.out.println("getMonthValue(): " + hoje.getMonthValue());
        System.out.println("getYear():       " + hoje.getYear());
        System.out.println("getDayOfWeek():  " + hoje.getDayOfWeek());

        // ================================================
        // 2. LocalTime
        // ================================================
        System.out.println("\n=== LocalTime ===");

        LocalTime agora              = LocalTime.now();
        LocalTime horaEspecifica     = LocalTime.of(13, 21, 42);
        LocalTime semSegundo         = LocalTime.of(13, 21);
        LocalTime daString           = LocalTime.parse("13:21:42");
        DateTimeFormatter fmtHora    = DateTimeFormatter.ofPattern("HHmmss");
        LocalTime semSeparador       = LocalTime.parse("132142", fmtHora);

        System.out.println("Agora:          " + agora);
        System.out.println("13:21:42:       " + horaEspecifica);
        System.out.println("Sem segundo:    " + semSegundo);
        System.out.println("Da string:      " + daString);
        System.out.println("Sem separador:  " + semSeparador);

        // Manipulação
        LocalTime maisTrintaMin  = agora.plusMinutes(30);
        LocalTime menosDuasHoras = agora.minusHours(2);
        System.out.println("\nAgora + 30 min: " + maisTrintaMin);
        System.out.println("Agora - 2h:     " + menosDuasHoras);

        // Comparação
        System.out.println("\nisBefore (agora < agora-2h): " + agora.isBefore(menosDuasHoras));

        // Formatação
        LocalTime hora = LocalTime.of(13, 21, 42);
        DateTimeFormatter fmtInvertido = DateTimeFormatter.ofPattern("ss-mm-HH");
        System.out.println("Formato ss-mm-HH: " + hora.format(fmtInvertido)); // 42-21-13

        // Dados específicos
        System.out.println("\ngetHour():   " + hora.getHour());
        System.out.println("getMinute(): " + hora.getMinute());
        System.out.println("getSecond(): " + hora.getSecond());
        System.out.println("getNano():   " + hora.getNano());

        // ================================================
        // 3. LocalDateTime
        // ================================================
        System.out.println("\n=== LocalDateTime ===");

        LocalDateTime dataHora  = LocalDateTime.of(2023, 6, 25, 16, 25);
        LocalDateTime comSeg    = LocalDateTime.of(2023, 6, 25, 16, 25, 33);
        LocalDateTime agoraDT   = LocalDateTime.now();

        System.out.println("Com minuto:  " + dataHora);
        System.out.println("Com segundo: " + comSeg);
        System.out.println("Agora:       " + agoraDT);

        // Manipulação
        System.out.println("\nProximo mês:      " + dataHora.plusMonths(1));
        System.out.println("Menos 15 min:     " + dataHora.minusMinutes(15));
        System.out.println("Definindo seg 33: " + dataHora.withSecond(33));

        // Comparação
        LocalDateTime dh1 = LocalDateTime.of(2023, 6, 25, 16, 25);
        LocalDateTime dh2 = LocalDateTime.of(2023, 6, 25, 16, 25, 17);
        System.out.println("\ndh1.equals(dh2): " + dh1.equals(dh2));   // false (dh2 tem segundos)
        System.out.println("Mesmo dia? " + (dh1.getDayOfMonth() == dh2.getDayOfMonth())); // true

        // Formatação
        DateTimeFormatter fmtDT = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        System.out.println("Formatado: " + LocalDateTime.of(2023, 7, 22, 17, 33).format(fmtDT));

        // ================================================
        // 4. Instant
        // ================================================
        System.out.println("\n=== Instant ===");

        long milisegundos = 1678713480000L;
        Instant instantDeMilis = Instant.ofEpochMilli(milisegundos);
        Instant instantDeSegs  = Instant.ofEpochSecond(milisegundos / 1000);
        Instant instantAgora   = Instant.now();
        Instant instantParsed  = Instant.parse("1984-08-13T10:15:30.345Z");

        System.out.println("De milissegundos:  " + instantDeMilis);
        System.out.println("De segundos:       " + instantDeSegs);
        System.out.println("Agora:             " + instantAgora);
        System.out.println("Parsed:            " + instantParsed);

        // Manipulação
        System.out.println("\n-- Manipulação de Instant --");
        System.out.println("+10s:  " + instantParsed.plusSeconds(10));
        System.out.println("-15s:  " + instantParsed.minusSeconds(15));
        System.out.println("+10d:  " + instantParsed.plus(10, ChronoUnit.DAYS));
        System.out.println("-3h:   " + instantParsed.minus(3, ChronoUnit.HOURS));
        System.out.println("+5d (Period): " + instantParsed.plus(Period.ofDays(5)));

        // Comparação
        System.out.println("\nisAfter(agora):  " + instantParsed.isAfter(instantAgora));
        System.out.println("equals(agora):   " + instantParsed.equals(instantAgora));

        // Formatação
        DateTimeFormatter fmtInstant = DateTimeFormatter
                .ofPattern("dd.MM.yyyy")
                .withZone(ZoneId.systemDefault());
        System.out.println("Formatado: " + fmtInstant.format(Instant.parse("2022-02-15T18:35:24.00Z")));

        // Dados específicos
        System.out.println("\nEpochSecond: " + instantAgora.getEpochSecond());
        System.out.println("Nano:        " + instantAgora.getNano());

        // ================================================
        // 5. Period e Duration
        // ================================================
        System.out.println("\n=== Period ===");

        LocalDate dataBase = LocalDate.of(2023, 2, 20);
        LocalDate natal    = LocalDate.of(2023, 12, 25);
        Period period      = Period.between(dataBase, natal);

        System.out.println("De " + dataBase + " até " + natal + ":");
        System.out.println("Anos:   " + period.getYears());
        System.out.println("Meses:  " + period.getMonths());
        System.out.println("Dias:   " + period.getDays());

        System.out.println("\n=== Duration ===");

        LocalTime inicioTreino = LocalTime.of(6, 30, 33);
        LocalTime fimTreino    = LocalTime.of(7, 16, 14);
        Duration duration      = Duration.between(inicioTreino, fimTreino);

        System.out.println("Início: " + inicioTreino + " | Fim: " + fimTreino);
        System.out.println("Duração (segundos): " + duration.getSeconds());
        System.out.println("Duração (formato):  " + LocalTime.ofSecondOfDay(duration.getSeconds()));

        // ================================================
        // 6. Transformações
        // ================================================
        System.out.println("\n=== Transformações ===");

        LocalDateTime dhBase = LocalDateTime.of(2023, 1, 24, 16, 31, 27);

        // LocalDateTime → LocalDate
        LocalDate soData = dhBase.toLocalDate();
        System.out.println("LocalDateTime → LocalDate: " + soData);

        // LocalDateTime → LocalTime
        LocalTime soHora = dhBase.toLocalTime();
        System.out.println("LocalDateTime → LocalTime: " + soHora);

        // LocalDate → LocalDateTime
        LocalDate soDataBase = LocalDate.of(2023, 1, 24);
        LocalDateTime comHora1 = soDataBase.atTime(16, 31, 27);
        LocalDateTime comHora2 = soDataBase.atTime(LocalTime.of(16, 31));
        LocalDateTime inicioDia = soDataBase.atStartOfDay();
        System.out.println("LocalDate → LocalDateTime (hora): " + comHora1);
        System.out.println("LocalDate → LocalDateTime (LT):   " + comHora2);
        System.out.println("LocalDate → LocalDateTime (start):" + inicioDia);

        // Instant → LocalDateTime
        Instant instante = Instant.parse("2023-03-13T15:58:55.794285600Z");
        LocalDateTime deInstant = LocalDateTime.ofInstant(instante, ZoneOffset.UTC);
        System.out.println("Instant → LocalDateTime (UTC): " + deInstant);
    }
}
