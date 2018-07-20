package es.upm.fi.dia.oeg.graphqlexample.java;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final PersonResolver personResolver;
    private final StudentResolver studentResolver;

    public Query(
            PersonResolver personResolver,
            StudentResolver studentResolver
    ) {
        this.personResolver = personResolver;
        this.studentResolver = studentResolver;
    }

    public List<Person> allPersons() { return personResolver.getAllPersons(); }
    public List<Student> allStudents() { return studentResolver.getAllStudents(); }
}
