package com.allison.functional

import com.allison.pages.EmployeeListPage
import com.allison.pages.EmployeeShowPage
import com.allison.remote.EmployeeRemoteControl
import geb.spock.GebReportingSpec

class firstSpec extends GebReportingSpec {

    EmployeeRemoteControl remote = new EmployeeRemoteControl()

    Long employeeId_1
    Long employeeId_2
    Long employeeId_3

    def setup() {
        EmployeeRemoteControl remote = new EmployeeRemoteControl()
        employeeId_1 = remote.createEmployee('Alice', 'LastName')
        employeeId_2 = remote.createEmployee('Bob', 'LastName2')
        employeeId_3 = remote.createEmployee('Charles', 'LastName3')

    }

    def 'A descriptive name for the feature'() {

        given: 'Setup stuff'
        // Can be blank

        when: 'The employee list page is navigated to'
        EmployeeListPage employeeListPage = to EmployeeListPage // implicitly calls the at-checker

        then: 'The employee list page header is displayed'
        assert at(EmployeeListPage) // All statements in a then-block are
                                    // implicitly asserted. Bloom's code standards
                                    // are to always explicitly assert

        and: 'The employee is listed'
        assert employeeListPage.employeeLinkIsPresent(employeeId_1)

        when: 'The employee is clicked'
        employeeListPage.clickEmployeeLink(employeeId_1)

        then: 'At the show employee page'
        assert at(EmployeeShowPage)
    }

    def cleanup() {
        remote.deleteEmployee(employeeId_1)
        remote.deleteEmployee(employeeId_2)
        remote.deleteEmployee(employeeId_3)
    }

}
