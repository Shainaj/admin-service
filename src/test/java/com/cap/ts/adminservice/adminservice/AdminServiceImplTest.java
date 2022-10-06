/*
package com.cap.ts.adminservice.adminservice;


import com.cap.ts.adminservice.adminservice.dto.LoginRequestDto;
import com.cap.ts.adminservice.adminservice.dto.LoginResponseDto;
import com.cap.ts.adminservice.adminservice.projection.LeaveDetailsProjection;
import com.cap.ts.adminservice.adminservice.projection.UserProjection;
import com.cap.ts.adminservice.adminservice.repository.AuthorizationRepository;
import com.cap.ts.adminservice.adminservice.repository.UserInfoRepository;
import com.cap.ts.adminservice.adminservice.service.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class AdminServiceImplTest {

    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    AuthorizationRepository authorizationRepository;

    @Mock
    UserInfoRepository userInfoRepository;

    ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

    Map<String, Object> map = Map.of("userId", "sanadaf", "userName", "Saleem Nadaf",
            "userEmailId","saleem.nadaf@capgemini.com",
            "userRole", "admin"  );

    Map<String, Object> leaveMap = Map.of("userName", "Abhilasha", "userId", "abhilasha", "leaveOnDate", "2022-09-20",
            "leaveType", "Privilege Leave", "noOfDays", "Full Day","leaveId", 1122);


    UserProjection projection = factory.createProjection(UserProjection.class, map);
    LeaveDetailsProjection leaveDetailsProjection = factory.createProjection(LeaveDetailsProjection.class, leaveMap);

    @Test
    public void testGetUserDataPostLogin(){
        LoginRequestDto loginRequestDto= new LoginRequestDto();
        loginRequestDto.setLoginId("sanadaf");
        loginRequestDto.setPassword("Saleem@123");

        Mockito.lenient().when(authorizationRepository.findPasswordByUserId(loginRequestDto.getLoginId())).thenReturn(Optional.of("Saleem@123"));
        Mockito.lenient().when(userInfoRepository.authenticateUserAndGetDetails(loginRequestDto.getLoginId(),loginRequestDto.getPassword())).thenReturn(projection);

        final LoginResponseDto userDataPostLogin = adminService.getUserDataPostLogin(loginRequestDto);
        assertEquals(projection.getUserName(), userDataPostLogin.getUserProjection().getUserName());

    }

    @Test
    public void testGetUserDataPostLogin(){
        LoginRequestDto loginRequestDto= new LoginRequestDto();
        loginRequestDto.setLoginId("sanadaf");
        loginRequestDto.setPassword("Saleem@123");

        Mockito.lenient().when(authorizationRepository.findPasswordByUserId(loginRequestDto.getLoginId())).thenReturn(Optional.of("Saleem@123"));
        Mockito.lenient().when(userInfoRepository.authenticateUserAndGetDetails(loginRequestDto.getLoginId(),loginRequestDto.getPassword())).thenReturn(projection);

        final LoginResponseDto userDataPostLogin = adminService.getUserDataPostLogin(loginRequestDto);
        assertEquals(projection.getUserName(), userDataPostLogin.getUserProjection().getUserName());

    }



}
*/
