package com.roomy.roomy.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

//adding the following token to make it a managed bean
@Service
public class JwtService {
    //we can move to application properties
    private static final String SECRET_KEY ="3F4428472B4B6250645367566B5970337336763979244226452948404D635166";

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }


    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public UUID extractUUID(String token)
    {
        return UUID.fromString(extractClaim(token, claims -> (String) claims.get("userId")));
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }

    public String generateToken(
        Map<String, Object> extraClaims,
        UserDetails userDetails ){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))  //token is valid for 1 day
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()))&& !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
//a signing key is a secret that is  used to digitally sign the JWT the signing key is
//used to create the signature part of the JWT which  is used to verify that the sender of the JWT is
//who it claims to be and ensure that the message  wasn't changed along the way so we want to ensure
//that the same person or the same client that is  sending this JWT key is the one that claims who to
//be okay so the signing key is used in conjunction  with the sign-in algorithm specified in the JWT
//header to create the signature the specific  sign-in algorithm and key size will depend on
//the security requirement of your application and  the level of trust you have in the signing party
//okay so here in order to do that first of all  we need to go ahead and generate a new token

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())  //
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
