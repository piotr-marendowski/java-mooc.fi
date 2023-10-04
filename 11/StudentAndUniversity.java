import java.util.List;

public class StudentAndUniversity {
    class Student {
        private String studentID;
        private String name;
        private University uni;
    }

    class University {
        private String name;
        private List<Student> students;
    }
}
