package org.neomatrix369.salaryslip;

import org.junit.Assert;
import org.junit.Test;
import org.neomatrix369.salaryslip.domain.Employee;
import org.neomatrix369.salaryslip.domain.SalarySlip;

public class SalarySlipGeneratorIntegrationTest {

    @Test
    public void checkThatICanGenerateASalarySlipWithASalaryOf24000() {
        //given my generator
        SalarySlipGenerator salarySlipGenerator = new SalarySlipGenerator();
        //and employee details
        Employee employee = new Employee();
        employee.setId(12345);
        employee.setAnnualGrossSalary(24000);
        employee.setName("John J Doe");

        //when I generate the salary slip
        SalarySlip salarySlip = salarySlipGenerator.generateFor(employee);

        //then I get a salary slip with the expected fields
        Assert.assertNotNull(salarySlip);
        Assert.assertEquals(12345,salarySlip.getEmployee().getId());
        Assert.assertEquals("John J Doe",salarySlip.getEmployee().getName());
        Assert.assertEquals(2000.00,salarySlip.getGrossSalary(),0.01);
        Assert.assertEquals(159.40,salarySlip.getNationalInsuranceContributions(),0.01);
        Assert.assertEquals(916.67,salarySlip.getTaxFreeAllowance(),0.01);
        Assert.assertEquals(1083.33,salarySlip.getTaxableIncome(),0.01);
        Assert.assertEquals(216.67,salarySlip.getTaxPayable(),0.01);
    }
}