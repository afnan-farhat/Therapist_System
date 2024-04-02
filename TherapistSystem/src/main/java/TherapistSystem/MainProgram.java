// Name: Afnan Farhat 
// Email: ahfarhat@stu.kau.edu.sa
// ID: 2105973
// Dr. Ola Alsaedi
// Section: B0T
// Assignment No: 1
// Date: 22/12/2022 - 5/1/2023
package TherapistSystem;

import java.util.Scanner;
import java.io.*;

public class MainProgram {

    // Data Feild
//    private int count = 0;
    private static int numPatient = 0;
    private static int numTherapist = 0;

    public static void main(String[] args) throws FileNotFoundException {
        // STEP 1: CREATE THE FILES & SCANNER
        // Scanner to user

        // Make Scanner & Read from 3 files - Write the output in fourth file
        File fileCommands = new File("commands.txt");
        File file1 = new File("intialPatientInformation.txt");
        File file2 = new File("intialTerpaistInformation.txt");
        File output = new File("output.txt");

        Scanner inputCommands = new Scanner(fileCommands);
        Scanner input1 = new Scanner(file1);
        Scanner input2 = new Scanner(file2);
        PrintWriter pen = new PrintWriter(output);

        // Check the input files exist or not 
        if (!fileCommands.exists()) {
            System.out.println("Commands file not exists");
            System.exit(0);
        }
        if (!file1.exists()) {
            System.out.println("First file not exists");
            System.exit(0);
        }
        if (!file2.exists()) {
            System.out.println("Second file not exists");
            System.exit(0);
        }

        //---------------------------------------------------------------------------------------------------
        // STEP 2: Create all linked lists
        PatientList Patientlist = new PatientList(); // Patient
        TherpaistList Therapistlist = new TherpaistList(); //Therpaist
        WaitingList waitinglist = new WaitingList(); // Waiting

        // Scanner to read the information from file 1
        numPatient = input1.nextInt(); // 6
        // Scanner to read  the information from file 2
        numTherapist = input2.nextInt(); // 6

        //---------------------------------------------------------------------------------------------------
        // STEP 3: READ COMMANDS FILE TO STARTUP & DISPLAY
        startUP(inputCommands, input1, input2, Patientlist, Therapistlist, waitinglist, pen);
        DISPLAY_ALL_Info(inputCommands, Patientlist, Therapistlist, waitinglist, pen);

        inputCommands.close();
        input1.close();
        input2.close();
        pen.close();

    }

    // >>> FUNCTIONS 
    public static void startUP(Scanner inputCommands, Scanner input1, Scanner input2, PatientList Patientlist,
            TherpaistList Therapistlist, WaitingList waitinglist, PrintWriter pen) {

        String startUP = inputCommands.nextLine(); // STARTUP

        // Start to add all information for linked lists
        if (startUP.equalsIgnoreCase("STARTUP")) {

            // Store all information of Therapist in linked list
            int count_Therapist = 0;
            while (count_Therapist <= numTherapist) { // insert from 0 -> 5 (6 values) 
                if (input2.hasNextLine()) {
                    Scanner info = new Scanner(input2.nextLine()); //read other lines in seconde file 

                    if (info.hasNext()) {

                        int TherpID = info.nextInt();
                        String Fname = info.next();
                        String lName = info.next();
                        String Specialist = info.next();
                        int MaxNumOFPat = info.nextInt();
                        String Status = info.next();

                        Therapistlist.addTherapist(TherpID, Fname, lName, Specialist, MaxNumOFPat, Status);

                    }// end while
                    count_Therapist++;
                } // end if 

            }//end while

            // Store all information of Patient in linked list
            int count_Patient = 0;
            while (count_Patient <= numPatient) { // insert from 0 -> 5 (6 values)
                if (input1.hasNextLine()) {
                    Scanner info = new Scanner(input1.nextLine()); //read other lines in first file 

                    while (info.hasNext()) {
                        int PatID = info.nextInt();
                        String Fname = info.next();
                        String lName = info.next();
                        int TherpID = info.nextInt();
                        String Diagnostic = info.next();
                        String Status = info.next();

                        //Create object to delete operation
                        Therapist T = Therapistlist.searchTherapistID(TherpID);

                        // To delete pateient 
                        if (T.getStatus().equalsIgnoreCase("Available")) {
                            Patientlist.addPatient(PatID, Fname, lName, TherpID, Diagnostic, Status);
                            T.setCount(T.getCount() + 1);
                            if (T.getCount() == T.getMaxNumOFPat()) {
                                T.setStatus("NotAvailable");
                            }
                        } else {//                        else {
                            waitinglist.addWaiting(PatID, Fname, lName, TherpID, Diagnostic, "Waiting");

                            Patient P = Patientlist.searchPatID(PatID);
                            Patient W = waitinglist.searchPatID(PatID);

                            if (P == W) {
                                Patientlist.deletePatientByID(PatID);
                            }
                        }

                        //Create object to assign operation
                        Therapist T2 = Therapistlist.searchTherapistID(TherpID);
                        String specialist = T.getSpecialist();
                        Patient P2 = waitinglist.searchSpecialist(specialist);

                        // To assign pateient
                        if (P2 != null) {
                            P2.setTherpID(T2.getTherpID());
                            P2.setStatus("inprocess");
                            Patientlist.addPatient(P2.getPatID(), P2.getFname(), P2.getlName(), P2.getTherpID(),
                                    P2.getDiagnostic(), P2.getStatus());
                            waitinglist.deletePatientByID(P2.getPatID());
                        } else {
                            T2.setCount(T2.getCount() - 1);
                            T2.setStatus("Available");
                        }

                    }// end while
                    count_Patient++;

                } // end if 
            }//end while

        }

    }

    public static void DISPLAY_ALL_Info(Scanner inputCommands, PatientList Patientlist, TherpaistList Therapistlist,
            WaitingList waitinglist, PrintWriter pen) {

        String displayOperation = inputCommands.nextLine(); // DISPLAY_ALL_Info

        if (displayOperation.equalsIgnoreCase("DISPLAY_ALL_Info")) {
            // print all information for Patient list
            pen.println("Number of patients are " + numPatient);
            pen.println("PatientID	Name 			TherapistID  Diagnostic     Status ");

            Patientlist.displayAllPatient(pen);

            pen.println(".......................................................................");

            // print all information for Patient list
            pen.println("Number of Therapists are " + numTherapist);
            pen.println("TerapistID	Name 			Specialist   Max Patients     Status ");

            Therapistlist.displayAllTherapist(pen);

            pen.println(".........................................................................");

            //waitinglist.displayAllWaitingPatient(pen);
        }
    }
}
