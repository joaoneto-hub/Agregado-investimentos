package joaoneto_hub.agregadorinvestimentos.service;

import joaoneto_hub.agregadorinvestimentos.controller.dto.CreateAccountDto;
import joaoneto_hub.agregadorinvestimentos.controller.dto.CreateUserDto;
import joaoneto_hub.agregadorinvestimentos.controller.dto.UpdateUserDto;
import joaoneto_hub.agregadorinvestimentos.entity.Account;
import joaoneto_hub.agregadorinvestimentos.entity.BillingAddress;
import joaoneto_hub.agregadorinvestimentos.entity.User;
import joaoneto_hub.agregadorinvestimentos.repository.AcconutRepository;
import joaoneto_hub.agregadorinvestimentos.repository.BillingAddressRepository;
import joaoneto_hub.agregadorinvestimentos.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService  {
    private final UserRepository userRepository;
    private AcconutRepository acconutRepository;
    private BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, AcconutRepository acconutRepository,
            BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.acconutRepository = acconutRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UUID createUser(@RequestBody CreateUserDto createUserDto) {
        //DTO -> ENTIDY
        var entity = new User(
                null,
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                null,
                null);
        var userSaved = userRepository.save(entity);
        return userSaved.getUserId();
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId));

    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(String userId, UpdateUserDto updateUserDto) {
        var id = UUID.fromString(userId);
        var userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            var user = userEntity.get();
            if(updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }
            if(updateUserDto.password() != null) {
                user.setPassword(updateUserDto.password());
            }
            userRepository.save(user);
         
        } 
       
    }

    public void deleteUser(String userId) {
        var user = getUserById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
    }

    public void createAccount(String userId, CreateAccountDto createAccountDto) {
        var user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new ResolutionException("User not found"));

        var account = new Account(
                null,
                new ArrayList<>(),
                createAccountDto.description(),
                user,
                null);

        var accountCreated = acconutRepository.save(account);

        var billingAddress = new BillingAddress(
                null,
                accountCreated,
                createAccountDto.street(),
                createAccountDto.number());

        billingAddressRepository.save(billingAddress);

    }
}
