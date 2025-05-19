package com.bookings.api_gateway.Security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    Logger logger =LoggerFactory.getLogger(OncePerRequestFilter.class);

    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String requestHeader=request.getHeader("Authorization");
       logger.info("Header :{}",requestHeader);
       String username=null;
       String token=null;
       if(Objects.nonNull(requestHeader) && requestHeader.startsWith("Bearer")){
           token=requestHeader.substring(7);
           try{
               username=this.jwtHelper.getUsernameFromToken(token);
           }catch(IllegalArgumentException illegalArgumentException){
                logger.info("Illeagal Argument while fetching the user name");
           }catch(ExpiredJwtException expiredJwtException){
                logger.info("Given Jwt token expired");
           }catch(MalformedJwtException malformedJwtException){
                 logger.info("some changed has been done in token || Invalid Token ");
                 malformedJwtException.printStackTrace();
           }catch (Exception ex){
               ex.printStackTrace();;
           }
       }else{
           logger.info("invalid header value !");
       }

       if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null){

           UserDetails userDetails=this.userDetailsService.loadUserByUsername(username);
           Boolean isValidate=this.jwtHelper.validateToken(token,userDetails);
           if(isValidate){
               UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
               usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
           }else{
               logger.info("validation failed !");
           }
       }
       filterChain.doFilter(request,response);
    }
}
