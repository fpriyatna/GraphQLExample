package es.upm.fi.dia.oeg.graphqlexample.java;

import com.coxautodev.graphql.tools.SchemaParser;
import javax.servlet.annotation.WebServlet;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;


@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {
    private static final PersonRepository personRepository;
    private static final StudentRepository studentRepository;

    static {
        MongoDatabase mongo2 = new MongoClient().getDatabase("universidad");
        personRepository = new PersonRepository(mongo2.getCollection("personas"));
        studentRepository = new StudentRepository(mongo2.getCollection("personas"));
    }

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                        new Query(personRepository, studentRepository),
                        new Mutation(personRepository))
                .build()
                .makeExecutableSchema();
    }
}
