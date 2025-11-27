package br.com.smartorder.clientservice.mapper;

import br.com.smartorder.clientservice.dto.UserResponsedto;
import br.com.smartorder.clientservice.dto.Userdto;
import br.com.smartorder.clientservice.entity.UserEntity;

public class UserMapper {

    public static UserResponsedto entityTodto(UserEntity userEntity) {
        return new UserResponsedto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail()
        );
    }

    public static UserEntity dtoToEntity(Userdto userdto) {

        UserEntity userEntity = new UserEntity();

        userEntity.setName(userdto.name());
        userEntity.setEmail(userdto.email());
        userEntity.setPassword(userdto.password());

        return userEntity;

    }

}
