package com.app.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.CustomerDTO;
import com.app.entities.Customer;
import com.app.services.ICustomerService;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/login")
	 public ResponseEntity<?> getCustomerLogin()
	 {
		 return ResponseEntity.ok("Enter email ID and password");
	 }

     @PostMapping("/login")
	 public ResponseEntity<?> getCustomerDetails(@RequestBody CustomerDTO loginInfo,HttpSession session)
	 {
		 System.out.println(loginInfo.getEmail()+" "+loginInfo.getPassword());
		 Customer customer = customerService.getCustomerDetails(loginInfo.getEmail(), loginInfo.getPassword());
		 session.setAttribute("user", customer);
		 return new ResponseEntity<>(customer,HttpStatus.OK);
	 }

     @GetMapping("/profile/{id}")
	 public ResponseEntity<?> getProfile(@PathVariable int id)
	 {
		 return new ResponseEntity<>(customerService.findUsingId(id),HttpStatus.OK);
	 }

     @GetMapping("/update/{id}")
	 public ResponseEntity<?> updateCustomerInfo(@PathVariable int id)
	 {
		 return ResponseEntity.ok(customerService.findUsingId(id));
	 }

     @PostMapping("/update/{id}")
	 public ResponseEntity<?> updateCustomer(@RequestBody CustomerDTO customer)
	 {
    	 Customer customerEnt = customerService.updateCustomerDetails(customer);
	     return new ResponseEntity<>(customerEnt, HttpStatus. OK);
	 }

     @GetMapping("/register")
	 public ResponseEntity<?> getRegistrationForm()
	 {
		 return ResponseEntity.ok("Please fill in the details");
	 }
	 
	 @PostMapping("/register")
	 public ResponseEntity<?> registerCustomer(@RequestBody Customer customer)
	 {
		return new ResponseEntity<>(customerService.registerCustomer(customer),HttpStatus.OK); 
	 }

     

     @GetMapping("/booking")
     public ResponseEntity<?> roomBooking(HttpSession session)
     {
    	 Customer customer = (Customer) session.getAttribute("user");
		return null;

     }

     //@GetMapping("/cancelbooking")

     @GetMapping("/history/{id}")
     public ResponseEntity<?> checkBooking(@PathVariable int id)
	 {
		 return new ResponseEntity<>(customerService.getBookingHistory(id),HttpStatus.OK);
	 }
	 

     @GetMapping("/logout")
     public String customerLogout(HttpSession session, Model map, HttpServletResponse resp, HttpServletRequest req)
     {
        map.addAttribute("user_details", session.getAttribute("user_details"));
        session.invalidate();
        resp.setHeader("refresh","5;url= /demo_final_project");
        return "/customer/logout";
     }

     @GetMapping("/payment/{id}")
     public ResponseEntity<?> customerPayment(@PathVariable int id)
     {
    	 return new ResponseEntity<>(customerService.getPaymentList(id),HttpStatus.OK);
     }

}
