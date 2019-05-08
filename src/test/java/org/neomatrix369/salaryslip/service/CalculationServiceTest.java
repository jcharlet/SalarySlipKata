package org.neomatrix369.salaryslip.service;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationServiceTest {

    @Test
    public void testCalculateNationalInsuranceContributions() {

        //given my calculation service
        CalculationService calculationService = new CalculationService();
        // and a list of salaries and expected contributions

        double[][] arrayOfMonthlySalaryAndExpectedContributions = {{416.67    ,0.00},
        {671.67    ,0.00},
        {755.00    ,10.00},
        {3333.33  ,319.40},
        {3583.33  ,349.40},
        {3750.00  ,352.73},
        {4166.67  ,361.07},
        {5000.00  ,377.73}};

        for (int i = 0; i < arrayOfMonthlySalaryAndExpectedContributions.length; i++) {
            //when I calculate the contributions for every salary
            double nationalInsuranceContributions = calculationService.calculateNationalInsuranceContributions(arrayOfMonthlySalaryAndExpectedContributions[i][0]);
            // then I get the right contributions
            double expected = arrayOfMonthlySalaryAndExpectedContributions[i][1];
            Assert.assertEquals(expected,nationalInsuranceContributions,1);
        }

    }
}