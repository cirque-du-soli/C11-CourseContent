/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.solifsd08.day01teammembers;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author solil
 */
public class Day01TeamMembers {

    public static void main(String[] args) {
        
        //SETUP:
        
        String line; //for file's data

        // TEST: find working directory
        System.out.println(Paths.get("").toAbsolutePath());
        
        //try-with-resources
        try(
                FileReader fr = new FileReader("teams.txt"); 
                BufferedReader br = new BufferedReader(fr)
                ){
            
            //TEST: print line contents
            /*
            while ((line = br.readLine()) != null) {
                System.out.println("Text from the line: " + line);
            } */
            
            //for given data <tName, tPlayers>
            HashMap<String, String[]> teams = new HashMap();
            
            //for processed data
            HashMap<String, String[]> players = new HashMap();
            
            //get data from file
            while ((line = br.readLine()) != null) {
                                
                // parse tName & tPlayers
                String[] tData = line.split(":");
                
                //get team name
                String tName = tData[0];
                
                //get player names
                String[] tPlayers = tData[1].split(",");
                
                //put the data into teams HashMap
                teams.put(tName, tPlayers);
                        
            } //END: get data from file
            
            //Process the data
            //iterate through each team
            teams.forEach((tName, tPlayers) -> {
                
                //iterate through each player on team
                for(String player : tPlayers) {
                    
                    //check if player exists in players HashMap
                    if (players.containsKey(player)) { //player in HashMap
                        
                        //get current teams
                        String[] pCurrTeams = players.get(player);
                        
                        //create array for appended list teams length + 1
                        String[] pNewTeams = new String[pCurrTeams.length + 1];

                        //set current Teams into pNewTeams
                        
                        System.arraycopy(pCurrTeams, 0, pNewTeams, 0, pCurrTeams.length);
                        
                        //add new team
                        pNewTeams[pCurrTeams.length] = tName;
                        
                        //set pTeams
                        players.put(player, pNewTeams);
                       
                    } else {// if player DNE
                        
                        String[] pNewTeams = new String[1];
                        pNewTeams[0] = tName;
                        players.put(player, pNewTeams);
                    } 
                    
                }
                
            }); //END: Process Data
            
            //Output Data
            
            players.forEach((pName, tNames)->{
                
                //intro print
                System.out.print(pName+" plays in: ");
                
                //print each team name
                for(int i=0; i<tNames.length; i++) {
                    System.out.print(tNames[i]);
                    
                    //print comma if not last team
                    if (i != tNames.length-1) {
                        System.out.print(", ");
                    } else {
                        System.out.println("\n");
                    }
                }
            }); //END: output data
            
        } catch (IOException e) {
            System.out.println("IO Exception in try block =>" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Aw shucks, something else broke! e => "+e.getMessage());
        }    
    }
}
