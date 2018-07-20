# ainn-request
Request and Answers for Mappings

# To install
1. You need to install pip https://pip.pypa.io/en/stable/installing/
2. Create virtual environment http://docs.python-guide.org/en/latest/dev/virtualenvs/
3. Access the environment variable
4. Install the requirements: run `pip install -r requirements.txt` in the app directory
5. `python app.py`
6. Access http://localhost:5000/graphql on your browser




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
