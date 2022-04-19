package net.atos.reservas.reservaSalas.auth.jwt;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
/*
 * Clase que valida si lo que entra es un token autorizado, si no devuelve un error 401 de No Autorizado.
 * Nos devuelve el error de no autorizado. Rechaza las peticiones que no este autenticadas.
 */
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException)
			throws IOException, ServletException {

		logger.error("Error en el metodo commence en clase JwtEntryPoint");
		logger.error("Mensaje de error que me llega: " + authException.getMessage());
		logger.error("Mensaje de error que me llega: " + IOException.class);
		
		/*res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        res.getWriter().write(JsonBuilder //my util class for creating json strings
                .put("timestamp", DateGenerator.getDate())
                .put("status", 403)
                .put("message", "Access denied")
                .build());*/
        
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	}

}
