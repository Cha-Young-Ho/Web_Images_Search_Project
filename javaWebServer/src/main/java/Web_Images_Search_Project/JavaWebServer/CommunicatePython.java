package Web_Images_Search_Project.JavaWebServer;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Slf4j
public class CommunicatePython {

    public String  createHttpRequestAndSend(String query){

        //필요한 객체 생성
        RestTemplate restTemplate = new RestTemplate();

        //body 생성
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("query", query);

        //header 생성

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(params, headers);

        JSONObject jsonObject = new JSONObject(restTemplate.postForObject("http://192.168.56.1:9000/get_data", entity, String.class));

        String result = jsonObject.getString("check");
        return result;

    }

};