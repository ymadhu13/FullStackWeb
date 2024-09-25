package Bean;

public class Student {
    private String registeredNo;
    private String studentName;
    private String dob;  // Changed from `DOB` to `dob` to be consistent
    private String gender;
    private String branch;
    private int year;
    private String semester;
    private String collegeName;

    public Student() {
        super();
    }

    public Student(String registeredNo, String studentName, String dob, String gender, String branch, int year,
                   String semester, String collegeName) {
        super();
        this.registeredNo = registeredNo;
        this.studentName = studentName;
        this.dob = dob;  // Changed this.DOB to this.dob
        this.gender = gender;
        this.branch = branch;
        this.year = year;
        this.semester = semester;
        this.collegeName = collegeName;
    }

    public String getRegisteredNo() {
        return registeredNo;
    }

    public void setRegisteredNo(String registeredNo) {
        this.registeredNo = registeredNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDob() {
        return dob;  // Updated getter to match "dob"
    }

    public void setDob(String dob) {  // Updated setter to match "dob"
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "Student [registeredNo=" + registeredNo + ", studentName=" + studentName + ", dob=" + dob + ", gender="
                + gender + ", branch=" + branch + ", year=" + year + ", semester=" + semester + ", collegeName="
                + collegeName + "]";
    }
}
