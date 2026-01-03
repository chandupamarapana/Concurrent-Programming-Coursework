package org.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewSubmissionSystem {
    private int numofStudents;
    private int poolSize;
    private SubmissionStats submissionStats;
    private ExecutorService executor;

    public NewSubmissionSystem(int poolSize, int numofStudents){
        this.poolSize = poolSize;
        this.submissionStats = new SubmissionStats();
        this.numofStudents = numofStudents;
    }
    // The new system uses a threadPool with multiple threads processing concurrently
    // Each student submission is a separated task submitted to the pool
    public void processSubmission() {
        System.out.println("The new submissions system");
        System.out.println(" Processing " + numofStudents + " submissions concurrently ");
        System.out.println("Thread pool size " + poolSize);
        System.out.println();

        //Create thread pool with specified number of threads
        executor = Executors.newFixedThreadPool(poolSize);

        //CountdownLatch to wait for all submissions to complete
        // Initiated with the number of students - counts down to zero
        CountDownLatch countDownLatch = new CountDownLatch(numofStudents);

        submissionStats.setStartTime();

        //submit each student as a separate task to the thread pool
        for (int i = 0; i < numofStudents; i++) {
            final int studentId = i + 1;
            final String studentName = "Student " + studentId;

            // each submition runs in parellel on available threads
            executor.execute(() -> {
                Student student = new Student(studentId, studentName);
                try {
                    boolean success = student.submitExam(studentName);
                    if (success) {
                        submissionStats.increaseSuccessfulSubmission();
                    } else {
                        submissionStats.increaseFailingSubmissions();
                    }
                    //show the progress for every 1000 students
                    if (studentId % 1000 == 0) {
                        System.out.println("[" + Thread.currentThread().getName() + "]" + "Processed submissions for student " + studentId);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    submissionStats.increaseFailingSubmissions();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            System.out.println("waiting for all the " + poolSize + " Threads to complete all the submissions ");
            countDownLatch.await(); // wait untill all the submissions are done (latch = 0 )
            System.out.println("All submissions finished! ");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted while waiting! ");
        }
        submissionStats.setEndTime();
        System.out.println(" all the submissions are complete ");
        System.out.println(" All " + numofStudents + "submissions processed by " + poolSize + " threads.");
        System.out.println();
    }
    public SubmissionStats getStats() {
        return submissionStats;
    }

    //shutdown the executor service gracefully
    public void shutdown() throws InterruptedException{
        System.out.println(" Shutting down thread pool ");
        executor.shutdown(); // Dont accept new tasks

        //wait for existing tasks to complete (max 30 seconds )
        if (!executor.awaitTermination(30, TimeUnit.SECONDS)){
            System.out.println("Thread pool did not terminate in time, Forcing shutdown");
            executor.shutdown();
        }
        System.out.println(" New Submission system shutting down.");
    }

}
