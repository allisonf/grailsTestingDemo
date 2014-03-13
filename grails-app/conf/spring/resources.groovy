import com.allison.test.functional.data.EmployeeDataUtil
import grails.util.Environment

// Place your Spring DSL code here
beans = {
    if (Environment.current == Environment.TEST) {
        employeeDataUtil(EmployeeDataUtil) {bean ->
            bean.autowire = "byName"
        }
    }
}
