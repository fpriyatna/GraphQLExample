package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import graphql.GraphQLException;

public class Mutation implements GraphQLRootResolver {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public Mutation(LinkRepository linkRepository, UserRepository userRepository, PersonRepository personRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    public Link createLink(String url, String description) {
        Link newLink = new Link(url, description);
        linkRepository.saveLink(newLink);
        return newLink;
    }

    public User createUser(String name, AuthData auth) {
        User newUser = new User(name, auth.getEmail(), auth.getPassword());
        userRepository.saveUser(newUser);
        return newUser;
    }

    public Person createPerson(String name, String occupation) {
        Person newPerson = new Person(name, occupation);
        personRepository.savePerson(newPerson);
        return newPerson;
    }

    public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getPassword())) {
            return new SigninPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }

}
