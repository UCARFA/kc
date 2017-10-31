package org.kuali.coeus.common.framework.unit.sync;

import org.kuali.coeus.sys.api.model.Coded;
import org.kuali.coeus.sys.api.model.Describable;

import java.util.Arrays;

public enum SyncBehavior implements org.kuali.rice.core.api.mo.common.Coded, Coded, Describable {
    IGNORE_EXISTING("RESBOOT1", "Ignore Existing"),
    DELETE_READD("RESBOOT2", "Delete/Readd"),
    DELETE_ALL_ADD("RESBOOT3", "Delete All/Add");
    private final String code;
    private final String description;

    SyncBehavior(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static SyncBehavior fromCode(String code) {
        return Arrays.stream(values())
                .filter(v -> v.getCode().equals(code))
                .findFirst()
                .<IllegalArgumentException>orElseThrow(() -> {
                    throw new IllegalArgumentException("invalid code" + code);
                });
    }
}
