# GraphQLExample
Example of using GraphQL with Java and MongoDB

# To install
1. ``` git clone https://github.com/fpriyatna/GraphQLExample ```
2. ``` mvn clean jetty:run ```
3. access http://localhost:8080 from your browser

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

## To query all person
```
{
  allPersons {
    id
    name
  }
}
```

## To query all students
```
{
  allStudents {
    id
    name
  }
}
```
