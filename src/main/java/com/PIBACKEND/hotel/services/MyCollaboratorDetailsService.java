package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.model.Acess;
import com.PIBACKEND.hotel.model.Collaborator;
import com.PIBACKEND.hotel.repositories.CollaboratorRepository;
import com.PIBACKEND.hotel.services.exceptions.EntityNotFoundExceptionHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class MyCollaboratorDetailsService implements UserDetailsService {

    @Autowired
    private CollaboratorRepository repository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Collaborator userAccount = repository.findByEmail(email);

        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();

        if (userAccount != null) {
            Acess role = userAccount.getAcess_id();
            if (role != null) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getAcess_level());
                grantList.add(grantedAuthority);
                return (UserDetails) new Collaborator(email,userAccount.getCollaborator_password(),grantList);
            }
        }

        throw new EntityNotFoundExceptionHotel("Email ou senha incorreto");
    }

}
