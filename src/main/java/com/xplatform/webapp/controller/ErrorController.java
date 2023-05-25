package com.xplatform.webapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request) {
//        // Get the HTTP error status code
//        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//        if (statusCode != null) {
//            // Customize the error handling based on the status code
//            if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                // Handle 404 Not Found error
//                return "error-404"; // Update with your actual error view name
//            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                // Handle 500 Internal Server Error
//                return "error-500"; // Update with your actual error view name
//            }
//            // Add more error handling based on different status codes if needed
//        }
//
//        // Return a generic error page if no specific handling is defined
//        return "error"; // Update with your actual error view name
//    }

//    @GetMapping("/error")
//    public String getErrorPath() {
//        return "error"; // Update with your actual error view name
//    }
}


