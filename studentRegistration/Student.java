package studentRegistration;
//Student Class
abstract class Student {
    private String studentName;
    private int studentUID;
    private String studentID;
    private int studentYear;
    private int studentSemester;
    private boolean registered;
    private String studentOccupation;

    //Constructor of Class Student
    public Student(String studentName, String studentID, int studentUID, int studentYear, int studentSemester,String studentOccupation) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentUID = studentUID;
        this.studentYear = studentYear;
        this.studentSemester = studentSemester;
        this.registered = false;
        this.studentOccupation = studentOccupation;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public int getStudentUID() {
        return studentUID;
    }

    public String getStudentOccupation() {
        return studentOccupation;
    }

    public int getStudentYear() {
        return studentYear;
    }

    public int getStudentSemester() {
        return studentSemester;
    }

    public boolean isRegistered() {
        return registered;
    }
    public void register() {
        registered = true;
    }

    // Abstract method to be implemented by subclasses, just for demonstration
    public abstract void additionalInfo();
}
//Class UndergraduateStudent which inherit all non-private members
class UndergraduateStudent extends Student {
    public String getStudentDepartment() {
        return studentDepartment;
    }
    private String studentDepartment;
    public UndergraduateStudent(String studentName, String studentID, int studentUID, String studentOccupation, int studentYear, int studentSemester) {
        super(studentName, studentID, studentUID, studentYear, studentSemester,studentOccupation);
        this.studentDepartment = studentOccupation;
    }

    //To demonstrate method overriding or polymorphism
    @Override
    public void additionalInfo() {
        System.out.println("I am an Undergraduate Student");
    }
}

class PostgraduateStudent extends Student {
    public String getResearch() {
        return researchField;
    }

    private String researchField;
    public PostgraduateStudent(String studentName, String studentID, int studentUID, String studentOccupation, int studentYear, int studentSemester) {
        super(studentName, studentID, studentUID, studentYear, studentSemester,studentOccupation);
        this.researchField = studentOccupation;
    }

    @Override
    public void additionalInfo() {
        System.out.println("I am a Postgraduate Student");
    }

    // Additional method for postgraduate students
    public void research() {
        System.out.println("Postgraduate student is conducting research.");
    }
}

