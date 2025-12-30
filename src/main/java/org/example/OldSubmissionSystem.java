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
    public void processSubmissions(){
        System.out.println(" Eastminster University exam submission system - old ");
        System.out.println("processing "+ numberOfStudents + " submissions one by one");
        System.out.println();
        submissionStats.setStartTime();
        System.out.println("Start processing ");
        System.out.println("Main thread: "+ Thread.currentThread().getName());
        System.out.println();

        for (int i=0; i < numberOfStudents; i++){
            Student student = new Student(i+1, "Student ", (i+1));
//            try {
//                // process this student
////                boolean success = student.submitExam(student.getName());
//            }

        }
    }


}
