package com.retrowalk.models;

/**
 * TenantContext
 */
public class TenantContext {

    /**
     * ThreadLocal
     */
    private static final ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

    /**
     * Get Current Thread.
     */
    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    /**
     * Set Current Thread.
     */
    public static void setCurrentTenant(String tenantId) {
        currentTenant.set(tenantId);
    }

    /**
     * Clear tenant.
     */
    public static void clear() {
        currentTenant.remove();
    }
}
