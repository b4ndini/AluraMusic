package com.lfelipe.alura.music.controller;

import com.lfelipe.alura.music.network.api.GroqApi;
import com.lfelipe.alura.music.network.model.GroqResponse;
import com.lfelipe.alura.music.util.ApiConstants;
import com.lfelipe.alura.music.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroqController {

    @Autowired
    private GroqApi groqApi;

    public GroqController(GroqApi groupApi) {
        this.groqApi = groupApi;
    }

    public void getQrogAnswer(String busca){
        try{
            String resp = groqApi.post(busca, ApiConstants.GET_GROQ_ANSWER_ENDPOINT);
            GroqResponse groqResp = Converter.getObject(resp, GroqResponse.class);
            System.out.println(groqResp.getContent());
        }catch(Exception e){
            System.out.println("Erro! Não foi possível completar a operação: " + e.getLocalizedMessage());
        }
    }
}
