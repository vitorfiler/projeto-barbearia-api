package com.barbeariaapi.tenant;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {
    
    @Override
    protected Object determineCurrentLookupKey() {
        String dbKey = DataSourceContextHolder.get();
        System.out.println("🧭 BANCO USADO NA REQUISIÇÃO: " + dbKey);
        return dbKey;
    }
}
