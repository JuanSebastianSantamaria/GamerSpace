package com.project.GamerSpaceServer.restControllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import com.project.GamerSpaceServer.dtos.AdminDTO;
import com.project.GamerSpaceServer.dtos.CustomerDTO;
import com.project.GamerSpaceServer.dtos.UserGSDTO;
import com.project.GamerSpaceServer.model.Admin;
import com.project.GamerSpaceServer.model.Customer;
import com.project.GamerSpaceServer.model.PurchaseCar;
import com.project.GamerSpaceServer.services.IAdminService;
import com.project.GamerSpaceServer.services.ICustomerService;
import com.project.GamerSpaceServer.services.IPurchaseService;
import com.project.GamerSpaceServer.utils.Constants;
import com.project.GamerSpaceServer.utils.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserREST {
    @Autowired
    private IAdminService adminService;

    @Autowired
    private ICustomerService customerService;

    @Autowired IPurchaseService purchaseService;

    @RolesAllowed(Constants.ROLE_ADMIN)
    @PutMapping("/admin/update")
    public AdminDTO updateAdmin(@RequestBody Admin admin){
        return Converter.convertAdminToDTO(adminService.updateAdmin(admin));
    }

    @RolesAllowed(Constants.ROLE_ADMIN)
    @GetMapping("/admin/{id}")
    public AdminDTO findAdminById(@PathVariable Long id){
        return Converter.convertAdminToDTO(adminService.findAdminById(id));
    }

    @RolesAllowed({Constants.ROLE_ADMIN, Constants.ROLE_CUSTOMER})
    @GetMapping("/users/{username}")
    public UserGSDTO findUserByUsername(@PathVariable String username){
        UserGSDTO response = null;
        Optional<Admin> adminOpt = adminService.findByUsername(username);
        if(adminOpt.isPresent()){
            response = Converter.convertAdminToDTO(adminOpt.get());
            return response;
        } else {
            Optional<Customer> customerOpt = customerService.findByUsername(username);
            response = Converter.convertCustomerToDTO(customerOpt.get());
            return response;
        }
    }

    @PostMapping("/customer/new")
    public CustomerDTO createCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.createCustomer(customer);
        PurchaseCar car = new PurchaseCar();
        car.setCustomer(newCustomer);
        car.setProducts(new ArrayList<>());
        purchaseService.createPurchaseCar(car);
        return Converter.convertCustomerToDTO(newCustomer);
    }

    @RolesAllowed(Constants.ROLE_CUSTOMER)
    @PutMapping("/customer/update")
    public CustomerDTO updateCustomer(@RequestBody Customer customer){
        return Converter.convertCustomerToDTO(customerService.updateCustomer(customer));
    }

    @RolesAllowed(Constants.ROLE_CUSTOMER)
    @GetMapping("/customer/{id}")
    public CustomerDTO findCustomerById(@PathVariable Long id){
        return Converter.convertCustomerToDTO(customerService.findCustomerById(id));
    }
}
