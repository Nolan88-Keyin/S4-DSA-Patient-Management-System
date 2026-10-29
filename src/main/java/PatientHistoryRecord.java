public class PatientHistoryRecord {
    private final String visitDate;
    private final String diagnosis;
    private final String treatmentNotes;

    public PatientHistoryRecord(String visitDate, String diagnosis, String treatmentNotes) {
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.treatmentNotes = treatmentNotes;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatmentNotes() {
        return treatmentNotes;
    }

    @Override
    public String toString() {
        return "Visit Date: " + visitDate +
                " | Diagnosis: " + diagnosis +
                " | Treatment Notes: " + treatmentNotes;
    }
}
