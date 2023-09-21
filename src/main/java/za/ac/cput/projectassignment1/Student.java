package za.ac.cput.projectassignment1;

/**
 *
 * @author Desktop
 */
public class Student {

    private int id;
    private String gardian, surname, firstName, email, nationality, dateOfBirth, address, province, gender;
    private int postalCode, number;
    private String gardianName, gardianSurname, gardianEmail, gardianNationality, gardianAddress, gardianProvince;
    private int gardianId, gardianPostalCode, gardianNumber;
    private String school, grade;
    private int year;
    private String subject1, subject2, subject3, subject4, subject5, subject6, subject7;
    private int percent1, percent2, percent3, percent4, percent5, percent6, percent7;

    public Student(String gardian, String surname, String firstName, String email, String nationality, String dateOfBirth, String address, String province, String gender, int id, int postalCode, int number, String gardianName, String gardianSurname, String gardianEmail, String gardianAddress, String gardianNationality, String gardianProvince, int gardianId, int gardianPostalCode, int gardianNumber, String school, int year, String grade, String subject1, String subject2, String subject3, String subject4, String subject5, String subject6, String subject7, int percent1, int percent2, int percent3, int percent4, int percent5, int percent6, int percent7) {
        this.gardian = gardian;
        this.surname = surname;
        this.firstName = firstName;
        this.email = email;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.province = province;
        this.gender = gender;
        this.id = id;
        this.postalCode = postalCode;
        this.number = number;
        this.gardianName = gardianName;
        this.gardianSurname = gardianSurname;
        this.gardianEmail = gardianEmail;
        this.gardianNationality = gardianNationality;
        this.gardianAddress = gardianAddress;
        this.gardianProvince = gardianProvince;
        this.gardianId = gardianId;
        this.gardianPostalCode = gardianPostalCode;
        this.gardianNumber = gardianNumber;
        this.school = school;
        this.year = year;
        this.grade = grade;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
        this.subject5 = subject5;
        this.subject6 = subject6;
        this.subject7 = subject7;
        this.percent1 = percent1;
        this.percent2 = percent2;
        this.percent3 = percent3;
        this.percent4 = percent4;
        this.percent5 = percent5;
        this.percent6 = percent6;
        this.percent7 = percent7;
    }
    
    

    public void setGardian(String gardian) {
        this.gardian = gardian;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setGardianName(String gardianName) {
        this.gardianName = gardianName;
    }

    public void setGardianSurname(String gardianSurname) {
        this.gardianSurname = gardianSurname;
    }

    public void setgardianEmail(String gardianEmail) {
        this.gardianEmail = gardianEmail;
    }

    public void setGardianNationality(String gardianNationality) {
        this.gardianEmail = gardianNationality;
    }

    public void setGardianAddress(String gardianAddress) {
        this.gardianAddress = gardianAddress;
    }

    public void setGardianProvince(String gardianProvince) {
        this.gardianProvince = gardianProvince;
    }

    public void setGardianId(int gardianId) {
        this.gardianId = gardianId;
    }

    public void setGardianPostalCode(int gardianPostalCode) {
        this.gardianPostalCode = gardianPostalCode;
    }

    public void setGardianNumber(int gardianNumber) {
        this.gardianNumber = gardianNumber;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public void setSubject4(String subject4) {
        this.subject4 = subject4;
    }

    public void setSubject5(String subject5) {
        this.subject5 = subject5;
    }

    public void setSubject6(String subject6) {
        this.subject6 = subject6;
    }

    public void setSubject7(String subject7) {
        this.subject7 = subject7;
    }

    public void setPercent1(int percent1) {
        this.percent1 = percent1;
    }

    public void setPercent2(int percent2) {
        this.percent2 = percent2;
    }

    public void setPercent3(int percent3) {
        this.percent3 = percent3;
    }

    public void setPercent4(int percent4) {
        this.percent4 = percent4;
    }

    public void setPercent5(int percent5) {
        this.percent5 = percent5;
    }

    public void setPercent6(int percent6) {
        this.percent6 = percent6;
    }

    public void setPercent7(int percent7) {
        this.percent7 = percent7;
    }

    public String getGardian() {
        return gardian;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getProvince() {
        return province;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getNumber() {
        return number;
    }

    public String getGardianName() {
        return gardianName;
    }

    public String getGardianSurname() {
        return gardianSurname;
    }

    public String getGardianEmail() {
        return gardianEmail;
    }

    public String getGardianNationality() {
        return gardianNationality;
    }

    public String getGardianAddress() {
        return gardianAddress;
    }

    public String getGardianProvince() {
        return gardianProvince;
    }

    public int getGardianId() {
        return gardianId;
    }

    public int getGardianPostalCode() {
        return gardianPostalCode;
    }

    public int getGardianNumber() {
        return gardianNumber;
    }

    public String getSchool() {
        return school;
    }

    public int getYear() {
        return year;
    }

    public String getGrade() {
        return grade;
    }

    public String getSubject1() {
        return subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    public String getSubject4() {
        return subject4;
    }

    public String getSubject5() {
        return subject5;
    }

    public String getSubject6() {
        return subject6;
    }

    public String getSubject7() {
        return subject7;
    }

    public int getPercent1() {
        return percent1;
    }

    public int getPercent2() {
        return percent2;
    }

    public int getPercent3() {
        return percent3;
    }

    public int getPercent4() {
        return percent4;
    }

    public int getPercent5() {
        return percent5;
    }

    public int getPercent6() {
        return percent6;
    }

    public int getPercent7() {
        return percent7;
    }

}
