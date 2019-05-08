package org.neomatrix369.salaryslip;

import org.junit.Assert;
import org.junit.Test;
import org.neomatrix369.salaryslip.domain.Employee;
import org.neomatrix369.salaryslip.domain.SalarySlip;

public class SalarySlipGeneratorTest {

    @Test
    public void checkThatICanGenerateASalarySlip() {
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
        Assert.assertEquals(2000.00,salarySlip.getGrossSalary());
        Assert.assertEquals(159.40,salarySlip.getNationalInsuranceContributions());
        Assert.assertEquals(916.67,salarySlip.getTaxFreeAllowance());
        Assert.assertEquals(1083.33,salarySlip.getTaxableIncome());
        Assert.assertEquals(216.67,salarySlip.getTaxPayable());
    }
}