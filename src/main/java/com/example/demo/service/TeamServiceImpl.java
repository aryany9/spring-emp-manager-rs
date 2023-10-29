package com.example.demo.service;

import com.example.demo.model.Team;
import com.example.demo.model.request.AddTeamRequest;
import com.example.demo.model.response.AddTeamResponse;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamRepository teamRepository;

    @Override
    public AddTeamResponse addTeam(AddTeamRequest addTeamRequest) {
        Team team = new Team();

        team.setName(addTeamRequest.getName());
        team.setDescription(addTeamRequest.getDescription());

        Team savedTeam = teamRepository.save(team);
        AddTeamResponse teamResponse = new AddTeamResponse();
        teamResponse.setTeamId(savedTeam.getId());
        teamResponse.setTeamName(savedTeam.getName());
        teamResponse.setDescription(savedTeam.getDescription());
        return teamResponse;
    }
}
