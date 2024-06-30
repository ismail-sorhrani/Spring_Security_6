package ma.springsec.controllers;

import lombok.Data;
import ma.springsec.entities.AppRole;
import ma.springsec.entities.AppUser;
import ma.springsec.services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/users")
    public List<AppUser> users(){
        return accountService.listUsers();
    }

    @PostMapping(path = "/users")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }
    @PostMapping(path = "/role")
    public AppRole saveRole(@RequestBody AppRole appRole){

        return accountService.addNewRole(appRole);
    }
    @PostMapping(path = "/addRoleToUser")
    void addRoleToUser(@RequestBody Dto dto){
        accountService.addRoleToUsername(dto.getUsername(),dto.getRolename());
    }

}
@Data
class Dto{
   private String username;
   private String rolename;
}
