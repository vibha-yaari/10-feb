package com.example.democontroller;

import com.example.demoentity.Department;
import com.example.demoservice.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DepController {
    @Autowired
    private DepService depService;

    @GetMapping
    public String adddepartment(Model model){
        List<Department> listdepartment= depService.listAll();
        model.addAttribute("listdepartment",listdepartment);
        return "dep";
    }

    @GetMapping
    public String depadd(Model model){
        model.addAttribute("department", new Department() );
        return "depnew";
    }



    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveDepartment(@ModelAttribute("department") Department dep){
        depService.save(dep);
        return "redirect:/dep";
    }



}
