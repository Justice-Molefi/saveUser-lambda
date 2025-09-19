package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SaveUserLambda implements RequestHandler<UserRequest, String> {


    @Override
    public String handleRequest(UserRequest userRequest, Context context) {
        UserRepository userRepository = new UserRepository();

        if(userRequest == null)
            throw new IllegalArgumentException("Bad Request");

        String firstName = userRequest.getFirstName();
        String lastName = userRequest.getLastName();

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        User result = userRepository.create(user);

        return "User created successfully: " + result.getFirstName() + " " + result.getLastName();
    }
}
