package com.example;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.UUID;

public class UserRepository {
    private final DynamoDbTable<User> userDynamoDbTable;

    public UserRepository(){
        DynamoDbClient client = DynamoDbClient.create();
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(client)
                .build();
        this.userDynamoDbTable = enhancedClient.table("Users", TableSchema.fromBean(User.class));
    }

    public User create(User user){
        if(user == null)
            throw new IllegalArgumentException("Bad Request");

        user.setUserId(UUID.randomUUID().toString());
        userDynamoDbTable.putItem(user);
        return user;
    }

}
