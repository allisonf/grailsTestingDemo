package com.allison.pages

import geb.Page


class EmployeeShowPage extends Page {

    static url = 'employee/show'

    static at = {
        pageTitle.text() == 'Employee Show Page'
    }

    static content = {
        pageTitle(wait: true) { $('h2.title')}
        firstName(wait: true) { $('div#firstName').text() }
        lastName(wait: true) { $('div#lastName').text() }
    }
}
