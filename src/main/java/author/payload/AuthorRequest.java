package author.payload;

import author.validation.AuthorDescriptionValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class AuthorRequest {
	@NotEmpty(message = "The name can not be empty")
	private String name;
	@NotEmpty(message = "The email can not be empty")
	@Email(message = "The email is not valid")
	private String email;
	@NotEmpty(message = "The description can not be empty")
	@AuthorDescriptionValidation
	private String description;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthorDTO [name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
