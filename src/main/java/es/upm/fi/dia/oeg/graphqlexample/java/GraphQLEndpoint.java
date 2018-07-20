package es.upm.fi.dia.oeg.graphqlexample.java;

import com.coxautodev.graphql.tools.SchemaParser;
import javax.servlet.annotation.WebServlet;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;


@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {
    private static final PersonResolver personResolver;
    private static final StudentResolver studentResolver;

    static {
        MongoDatabase mongo2 = new MongoClient().getDatabase("universidad");
        personResolver = new PersonResolver(mongo2.getCollection(PersonResolver.COLLECTION_SOURCE));
        studentResolver = new StudentResolver(mongo2.getCollection(StudentResolver.COLLECTION_SOURCE));
    }

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                        new Query(personResolver, studentResolver),
                        new Mutation(personResolver))
                .build()
                .makeExecutableSchema();
    }
}
