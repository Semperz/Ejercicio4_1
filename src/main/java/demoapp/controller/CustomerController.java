package demoapp.controller;

import demoapp.model.entity.Customer;
import demoapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
     CustomerService customerService;

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.listCustomers());
        return "listCustomers";
    }

    @GetMapping("/customers/new")
    public String newCustomer(Model model, Customer newCustomer) {
        model.addAttribute("customer", newCustomer);
        return "newCustomer";
    }

    @PostMapping("/customers")
    public String addCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}
