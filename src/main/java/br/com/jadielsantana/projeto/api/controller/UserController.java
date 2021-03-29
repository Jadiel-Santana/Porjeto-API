package br.com.jadielsantana.projeto.api.controller;

import br.com.jadielsantana.projeto.api.controller.dto.UserRq;
import br.com.jadielsantana.projeto.api.controller.dto.UserRs;
import br.com.jadielsantana.projeto.api.model.User;
import br.com.jadielsantana.projeto.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public List<UserRs> findAll() {
        List<User> pessoas = repository.findAll();
        return pessoas
                .stream()
                .map(UserRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserRs findById(@PathVariable("id") Long id) {
        Optional<User> user = repository.findById(id);
        return user.map(UserRs::converter).orElse(null);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody UserRq user) {
        User u = new User();
        u.setNome(user.getNome());
        u.setSenha(user.getSenha());
        repository.save(u);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody UserRq user) throws Exception {
        Optional<User> p = repository.findById(id);

        if (p.isPresent()) {
            User userSave = p.get();
            userSave.setNome(user.getNome());
            userSave.setSenha(user.getSenha());
            repository.save(userSave);
        } else {
            throw new Exception("Usuário Não encontrado");
        }
    }
}