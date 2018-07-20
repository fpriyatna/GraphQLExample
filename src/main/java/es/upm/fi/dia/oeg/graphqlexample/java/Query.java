package es.upm.fi.dia.oeg.graphqlexample.java;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final PersonRepository personRepository;
    private final StudentRepository studentRepository;

    public Query(
            PersonRepository personRepository,
            StudentRepository studentRepository
    ) {
        this.personRepository = personRepository;
        this.studentRepository = studentRepository;
    }

    public List<Person> allPersons() { return personRepository.getAllPersons(); }
    public List<Student> allStudents() { return studentRepository.getAllStudents(); }
}
