//
////src/main/java/com/restaurant/demo/config/WebConfig.java
//package com.restaurant.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig {
//
// @Bean
// public WebMvcConfigurer corsConfigurer() {
//     return new WebMvcConfigurer() {
//         @Override
//         public void addCorsMappings(CorsRegistry registry) {
//             registry.addMapping("/api/**")
//                     .allowedOrigins("http://localhost:3000") // React app's URL
//                     .allowedMethods("GET", "POST", "PUT", "DELETE")
//                     .allowedHeaders("*");
//         }
//     };
// }
//}
