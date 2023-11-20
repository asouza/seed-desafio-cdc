package cv.hexadus.seeddesafiocdc.author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterAuthorRequest {
    @NotBlank(message = "[author registration] - name cannot be empty.")
    @NotNull(message = "[author registration] - name cannot be null.")
    private String name;

    @NotNull(message = "[author registration] - email cannot be null.")
    @Email(message = "[author registration] - email field must be a valid email format.")
    private String email;
    @NotNull(message = "[author registration] - description cannot be null.")
    @NotBlank(message = "[author registration] - description cannot be empty.")
    @Size(max = 400, message = "[author registration] - description max size: 400 ")
    private String description;

    public RegisterAuthorRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author toModel() {
        return new Author(name, email, description);
    }
}
