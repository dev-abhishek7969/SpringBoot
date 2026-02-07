package httpbasic_demo.com.abhi.dto;

import java.util.Set;

/**
 * @author Abhishek Kumar
 */
public record RoleDTO(String name, Set<AuthorityDTO> authorities) {

}
