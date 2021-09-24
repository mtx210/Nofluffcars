package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.repository.GenerationsRepository;
import com.murbanowicz.nofluffcars.dto.response.GenerationResponse;
import com.murbanowicz.nofluffcars.exception.RestApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerationsService {

    private final GenerationsRepository generationsRepository;

    public GenerationsService(GenerationsRepository generationsRepository) {
        this.generationsRepository = generationsRepository;
    }

    public List<GenerationResponse> getByModelId(Long modelId) throws RestApiException {
        if(modelId == null){
            throw new RestApiException(HttpStatus.BAD_REQUEST);
        }

        List<GenerationResponse> generations = generationsRepository.getGenerationsByModelId(modelId);
        if(generations.isEmpty()){
            throw new RestApiException(HttpStatus.NO_CONTENT);
        }

        return generations;
    }
}