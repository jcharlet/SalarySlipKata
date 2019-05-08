package org.neomatrix369.salaryslip;

import org.neomatrix369.salaryslip.domain.Employee;
import org.neomatrix369.salaryslip.domain.SalarySlip;
import org.neomatrix369.salaryslip.service.CalculationService;

public class SalarySlipGenerator {
    private final CalculationService calculationService = new CalculationService();
    public SalarySlip generateFor(Employee employee) {
        SalarySlip salarySlip = new SalarySlip();
        salarySlip.setEmployee(employee);
        int grossSalary = employee.getAnnualGrossSalary() / 12;
        salarySlip.setGrossSalary(grossSalary);
        salarySlip.setNationalInsuranceContributions(calculationService.calculateNationalInsuranceContributions(grossSalary));
        return salarySlip;
    }
}