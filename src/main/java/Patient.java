public class Patient {
    private final String name;
    private final int id;
    private final String reasonForVisit;

    public Patient(String name, int id, String reasonForVisit) {
        this.name = name;
        this.id = id;
        this.reasonForVisit = reasonForVisit;
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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reasonForVisit='" + reasonForVisit + '\'' +
                '}';
    }
}