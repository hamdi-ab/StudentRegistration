package studentRegistration;

public class Course {
    private String courseName;
    private int courseCode;
    private int courseCreditHour;
    private int courseYear;
    private int courseSemester;

    public Course(String courseName, int courseCode, int courseCreditHour, int courseYear, int courseSemester) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCreditHour = courseCreditHour;
        this.courseYear = courseYear;
        this.courseSemester = courseSemester;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }
    public int getCourseCreditHour() {
        return courseCreditHour;
    }
    public void setCourseCreditHour(int courseCreditHour) {
        this.courseCreditHour = courseCreditHour;
    }
    public int getCourseYear() {
        return courseYear;
    }
    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }
    public int getCourseSemester() {
        return courseSemester;
    }
    public void setCourseSemester(int courseSemester) {
        this.courseSemester = courseSemester;
    }
}
