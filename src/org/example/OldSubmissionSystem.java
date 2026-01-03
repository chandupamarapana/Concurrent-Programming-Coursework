package org.example;

// This is to simulate the old submission system and demonstrate why this is not successful for 100000 students
public class OldSubmissionSystem {
    private int numberOfStudents;
    private int poolSize;
    private SubmissionStats submissionStats;

    public OldSubmissionSystem(int numberOfStudents, int poolSize){
        this.numberOfStudents = numberOfStudents;
        this.poolSize = poolSize;
        this.submissionStats = new SubmissionStats();
    }
    public void processSubmissions() {
        System.out.println(" EastMinster University exam submission system - old ");
        System.out.println("processing " + numberOfStudents + " submissions one by one");
        System.out.println();
        submissionStats.setStartTime();
        System.out.println("Start processing ");
        System.out.println("Main thread: " + Thread.currentThread().getName());
        System.out.println();

        for (int i = 0; i < numberOfStudents; i++) {
            Student student = new Student(i + 1, "Student " + (i + 1));
            try {
                // process this student
                boolean success = student.submitExam(student.getName());

                if (success) {
                    submissionStats.increaseSuccessfulSubmission();
                } else {
                    submissionStats.increaseFailingSubmissions();
                }
                //show the progress for every 1000 students
                if ((i + 1) % 1000 == 0) {
                    System.out.println("Processed " + (i + 1) + " submissions");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                submissionStats.increaseFailingSubmissions();
                System.out.println("Submission interrupted for " + student.getName());
            }
        }
            submissionStats.setEndTime();
            System.out.println("Submissions completed ");
            System.out.println("all " + numberOfStudents + " submissions processed");
            System.out.println();
        }

        public int getNumberOfStudents(){
            return numberOfStudents;
        }
        public int getPoolSize(){
        return poolSize;
    }
        public SubmissionStats getSubmissionStats(){
        return submissionStats;
    }


}
