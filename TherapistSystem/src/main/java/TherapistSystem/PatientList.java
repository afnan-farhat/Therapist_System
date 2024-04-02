// Name: Afnan Farhat 
// Email: ahfarhat@stu.kau.edu.sa
// ID: 2105973
// Dr. Ola Alsaedi
// Section: B0T
// Assignment No: 1
// Date: 22/12/2022 - 5/1/2023
package TherapistSystem;

import java.io.PrintWriter;

public class PatientList {

    //Data Feild 
    private Patient headP;

    // Constractures
    public PatientList() {
        headP = null;
    }

    public PatientList(Patient headP) {
        this.headP = headP;
    }

    //  boolean | isEmpty() 
    public boolean isEmpty() {
        return headP == null;
    }

    // Patient | addPatient(Patient, values)
    public void addPatient(int PatID, String Fname, String lName, int TherpID, String Diagnostic, String Status) {
        headP = addPatient(headP, PatID, Fname, lName, TherpID, Diagnostic, Status);
    }

    private Patient addPatient(Patient headP, int PatID, String Fname, String lName, int TherpID, String Diagnostic, String Status) {
        // IF there is no list, newNode will be the first node, so just return it
        if (headP == null) {
            headP = new Patient(PatID, Fname, lName, TherpID, Diagnostic, Status, headP);
            return headP;
        } // ELSE, we have a list. Insert the new node at the correct location
        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            Patient helpPtr = headP;
            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) {

                helpPtr = helpPtr.getNext();
            }
            // Now make the new node. Set its next to point to the successor node.
            // And then make the predecessor node point to the new node
            Patient newNode = new Patient(PatID, Fname, lName, TherpID, Diagnostic, Status, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        // Return head
        return headP;
    }

    // void | deletePatientByID(Patient, int)
    public void deletePatientByID(int PatID) {
        headP = deletePatientByID(headP, PatID);
    }

    private Patient deletePatientByID(Patient headP, int PatID) {
        // We can only delete if the list has nodes (is not empty)
        if (headP != null) {
            // IF the first node (at the head) has the data value we are wanting to delete
            // we found it. Delete by skipping the node and making head point to the next node.
            if (headP.getPatID() == PatID) {
                headP = headP.getNext();
            } // ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
            else {
                // We need to traverse to find the data we want to delete...so we need a help ptr
                Patient helpPtr = headP;
                // Traverse to correct deletion point
                while (helpPtr.getNext() != null) {
                    if (helpPtr.getNext().getPatID() == PatID) {
                        helpPtr.setNext(helpPtr.getNext().getNext());
                        break; // we deleted the value and should break out of the while loop
                    }
                    helpPtr = helpPtr.getNext();
                }
            }
            // return the possibly updated head of the list
            return headP;
        }
        return headP; // null
    }

    // String | displayAllPatient (Patient)
    public void displayAllPatient(PrintWriter pen) {
        displayAllPatient(headP, pen);
    }

    private void displayAllPatient(Patient headP, PrintWriter pen) {
        // We need to traverse...so we need a help ptr
        Patient helpPtr = headP;

        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Add all data to variable
            String fullName = helpPtr.getFname() + " " + helpPtr.getlName();
            pen.printf("%-18d%-18s%-12d%-14s%s%n", helpPtr.getPatID(), fullName, helpPtr.getTherpID(),
                    helpPtr.getDiagnostic(), helpPtr.getStatus());
            // Step one node over
            helpPtr = helpPtr.getNext();
            //helpPtr_T = helpPtr_T.getNext();
        }
    }

    // void | addWaiting(Patient, values)
    public void addWaiting(int PatID, String Fname, String lName, int TherpID, String Diagnostic, String Status) {
        headP = addWaiting(headP, PatID, Fname, lName, TherpID, Diagnostic, Status);
    }

    private Patient addWaiting(Patient headP, int PatID, String Fname, String lName, int TherpID, String Diagnostic, String Status) {
        // IF there is no list, newNode will be the first node, so just return it
        if (headP == null || headP.getPatID() > PatID) {
            headP = new Patient(PatID, Fname, lName, TherpID, Diagnostic, Status, headP);
            return headP;
        } // ELSE, we have a list. Insert the new node at the correct location
        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            Patient helpPtr = headP;
            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) {
                if (helpPtr.getNext().getPatID() > PatID) {
                    break; // we found our spot and should break out of the while loop
                }
                helpPtr = helpPtr.getNext();
            }
            // Now make the new node. Set its next to point to the successor node.
            // And then make the predecessor node point to the new node
            Patient newNode = new Patient(PatID, Fname, lName, TherpID, Diagnostic, Status, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        // Return head
        return headP;
    }

    // boolean | searchPatID(Patient, int)
    public Patient searchPatID(int PatID) {
        return searchPatID(headP, PatID);
    }

    private Patient searchPatID(Patient headP, int PatID) {
        Patient helpPtr = headP;
        while (helpPtr != null) {
            if (helpPtr.getPatID() == PatID) {
                return helpPtr;
            }
            helpPtr = helpPtr.getNext();
        }
        return headP;
    }

}
