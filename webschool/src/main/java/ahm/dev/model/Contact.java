package ahm.dev.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {
    
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    
    @NotBlank(message = "Message is required")
    private String message;
    
    @Size(min = 5, max = 600, message = "Subject should be between 5 and 600 characters")
    private String subject;

    @NotNull(message = "Phone is required")
    @Size(min = 10, max = 15, message = "Phone should be between 10 and 15 characters")
    private String phone;

}
