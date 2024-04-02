// Name: Afnan Farhat 
// Email: ahfarhat@stu.kau.edu.sa
// ID: 2105973
// Dr. Ola Alsaedi
// Section: B0T
// Assignment No: 1
// Date: 22/12/2022 - 5/1/2023
package TherapistSystem;

import java.io.PrintWriter;

public class WaitingList {

    // Data Feild 
    private Patient headW;
    private Therapist headT;
    private int PatID;

    // boolean | isEmpty()
    public boolean isEmpty() {
        return headW == null;
    }

    // String | displayAllWaitingPatient(Patient, int)
    public void displayAllWaitingPatient(PrintWriter pen) {
        displayAllWaitingPatient(headW, PatID, pen);
    }

    private void displayAllWaitingPatient(Patient headW, int PatID, PrintWriter pen) {
        // We need to traverse...so we need a help ptr
        Patient helpPtr = headW;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Print the data value of the node
            pen.print((helpPtr.getPatID() + "\t\t" + helpPtr.getFname() + " " + helpPtr.getlName()
                    + "\t\t" + helpPtr.getTherpID() + "\t" + helpPtr.getDiagnostic() + "          " + helpPtr.getStatus() + "\n"));
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
    }

    // Patient | addWaiting(Patient, values)
    public void addWaiting(int PatID, String Fname, String lName, int TherpID, String Diagnostic, String Status) {
        headW = addWaiting(headW, PatID, Fname, lName, TherpID, Diagnostic, Status);
    }

    private Patient addWaiting(Patient headW, int PatID, String Fname, String lName, int TherpID, String Diagnostic, String Status) {
        // IF there is no list, newNode will be the first node, so just return it
        if (headW == null) {
            headW = new Patient(PatID, Fname, lName, TherpID, Diagnostic, Status, headW);
            return headW;
        } // ELSE, we have a list. Insert the new node at the correct location
        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            Patient helpPtr = headW;
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
        return headW;
    }

    // boolean | searchPatID(Patient, int)
    public Patient searchPatID(int PatID) {
        return searchPatID(headW, PatID);
    }

    private Patient searchPatID(Patient headW, int PatID) {
        Patient helpPtr = headW;
        while (helpPtr != null) {
            if (helpPtr.getPatID() == PatID) {
                break;
            }
            helpPtr = helpPtr.getNext();
        }
        return helpPtr;
    }

    // Therapist | searchTherapistID(Therapist, int)

    public Patient searchSpecialist( String Specialist) {
        Patient helpPtr = headW;
        while (helpPtr != null) {
            if (helpPtr.getDiagnostic().equals(Specialist)) {
                break;
            }
            helpPtr = helpPtr.getNext();
        }
        return helpPtr;
    }

    // void | deletePatientByID(Patient, int)
    public void deletePatientByID(int PatID) {
        headW = deletePatientByID(headW, PatID);
    }

    private Patient deletePatientByID(Patient headW, int PatID) {
        // We can only delete if the list has nodes (is not empty)
        if (!isEmpty() ){
            // IF the first node (at the head) has the data value we are wanting to delete
            // we found it. Delete by skipping the node and making head point to the next node.
            if (headW.getPatID() == PatID) {
                headW = headW.getNext();
            } // ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
            else {
                // We need to traverse to find the data we want to delete...so we need a help ptr
                Patient helpPtr = headW;
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
        }
        return headW; // null
    }
}
