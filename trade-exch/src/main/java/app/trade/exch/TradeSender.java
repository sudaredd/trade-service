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

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class TradeSender implements CommandLineRunner {

    @Autowired
    private TradeSenderStreams tradeSenderStreams;

    @Override
    public void run(String... args) throws Exception {
        log.info("writing to Kakfa with scheduler");
        Schedulers.newSingle("TradeSender").schedulePeriodically(() -> sendMsg(), 3, 5, TimeUnit.SECONDS);
    }

    private void sendMsg() {
        MessageChannel messageChannel = tradeSenderStreams.tradeOutBoundChannel();
        messageChannel.send(MessageBuilder.
                withPayload(TradeUtil.tradeMessage()).
                setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN).
                setHeader("UNIQUE_ID", UUID.randomUUID().toString()).
                build(), 1);
    }

   
}
