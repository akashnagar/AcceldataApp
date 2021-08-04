package com.key.value.store.util;

import lombok.Getter;

@Getter
public enum Commands {
    UPSERT("u"),
    DELETE("---%%d%%---");

    private final String commandText;

    Commands(String commandText) {
        this.commandText = commandText;
    }
}
