public class SamplePatientHistory {
    public static PatientHistory sampleData() {
        PatientHistory history = new PatientHistory();
        history.addRecord(new PatientHistoryRecord("2025-01-12", "Seasonal allergies", "Recommended avoidance of known triggers."));
        history.addRecord(new PatientHistoryRecord("2025-02-03", "Common cold", "Rest and fluids advised."));
        history.addRecord(new PatientHistoryRecord("2025-03-19", "Minor wrist sprain", "Wrist support and rest recommended."));
        history.addRecord(new PatientHistoryRecord("2025-04-08", "Tension headache", "Hydration and rest discussed."));
        history.addRecord(new PatientHistoryRecord("2025-05-21", "Mild dermatitis", "Skin care guidance provided."));
        history.addRecord(new PatientHistoryRecord("2025-06-14", "Seasonal allergies", "Follow-up care instructions reviewed."));
        history.addRecord(new PatientHistoryRecord("2025-07-30", "Minor ankle sprain", "Rest and gradual return to activity advised."));
        history.addRecord(new PatientHistoryRecord("2025-09-05", "Common cold", "Symptoms reviewed; rest advised."));
        history.addRecord(new PatientHistoryRecord("2025-10-17", "Tension headache", "Follow-up guidance provided."));
        history.addRecord(new PatientHistoryRecord("2025-12-02", "Routine checkup", "General wellness guidance provided."));
        return history;
    }
}
