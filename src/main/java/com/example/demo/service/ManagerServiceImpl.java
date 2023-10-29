package com.example.demo.service;

import com.example.demo.exception.SeniorVPNotFoundException;
import com.example.demo.exception.TeamNotFoundException;
import com.example.demo.model.Manager;
import com.example.demo.model.SeniorVP;
import com.example.demo.model.Team;
import com.example.demo.model.request.CreateManagerRequest;
import com.example.demo.model.response.CreateManagerResponse;
import com.example.demo.model.response.ManagerItemResponse;
import com.example.demo.model.response.SeniorVpItemResponse;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.SeniorVpRepository;
import com.example.demo.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    SeniorVpRepository seniorVpRepository;

    @Override
    public ManagerItemResponse getManager(Long managerId) {
        ManagerItemResponse managerItemResponse = new ManagerItemResponse();
        Optional<Manager> manager = managerRepository.findManagerById(managerId);
        managerItemResponse.setId(manager.get().getId());
        managerItemResponse.setSeniorVpId(manager.get().getSeniorVP().getId());
        managerItemResponse.setTeamId(manager.get().getTeam().getId());
        managerItemResponse.setFirstName(manager.get().getFirstName());
        managerItemResponse.setLastName(manager.get().getLastName());

        return managerItemResponse;
    }

    @Override
    public CreateManagerResponse createManager(CreateManagerRequest createManagerRequest) {
        Manager manager = new Manager();
        manager.setFirstName(createManagerRequest.getFirstName());
        manager.setLastName(createManagerRequest.getLastName());
//        log.info("createManagerRequest.getTeamId(): {}", createManagerRequest.getTeamId());
        System.out.println("createManagerRequest.getTeamId():" + createManagerRequest.getTeamId());
        manager.setTeam(getTeam(createManagerRequest.getTeamId()));
        manager.setSeniorVP(getSeniorVp(createManagerRequest.getSeniorVpId()));

        Manager result = managerRepository.save(manager);
        CreateManagerResponse createManagerResponse = new CreateManagerResponse();
        createManagerResponse.setId(result.getId());
        createManagerResponse.setFirstName(result.getFirstName());
        createManagerResponse.setLastName(result.getLastName());
        return createManagerResponse;
    }


    public Team getTeam(Long teamId) {
//        log.info("Team ID: {}", teamId.toString());
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException(teamId));
    }


    public SeniorVP getSeniorVp(Long seniorVp) {
        log.info("Senior VP ID: {}", seniorVp.toString());
        return seniorVpRepository.findById(seniorVp)
                .orElseThrow(() -> new SeniorVPNotFoundException(seniorVp));
    }

    @Override
    public List<ManagerItemResponse> getManagers() {

        List<ManagerItemResponse> response = new ArrayList<ManagerItemResponse>();
        List<Manager> managers = managerRepository.findAll();
        for (Manager manager : managers) {
            ManagerItemResponse itemResponse = new ManagerItemResponse();
            itemResponse.setId(manager.getId());
            itemResponse.setFirstName(manager.getFirstName());
            itemResponse.setLastName(manager.getLastName());
            itemResponse.setSeniorVpId(manager.getSeniorVP().getId());
            itemResponse.setTeamId(manager.getTeam().getId());

            response.add(itemResponse);
        }
        return response;

    }

}
