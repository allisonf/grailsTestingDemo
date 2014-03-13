package com.allison.test.functional.data

import com.allison.domain.Employee


class EmployeeDataUtil {

    Long createEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName: firstName, lastName: lastName)

        employee.save(flush: true)

        employee.id
    }

    void deleteEmployee(Long id) {
        Employee employee = Employee.get(id)
        employee.delete(flush: true)
    }
}
