package com.educacionit.apis.services.service;

import com.educacionit.apis.services.entity.User;
import com.educacionit.apis.services.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("user")
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository dao;


    ///////////////////////////////////  CRUD  //////////////////////////////////////////


    //Method POST para crear un nuevo usuario -> Evento de Registrar
    @RequestMapping (method = RequestMethod.POST)
    @Override
    public ResponseEntity<?> createUser(User data){
        try{
            this.dao.save(data);
        }catch(Exception e){
            return ResponseEntity.badRequest ().build ();
        }

        return ResponseEntity.noContent ().build ();
    }

    //Method GET para retorna el usuario
    @RequestMapping (value="{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    @Override
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
        //return repositoryUser.findById(id).orElseThrow(() -> new Exception("El usuario no existe."));
        /*User target = dao.findById();

        if (target == null) {

           // return ResponseEntity.status(404).body(new Message ("400", "Resource Student", String.format ("Student %s not found", id)));

        } else {

            return ResponseEntity.ok (target);
        }*/
        return null;
    }

    //Method PUT para modificar el usuario
    @RequestMapping (value="{id}", method = RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @Override
    public ResponseEntity<?> updateUser(Long id, User data){
        try {

            if (!this.dao.existsById (id)) {

               // return ResponseEntity.status(404).body(new Message ("400", "Resource Student", String.format ("Student %s not found", id)));
            }

            data.setId (id);
            this.dao.save (data);

        } catch (Exception e) {

            return ResponseEntity.badRequest ().build ();
        }

        return ResponseEntity.ok (data);
    }

    //Method DELETE para eliminar al usuario
    @RequestMapping (value="{id}", method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<?> deleteUser(Long id) {
        if (!this.dao.existsById (id)) {
           // return ResponseEntity.status(404).body(new Message ("400", "Resource Student", String.format ("Student %s not found", id)));
            return null;
        } else {

            this.dao.deleteById (id);

            return ResponseEntity.noContent ().build ();
        }
    }




/*
    private boolean checkPasswordValid(User user) throws Exception {
        if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
            throw new Exception("Confirm Password es obligatorio");
        }

        if ( !user.getPassword().equals(user.getConfirmPassword())) {
            throw new Exception("Password y Confirm Password no son iguales");
        }
        return true;
    }

 */

}

