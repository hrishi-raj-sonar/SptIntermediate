/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class StoryOdsReaderWriter {

    Sheet sheet;

    public void readODS(File file) {

        try {
            //Getting the 0th sheet for manipulation| pass sheet name as string
            sheet = SpreadSheet.createFromFile(file).getSheet(0);

            //remove row from the sheet
            //sheet.removeRow(5);
            //Get row count and column count
            int nColCount = sheet.getColumnCount();
            int nRowCount = sheet.getRowCount();

            System.out.println("Rows :" + nRowCount);
            System.out.println("Cols :" + nColCount);

            sheet.setValueAt("Hello", 2, 2);

            //Show a particular row
            Scanner sc = new Scanner(System.in);
            System.out.println("What story do your want to see?");
            int rowNum = sc.nextInt();
            MutableCell cell1 = null;
            int c = 0;
            for (; c < nColCount; c++) {
                cell1 = sheet.getCellAt(c, rowNum);
                System.out.println(cell1.getValue() + " ");
            }

            //Iterating through each row of the selected sheet
            MutableCell cell = null;
            for (int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++) {
                //Iterating through each column
                int nColIndex = 0;
                for (; nColIndex < nColCount; nColIndex++) {
                    cell = sheet.getCellAt(nColIndex, nRowIndex);
                    System.out.print(cell.getValue() + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToODS(File file) {
        try {
            sheet = SpreadSheet.createFromFile(file).getSheet(0);

            int nColCount = sheet.getColumnCount();
            int nRowCount = sheet.getRowCount();

            //System.out.println("Rows :"+nRowCount);
            //System.out.println("Cols :"+nColCount);
            sheet.ensureRowCount(nRowCount + 1);
            sheet.ensureColumnCount(7);

            sheet.setValueAt(nRowCount, 0, nRowCount);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Story Name: ");
            String storyName = sc.next();
            sheet.setValueAt(storyName, 1, nRowCount);

            System.out.println("Enter Story Status: ");
            String storyStatus = sc.next();
            sheet.setValueAt(storyStatus, 2, nRowCount);

            System.out.println("Enter Story Points: ");
            int storyPoints = sc.nextInt();
            sheet.setValueAt(storyPoints, 3, nRowCount);

            System.out.println("Enter Story Requestor: ");
            String storyRequestor = sc.next();
            sheet.setValueAt(storyRequestor, 4, nRowCount);

            System.out.println("Enter Story Developer: ");
            String storyDeveloper = sc.next();
            sheet.setValueAt(storyDeveloper, 5, nRowCount);

            System.out.println("Enter Story Reviewer: ");
            String storyReviewer = sc.next();
            sheet.setValueAt(storyReviewer, 6, nRowCount);

            sheet.getSpreadSheet().saveAs(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeODS(File file) {
        try {
            sheet = SpreadSheet.createFromFile(file).getSheet(0);

            int nColCount = sheet.getColumnCount();
            int nRowCount = sheet.getRowCount();

            System.out.println("Rows :" + nRowCount);
            System.out.println("Cols :" + nColCount);

            //Change a particular row
            MutableCell cell2 = null;

            Scanner sc = new Scanner(System.in);
            System.out.println("What story do your want to change?");
            int changeRowNum = sc.nextInt();
            System.out.println("What attribute do you want to change? ");
            String changingAttribute = sc.next();
            switch (changingAttribute) {
                case "name":
                    cell2 = sheet.getCellAt(1, changeRowNum);
                    System.out.println("Enter new name: ");
                    String newStoryName = sc.next();
                    cell2.setValue(newStoryName);
                    break;
                case "status":
                    cell2 = sheet.getCellAt(2, changeRowNum);
                    System.out.println("Enter new status: ");
                    String newStoryStatus = sc.next();
                    cell2.setValue(newStoryStatus);

            }

            sheet.getSpreadSheet().saveAs(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startStory(File file) {
        try {
            sheet = SpreadSheet.createFromFile(file).getSheet(0);

            int nColCount = sheet.getColumnCount();
            int nRowCount = sheet.getRowCount();

            System.out.println("Rows :" + nRowCount);
            System.out.println("Cols :" + nColCount);

            //Change a particular row
            MutableCell cell2 = null;

            Scanner sc = new Scanner(System.in);
            System.out.println("What story do your want to start?");
            int startRowNum = sc.nextInt();
            cell2 = sheet.getCellAt(2, startRowNum);
            cell2.setValue("Started");

            sheet.getSpreadSheet().saveAs(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void finishStory(File file) {
        try {
            sheet = SpreadSheet.createFromFile(file).getSheet(0);

            int nColCount = sheet.getColumnCount();
            int nRowCount = sheet.getRowCount();

            System.out.println("Rows :" + nRowCount);
            System.out.println("Cols :" + nColCount);

            //Change a particular row
            MutableCell cell2 = null;

            Scanner sc = new Scanner(System.in);
            System.out.println("What story do your want to finish?");
            int finishRowNum = sc.nextInt();
            cell2 = sheet.getCellAt(2, finishRowNum);
            cell2.setValue("Finished");

            sheet.getSpreadSheet().saveAs(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deliverStory(File file) {
        try {
            sheet = SpreadSheet.createFromFile(file).getSheet(0);

            int nColCount = sheet.getColumnCount();
            int nRowCount = sheet.getRowCount();

            System.out.println("Rows :" + nRowCount);
            System.out.println("Cols :" + nColCount);

            //Change a particular row
            MutableCell cell2 = null;

            Scanner sc = new Scanner(System.in);
            System.out.println("What story do your want to deliver?");
            int deliverRowNum = sc.nextInt();
            cell2 = sheet.getCellAt(2, deliverRowNum);
            cell2.setValue("nnnnnnn");

            sheet.getSpreadSheet().saveAs(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reviewStory(File file) {
        try {
            sheet = SpreadSheet.createFromFile(file).getSheet(0);

            int nColCount = sheet.getColumnCount();
            int nRowCount = sheet.getRowCount();

            System.out.println("Rows :" + nRowCount);
            System.out.println("Cols :" + nColCount);

            //Change a particular row
            MutableCell cell2 = null;

            Scanner sc = new Scanner(System.in);
            System.out.println("What story do your want to review?");
            int reviewRowNum = sc.nextInt();
            System.out.println("Accept or reject story? ");
            String changingAttribute = sc.next();
            switch (changingAttribute) {
                case "accept":
                    cell2 = sheet.getCellAt(2, reviewRowNum);
                    cell2.setValue("Done");
                    break;
                case "reject":
                    cell2 = sheet.getCellAt(2, reviewRowNum);
                    cell2.setValue("Unstarted");
            }
            sheet.getSpreadSheet().saveAs(file);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

