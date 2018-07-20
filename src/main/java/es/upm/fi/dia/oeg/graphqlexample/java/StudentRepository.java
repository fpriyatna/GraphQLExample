package es.upm.fi.dia.oeg.graphqlexample.java;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class StudentRepository {
    private final MongoCollection<Document> students;

    public StudentRepository(MongoCollection<Document> students) {
        this.students = students;
    }

    public Student findById(String id) {
        Document doc = students.find(eq("_id", new ObjectId(id))).first();
        return student(doc);
    }

    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        for (Document doc : students.find(eq("ocupacion", "estudiante"))) {
            allStudents.add(student(doc));
        }
        return allStudents;
    }

    public void saveStudent(Student student) {
        Document doc = new Document();
        doc.append("nombre", student.getName());
        students.insertOne(doc);
    }

    private Student student(Document doc) {
        return new Student(
                doc.get("_id").toString(),
                doc.getString("nombre"));
    }


}
