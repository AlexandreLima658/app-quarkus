package org.com.br.service;

import io.vertx.ext.auth.User;
import jakarta.enterprise.context.ApplicationScoped;
import org.com.br.entity.UserEntity;
import org.com.br.exception.UserNotFoundException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public UserEntity create(final UserEntity user){
       UserEntity.persist(user);
       return user;
    }

    public List<UserEntity> findAll(final Integer page, final Integer pageSize) {
        return UserEntity.findAll()
                .page(page, pageSize)
                .list();
    }

    public UserEntity findById(final UUID userId) {
         return UserEntity.<UserEntity>findByIdOptional(userId)
                 .orElseThrow(UserNotFoundException::new);
    }

    public UserEntity update(final UUID userId, final UserEntity userEntity){
       final var user = findById(userId);

       user.userName = userEntity.userName;
       UserEntity.persist(user);

       return user;

    }

    public void delete(final UUID userId) {
        final var user = findById(userId);
        UserEntity.deleteById(user.userId);
    }
}
