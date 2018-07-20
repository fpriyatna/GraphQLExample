# GraphQLExample
Example of using GraphQL with Java and MongoDB, you need to have Git/Maven/MongoDB installed on your system

# To install
1. ``` git clone https://github.com/fpriyatna/GraphQLExample ```
2. ``` cd GraphQLExample ```
3. ``` mvn clean jetty:run ```
4. access http://localhost:8080 from your browser

# Examples

## To add Ahmad
```
mutation createPerson {
  createPerson(
    name: "Ahmad"
    occupation: "estudiante") {
    name
  }
}
```

## To add Freddy
```
mutation createPerson {
  createPerson(
    name: "Freddy"
    occupation: "investigador") {
    name
  }
}
```

## To add Oscar
```
mutation createPerson {
  createPerson(
    name: "Oscar"
    occupation: "profesor") {
    name
  }
}
```

## To query all person (Person is mapped to collection Persona, name is mapped to field nombre)
```
{
  allPersons {
    id
    name
  }
}
```

## To query all students (Student is mapped to collection Persona with field ocupacion=estudiante, name is mapped to  field nombre)
```
{
  allStudents {
    id
    name
  }
}
```
