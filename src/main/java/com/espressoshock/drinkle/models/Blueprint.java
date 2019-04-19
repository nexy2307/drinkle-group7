package com.espressoshock.drinkle.models;

import java.sql.Timestamp;
import java.util.List;

public abstract class Blueprint {
    private String metadata;
    private Timestamp ts;
    private int blueprintId;
    private List<Permission>permissions;
    private AcessLevel accessLevel;
    private Statistic statistic;

    public Blueprint(String metadata, Timestamp ts, int blueprintId, List<Permission> permissions, AcessLevel accessLevel, Statistic statistic) {
        this.metadata = metadata;
        this.ts = ts;
        this.blueprintId = blueprintId;
        this.permissions = permissions;
        this.accessLevel = accessLevel;
        this.statistic = statistic;
    }

    public String getMetadata() {
        return metadata;
    }

    public Timestamp getTs() {
        return ts;
    }

    public int getBlueprintId() {
        return blueprintId;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public AcessLevel getAccessLevel() {
        return accessLevel;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public void setAccessLevel(AcessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }
}
