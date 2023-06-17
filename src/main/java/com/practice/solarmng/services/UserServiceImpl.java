package com.practice.solarmng.services;
import com.practice.solarmng.entity.UserEntity;
import com.practice.solarmng.exception.UserNotFoundException;
import com.practice.solarmng.model.User;
import com.practice.solarmng.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(user,userEntity);
        userRepository.save(userEntity);

        return user;
    }

    @Override
    public User getUser(long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            return user;
        } else {
            throw new UserNotFoundException("User not found with username: " + id);
        }
    }

    @Override
    public User updateUser(long id, User updatedUser) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            updatedUser.setId(userEntity.getId());
            BeanUtils.copyProperties(updatedUser, userEntity);
            userRepository.save(userEntity);
            return updatedUser;
        } else {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
    }

    @Override
    public void deleteUser(long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            userRepository.delete(optionalUserEntity.get());
        } else {
            throw new UserNotFoundException("User not found with username: " + id);
        }
    }

    @Override
    public User loginUser(User user){
        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(user.getUsername());

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            if(user.getPassword().equals(userEntity.getPassword())) {
                User loggedUser = new User();
                BeanUtils.copyProperties(userEntity, loggedUser);
                return loggedUser;
            }
            else {
                throw new UserNotFoundException("Invalid Password");
            }
        } else {
            throw new UserNotFoundException("Invalid Username");
        }
    }

//    @Override
//    public void updatePassword(long userId, String newPassword) {
//        UserEntity existingUser = userRepository.findById(userId)
//                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
//
//        String hashedPassword = passwordEncoder.encode(newPassword);
//        existingUser.setPassword(hashedPassword);
//    }

}
