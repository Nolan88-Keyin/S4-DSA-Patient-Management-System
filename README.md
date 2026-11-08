# Patient Management System

A Java console application demonstrating a triage-prioritized patient waiting queue and a doubly linked list for navigating patient history.

## Requirements

- JDK 27
- Apache Maven

## Build and run

From the project root, run:

```bash
mvn compile exec:java
```

Run the unit tests with:

```bash
mvn test
```

## Using the application

The program displays a numbered menu. Enter the number for an action and follow the prompts:

| Option | Action |
|---|---|
| 1 | Search for a patient ID in the current waiting queue |
| 2 | Add a patient; enter ID, name, reason for visit, and triage level |
| 3 | Serve and remove the next patient |
| 4 | Add an emergency patient at a specified queue position |
| 5 | Display all patients currently waiting |
| 6 | Navigate to the next patient-history record |
| 7 | Navigate to the previous patient-history record |
| 8 | Display and navigate to the oldest history record |
| 9 | Display and navigate to the newest history record |
| 10 | Exit |

Triage levels range from 1 to 5, where **1 is the highest priority** and **5 is the lowest**. Regularly added patients are ordered by triage level; patients with the same level remain in arrival order. Emergency insertion uses a displayed, 1-based position (position 1 is the front of the queue) and can manually change that ordering.

The waiting queue starts empty each time the program runs. The history is initialized with 10 sample records. History navigation starts at the oldest record; the next and previous options report when you are already at either end. All data is held in memory and is not saved after the program exits.

Patient-ID search only checks patients currently in the waiting queue; patients who have already been served are no longer searchable there.