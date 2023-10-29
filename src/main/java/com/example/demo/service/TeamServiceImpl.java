package com.example.demo.service;

import com.example.demo.model.SeniorVP;
import com.example.demo.model.Team;
import com.example.demo.model.request.AddTeamRequest;
import com.example.demo.model.response.SeniorVpItemResponse;
import com.example.demo.model.response.TeamItemResponse;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamRepository teamRepository;

    @Override
    public TeamItemResponse addTeam(AddTeamRequest addTeamRequest) {
        Team team = new Team();

        team.setName(addTeamRequest.getName());
        team.setDescription(addTeamRequest.getDescription());

        Team savedTeam = teamRepository.save(team);
        TeamItemResponse teamResponse = new TeamItemResponse();
        teamResponse.setTeamId(savedTeam.getId());
        teamResponse.setTeamName(savedTeam.getName());
        teamResponse.setDescription(savedTeam.getDescription());
        return teamResponse;
    }

    @Override
    public TeamItemResponse getTeam(Long id) {
        TeamItemResponse teamItemResponse = new TeamItemResponse();
        Optional<Team> result = teamRepository.findById(id);
        teamItemResponse.setTeamId(result.get().getId());
        teamItemResponse.setTeamName(result.get().getName());
        teamItemResponse.setDescription(result.get().getDescription());
        return teamItemResponse;
    }

    @Override
    public List<TeamItemResponse> getAllTeam() {
        List<TeamItemResponse> response = new ArrayList<TeamItemResponse>();
        List<Team> teams = teamRepository.findAll();
        for (Team team : teams) {
            TeamItemResponse itemResponse = new TeamItemResponse();
            itemResponse.setTeamId(team.getId());
            itemResponse.setTeamName(team.getName());
            itemResponse.setDescription(team.getDescription());
            response.add(itemResponse);
        }
        return response;
    }
}
