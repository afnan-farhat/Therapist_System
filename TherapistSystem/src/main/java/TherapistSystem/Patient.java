// Name: Afnan Farhat 
// Email: ahfarhat@stu.kau.edu.sa
// ID: 2105973
// Dr. Ola Alsaedi
// Section: B0T
// Assignment No: 1
// Date: 22/12/2022 - 5/1/2023

package TherapistSystem;

public class Patient {

    //Data Feild 
    private int PatID;
    private String Fname;
    private String lName;
    private int TherpID;
    private String Diagnostic;
    private String Status;
    private Patient next;

    // defult constracture
    public Patient() {
    }
    
    // Constracture with all data 
    public Patient(int PatID, String Fname, String lName,int TherpID ,String Diagnostic, String Status) {
        this.PatID = PatID;
        this.Fname = Fname;
        this.lName = lName;
        this.Diagnostic = Diagnostic;
        this.Status = Status;
        next = null;
    }

    // Constracture with all data & next (refrence)
    public Patient(int PatID, String Fname, String lName,int TherpID, String Diagnostic, String Status, Patient next) {
        this.PatID = PatID;
        this.Fname = Fname;
        this.lName = lName;
        this.TherpID = TherpID;
        this.Diagnostic = Diagnostic;
        this.Status = Status;
        this.next = next;
    }

    // Other methods
    public int getPatID() {
        return PatID;
    }

    public String getFname() {
        return Fname;
    }

    public String getlName() {
        return lName;
    }

    public int getTherpID() {
        return TherpID;
    }

    public String getDiagnostic() {
        return Diagnostic;
    }

    public String getStatus() {
        return Status;
    }

    public Patient getNext() {
        return next;
    }

    public void setPatID(int PatID) {
        this.PatID = PatID;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setTherpID(int TherpID) {
        this.TherpID = TherpID;
    }

    public void setDiagnostic(String Diagnostic) {
        this.Diagnostic = Diagnostic;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setNext(Patient next) {
        this.next = next;
    }

}
