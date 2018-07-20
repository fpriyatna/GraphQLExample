package es.upm.fi.dia.oeg.graphqlexample.java;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class PersonResolver {
    private final MongoCollection<Document> persons;
    static final String COLLECTION_SOURCE = "personas";

    public PersonResolver(MongoCollection<Document> persons) {
        this.persons = persons;
    }

    public Person findById(String id) {
        Document doc = persons.find(eq("_id", new ObjectId(id))).first();
        return person(doc);
    }

    public List<Person> getAllPersons() {
        List<Person> allPersons = new ArrayList<>();
        for (Document doc : persons.find()) {
            allPersons.add(person(doc));
        }
        return allPersons;
    }

    public void savePerson(Person person) {
        Document doc = new Document();
        doc.append("nombre", person.getName()); //map Person.name to personas.nombre
        doc.append("ocupacion", person.getOccupation()); //map Person.ocupation to personas.ocupacion
        persons.insertOne(doc);
    }

    private Person person(Document doc) {
        return new Person(
                doc.get("_id").toString(),
                doc.getString("nombre"),
                doc.getString("ocupacion")
        );
    }
}
