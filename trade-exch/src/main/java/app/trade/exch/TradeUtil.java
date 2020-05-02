package app.trade.exch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class TradeUtil {
    private static List<String> traders = new ArrayList<String>(Arrays.asList("sudark", "davidb", "abdoa", "innag"));
    private static List<String> cusips = new ArrayList<String>(Arrays.asList("9128284J6", "9128284P2", "9128284L1", "9128284M9", "9128284N7"));
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static AtomicLong tradeSeqIdGenerrator = new AtomicLong(1000);

    /**
     *  private String fixMessage = "35=8;75=2020-02-07;9114=2020-05-11;60=2020-02-07T14:59:53.708098;48=9128284M9;55=davidb;15=2;31=99.40625;38=8000000;"
     * @return
     */
    public static String tradeMessage() {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        String str = LocalDate.now().format(dateTimeFormatter);
        String tradeId = str + tradeSeqIdGenerrator.getAndIncrement();
        StringJoiner joiner = new StringJoiner(";");
        int a = r.ints(1, 32).findFirst().getAsInt();
        double dec = ((double) a) / 32d + r.ints(98, 104).findFirst().getAsInt();
        joiner.add("35=8").
                add("75="+LocalDate.now().toString()).
                add("9114=" + LocalDate.now().plusDays(1).toString()).
                add("60=" + LocalDateTime.now().toString()).
                add("48=" + cusips.get(r.nextInt(cusips.size()))).
                add("55=" + traders.get(r.nextInt(traders.size()))).
                add("17=" + tradeId ).
                add("15=" + r.ints(1, 3).findFirst().getAsInt()).
                add("38=" + (r.ints(1, 16).findFirst().getAsInt()) * 1000000).
                add("31=" + dec);
        return joiner.toString();
    }
}
