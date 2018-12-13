package com.example.demo.jwt;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JWTFactory {

	private static final String TOKEN_KEY = "so.Rjs.ep";

	private static final Date ISSUED_DATE;
	private static final Date EXPIRES_DATE;

	static{
	    Calendar cal = Calendar.getInstance();
	    //cal.add(Calendar.MONTH, -1);
	    ISSUED_DATE = cal.getTime();
	    cal.add(Calendar.DATE, 10);
		EXPIRES_DATE = cal.getTime();
	}
	
	public String createJWT(UserInfoVO user) throws Exception {
		try {
			log.info("ISSUED_DATE=>{}",ISSUED_DATE);
			log.info("EXPIRES_DATE=>{}",EXPIRES_DATE);
			return JWT.create()
				.withIssuer(user.getUi_id())
				.withIssuedAt(ISSUED_DATE)
				.withExpiresAt(EXPIRES_DATE)
				.sign(Algorithm.HMAC256(TOKEN_KEY));
			
		} catch (JWTCreationException createEx) {
			log.info("Create Error");
			createEx.printStackTrace();
		}
		return null;
	}
	public boolean verifyJwt(Map<String,String> map) throws Exception{
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_KEY))
				.withIssuer(map.get("id"))
				.build();

		DecodedJWT jwt = verifier.verify(map.get("token"));
		log.info("issuer=>{}",jwt.getIssuer());
		return true;
	}

}
