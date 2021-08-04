package com.key.value.store.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.concurrent.ConcurrentMap;

@Slf4j
public class IOUtils {
    public static void readFileAndUpdateCache(String fileName, ConcurrentMap<String,String> cache){
        try (BufferedReader br = new BufferedReader(new FileReader(new File(Constants.FILE_NAME)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(Constants.COMMAND_SEPARATOR);
                if (tokens.length == 2) {
                    if (Commands.DELETE.getCommandText().equals(tokens[1])){
                        cache.remove(tokens[0]);
                    }else {
                        cache.put(tokens[0],tokens[1]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            log.error("Persistence file not found. Initializing empty cache");
        } catch (IOException e) {
            log.error("Error reading file");
        }
    }
}
