package SalarySlipKata.domain_service;

import static java.time.LocalDate.now;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import SalarySlipKata.domain.Bonus;
import SalarySlipKata.domain.EmployeeId;
import SalarySlipKata.domain.GBP;
import SalarySlipKata.domain.Loan;
import SalarySlipKata.domain.Overtime;
import SalarySlipKata.domain.SalaryItem;

public class SalaryRepository {
  private final Map<EmployeeId, List<SalaryItem>> salaries = new HashMap<>();

  static final SalaryItem NO_OVERTIME = new Overtime(new GBP(0.0), now());
  static final SalaryItem NO_LOAN = new Loan(new GBP(0.0), now());
  static final SalaryItem NO_BONUS = new Bonus(new GBP(0.0), now());

  public void addEarningFor(EmployeeId employeeId, SalaryItem earning) {
    addSalaryToListFor(employeeId, earning);
  }

  public void addDeductionFor(EmployeeId employeeId, SalaryItem deduction) {
    addSalaryToListFor(employeeId, deduction);
  }

  private void addSalaryToListFor(EmployeeId employeeId, SalaryItem salaryItem) {
    final List<SalaryItem> list = salaries.getOrDefault(employeeId, new ArrayList<>());
    list.add(salaryItem);

    salaries.put(employeeId, list);
  }

  public GBP getBonusFor(EmployeeId employeeId) {
    return getFromSalaryListFor(employeeId, eachSalaryItem -> eachSalaryItem instanceof Bonus, NO_BONUS);
  }

  public GBP getOvertimeFor(EmployeeId employeeId) {
    return getFromSalaryListFor(employeeId, eachSalaryItem -> eachSalaryItem instanceof Overtime, NO_OVERTIME);
  }

  public GBP getLoanFor(EmployeeId employeeId) {
    return getFromSalaryListFor(employeeId, eachSalaryItem -> eachSalaryItem instanceof Loan, NO_LOAN);
  }

  private GBP getFromSalaryListFor(
      EmployeeId employeeId,
      Predicate<SalaryItem> condition,
      SalaryItem defaultSalaryItem) {

    return salaries
        .get(employeeId)
        .stream()
        .filter(condition)
        .findFirst()
        .orElse(defaultSalaryItem)
        .getAmount();
  }
}
