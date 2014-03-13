package com.allison.domain

class Employee {

    String firstName
    String lastName

    static constraints = {
        firstName(nullable: false, blank:false, maxSize: 30)
        lastName(nullable: false, blank: false, maxSize: 30)
    }
}
