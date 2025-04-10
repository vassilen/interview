package com.github.interview;

import com.github.interview.mocked.ClientFactory;
import com.github.interview.mocked.StatementContext;
import com.github.interview.statements.StatementsRestClient;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
public class Main {

    public static void main(String[] args) {
        StatementsRestClient restClient = new StatementsRestClient(new ClientFactory());

        StatementContext context = new StatementContext();
        context.setBaseUrl("https://example.com");
        context.setFrom(Instant.now().minusSeconds(24 * 60 * 60));
        context.setTo(Instant.now());
        context.setIban("CY68005000121234567890123456");

        byte[] statement = restClient.fetchStatementJson(context);
        log.info("Fetched statement: {}", new String(statement));
    }
}
