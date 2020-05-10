package app.trade.service;

import app.trade.model.Audit;
import app.trade.model.Trade;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import java.time.LocalDateTime;

public class AbstractProcessor {

    private Gson gson = new Gson();

    @Autowired
    private ElasticsearchTemplate esTemplate;

    public Trade process (Audit audit) {
        preProcess(audit);
        processMessage(audit);
        return postProcessMessage(audit);
    }

    private Trade postProcessMessage(Audit audit) {
        setAuditStatus(audit, Status.POST_PROCESS);
        return audit.getTrade();
    }

    protected void processMessage(Audit audit) {
        setAuditStatus(audit, Status.PROCESS);
    }

    private void preProcess(Audit audit) {
        setAuditStatus(audit, Status.PRE_PROCESS);
    }

    private void setAuditStatus(Audit audit, Status preProcess) {
        audit.setTime(LocalDateTime.now().toString());
        audit.setStatus(preProcess);
        loadToElastic(audit);
    }

    private void loadToElastic(Audit audit) {
        IndexQuery indexQuery = new IndexQuery();
        indexQuery.setId(audit.getUniqueId());
        indexQuery.setSource(gson.toJson(audit));
        indexQuery.setIndexName("trades_audit");
        indexQuery.setType("Trade");
        esTemplate.index(indexQuery);
    }

}
