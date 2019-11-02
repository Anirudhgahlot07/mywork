package com.IplProblem_Apr.service;

import java.io.IOException;

public interface ReadDataServiceInterface {
    
    public void readDataOfCsv() throws IOException;
    
    public void fillDataOfCsv(String[] data);

}
