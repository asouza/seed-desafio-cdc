package cryss.dev.author_api.infrastructure.configuration.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Configuration
public class OpenApiConfiguration {

  private final String module;
  private final String version;
  private final String contactName;
  private final String contactMail;

  public static final String TAG_CART = "Author";

  public OpenApiConfiguration(@Value("${api.module}") String module, @Value("${api.version}") String version,
                              @Value("${api.contact.name}") String contactName, @Value("${api.contact.mail}") String contactMail) {
    this.module = module;
    this.version = version;
    this.contactName = contactName;
    this.contactMail = contactMail;
  }

  @Bean
  public OpenAPI customOpenAPI() {
    final String apiTitle = String.format("%s API", StringUtils.capitalize(module));
    return new OpenAPI()
        .tags(getTags())
        .info(new Info().title(apiTitle).version(version).contact(getContact()));
  }

  private List<Tag> getTags() {
    return Arrays.asList(new Tag().name(TAG_CART).description("Endpoins para alteração de informações de autores."));
  }

  private Contact getContact() {
    return new Contact().name(contactName).email(contactMail);
  }

}