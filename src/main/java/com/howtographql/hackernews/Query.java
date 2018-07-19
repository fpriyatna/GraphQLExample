package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final LinkRepository linkRepository;
    private final PersonRepository personRepository;
    private final StudentRepository studentRepository;

    public Query(
            LinkRepository linkRepository,
            PersonRepository personRepository,
            StudentRepository studentRepository
    ) {
        this.linkRepository = linkRepository;
        this.personRepository = personRepository;
        this.studentRepository = studentRepository;
    }

    public List<Link> allLinks() { return linkRepository.getAllLinks(); }
    public List<Person> allPersons() { return personRepository.getAllPersons(); }
    public List<Student> allStudents() { return studentRepository.getAllStudents(); }

}
