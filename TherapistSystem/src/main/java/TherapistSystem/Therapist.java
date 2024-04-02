// Name: Afnan Farhat 
// Email: ahfarhat@stu.kau.edu.sa
// ID: 2105973
// Dr. Ola Alsaedi
// Section: B0T
// Assignment No: 1
// Date: 22/12/2022 - 5/1/2023

package TherapistSystem;

public class Therapist {

    //Data Felid
    private int TherpID;
    private String Fname;
    private String lName;
    private String Specialist;
    private int MaxNumOFPat;
    private String Status;
    private Therapist next;
    private int count = 0;

    // Defult constracture
    public Therapist() {
    }

    // Constracture with all data 
    public Therapist(int TherpID, String Fname, String lName, String Specialist, int MaxNumOFPat, String Status, int count, Therapist next) {
        this.TherpID = TherpID;
        this.Fname = Fname;
        this.lName = lName;
        this.Specialist = Specialist;
        this.MaxNumOFPat = MaxNumOFPat;
        this.Status = Status;
        this.count = count;
        this.next = next;
    }

    // Constracture with all data & next (refrence)
    public Therapist(int TherpID, String Fname, String lName, String Specialist, int MaxNumOFPat, String Status, Therapist next) {
        this.TherpID = TherpID;
        this.Fname = Fname;
        this.lName = lName;
        this.Specialist = Specialist;
        this.MaxNumOFPat = MaxNumOFPat;
        this.Status = Status;
        this.next = next;
    }
    
    // Other methods
    public int getCount() {
        return count;
    }

    public int getTherpID() {
        return TherpID;
    }

    public String getFname() {
        return Fname;
    }

    public String getlName() {
        return lName;
    }

    public String getSpecialist() {
        return Specialist;
    }

    public int getMaxNumOFPat() {
        return MaxNumOFPat;
    }

    public String getStatus() {
        return Status;
    }

    public Therapist getNext() {
        return next;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTherpID(int TherpID) {
        this.TherpID = TherpID;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setSpecialist(String Specialist) {
        this.Specialist = Specialist;
    }

    public void setMaxNumOFPat(int MaxNumOFPat) {
        this.MaxNumOFPat = MaxNumOFPat;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setNext(Therapist next) {
        this.next = next;
    }
    
    
    

}
