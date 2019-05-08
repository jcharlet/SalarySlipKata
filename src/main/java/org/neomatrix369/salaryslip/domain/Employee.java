package org.neomatrix369.salaryslip.domain;

public class Employee {
    private String name;
    private int id;
    private int annualGrossSalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnnualGrossSalary(int annualGrossSalary) {
        this.annualGrossSalary = annualGrossSalary;
    }

    public int getAnnualGrossSalary() {
        return annualGrossSalary;
    }
}
