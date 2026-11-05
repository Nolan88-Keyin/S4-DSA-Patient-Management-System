import java.util.Scanner;

public class PatientScannerMenu {
    private final Scanner scanner;
    private final PatientWaitingQueue waitingQueue;
    private final PatientHistory patientHistory;
    private boolean running;

    public PatientScannerMenu(PatientWaitingQueue waitingQueue, PatientHistory patientHistory) {
        this.scanner = new Scanner(System.in);
        this.waitingQueue = waitingQueue;
        this.patientHistory = patientHistory;
        this.running = true;
    }

    public void run() {
        while (running && scanner.hasNextLine()) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    scanPatientId();
                    break;
                case "2":
                    addPatient();
                    break;
                case "3":
                    serveNextPatient();
                    break;
                case "4":
                    insertEmergencyPatient();
                    break;
                case "5":
                    waitingQueue.printQueue();
                    break;
                case "6":
                    patientHistory.showNextWithMessage();
                    break;
                case "7":
                    patientHistory.showPreviousWithMessage();
                    break;
                case "8":
                    displayHistoryRecord(patientHistory.showOldest(), "No patient history records available.");
                    break;
                case "9":
                    displayHistoryRecord(patientHistory.showNewest(), "No patient history records available.");
                    break;
                case "10":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nPatient Management Menu:");
        System.out.println("1. Scan Patient ID in waiting queue");
        System.out.println("2. Add patient to waiting queue");
        System.out.println("3. Serve next patient");
        System.out.println("4. Insert emergency patient at position");
        System.out.println("5. Display waiting queue");
        System.out.println("6. Show next history record");
        System.out.println("7. Show previous history record");
        System.out.println("8. Display oldest history record");
        System.out.println("9. Display newest history record");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    private void scanPatientId() {
        Integer id = promptForInteger("Enter patient ID: ");
        if (id == null) {
            return;
        }

        Patient patient = waitingQueue.searchById(id);
        if (patient == null) {
            System.out.println("Patient ID " + id + " was not found in the waiting queue.");
        } else {
            System.out.println("Patient found: " + patient);
        }
    }

    private void addPatient() {
        Patient patient = promptForPatient();
        if (patient != null) {
            waitingQueue.addPatient(patient);
            System.out.println("Patient added to the waiting queue.");
        }
    }

    private void serveNextPatient() {
        Patient patient = waitingQueue.nextPatient();
        if (patient == null) {
            System.out.println("The waiting queue is empty.");
        } else {
            System.out.println("Serving patient: " + patient);
        }
    }

    private void insertEmergencyPatient() {
        Patient patient = promptForPatient();
        if (patient == null) {
            return;
        }

        Integer position = promptForInteger("Enter queue position (1-" + (waitingQueue.size() + 1) + "): ");
        if (position == null) {
            return;
        }
        if (waitingQueue.insertAtPosition(position - 1, patient)) {
            System.out.println("Emergency patient inserted at position " + position + ".");
        } else {
            System.out.println("Invalid queue position.");
        }
    }

    private Patient promptForPatient() {
        Integer id = promptForInteger("Enter patient ID: ");
        if (id == null) {
            return null;
        }

        System.out.print("Enter patient name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter reason for visit: ");
        String reason = scanner.nextLine().trim();
        Integer triageLevel = promptForInteger("Enter triage level (1=highest priority, 5=lowest): ");
        if (triageLevel == null) {
            return null;
        }
        if (triageLevel < 1 || triageLevel > 5) {
            System.out.println("Triage level must be from 1 to 5.");
            return null;
        }
        if (name.isEmpty() || reason.isEmpty()) {
            System.out.println("Patient name and reason for visit cannot be empty.");
            return null;
        }

        return new Patient(name, id, reason, triageLevel);
    }

    private Integer promptForInteger(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            System.out.println("Please enter a valid whole number.");
            return null;
        }
    }

    private void displayHistoryRecord(PatientHistoryRecord record, String emptyMessage) {
        if (record == null) {
            System.out.println(emptyMessage);
        } else {
            System.out.println(record);
        }
    }
}
