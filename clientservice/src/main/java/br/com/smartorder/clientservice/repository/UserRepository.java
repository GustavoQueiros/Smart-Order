package br.com.smartorder.clientservice.repository;

import br.com.smartorder.clientservice.dto.UserRequestDto;
import br.com.smartorder.clientservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public Optional<UserEntity> findByEmail(String email);

}
