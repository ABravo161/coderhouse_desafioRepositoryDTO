package com.coderhouse.service.impl;

import com.coderhouse.builder.UserBuilder;
import com.coderhouse.cache.CacheClient;
import com.coderhouse.model.UserFactory;
import com.coderhouse.model.database.document.UserDocument;
import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;
import com.coderhouse.repository.UserRepository;
import com.coderhouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserFactory userFactory = new UserFactory();
    private final CacheClient<UserResponse> cache;

    @Override
    public UserResponse create(UserRequest request) {
        var document= userFactory.createUser(request);
        repository.save(document);
        return saveInCache(UserBuilder.docToResponseCreate(document));
    }

    @Override
    public UserResponse getUser(String id){
        var docincache = cache.recover(id, UserResponse.class);
        if (docincache!=null){
            return docincache;
        }
        return saveInCache(UserBuilder.docToResponseCreate(repository.findById(id).orElseThrow()));
    }

    @Override
    public List<UserResponse> searchAll() {
        return UserBuilder.listDocToResponse(repository.findAll());
    }



    private UserResponse saveInCache(UserResponse userResponse){
        return cache.save(userResponse.getId(), userResponse);
    }

}

