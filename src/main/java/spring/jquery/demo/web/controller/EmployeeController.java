package spring.jquery.demo.web.controller;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.jquery.demo.server.dao.EmployeeDao;
import spring.jquery.demo.server.entity.Employee;

import java.util.List;

/**
 * Handles requests for the employees page.
 */
@Controller
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    public static final String BASEURL = "/app";
    public static final String SHOW_ALL = /*BASEURL + */"/show/all";
    public static final String ADD =  /*BASEURL + */"/add";
    public static final String REDIRECT_SHOW_ALL = "redirect:/show/all";

    private final EmployeeDao dao;

    /**
     * Constructor. Injects {@link EmployeeDao}.
     *
     * @param employeeDao {@link EmployeeDao} instance to be injected
     */
    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.dao = employeeDao;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() throws NotFoundException {
        logger.info("index GET");
        return REDIRECT_SHOW_ALL;
    }

    @RequestMapping(value = SHOW_ALL, method = RequestMethod.GET)
    public ModelAndView getAllMessages() throws NotFoundException {
        logger.info("getAllMessages GET");
        List<Employee> employees = dao.findAll();

        ModelAndView mav = new ModelAndView("emplList");
        mav.addObject("employees", employees);
        return mav;
    }

    @RequestMapping(value = {ADD/*, ADD + "/employee"*/}, method = RequestMethod.GET)
    public String getCreateForm(Model model) {
        logger.info("getCreateForm RequestMapping(method=RequestMethod.GET)|" + ADD);
        model.addAttribute(new Employee());
        return "addForm";
    }

    @RequestMapping(value = {/*ADD, */ADD + "/employee"}, method = RequestMethod.POST)
    public String create(Employee employee, BindingResult result) {
        logger.info("create RequestMapping(method=RequestMethod.POST)====" + ADD);
        if (result.hasErrors()) {
            return "addForm";
        }
        //message.setDatePosted(new Date(System.currentTimeMillis()));
        dao.makePersistent(employee);
        logger.info("Redirecting(method=RequestMethod.POST)>>>>" + REDIRECT_SHOW_ALL);
        return REDIRECT_SHOW_ALL;
    }

}
