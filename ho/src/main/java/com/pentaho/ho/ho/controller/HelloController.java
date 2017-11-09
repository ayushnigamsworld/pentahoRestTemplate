package com.pentaho.ho.ho.controller;

import com.pentaho.ho.ho.authorization.Authorization;
import com.pentaho.ho.ho.model.Ace;
import com.pentaho.ho.ho.model.RepositoryFileAclDto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getAcl")
    public String getAcl(){

        String url = "http://localhost:8080/pentaho/api/repo/files/home:adminMain:a1.txt/acl";

        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "password"));

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        System.out.print("Response -> "+ response.getBody());


        return "Response -> "+ response.getBody();
    }

    @RequestMapping("/putAcl")
    public String putAcl() throws JAXBException {

        JAXBContext contextObj = JAXBContext.newInstance(RepositoryFileAclDto.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Filling xml data
        Ace ace1 = new Ace(true, 1, "CC_1", 1);
        Ace ace2 = new Ace(false, 4, "Role_Administrator", 1);

        ArrayList<Ace> aces = new ArrayList<Ace>();
        aces.add(ace1);
        aces.add(ace2);

        RepositoryFileAclDto acls = new RepositoryFileAclDto(aces, "agent", 0);

        StringWriter stringWriter = new StringWriter();
        marshallerObj.marshal(acls, stringWriter);

        String body = stringWriter.toString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        String url = "http://localhost:8080/pentaho/api/repo/files/home:adminMain:a1.txt/acl";

        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "password"));

        HttpEntity<String> request = new HttpEntity<String>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);

        System.out.println("Response -> "+ response.getBody());
        System.out.println("Status Code -> "+ response.getStatusCode());

        return "Response -> "+ response.getBody();

    }
}
