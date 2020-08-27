package Package.Lesson29.main.java.com.tanasohlo.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IDGeneratorImpl implements IDGenerator{
    @Override
    public synchronized String generate() {
        return UUID.randomUUID().toString();
    }
}
