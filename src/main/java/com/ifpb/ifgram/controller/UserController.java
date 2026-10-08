
package IFgram.ifpb.Controller;

import org.springframework.web.bind.annotation.*;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("User")
public class UserController{

    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PostMapping
    public String postUser(){
        return "Chamei o endpoint como um post";
    }

    @PutMapping
    public String putUser(){
        return "Chamei o endpoint como um put";
    }

    @PatchMapping
    public String patchUser(){
        return "Chamei o endpoint como um patch";
    }

    @DeleteMapping
    public String deletar(){
        return null;
    }
}