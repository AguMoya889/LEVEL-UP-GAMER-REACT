package com.levelup.gamer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI levelUpGamerAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Servidor de desarrollo");
        
        Contact contact = new Contact();
        contact.setName("Giancarlo Ovalle & Agustín Moya");
        contact.setEmail("gianovalle21@gmail.com");
        
        License license = new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");
        
        Info info = new Info()
                .title("Level Up Gamer API")
                .version("1.0")
                .contact(contact)
                .description("API REST para e-commerce de productos gaming. Incluye gestión de productos, usuarios, órdenes de compra y estadísticas administrativas.")
                .license(license);
        
        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer));
    }
}
