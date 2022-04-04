package com.zeto.rezerwacja.config;

import com.zeto.rezerwacja.service.impl.UzytkownikDetalisServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
    @Autowired
    private UzytkownikDetalisServiceImpl uzytkownikDetalisService;


    @Autowired
    private  JwtUtils jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       final String requestTokenHeader =  request.getHeader("Autoryzacja");
        System.out.println(requestTokenHeader);
        String email=null;
        String jwtToken=null;


        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer"))
        {
            //yes
            jwtToken=requestTokenHeader.substring(7);

            try {
                email = this.jwtUtil.extractUsername(jwtToken);
            }catch (ExpiredJwtException e)
            {
                e.printStackTrace();
                System.out.println("Jwt Token wyparowal");
            }catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("error");
            }



        }else
        {

            System.out.println("Niepoprawny Token");

        }

        //validated
        if (email!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
          final UserDetails userDetails =  this.uzytkownikDetalisService.loadUserByUsername(email);
          if (this.jwtUtil.validateToken(jwtToken,userDetails))
          {
              //token is valid
              UsernamePasswordAuthenticationToken usernamePasswordAuthentication =
                      new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
              usernamePasswordAuthentication.setDetails(
                      new WebAuthenticationDetailsSource().buildDetails(request));
              SecurityContextHolder.getContext()
                      .setAuthentication(usernamePasswordAuthentication);
          }
        }else
        {
            System.out.printf("Niepoprawny Token");
        }

        filterChain.doFilter(request,response);

    }



}
