package com.example.undercover.Data;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Assignment implements Iterable<String> {

    private String[] jobs = {"Astronaut", "Police Officer", "Doctor",
            "Chef", "Pirate", "Pilot", "Bus Driver", "Banker", "Lawyer", "Construction Worker",
    "Plumber", "Student"};

    private List jobsList;

    public Assignment() {
        this.jobsList = Arrays.asList(this.jobs);
    }

    public List getJobsList() {
        return jobsList;
    }

    @Override
    public Iterator<String> iterator() {
        return this.jobsList.iterator();
    }
}
