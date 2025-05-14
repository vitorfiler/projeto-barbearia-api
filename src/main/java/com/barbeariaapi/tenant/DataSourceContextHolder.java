package com.barbeariaapi.tenant;

public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void set(String dbKey) {
        contextHolder.set(dbKey);
    }

    public static String get() {
        return contextHolder.get();
    }

    public static void clear() {
        contextHolder.remove();
    }
}
