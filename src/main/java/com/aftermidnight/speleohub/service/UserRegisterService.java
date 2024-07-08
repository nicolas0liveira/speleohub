package com.aftermidnight.speleohub.service;

import com.aftermidnight.speleohub.model.User;

public class UserRegisterService {
    
    public User register(User user) {
        // Lógica para cadastrar o usuário
        // ...
        throw new UnsupportedOperationException("Unimplemented method 'getOneOrFail'");

        // return usuarioRepository.save(usuario);
    }

    public User login(String email, String senha) {
        // Lógica para verificar credenciais e realizar login
        // ...
        throw new UnsupportedOperationException("Unimplemented method 'getOneOrFail'");

        // return usuarioRepository.findByEmail(email).orElse(null);
    }

    public void sendPasswordRecoveryEmail(String email) {
        // Lógica para enviar e-mail de recuperação de senha
        // ...
    }

    public void sendWellcomeEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'sendWellcomeEmail'");
    }
}
