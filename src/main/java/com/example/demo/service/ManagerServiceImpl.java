package com.example.demo.service;

import com.example.demo.exception.SeniorVPNotFoundException;
import com.example.demo.exception.TeamNotFoundException;
import com.example.demo.model.Manager;
import com.example.demo.model.SeniorVP;
import com.example.demo.model.Team;
import com.example.demo.model.request.CreateManagerRequest;
import com.example.demo.model.response.CreateManagerResponse;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.SeniorVpRepository;
import com.example.demo.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Optional<Manager> getManager(Long managerId) {
        return managerRepository.findManagerById(managerId);
    }

    @Override
    public CreateManagerResponse createManager(CreateManagerRequest createManagerRequest) {
        Manager manager = new Manager();
        manager.setFName(createManagerRequest.getFName());
        manager.setLName(createManagerRequest.getLName());
        manager.setTeam(getTeam(createManagerRequest.getTeamId()));
        manager.setSeniorVP(getSeniorVp(createManagerRequest.getSeniorVpId()));

        Manager result = managerRepository.save(manager);
        CreateManagerResponse createManagerResponse = new CreateManagerResponse();
        createManagerResponse.setId(result.getId());
        createManagerResponse.setFirstName(result.getFName());
        createManagerResponse.setLastName(result.getLName());
        return createManagerResponse;
    }

    @Override
    public Team getTeam(Long teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException(teamId));
    }

    @Override
    public SeniorVP getSeniorVp(Long seniorVp) {
        return seniorVpRepository.findById(seniorVp)
                .orElseThrow(() -> new SeniorVPNotFoundException(seniorVp));
    }

}
