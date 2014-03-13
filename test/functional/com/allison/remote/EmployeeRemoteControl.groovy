package com.allison.remote

import groovyx.remote.client.RemoteControl
import groovyx.remote.transport.http.HttpTransport

class EmployeeRemoteControl {

    RemoteControl remote

    EmployeeRemoteControl() {
        String port = System.getProperty('grails.server.port.http', '8080')
        remote = new RemoteControl(new HttpTransport("http://localhost:${port}/gebDemo/grails-remote-control"))
    }


    Long createEmployee(String firstName, String lastName) {
        remote {
            ctx.employeeDataUtil.createEmployee(firstName, lastName)
        }
    }

    void deleteEmployee(Long id) {
        remote {
            ctx.employeeDataUtil.deleteEmployee(id)
        }
    }
}
