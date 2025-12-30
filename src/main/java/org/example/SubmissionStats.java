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
    public void IncreaseSuccessfulSubmission(){
        successfulSubmissions.incrementAndGet();

    }
    //records a fail submission
    //called by worker threads when the submission fails
    public void increaseFailingSubmissions(){
        failedSubmissions.incrementAndGet();

    }
    public void printResults(String method, long totaltimeMS){

    }


}
