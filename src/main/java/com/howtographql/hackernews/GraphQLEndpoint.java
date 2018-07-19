package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.SchemaParser;
import javax.servlet.annotation.WebServlet;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;


@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {
    private static final LinkRepository linkRepository;
    private static final UserRepository userRepository;
    private static final PersonRepository personRepository;
    private static final StudentRepository studentRepository;

    static {
        //Change to `new MongoClient("mongodb://<host>:<port>/hackernews")`
        //if you don't have Mongo running locally on port 27017
        MongoDatabase mongo1 = new MongoClient().getDatabase("hackernews");
        linkRepository = new LinkRepository(mongo1.getCollection("links"));
        userRepository = new UserRepository(mongo1.getCollection("users"));

        MongoDatabase mongo2 = new MongoClient().getDatabase("universidad");
        personRepository = new PersonRepository(mongo2.getCollection("personas"));
        studentRepository = new StudentRepository(mongo2.getCollection("personas"));
    }

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        /*
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(linkRepository), new Mutation(linkRepository, userRepository))
                .build()
                .makeExecutableSchema();
                */

        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                        new Query(linkRepository, personRepository, studentRepository),
                        new Mutation(linkRepository, userRepository, personRepository),
                        new SigninResolver())
                .build()
                .makeExecutableSchema();

    }
}
