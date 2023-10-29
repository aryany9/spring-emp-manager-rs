package com.example.demo.service;
import com.example.demo.model.SeniorVP;
import com.example.demo.model.request.AddSeniorVPRequest;
import com.example.demo.model.response.AddSeniorVpResponse;
import com.example.demo.repository.SeniorVpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeniorVpServiceImpl implements SeniorVpService {
    @Autowired
    SeniorVpRepository seniorVpRepository;

    @Override
    public AddSeniorVpResponse addSeniorVp(AddSeniorVPRequest addSeniorVPRequest) {
        SeniorVP seniorVP = new SeniorVP();
        seniorVP.setFirstName(addSeniorVPRequest.getFirstName());
        seniorVP.setLastName(addSeniorVPRequest.getLastName());

        SeniorVP savedVp = seniorVpRepository.save(seniorVP);

        AddSeniorVpResponse response = new AddSeniorVpResponse();
        response.setFirstName(savedVp.getFirstName());
        response.setId(savedVp.getId());
        response.setLastName(savedVp.getLastName());
        return response;
    }
}
