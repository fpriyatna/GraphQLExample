package es.upm.fi.dia.oeg.graphqlexample.java;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import graphql.GraphQLException;

public class Mutation implements GraphQLRootResolver {
    private final PersonRepository personRepository;

    public Mutation(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(String name, String occupation) {
        Person newPerson = new Person(name, occupation);
        personRepository.savePerson(newPerson);
        return newPerson;
    }
}
