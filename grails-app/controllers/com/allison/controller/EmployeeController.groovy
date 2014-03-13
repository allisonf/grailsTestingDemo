package com.allison.controller

import com.allison.domain.Employee
import com.allison.service.EmployeeService


class EmployeeController {

    EmployeeService employeeService

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        [employees: Employee.list()]
    }

    def show = {
        [employee: Employee.get(params.id)]
    }
}
