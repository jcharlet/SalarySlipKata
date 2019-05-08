package org.neomatrix369.salaryslip.service;

public class CalculationService {

    public static final double HIGHER_CONTRIB_THRESHOLD = 43000.0 / 12;
    public static final double BASIC_CONTRIB_THRESHOLD = 8060.0/12;

    /**
     * calculateNationalInsuranceContributions
     *       ---------------------+-------------------------+--------
     *       Band                 | NI deductible income    | NI Rate
     *       ---------------------+-------------------------+--------
     *       No contributions     | Up to £8,060.00         |    0%
     *       Basic contributions  | £8,060.00 to £43,000.00 |   12%
     *       Higher contributions | over £43,000.00         |    2%
     *       ---------------------+-------------------------+--------
     * @param grossSalary
     * @return
     */
    public double calculateNationalInsuranceContributions(double grossSalary) {
        double excessIncomeForHigherContributions = grossSalary - HIGHER_CONTRIB_THRESHOLD;
        if(excessIncomeForHigherContributions<0){
            excessIncomeForHigherContributions=0;
        }


        double excessIncomeForBasicContributions = grossSalary - BASIC_CONTRIB_THRESHOLD;
        if(excessIncomeForBasicContributions > HIGHER_CONTRIB_THRESHOLD -BASIC_CONTRIB_THRESHOLD){
            excessIncomeForBasicContributions= HIGHER_CONTRIB_THRESHOLD -BASIC_CONTRIB_THRESHOLD;
        }else if(excessIncomeForBasicContributions<0){
            excessIncomeForBasicContributions=0;
        }

        return excessIncomeForBasicContributions*0.12+excessIncomeForHigherContributions*0.02;
    }
}
