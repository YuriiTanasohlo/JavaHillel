package Package.Lesson29.main.java.com.tanasohlo.service;

import java.util.UUID;

public class IDGeneratorImpl implements IDGenerator{
    @Override
    public synchronized String generate() {
        return UUID.randomUUID().toString();
    }
}
