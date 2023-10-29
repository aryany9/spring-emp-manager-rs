package com.example.demo.service;
import com.example.demo.model.SeniorVP;
import com.example.demo.model.request.AddSeniorVPRequest;
import com.example.demo.model.response.SeniorVpItemResponse;
import com.example.demo.repository.SeniorVpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeniorVpServiceImpl implements SeniorVpService {
    @Autowired
    SeniorVpRepository seniorVpRepository;

    @Override
    public SeniorVpItemResponse addSeniorVp(AddSeniorVPRequest addSeniorVPRequest) {
        SeniorVP seniorVP = new SeniorVP();
        seniorVP.setFirstName(addSeniorVPRequest.getFirstName());
        seniorVP.setLastName(addSeniorVPRequest.getLastName());

        SeniorVP savedVp = seniorVpRepository.save(seniorVP);

        SeniorVpItemResponse response = new SeniorVpItemResponse();
        response.setFirstName(savedVp.getFirstName());
        response.setId(savedVp.getId());
        response.setLastName(savedVp.getLastName());
        return response;
    }

    @Override
    public List<SeniorVpItemResponse> getAllSeniorVp() {
        List<SeniorVpItemResponse> response = new ArrayList<SeniorVpItemResponse>();
        List<SeniorVP> seniorVPS = seniorVpRepository.findAll();
        for (SeniorVP seniorVP : seniorVPS) {
            SeniorVpItemResponse itemResponse = new SeniorVpItemResponse();
            itemResponse.setId(seniorVP.getId());
            itemResponse.setFirstName(seniorVP.getFirstName());
            itemResponse.setLastName(seniorVP.getLastName());
            response.add(itemResponse);
        }
        return response;
    }

    @Override
    public SeniorVpItemResponse getSeniorVp(Long seniorVpId) {
        SeniorVpItemResponse seniorVpItemResponse = new SeniorVpItemResponse();
        Optional<SeniorVP> result = seniorVpRepository.findById(seniorVpId);
        seniorVpItemResponse.setId(result.get().getId());
        seniorVpItemResponse.setFirstName(result.get().getFirstName());
        seniorVpItemResponse.setLastName(result.get().getLastName());
        return seniorVpItemResponse;
    }
}
