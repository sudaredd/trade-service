package app.trade;

import app.trade.model.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

enum FixTags {
    TRADE_DATE(75),
    TRADE_TIME(60),
    TRADE_ID(17),
    CUSIP(48),
    SIDE(15),
    PRICE(31),
    QUANTITY(38),
    TRADER(55),
    SETTLE_DATE(9114);

    FixTags(int val) {
        this.tag = val;
    }

    public int getTag() {
        return tag;
    }

    int tag;
}

@Slf4j
@Component
public class TradeTransformer {

    private JAXBContext jaxbContext;
    private Marshaller marshaller;

    {
        try {
            jaxbContext = JAXBContext.newInstance(Trade.class);
            marshaller = jaxbContext.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public TradeTransformer() {

    }

    public Trade trade(String fix) {
        Map<Integer, String> fixMap = parseFix(fix);
        return getTrade(fixMap);
    }

    public String convertToNewTrade(Trade trade) {
        StringWriter sw = new StringWriter();
        try {
            marshaller.marshal(trade, sw);
        } catch (JAXBException e) {
            log.error("Error occurred while parsing to NewTrade ", e);
        }
        return sw.toString();
    }

    private Trade getTrade(Map<Integer, String> fixMap) {
        Trade.TradeBuilder tradeBuilder = Trade.builder();
        for (FixTags tag : FixTags.values()) {
            switch (tag) {
                case CUSIP:
                    tradeBuilder.symbol(val(fixMap, tag));
                    break;
                case PRICE:
                    tradeBuilder.price(Double.parseDouble(val(fixMap, tag)));
                    break;
                case TRADER:
                    tradeBuilder.trader(val(fixMap, tag));
                    break;
                case QUANTITY:
                    tradeBuilder.quantity(Integer.parseInt(val(fixMap, tag)));
                    break;
                case TRADE_ID:
                    tradeBuilder.tradeId(val(fixMap, tag));
                    break;
                case SIDE:
                    tradeBuilder.side(val(fixMap, tag));
                    break;
                case TRADE_DATE:
                    tradeBuilder.tradeDate(val(fixMap, tag));
                    break;
                case TRADE_TIME:
                    tradeBuilder.tradeTime(val(fixMap, tag));
                    break;
                case SETTLE_DATE:
                    tradeBuilder.settleDate(val(fixMap, tag));
                    break;
            }
        }
        return tradeBuilder.build();
    }

    private String val(Map<Integer, String> fixMap, FixTags tag) {
        return fixMap.get(tag.getTag());
    }

    private Map<Integer, String> parseFix(String fix) {
        return Arrays.stream(fix.split(";")).
                map(s -> s.split("=")).
                collect(Collectors.toMap(v -> Integer.parseInt(v[0]), v -> v[1]));
    }
}
