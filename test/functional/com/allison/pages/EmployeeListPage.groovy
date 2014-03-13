package com.allison.pages

import geb.Page


class EmployeeListPage extends Page {

    // the link that is navigated to on the 'to' call
    static url = "employee/list"

    // the closure that is verified on the 'at' call
    static at = {
        pageTitle.text() == 'Employee List Page'
    }

    // The navigator objects
    static content = {
        pageTitle(wait: true) { $('h2.title') } // 'wait' will wait for the element to be displayed for 30 seconds
                                                // before it will return from loading the page
        employeeLink(wait: true, to: EmployeeShowPage)
                { id -> $('a.employeeLink', 'id': "${id}") }
    }

    // It is good practice to wrap all the navigator objects in methods
    boolean employeeLinkIsPresent(Long id) {
        employeeLink(id).isDisplayed()
    }

    EmployeeShowPage clickEmployeeLink(Long id) {
        employeeLink(id).click()

        return browser.page
    }
}
