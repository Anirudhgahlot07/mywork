package com.IplProblem_Apr.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.IplProblem_Apr.VOFiles.DeliveriesVO;

public class DeliveriesCSVReadService implements ReadDataServiceInterface {
    
    public static List<DeliveriesVO> deliveriesData = new ArrayList<DeliveriesVO>();

    public void readDataOfCsv() throws IOException{
        
    	BufferedReader br = null;
    	br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Enter file path of  deliveries.csv");
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
                // using comma as separator here
                String[] match = line.split(cvsSplitBy);
                fillDataOfCsv(match);

                
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
    
    public void fillDataOfCsv(String[] data){
        
        DeliveriesVO deliveriesVO = new DeliveriesVO();
        
        int data0 = Integer.parseInt(data[0]);
        int data1 = Integer.parseInt(data[1]);
        int data4 = Integer.parseInt(data[4]);
        int data5 = Integer.parseInt(data[5]);
        int data8 = Integer.parseInt(data[8]);
        int data9 = Integer.parseInt(data[9]);
        int data10 = Integer.parseInt(data[10]);
        int data11 = Integer.parseInt(data[11]);
        int data12 = Integer.parseInt(data[12]);
        int data13 = Integer.parseInt(data[13]);
        int data14 = Integer.parseInt(data[15]);
        int data15 = Integer.parseInt(data[15]);
        
        
        deliveriesVO.setMatchId(data0);
        deliveriesVO.setInnings(data1);
        deliveriesVO.setBattingTeam(data[2]);
        deliveriesVO.setBowlingTeam(data[3]);
        deliveriesVO.setOver(data4);
        deliveriesVO.setBall(data5);
        deliveriesVO.setBatsmanName(data[6]);
        deliveriesVO.setBowlerName(data[7]);
        deliveriesVO.setWideRuns(data8);
        deliveriesVO.setByeRuns(data9);
        deliveriesVO.setLegByeRuns(data10);
        deliveriesVO.setNoballRuns(data11);
        deliveriesVO.setPenaltyRuns(data12);
        deliveriesVO.setBatsmanRuns(data13);
        deliveriesVO.setExtraRuns(data14);
        deliveriesVO.setTotalRuns(data15);
        
        deliveriesData.add(deliveriesVO);
        
//      System.out.println("**********");
//      System.out.println(deliveriesData.get(0).getBatsmanName());
//      System.out.println("**********");
    }

	
}
