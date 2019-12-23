package com.blackapple.hw.controller;

import com.blackapple.hw.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

@Controller
public class RegisterController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute User user){
        try(FileWriter writer = new FileWriter("text.txt", true))
        {
            writer.write(user.toString()+"\n");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return "registerSuccessful";
    }

    @RequestMapping("/members")
    public String viewMembers(Model model){
        List<String> list= new LinkedList<>();
        try {
            File file = new File("text.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                list.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("members",list);
        return "members";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchUser(Model model){
        model.addAttribute("user",new User());
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String foundUser(@ModelAttribute User user){

        try {
            File file = new File("text.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(user.getFirstName())){
                    if(line.contains(user.getLastName())) {
                        System.out.println(line);
                        return "foundUser";
                    }
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "search";
    }
}
