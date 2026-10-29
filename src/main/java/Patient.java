import java.time.LocalDateTime;

public class Patient {
    private final String name;
    private final int id;
    private final String reasonForVisit;
    private final int triageLevel;
    private final LocalDateTime arrivalTime;

    public Patient(String name, int id, String reasonForVisit, int triageLevel) {
        this.name = name;
        this.id = id;
        this.reasonForVisit = reasonForVisit;
        this.triageLevel = triageLevel;
        this.arrivalTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reasonForVisit='" + reasonForVisit + '\'' +
                ", triageLevel=" + triageLevel +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}