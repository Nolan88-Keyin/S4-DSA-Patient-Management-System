public class PatientHistory {
    private static class Node {
        PatientHistoryRecord data;
        Node next;
        Node prev;

        Node(PatientHistoryRecord data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private Node current;
    private int size;

    public PatientHistory() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }

    public void addRecord(PatientHistoryRecord record) {
        Node newNode = new Node(record);
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public PatientHistoryRecord getCurrent() {
        return current == null ? null : current.data;
    }

    public PatientHistoryRecord showOldest() {
        if (head == null) {
            return null;
        }
        current = head;
        return current.data;
    }

    public PatientHistoryRecord showNewest() {
        if (tail == null) {
            return null;
        }
        current = tail;
        return current.data;
    }

    public PatientHistoryRecord next() {
        if (current == null || current.next == null) {
            return null;
        }
        current = current.next;
        return current.data;
    }

    public PatientHistoryRecord previous() {
        if (current == null || current.prev == null) {
            return null;
        }
        current = current.prev;
        return current.data;
    }

    public boolean hasNext() {
        return current != null && current.next != null;
    }

    public boolean hasPrevious() {
        return current != null && current.prev != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
