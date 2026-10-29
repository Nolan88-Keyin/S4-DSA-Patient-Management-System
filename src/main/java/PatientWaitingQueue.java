import java.util.LinkedList;

public class PatientWaitingQueue {
    private final LinkedList<Patient> queue;

    public PatientWaitingQueue() {
        this.queue = new LinkedList<>();
    }

    public void addPatient(Patient patient) {
        for (int i = 0; i < queue.size(); i++) {
            if (patient.getTriageLevel() < queue.get(i).getTriageLevel()) {
                queue.add(i, patient);
                return;
            }
        }
        queue.add(patient);
    }

    public Patient nextPatient() {
        return queue.poll();
    }

    public boolean insertAtPosition(int index, Patient patient) {
        if (patient == null || index < 0 || index > queue.size()) {
            return false;
        }
        queue.add(index, patient);
        return true;
    }

    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("The waiting queue is empty.");
            return;
        }
        int position = 1;
        for (Patient patient : queue) {
            System.out.println(position++ + ". " + patient);
        }
    }

    public Patient peekNextPatient() {
        return queue.peek();
    }

    public Patient searchById(int id) {
        for (Patient patient : queue) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}