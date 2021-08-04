package com.key.value.store.storage;

import com.key.value.store.util.CommandUtils;
import com.key.value.store.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class PersistentStorage implements Storage {

    private FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    PrintWriter out;

    @PostConstruct
    private void init() throws IOException {
        fileWriter = new FileWriter(Constants.FILE_NAME, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        out = new PrintWriter(bufferedWriter);
    }

    /*
        Making this method synchronized so that only 1 thread updates the file at a time
     */
    @Override
    public synchronized void upsert(String key, String value) {
        try {
            out.append(CommandUtils.getUpsertStatement(key, value));
            out.flush();
        } catch (Exception e) {
            log.error("Exception updating file : {}", e);
            //TODO: handle
        }
    }

    @Override
    public synchronized void delete(String key) {
        try {
            out.append(CommandUtils.getDeleteStatement(key));
            out.flush();
        } catch (Exception e) {
            //TODO: exception handling
        }
    }
}
