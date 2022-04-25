/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
/**
 *
 * @author hrishi
 */
public class UsersOdsReaderWriter {
    
    Sheet sheet;
    
    public void readODS(File file){
    
    try {
         //Getting the 0th sheet for manipulation| pass sheet name as string
         sheet = SpreadSheet.createFromFile(file).getSheet(0);
         
         
         //remove row from the sheet
         //sheet.removeRow(5);
         
         //Get row count and column count
         int nColCount = sheet.getColumnCount();
         int nRowCount = sheet.getRowCount();

         System.out.println("Rows :"+nRowCount);
         System.out.println("Cols :"+nColCount);
         
         //Iterating through each row of the selected sheet
         MutableCell cell = null;
         for(int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++)
         {
           //Iterating through each column
           int nColIndex = 0;
           for( ;nColIndex < nColCount; nColIndex++)
           {
             cell = sheet.getCellAt(nColIndex, nRowIndex);
             System.out.print(cell.getValue()+ " ");
            }
            System.out.println();
          }

        } catch (IOException e) {
          e.printStackTrace();
        }
  }
    
    public void addToODS(File file){
      try{
          sheet = SpreadSheet.createFromFile(file).getSheet(0);
        
         int nColCount = sheet.getColumnCount();
         int nRowCount = sheet.getRowCount();

         //System.out.println("Rows :"+nRowCount);
         //System.out.println("Cols :"+nColCount);
         
         sheet.ensureRowCount(nRowCount+1);
         sheet.ensureColumnCount(3);
         
         sheet.setValueAt(nRowCount, 0 , nRowCount);
         
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter Name: ");
         String name = sc.next();
         sheet.setValueAt(name, 1, nRowCount);
         
         System.out.println("Enter Email: ");
         String email = sc.next();
         sheet.setValueAt(email, 2 , nRowCount);
         
         sheet.getSpreadSheet().saveAs(file);
        
      }catch (IOException e) {
          e.printStackTrace();
        }
  }
    
    public void removeOdsRow(File file){
        try{
            sheet = SpreadSheet.createFromFile(file).getSheet(0);
            
            sheet.removeRow(2);
            
            sheet.getSpreadSheet().saveAs(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
