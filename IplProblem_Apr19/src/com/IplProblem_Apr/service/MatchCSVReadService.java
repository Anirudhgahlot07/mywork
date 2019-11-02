package com.IplProblem_Apr.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.IplProblem_Apr.VOFiles.MatchVO;

public class MatchCSVReadService implements ReadDataServiceInterface {
    

    
    public static List<MatchVO> matchesData = new ArrayList<MatchVO>();
    
    public void readDataOfCsv() throws IOException{
        
    	BufferedReader br = null;
    	br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Enter file path of match csv");
        String csvFile = br.readLine();
        
        String line = "";
        String cvsSplitBy = ",";
        int skip = 0;
        

        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                if(skip == 0){
                    skip++;
                    continue;
                }
                
                String[] match = line.split(cvsSplitBy,-1);
                this.fillDataOfCsv(match);
                

                
            }
        }
            

         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

       
        
            
    }
    
    
    public void fillDataOfCsv(String[] data) {
        MatchVO matchVO = new MatchVO();
        
        int data0 = Integer.parseInt(data[0]);
        int data1 = Integer.parseInt(data[1]);
        
        matchVO.setMatchId(data0);
        matchVO.setSeason(data1);
        matchVO.setCity(data[2]);
        matchVO.setDate(data[3]);
        matchVO.setTeam1(data[4]);
        matchVO.setTeam2(data[5]);
        matchVO.setTossWinner(data[6]);
        matchVO.setTossDecision(data[7]);
        matchVO.setResult(data[8]);
        matchVO.setWinner(data[9]);
        
        matchesData.add(matchVO);
        

    }
    
}
