package vitrine.api.controllers;

import org.springframework.web.bind.annotation.*;
import vitrine.api.classes.UsuarioDTO;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @PostMapping
    public String Post(@RequestBody UsuarioDTO usuario) {
        if ("admin".equals(usuario.getUsuario()) && "admin".equals(usuario.getSenha())) {
            return "OK";
        }
        return "ERRO";
    }
}
