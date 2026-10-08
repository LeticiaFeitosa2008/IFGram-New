
package IFgram.ifpb.DTO;


public record UserResponse(Long id, String nome, String email) {
    public static UserResponse from (User user){

        return new UserResponse(user.getNome(), user.getId(), user.getEmail());


    }
}