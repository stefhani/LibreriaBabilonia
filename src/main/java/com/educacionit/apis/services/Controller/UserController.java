
package com.educacionit.apis.services.Controller;

import com.educacionit.apis.services.entity.User;
import com.educacionit.apis.services.repository.RoleRepository;
import com.educacionit.apis.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RoleRepository roleRepository;

	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}

	//user-form
	@GetMapping("/user")
	public String userForm(Model model) {
		model.addAttribute("userForm", new User());
		//model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("listTab","active");
		return "form/user-view";
	}

	//Editar el usuario
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		//User userToEdit = userService.getUserById(id);

		//model.addAttribute("userForm", userToEdit);
		//model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");
		//model.addAttribute("passwordForm",new ChangePasswordForm(id));

		return "form/user-view";
	}
}


