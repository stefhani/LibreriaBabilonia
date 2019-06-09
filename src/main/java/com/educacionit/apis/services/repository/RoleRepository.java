package com.educacionit.apis.services.repository;

import com.educacionit.apis.services.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//CrudRepository es algo que nos provee jpa
//Definiendo el El Objeto y el tipo ID
public interface RoleRepository extends CrudRepository<Role, Long> {

}
