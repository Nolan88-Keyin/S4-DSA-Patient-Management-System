import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PatientSystemTests {
    @Test
    public void testPatientHistoryRecordCreation() {
        PatientHistoryRecord record = new PatientHistoryRecord("2025-01-12", "Seasonal allergies", "Recommended avoidance of known triggers.");
        Assertions.assertEquals("2025-01-12", record.getVisitDate());
        Assertions.assertEquals("Seasonal allergies", record.getDiagnosis());
        Assertions.assertEquals("Recommended avoidance of known triggers.", record.getTreatmentNotes());
    }

    @Test
    public void queueTriagePriorityTest() {
        PatientWaitingQueue queue = new PatientWaitingQueue();
        queue.addPatient(new Patient("John Doe", 30, "Flu", 2));
        queue.addPatient(new Patient("Jane Smith", 25, "Broken Arm", 1));
        queue.addPatient(new Patient("Alice Johnson", 40, "Headache", 3));

        Assertions.assertEquals("Jane Smith", queue.nextPatient().getName());
        Assertions.assertEquals("John Doe", queue.nextPatient().getName());
        Assertions.assertEquals("Alice Johnson", queue.nextPatient().getName());
    }

    @Test
    public void insertEmergencyPatientTest() {
        PatientWaitingQueue queue = new PatientWaitingQueue();
        queue.addPatient(new Patient("John Doe", 30, "Flu", 2));
        queue.addPatient(new Patient("Jane Smith", 25, "Broken Arm", 1));

        boolean inserted = queue.insertAtPosition(1, new Patient("Emergency Patient", 50, "Heart Attack", 1));
        Assertions.assertTrue(inserted);

        Assertions.assertEquals("Jane Smith", queue.nextPatient().getName());
        Assertions.assertEquals("Emergency Patient", queue.nextPatient().getName());
    }

    @Test
    public void testPatientHistoryNavigation() {
        PatientHistory history = new PatientHistory();
        history.addRecord(new PatientHistoryRecord("2025-01-12", "Seasonal allergies", "Recommended avoidance of known triggers."));
        history.addRecord(new PatientHistoryRecord("2025-02-03", "Common cold", "Rest and fluids advised."));
        history.addRecord(new PatientHistoryRecord("2025-03-19", "Minor wrist sprain", "Wrist support and rest recommended."));

        PatientHistoryRecord oldest = history.getCurrent();
        PatientHistoryRecord middle = history.next();
        PatientHistoryRecord newest = history.next();

        Assertions.assertEquals("2025-02-03", middle.getVisitDate());
        Assertions.assertEquals("2025-03-19", newest.getVisitDate());
        Assertions.assertNull(history.next());
        Assertions.assertSame(newest, history.getCurrent());

        Assertions.assertSame(middle, history.previous());
        Assertions.assertSame(oldest, history.previous());
        Assertions.assertNull(history.previous());
        Assertions.assertSame(oldest, history.getCurrent());
    }
}
