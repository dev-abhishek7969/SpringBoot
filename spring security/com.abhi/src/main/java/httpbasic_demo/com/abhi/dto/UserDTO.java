package httpbasic_demo.com.abhi.dto;

import java.util.Set;

public record UserDTO(String username, String password, String email, Set<RoleDTO> roles) {

}


/**
 * {
 *     "username": "john_doe",
 *     "password": "password123",
 *     "email": "john.doe@example.com",
 *     "roles": [
 *         {
 *             "name": "ADMIN",
 *             "authorities": [
 *                 {
 *                     "name": "READ_PERM"
 *                 },
 *                 {
 *                     "name": "WRITE_PERM"
 *                 },
 *                 {
 *                     "name": "DELETE_PERM"
 *                 }
 *             ]
 *         }
 *     ]
 * }
 */
