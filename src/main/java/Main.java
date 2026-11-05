public class Main {
    public static void main(String[] args) {
        PatientWaitingQueue waitingQueue = new PatientWaitingQueue();
        PatientHistory patientHistory = SamplePatientHistory.sampleData();

        PatientScannerMenu menu = new PatientScannerMenu(waitingQueue, patientHistory);
        menu.run();
    }
}
