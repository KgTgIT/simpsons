package it.kgtg.simpsons.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Profile("!dev")
@EnableMongoRepositories("it.kgtg.simpsons")
@Configuration
public class ExternalMongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Override
    public MongoClient mongoClient() {
        MongoClientURI clientURI = new MongoClientURI(uri);
        return new MongoClient(clientURI);
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }
}
