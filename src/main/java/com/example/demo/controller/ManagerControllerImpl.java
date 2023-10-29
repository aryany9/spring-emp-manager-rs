package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.model.request.CreateManagerRequest;
import com.example.demo.model.response.CreateManagerResponse;
import com.example.demo.model.response.ManagerItemResponse;
import com.example.demo.service.ManagerService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@NoArgsConstructor
public class ManagerControllerImpl implements ManagerController{

    @Autowired
    private ManagerService managerService;
    @Override
    public ResponseEntity<ManagerItemResponse> getManager(Long managerId) {
        return ResponseEntity.ok(managerService.getManager(managerId));
    }

    @Override
    public ResponseEntity<CreateManagerResponse> saveManager(CreateManagerRequest createManagerRequest){
        return ResponseEntity.ok(managerService.createManager(createManagerRequest));
    }

    @Override
    public ResponseEntity<List<ManagerItemResponse>> getManagers() {
        return ResponseEntity.ok(managerService.getManagers());
    }


}
