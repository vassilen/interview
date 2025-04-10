package com.github.interview.mocked;

import lombok.Data;

import java.time.Instant;

@Data
public class StatementContext {

    private String baseUrl;
    private Instant from;
    private Instant to;
    private String iban;
    private AuditLog auditLog = new AuditLog();
}
