package com.github.interview.statements;

import com.github.interview.mocked.ClientFactory;
import com.github.interview.mocked.StatementContext;
import com.github.interview.mocked.WebTarget;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

@RequiredArgsConstructor
@Slf4j
public class StatementsRestClient {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");

    private final ClientFactory clientFactory;

    public byte[] fetchStatementJson(StatementContext context) {
        WebTarget target = clientFactory.create().target(context.getBaseUrl())
                .path("/v1/payment-initiation")
                .queryParam("date-from", sdf.format(context.getTo()))
                .queryParam("date-to", sdf.format(context.getFrom()))
                .queryParam("account", context.getIban());

        log.info("Will try to fetch statement for bank account = %s from {} to {}", context.getIban(), context.getTo(), context.getFrom());

        byte[] result = target.request("text/json")
                .header("Authorization", "Bearer YWI1ODhhY2MtMmFjNC00NDZjLWFiZGQtMDZjMmVhOGIwOTdhOko2YUExZkw4dko2eFYwaUk1Ylg0blI0bkE4cEs3ZEczY0kwaks1bVI2ck4ycVEzcFAw")
                .header("X-Client-ID", "ab588acc-2ac4-446c-abdd-06c2ea8b097a")
                .get()
                .readEntity(byte[].class);

        log.info("Downloaded statement for bank account = %s from {} to {}", context.getIban(), context.getTo(), context.getFrom());
        context.getAuditLog().log(String.format("Fetched statement for %s from {} to {}", context.getIban(), context.getTo(), context.getFrom()));

        return result;
    }
}
