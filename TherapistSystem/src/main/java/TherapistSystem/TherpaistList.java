// Name: Afnan Farhat 
// Email: ahfarhat@stu.kau.edu.sa
// ID: 2105973
// Dr. Ola Alsaedi
// Section: B0T
// Assignment No: 1
// Date: 22/12/2022 - 5/1/2023
package TherapistSystem;

import java.io.PrintWriter;

public class TherpaistList {

    // Data Feild
    private Therapist headT;

    // Constractures
    public TherpaistList() {
        headT = null;
    }

    public TherpaistList(Therapist headT) {
        this.headT = headT;
    }

    // boolean | isEmpty()
    public boolean isEmpty() {
        return headT == null;
    }

    // Therapist | addTherapist(Therapist, values)
    public void addTherapist(int TherpID, String Fname, String lName, String Specialist, int MaxNumOFPat, String Status) {
        headT = addTherapist(headT, TherpID, Fname, lName, Specialist, MaxNumOFPat, Status);
    }

    private Therapist addTherapist(Therapist headT, int TherpID, String Fname, String lName, String Specialist, int MaxNumOFPat, String Status) {
        // IF there is no list, newNode will be the first node, so just return it
        if (headT == null) {
            headT = new Therapist(TherpID, Fname, lName, Specialist, MaxNumOFPat, Status, headT);
            return headT;
        } // ELSE, we have a list. Insert the new node at the correct location
        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            Therapist helpPtr = headT;
            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) {

                helpPtr = helpPtr.getNext();
            }
            // Now make the new node. Set its next to point to the successor node.
            // And then make the predecessor node point to the new node
            Therapist newNode = new Therapist(TherpID, Fname, lName, Specialist, MaxNumOFPat, Status, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        // Return head
        return headT;
    }

    // void | deletePatientByID(Therapist, int)
    public void deleteTherapistByID(int TherpID) {
        headT = deleteTherapistByID(headT, TherpID);
    }

    private Therapist deleteTherapistByID(Therapist headT, int TherpID) {
        // We can only delete if the list has nodes (is not empty)
        if (headT != null) {
            // IF the first node (at the head) has the data value we are wanting to delete
            // we found it. Delete by skipping the node and making head point to the next node.
            if (headT.getTherpID() == TherpID) {
                headT = headT.getNext();
            } // ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
            else {
                // We need to traverse to find the data we want to delete...so we need a help ptr
                Therapist helpPtr = headT;
                // Traverse to correct deletion point
                while (helpPtr.getNext() != null) {
                    if (helpPtr.getNext().getTherpID() == TherpID) {
                        helpPtr.setNext(helpPtr.getNext().getNext());
                        break; // we deleted the value and should break out of the while loop
                    }
                    helpPtr = helpPtr.getNext();
                }
            }
            // return the possibly updated head of the list
            return headT;
        }
        return headT; // null
    }

    // String | displayAllTherapist(Therapist)
    public void displayAllTherapist(PrintWriter pen) {
        displayAllTherapist(headT, pen);
    }

    private void displayAllTherapist(Therapist headT, PrintWriter pen) {
        // We need to traverse...so we need a help ptr
        Therapist helpPtr = headT;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Print the data value of the node
            String fullName = helpPtr.getFname() + " " + helpPtr.getlName();
            pen.printf("%-12d%-18s%-18s%-20d%s%n", helpPtr.getTherpID(), fullName, helpPtr.getSpecialist(),
                    helpPtr.getMaxNumOFPat(), helpPtr.getStatus());
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
    }

    // Therapist | searchTherapistID(Therapist, int)
    public Therapist searchTherapistID(int TherapistID) {
        return searchTherapistID(headT, TherapistID);
    }

    private Therapist searchTherapistID(Therapist headT, int TherapistID) {
        Therapist helpPtr = headT;
        while (helpPtr != null) {
            if (helpPtr.getTherpID() == TherapistID) {
                break;
            }
            helpPtr = helpPtr.getNext();
        }
        return helpPtr;
    }

}
