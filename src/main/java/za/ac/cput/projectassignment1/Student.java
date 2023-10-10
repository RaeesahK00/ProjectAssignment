package za.ac.cput.projectassignment1;

/**
 *
 * @author Desktop
 */
public class Student {
    private static String id;
    private static String firstName, surname;
    private static boolean idSA;
    private static boolean passport;
    private static String email, nationality, dateOfBirth;
    private static String language, address;
    private static String postalCode;
    private static String province;
    private static String number;
    private static boolean male;
    private static boolean female;
    private static String submittedId;

    
    private String gardianId;
    private String gardian;
    private String gardianName, gardianSurname, gardianEmail, gardianNationality, gardianAddress, gardianProvince;
    private String gardianPostalCode, gardianNumber;

    private String school;
    private int year;
    private boolean grade11;
    private boolean grade12;
    private String subject1;
    private int percent1;
    private String subject2;
    private int percent2;
    private String subject3;
    private int percent3;
    private String subject4;
    private int percent4;
    private String subject5;
    private int percent5;
    private String subject6;
    private int percent6;
    private String subject7;
    private int percent7;

    public Student() {
    }

    public Student(String id, String firstName, String surname, boolean idSA, boolean passport, String email, String nationality, String dateOfBirth, String language, String address, String postalCode, String province, String number, boolean male, boolean female, String submittedId) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.idSA = idSA;
        this.passport = passport;
        this.email = email;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.language = language;
        this.address = address;
        this.postalCode = postalCode;
        this.province = province;
        this.number = number;
        this.male = male;
        this.female = female;
        this.submittedId = submittedId;
    }

    public Student(String gardianId, String gardian, String gardianName, String gardianSurname, String gardianEmail, String gardianNationality, String gardianAddress, String gardianProvince, String gardianPostalCode, String gardianNumber) {
        this.gardianId = gardianId;
        this.gardian = gardian;
        this.gardianName = gardianName;
        this.gardianSurname = gardianSurname;
        this.gardianEmail = gardianEmail;
        this.gardianNationality = gardianNationality;
        this.gardianAddress = gardianAddress;
        this.gardianProvince = gardianProvince;
        this.gardianPostalCode = gardianPostalCode;
        this.gardianNumber = gardianNumber;
    }

   

    public Student(String id, String school, int year, boolean grade11, boolean grade12, String subject1, int percent1, String subject2, int percent2, String subject3, int percent3, String subject4, int percent4, String subject5, int percent5, String subject6, int percent6, String subject7, int percent7) {
        this.id = id;
        this.school = school;
        this.year = year;
        this.grade11 = grade11;
        this.grade12 = grade12;
        this.subject1 = subject1;
        this.percent1 = percent1;
        this.subject2 = subject2;
        this.percent2 = percent2;
        this.subject3 = subject3;
        this.percent3 = percent3;
        this.subject4 = subject4;
        this.percent4 = percent4;
        this.subject5 = subject5;
        this.percent5 = percent5;
        this.subject6 = subject6;
        this.percent6 = percent6;
        this.subject7 = subject7;
        this.percent7 = percent7;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isIdSA() {
        return idSA;
    }

    public void setIdSA(boolean idSA) {
        this.idSA = idSA;
    }

    public boolean isPassport() {
        return passport;
    }

    public void setPassport(boolean passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public String getSubmittedId() {
        return submittedId;
    }

    public void setSubmittedId(String submittedId) {
        this.submittedId = submittedId;
    }

    public String getGardian() {
        return gardian;
    }

    public void setGardian(String gardian) {
        this.gardian = gardian;
    }

    public String getGardianId() {
        return gardianId;
    }

    public void setGardianId(String gardianId) {
        this.gardianId = gardianId;
    }

    public String getGardianName() {
        return gardianName;
    }

    public void setGardianName(String gardianName) {
        this.gardianName = gardianName;
    }

    public String getGardianSurname() {
        return gardianSurname;
    }

    public void setGardianSurname(String gardianSurname) {
        this.gardianSurname = gardianSurname;
    }

    public String getGardianEmail() {
        return gardianEmail;
    }

    public void setGardianEmail(String gardianEmail) {
        this.gardianEmail = gardianEmail;
    }

    public String getGardianNationality() {
        return gardianNationality;
    }

    public void setGardianNationality(String gardianNationality) {
        this.gardianNationality = gardianNationality;
    }

    public String getGardianAddress() {
        return gardianAddress;
    }

    public void setGardianAddress(String gardianAddress) {
        this.gardianAddress = gardianAddress;
    }

    public String getGardianProvince() {
        return gardianProvince;
    }

    public void setGardianProvince(String gardianProvince) {
        this.gardianProvince = gardianProvince;
    }

    public int getGardianPostalCode() {
        return gardianPostalCode;
    }

    public void setGardianPostalCode(int gardianPostalCode) {
        this.gardianPostalCode = gardianPostalCode;
    }

    public int getGardianNumber() {
        return gardianNumber;
    }

    public void setGardianNumber(int gardianNumber) {
        this.gardianNumber = gardianNumber;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isGrade11() {
        return grade11;
    }

    public void setGrade11(boolean grade11) {
        this.grade11 = grade11;
    }

    public boolean isGrade12() {
        return grade12;
    }

    public void setGrade12(boolean grade12) {
        this.grade12 = grade12;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public int getPercent1() {
        return percent1;
    }

    public void setPercent1(int percent1) {
        this.percent1 = percent1;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public int getPercent2() {
        return percent2;
    }

    public void setPercent2(int percent2) {
        this.percent2 = percent2;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public int getPercent3() {
        return percent3;
    }

    public void setPercent3(int percent3) {
        this.percent3 = percent3;
    }

    public String getSubject4() {
        return subject4;
    }

    public void setSubject4(String subject4) {
        this.subject4 = subject4;
    }

    public int getPercent4() {
        return percent4;
    }

    public void setPercent4(int percent4) {
        this.percent4 = percent4;
    }

    public String getSubject5() {
        return subject5;
    }

    public void setSubject5(String subject5) {
        this.subject5 = subject5;
    }

    public int getPercent5() {
        return percent5;
    }

    public void setPercent5(int percent5) {
        this.percent5 = percent5;
    }

    public String getSubject6() {
        return subject6;
    }

    public void setSubject6(String subject6) {
        this.subject6 = subject6;
    }

    public int getPercent6() {
        return percent6;
    }

    public void setPercent6(int percent6) {
        this.percent6 = percent6;
    }

    public String getSubject7() {
        return subject7;
    }

    public void setSubject7(String subject7) {
        this.subject7 = subject7;
    }

    public int getPercent7() {
        return percent7;
    }

    public void setPercent7(int percent7) {
        this.percent7 = percent7;
    }

    
    

//    public boolean writeToFile1() {
//        FileHandler file = new FileHandler();
//        try {
//            file.openFile("StudentRegisterForm.txt");
//            file.writeFile(id.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s ", getSurname(), getFirstName(), getEmail(), getId(), getNationality(), getDateOfBirth(), getAddress(), getPostalCode(), getNumber(), getGender()));
//            file.closeFile();
//        } catch (IOException ex) {
//
//        }
//
//        return true;
//    }
//
//    public boolean writeToFile2() {
//        FileHandler file = new FileHandler();
//        try {
//            file.openFile("StudentRegisterForm.txt");
//            file.writeFile(id.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s ", getGardian(), getGardianSurname(), getGardianSurname(), getGardianEmail(), getGardianId(), getGardianNationality(), getGardianAddress(), getGardianPostalCode(), getGardianProvince(), getGardianNumber()));
//            file.closeFile();
//        } catch (IOException ex) {
//
//        }
//
//        return true;
//    }
//
//    public boolean writeToFile3() {
//        FileHandler file = new FileHandler();
//        try {
//            file.openFile("StudentRegisterForm.txt");
//            file.writeFile(id.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s ", getSchool(),getYear(),getGrade(),getSubject1(),getPercent1(),getSubject2(),getPercent2(),getSubject3(),getPercent3(),getSubject4(),getPercent4(),getSubject5(),getPercent5(),getSubject6(),getPercent6(),getSubject7(),getPercent7()));
//            file.closeFile();
//        } catch (IOException ex) {
//
//        }
//
//        return true;
//    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", surname=" + surname + ", idSA=" + idSA + ", passport=" + passport + ", email=" + email + ", nationality=" + nationality + ", dateOfBirth=" + dateOfBirth + ", language=" + language + ", address=" + address + ", postalCode=" + postalCode + ", province=" + province + ", number=" + number + ", male=" + male + ", female=" + female + ", submittedId=" + submittedId + ", gardian=" + gardian + ", gardianId=" + gardianId + ", gardianName=" + gardianName + ", gardianSurname=" + gardianSurname + ", gardianEmail=" + gardianEmail + ", gardianNationality=" + gardianNationality + ", gardianAddress=" + gardianAddress + ", gardianProvince=" + gardianProvince + ", gardianPostalCode=" + gardianPostalCode + ", gardianNumber=" + gardianNumber + ", school=" + school + ", year=" + year + ", grade11=" + grade11 + ", grade12=" + grade12 + ", subject1=" + subject1 + ", percent1=" + percent1 + ", subject2=" + subject2 + ", percent2=" + percent2 + ", subject3=" + subject3 + ", percent3=" + percent3 + ", subject4=" + subject4 + ", percent4=" + percent4 + ", subject5=" + subject5 + ", percent5=" + percent5 + ", subject6=" + subject6 + ", percent6=" + percent6 + ", subject7=" + subject7 + ", percent7=" + percent7 + '}';
    }
    
}
