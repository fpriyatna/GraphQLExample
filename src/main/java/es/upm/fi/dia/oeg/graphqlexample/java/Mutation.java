package es.upm.fi.dia.oeg.graphqlexample.java;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

public class Mutation implements GraphQLRootResolver {
    private final PersonResolver personResolver;

    public Mutation(PersonResolver personResolver) {
        this.personResolver = personResolver;
    }

    public Person createPerson(String name, String occupation) {
        Person newPerson = new Person(name, occupation);
        personResolver.savePerson(newPerson);
        return newPerson;
    }
}
