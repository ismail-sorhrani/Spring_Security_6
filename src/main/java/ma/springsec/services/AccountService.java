package ma.springsec.services;

import ma.springsec.entities.AppRole;
import ma.springsec.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUsername(String username,String rolename);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}
