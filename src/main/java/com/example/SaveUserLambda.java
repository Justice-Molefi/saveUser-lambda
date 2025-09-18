package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SaveUserLambda implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String s, Context context) {
        context.getLogger().log("input :" + s);

        if(s == null || s.isEmpty()) s = "World!";
        return "Hello " + s;
    }
}
