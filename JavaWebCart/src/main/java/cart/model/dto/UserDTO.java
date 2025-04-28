package cart.model.dto;

import lombok.Data;

@Data
public class UserDTO {
	private Integer id;
	private String userName;
	private String email;
	private Boolean completed;
}
