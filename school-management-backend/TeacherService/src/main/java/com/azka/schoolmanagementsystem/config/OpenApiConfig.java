package com.azka.schoolmanagementsystem.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "School Management System API",
                version = "1.0",
                description = "API for managing teacher operations",
                summary = "School Management System API allows you to manage students, teachers, courses, and other school-related resources.",
                termsOfService = "https://example.com/terms",
                contact = @Contact(
                        name = "Syed Siddiq",
                        url = "https://www.linkedin.com/in/syedsiddiqabubakar/",
                        email = "sayedsiddiq45@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8081", description = "Development Server"),
                @Server(url = "https://staging.example.com", description = "Staging Server"),
                @Server(url = "https://api.example.com", description = "Production Server")
        }

)
public class OpenApiConfig {
    // You can add additional configurations here
}