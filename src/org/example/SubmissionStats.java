package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class SubmissionStats {
    private AtomicInteger successfulSubmissions;
    private AtomicInteger failedSubmissions;
    private AtomicLong startTime;
    private AtomicLong endTime;

    public SubmissionStats(){ // initialize all statistics to zero
       this.successfulSubmissions = new AtomicInteger(0);
       this.failedSubmissions = new AtomicInteger(0);
       this.startTime = new AtomicLong(0);
       this.endTime = new AtomicLong(0);
    }


    // resets all statistics back to zero
    // useful when running multiple test scenarios
    public void reset(){
        successfulSubmissions.set(0);
        failedSubmissions.set(0);
        startTime.set(0);
        endTime.set(0);
    }
    // records a successful submission
    // called by worker threads when the submission succeeds
    public void increaseSuccessfulSubmission(){
        successfulSubmissions.incrementAndGet();

    }
    //records a fail submission
    //called by worker threads when the submission fails
    public void increaseFailingSubmissions(){
        failedSubmissions.incrementAndGet();
    }

    // records the start time of the submission process
    public void setStartTime(){
        startTime.set(System.currentTimeMillis());
    }

    // records the end time of the submission process
    public void setEndTime(){
        endTime.set(System.currentTimeMillis());
    }

    public int getSuccussfulSubmissions(){
        return successfulSubmissions.get();
    }
    public int getFailedSubmissions(){
        return failedSubmissions.get();
    }

    // get the total time for the submissions
    public long getTotalTimeMillis(){
        return endTime.get() - startTime.get();
    }

    // get the total number of submissions
    public int getTotalSubmissions(){
        return successfulSubmissions.get() + failedSubmissions.get();
    }

    // calculate the success rate as a percentage
    public double getSuccessRate(){
        int total = getTotalSubmissions();
        if (total == 0) {
            return 0.0;
        }
        return ((double) getSuccussfulSubmissions()/total) * 100;
    }
    // calculate throughput, successful submissions per second
    public double getThroughput(){
        long timeInMillis = getTotalTimeMillis();
        if (timeInMillis == 0){
            return 0.0 ;
        }
        double timeInSeconds = timeInMillis/1000.0;
        return getSuccussfulSubmissions() / timeInSeconds;
    }

    public void displayStats(){
        System.out.println("____________________________________");
        System.out.println("Submission Statistics");
        System.out.println("____________________________________");
        System.out.println("Total Submissions:       "+ getTotalSubmissions());
        System.out.println("Successful submissions   "+ getSuccussfulSubmissions());
        System.out.println("Failed submissions       "+ getFailedSubmissions());
        System.out.println("Total time (ms):         "+ getTotalTimeMillis());
        System.out.println("Total time (seconds):    "+ getTotalTimeMillis()/1000.0);
        System.out.println("Total time (minutes):    "+ getTotalTimeMillis()/1000.0/60.0);
        System.out.println("Success Rate:            "+ getSuccessRate());
        System.out.println("Throughput:              "+ getThroughput()+"submissions/sec");
        System.out.println("_____________________________________");
    }
    public void printResults(String method, long totalTimeMs){
        System.out.println(method + "- results");
        System.out.println();
        System.out.println();
        displayStats();
        System.out.println("Actual Measured Time: "+ totalTimeMs +" ms");
        System.out.println();
    }

}
