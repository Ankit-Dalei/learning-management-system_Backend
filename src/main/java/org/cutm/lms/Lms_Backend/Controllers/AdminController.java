package org.cutm.lms.Lms_Backend.Controllers;

import lombok.AllArgsConstructor;
import org.cutm.lms.Lms_Backend.Entity.Admin;
import org.cutm.lms.Lms_Backend.Service.AdminMethods;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/cutm/admin")
@AllArgsConstructor
public class AdminController {
    private AdminMethods adminMethods;
    // add admin rest api
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin admin1 = adminMethods.createAdmin(admin);
        return  new ResponseEntity<>(admin1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmin(){
        List<Admin> admins = adminMethods.getAllAdmin();
        return ResponseEntity.ok(admins);
    }
    @GetMapping("{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id){
        Admin admin =  adminMethods.getAdminById(id);
        return ResponseEntity.ok(admin);

    }
    @PutMapping("{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id,@RequestBody Admin admin) {
        Admin admin1 = adminMethods.updateAdmin(id,admin);
        return ResponseEntity.ok(admin1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        adminMethods.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully of id");
    }

}
