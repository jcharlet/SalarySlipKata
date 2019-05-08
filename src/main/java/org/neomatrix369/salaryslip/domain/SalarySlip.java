package org.neomatrix369.salaryslip.domain;

public class SalarySlip {
    private Employee employee;
    private double grossSalary;
    private double nationalInsuranceContributions;
    private double taxFreeAllowance;
    private double taxableIncome;
    private double taxPayable;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNationalInsuranceContributions() {
        return nationalInsuranceContributions;
    }

    public void setNationalInsuranceContributions(double nationalInsuranceContributions) {
        this.nationalInsuranceContributions = nationalInsuranceContributions;
    }

    public double getTaxFreeAllowance() {
        return taxFreeAllowance;
    }

    public void setTaxFreeAllowance(double taxFreeAllowance) {
        this.taxFreeAllowance = taxFreeAllowance;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTaxPayable() {
        return taxPayable;
    }

    public void setTaxPayable(double taxPayable) {
        this.taxPayable = taxPayable;
    }
}
