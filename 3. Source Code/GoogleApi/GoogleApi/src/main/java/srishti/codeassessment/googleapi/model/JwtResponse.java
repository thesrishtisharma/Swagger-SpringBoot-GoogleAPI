package srishti.codeassessment.googleapi.model;

import lombok.Data;

@Data
public class JwtToken {
    private String token;
    private String username;
}
