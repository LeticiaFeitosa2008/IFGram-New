package com.ifpb.ifgram.service;

import com.ifpb.ifgram.DTO.UserRequest;
import com.ifpb.ifgram.DTO.UserResponse;
import com.ifpb.ifgram.model.User;
import com.ifpb.ifgram.repository.UserRepository;
import io.swagger.v3.oas.annotations.info.Contact;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository repository;
    public UserService (UserRepository repository) {
        this. repository = repository;

}
    @Transactional
    public UserResponse criar(UserRequest request) throws EmailDuplicadoException {
        if (repository.existsByEmail(request.email())) {
            throw new EmailDuplicadoException(request.email());
    }
        User salvo = repository.save(new User(request.nome(), request.email()));
        return UserResponse.from(salvo);
    }

    public List<UserResponse> buscarTodosUsuarios(){
        List<User> listaUsuarios = repository.findAll();
        List<UserResponse> listausuariosResponse = new ArrayList<>();
        List<UserResponse> listaUsuariosResponse = List.of();
        for (User user: listaUsuarios) {
            UserResponse userReponse = new UserResponse(
                    user.getId(),
                    user.getNome(),
                    user.getEmail()
            );
            listaUsuariosResponse.add(userReponse);
        }
            return listaUsuariosResponse;
        }

        public UserResponse atualizarUsuario(UserRequest userRequest) throws Exception{
            Optional<User> usuario = repository.findByEmail(userRequest.email());
            if (usuario.isEmpty()){
                throw new Exception("Usuario não existe na base de dados");
            }
            User usuarioSalvo = usuario.get();
            usuarioSalvo.setNome(userRequest.nome());
            repository.save(usuarioSalvo);

            return  UserResponse.from(usuarioSalvo);
    }
}