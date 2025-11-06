package joaoneto_hub.agregadorinvestimentos.service;

import joaoneto_hub.agregadorinvestimentos.controller.CreateUserDto;
import joaoneto_hub.agregadorinvestimentos.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Nested
    class createUser {
        @Test
        @DisplayName("Should create a user with success")
        void shouldCreateAUserWithSuccess() {
            //Arrange
            doReturn(null).when(userRepository).save(any());
            var input = new CreateUserDto(
                    "username",
                    "email",
                    "password");
            //Act
            userService.createUser(input);
            //Assert
        }
    }
}