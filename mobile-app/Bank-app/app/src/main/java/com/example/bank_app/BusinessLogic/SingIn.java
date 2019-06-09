package com.example.bank_app.BusinessLogic;

import android.content.Context;

import com.example.bank_app.DataAccess.Models.User;
import com.example.bank_app.DataAccess.Repositories.UserRepository;

public class SingIn {
    User user;
    UserRepository userRepository;
    Context context;

    public SingIn(Context context) {
        this.user = new User();
        this.userRepository = new UserRepository(context);
        this.context = context;
    }


    public User sing (String id, String password){
            user = userRepository.getUserByIdentification(Integer.parseInt(id));
              if(user!=null){
                    if(user.getPassword_user()==Integer.parseInt(password)){
                        return user;
                      }else{
                        return null;
                    }
                 }
              return null;
            }
       }
