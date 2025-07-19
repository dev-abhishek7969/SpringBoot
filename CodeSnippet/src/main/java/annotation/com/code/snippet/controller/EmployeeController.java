package annotation.com.code.snippet.controller;

import com.code.snippet.entity.Employee;
import org.springframework.web.bind.annotation.*;

@RestController //@Controller + @ResponseBody
public class EmployeeController {


//    @RequestMapping(path = "/getEmployee",method = RequestMethod.GET)
//    @ResponseBody  --> Response of the api will not be a view but a body
    @GetMapping("/addEmployee")
    public String getEmployee(){
        return "Employee";
    }

    @GetMapping("/getEmployeeById")
    public String getEmployeeById(@RequestParam Integer empId){
        return "Emp with id = "+empId;
    }

    @GetMapping("/getEmployeeById/{empId}")
    public String getEmpById(@PathVariable Integer id){
        return "emp with id "+id;
    }

//    @RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
    @PostMapping("/addEmployee")
    public String addEmployee(Employee employee){
        return "added";
    }

    @PostMapping("/addEmp")
    public String addEmp(@RequestBody Employee emp){
        return "added";
    }

//    @RequestMapping(path = "/updateEmployee", method = RequestMethod.PUT)
    @PutMapping("/updateEmployee")
    public String updateEmployee(Employee employee){
        return "updated";
    }

//    @RequestMapping(path = "/deleteEmployee", method = RequestMethod.DELETE)
    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(Employee employee){
        return "deleted";
    }

}
