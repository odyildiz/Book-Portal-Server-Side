package tr.com.obss.bookportalserverside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.obss.bookportalserverside.entity.Role;
import tr.com.obss.bookportalserverside.model.RoleDTO;
import tr.com.obss.bookportalserverside.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(RoleDTO roleDto){
        Role role = new Role();
        role.setName(roleDto.getName());
        return roleRepository.save(role);
    }

    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }

    public Role updateRole(Long id, String name){
        Role role = roleRepository.findById(id).get();
        role.setName(name);
        return roleRepository.save(role);
    }

}
