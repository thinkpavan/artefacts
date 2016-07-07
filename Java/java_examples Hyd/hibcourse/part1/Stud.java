public class Stud{
    private String name;
    private Long studid;
    private String fname;
    private String address;
    public  void setName(String n) {
        name=n;
    }
    public  void setStudentId(Long  n) {
        studid=n;
    }
    public  void setFatherName(String n) {
        fname=n;
    }
    public  void setAddress(String n) {
        address=n;
    }
    public  String getName() {
        return name;
    }
    public  Long getStudentId() {
        return studid;
    }
    public  String getFatherName() {
        return fname;
    }
    public  String getAddress() {
        return address;
    }

   }