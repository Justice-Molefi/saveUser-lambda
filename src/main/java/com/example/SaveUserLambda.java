package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SaveUserLambda implements RequestHandler<UserRequest, String> {

    @Override
    public String handleRequest(UserRequest userRequest, Context context) {
        if(userRequest == null)
            throw new IllegalArgumentException("Bad Request");

        String firstName = userRequest.getFirstName();
        String lastName = userRequest.getLastName();

        context.getLogger().log("input :" + firstName + " " + lastName);

        return "Hello " + firstName + " " + lastName;
    }
}
