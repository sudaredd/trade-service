package app.trade.exch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class TradeSender implements CommandLineRunner {

    @Autowired
    private TradeSenderStreams tradeSenderStreams;

    private String fixMessage = "35=8;75=2020-02-07;9114=2020-05-11;60=2020-02-07T14:59:53.708098;48=9128284M9;55=davidb;15=2;31=99.40625;38=8000000;";

    @Override
    public void run(String... args) throws Exception {
        log.info("writing to Kakfa with scheduler");
        Schedulers.newSingle("TradeSender").schedulePeriodically(() -> sendMsg(), 3, 1, TimeUnit.SECONDS);
    }

    private void sendMsg() {
        MessageChannel messageChannel = tradeSenderStreams.tradeOutBoundChannel();
        messageChannel.send(MessageBuilder.
                withPayload(fixMessage).
                setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN).
               build(),1);
    }
}
