package com.key.value.store.util;

public class CommandUtils {
    public static String getUpsertStatement(String key, String value){

        return key + Constants.COMMAND_SEPARATOR + StringUtils.sanitize(value) + "\n";
    }

    public static String getDeleteStatement(String key){
        return key + Constants.COMMAND_SEPARATOR + Commands.DELETE.getCommandText() + "\n";
    }
}
