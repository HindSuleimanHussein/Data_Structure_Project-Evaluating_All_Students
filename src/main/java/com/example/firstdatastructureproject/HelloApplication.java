package com.example.firstdatastructureproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    Scene scene, insert, delete, display, average, mode, percentage;

    @Override
    public void start(Stage stage) throws IOException {
        LinkedList<Tawjihi> gazaScienceList = new LinkedList();
        LinkedList<Tawjihi> westBankScienceList = new LinkedList();
        LinkedList<Tawjihi> gazaLiteraryList = new LinkedList();
        LinkedList<Tawjihi> westBankLiteraryList = new LinkedList();

        File gazaFile = new File("Gaza_2022.csv");
        File westBankFile = new File("WestBank_2022.csv");

        Scanner scGaza = new Scanner(gazaFile);
        while(scGaza.hasNext()) {
            String s = scGaza.nextLine();
            String[] str = s.split(",");
            if(str[1].equalsIgnoreCase("Scientific")) {
                gazaScienceList.insertSorted(new Tawjihi(Integer.parseInt(str[0]), str[1], Double.parseDouble(str[2])));
            }
            else if(str[1].equalsIgnoreCase("Literary"))
                gazaLiteraryList.insertSorted(new Tawjihi(Integer.parseInt(str[0]), str[1], Double.parseDouble(str[2])));
        }




        Scanner scWestBank = new Scanner(westBankFile);
        while(scWestBank.hasNext()) {
            String s = scWestBank.nextLine();
            String[] str = s.split(",");
            if(str[1].equalsIgnoreCase("Scientific")) {
                westBankScienceList.insertSorted(new Tawjihi(Integer.parseInt(str[0]), str[1], Double.parseDouble(str[2])));
            }
            else if(str[1].equalsIgnoreCase("Literary"))
                westBankLiteraryList.insertSorted(new Tawjihi(Integer.parseInt(str[0]), str[1], Double.parseDouble(str[2])));
        }



        BorderPane mainPane = new BorderPane();

        Button insertMain = new Button("Insert A New Student");
        insertMain.setOnAction(e->stage.setScene(insert));

        Button deleteMain = new Button("Delete A Student");
        deleteMain.setOnAction(e->stage.setScene(delete));

        Button displayMain = new Button("Display The Top 10 Students");
        displayMain.setOnAction(e->stage.setScene(display));

        Button averageMain = new Button("Calculate The Average Mean Of Student");
        averageMain.setOnAction(e->stage.setScene(average));

        Button modeMain = new Button("Calculate The Average Mode Of Students");
        modeMain.setOnAction(e->stage.setScene(mode));

        Button percentageMain = new Button("Amount And Percentage Of Students Above The Average");
        percentageMain.setOnAction(e->stage.setScene(percentage));

        VBox mainButtons = new VBox(30);
        mainButtons.getChildren().addAll(insertMain, deleteMain, displayMain, averageMain, modeMain, percentageMain);
        mainButtons.setAlignment(Pos.CENTER);
        mainPane.setCenter(mainButtons);

        //insert Scene
        BorderPane insertPane = new BorderPane();
        TextField insertID = new TextField();
        Label labelInsertID = new Label("The Seat Number: ");

        TextField insertAverage = new TextField();
        Label labelInsertAverage = new Label("The Average: ");

        Label labelForInsertUser = new Label();

        RadioButton gazaLiterary = new RadioButton("Gaza-Literary Branch");
        RadioButton westBankLiterary = new RadioButton("West Bank-Literary Branch");
        RadioButton gazaScience = new RadioButton("Gaza-Scientific Branch");
        RadioButton westBankScience = new RadioButton("West Bank-Scientific Branch");
        ToggleGroup tgGazaWest = new ToggleGroup();
        gazaLiterary.setToggleGroup(tgGazaWest);
        westBankLiterary.setToggleGroup(tgGazaWest);
        gazaScience.setToggleGroup(tgGazaWest);
        westBankScience.setToggleGroup(tgGazaWest);


        HBox gazaWestToggle = new HBox(20);
        gazaWestToggle.getChildren().addAll(gazaLiterary, westBankLiterary, gazaScience, westBankScience);
        gazaWestToggle.setAlignment(Pos.CENTER);

        Button insertButton= new Button("Insert");
        insertButton.setOnAction(e->{
            if(westBankLiterary.isSelected()) {
                Node<Tawjihi> curr = westBankLiteraryList.getHead();
                while (curr != null) {
                    if (curr.getData().getSeatNumber() == Integer.parseInt(insertID.getText())) {
                        labelForInsertUser.setText("The Seat Number Is Already Registered");
                        break;
                    }
                    else
                        curr = curr.getNext();
                }
                if(curr==null) {
                    westBankLiteraryList.insertSorted(new Tawjihi(Integer.parseInt(insertID.getText()), "Literary", Double.parseDouble(insertAverage.getText())));
                    labelForInsertUser.setText("Successfully Added");
                }
            }

            else if(gazaLiterary.isSelected()){
                Node<Tawjihi> curr = gazaLiteraryList.getHead();
                while (curr != null) {
                    if (curr.getData().getSeatNumber() == Integer.parseInt(insertID.getText())) {
                        labelForInsertUser.setText("The Seat Number Is Already Registered");
                        break;
                    }
                    else
                        curr = curr.getNext();
                }
                if(curr==null) {
                    gazaLiteraryList.insertSorted(new Tawjihi(Integer.parseInt(insertID.getText()), "Literary", Double.parseDouble(insertAverage.getText())));
                    labelForInsertUser.setText("Successfully Added");
                }
            }

            else if(gazaScience.isSelected()){
                Node<Tawjihi> curr = gazaScienceList.getHead();
                while (curr != null) {
                    if (curr.getData().getSeatNumber() == Integer.parseInt(insertID.getText())) {
                        labelForInsertUser.setText("The Seat Number Is Already Registered");
                        break;
                    }
                    else
                        curr = curr.getNext();
                }
                if(curr==null) {
                    gazaScienceList.insertSorted(new Tawjihi(Integer.parseInt(insertID.getText()), "Scientific", Double.parseDouble(insertAverage.getText())));
                    labelForInsertUser.setText("Successfully Added");
                }
            }
            else if(westBankScience.isSelected()){
                Node<Tawjihi> curr = westBankScienceList.getHead();
                while (curr != null) {
                    if (curr.getData().getSeatNumber() == Integer.parseInt(insertID.getText())) {
                        labelForInsertUser.setText("The Seat Number Is Already Registered");
                        break;
                    }
                    else
                        curr = curr.getNext();
                }
                if(curr==null) {
                    westBankScienceList.insertSorted(new Tawjihi(Integer.parseInt(insertID.getText()), "Scientific", Double.parseDouble(insertAverage.getText())));
                    labelForInsertUser.setText("Successfully Added");
                }
            }

            insertID.setText(null);
            insertAverage.setText(null);

        });

        Button backInsert = new Button("Back");
        backInsert.setOnAction(e->{
            stage.setScene(scene);
            labelForInsertUser.setText(null);
        });

        HBox insertAndBack = new HBox(20);
        insertAndBack.getChildren().addAll(insertButton, backInsert);
        insertAndBack.setAlignment(Pos.CENTER);

        GridPane insertGrid = new GridPane();
        insertGrid.addRow(1, labelInsertID, insertID);
        insertGrid.addRow(2, labelInsertAverage, insertAverage);
        insertGrid.addRow(3, labelForInsertUser);
        insertGrid.addRow(4, gazaWestToggle);
        insertGrid.addRow(5, insertAndBack);
        insertGrid.setVgap(20);
        insertGrid.setAlignment(Pos.CENTER);

        insertPane.setCenter(insertGrid);
        insert = new Scene(insertPane, 900, 420);


        // Delete Scene
        BorderPane deletePane = new BorderPane();
        TextField deleteID = new TextField();
        Label labelDeleteID = new Label("The Seat Number: ");

        TextField deleteAverage = new TextField();
        Label labelDeleteAverage = new Label("The Average: ");

        TextField deleteBranch = new TextField();
        Label labelDeleteBranch = new Label("The Branch: ");

        Label labelForUserDelete = new Label();

        RadioButton gazaLiteraryDeleteRB = new RadioButton("Gaza-Literary Branch");
        RadioButton gazaScienceDeleteRB = new RadioButton("Gaza-Scientific Branch");
        RadioButton westBankScienceDeleteRB = new RadioButton("WestBank-Literary Branch");
        RadioButton westBankLiteraryDeleteRB = new RadioButton("West Bank-Scientific Branch");
        ToggleGroup tgAreaDeleteTop = new ToggleGroup();
        gazaLiteraryDeleteRB.setToggleGroup(tgAreaDeleteTop);
        gazaScienceDeleteRB.setToggleGroup(tgAreaDeleteTop);
        westBankScienceDeleteRB.setToggleGroup(tgAreaDeleteTop);
        westBankLiteraryDeleteRB.setToggleGroup(tgAreaDeleteTop);



        HBox DisplayAreaDeleteToggle = new HBox(20);
        DisplayAreaDeleteToggle.getChildren().addAll(gazaLiteraryDeleteRB, gazaScienceDeleteRB, westBankScienceDeleteRB, westBankLiteraryDeleteRB);
        DisplayAreaDeleteToggle.setAlignment(Pos.CENTER);

        Button deleteButton= new Button("Delete");
        deleteButton.setOnAction(e->{
            if(gazaScienceDeleteRB.isSelected()) {
                Node<Tawjihi> curr = gazaScienceList.getHead();
                while (curr.getNext() != null) {
                    if (curr.getData().getSeatNumber() == Integer.parseInt(deleteID.getText())) {
                        gazaScienceList.delete(curr.getData());
                        break;
                    }
                    curr=curr.getNext();
                }
            }

            else if(gazaLiteraryDeleteRB.isSelected()) {
                Node<Tawjihi> curr = gazaLiteraryList.getHead();
                while (curr.getNext() != null) {
                    if (curr.getData().getSeatNumber() == Integer.parseInt(deleteID.getText())) {
                        gazaLiteraryList.delete(curr.getData());
                        break;
                    }
                    curr=curr.getNext();
                }

            }

            else if(westBankScienceDeleteRB.isSelected()) {
                Node<Tawjihi> curr = westBankLiteraryList.getHead();
                while (curr.getNext() != null) {
                    if (curr.getData().getSeatNumber() == Integer.parseInt(deleteID.getText())) {
                        westBankLiteraryList.delete(curr.getData());
                        break;
                    }
                    curr=curr.getNext();
                }
            }

            else if(westBankLiteraryDeleteRB.isSelected()) {
                Node<Tawjihi> curr = westBankScienceList.getHead();
                while (curr.getNext() != null) {
                    if (curr.getData().getSeatNumber() == Integer.parseInt(deleteID.getText())) {
                        westBankScienceList.delete(curr.getData());
                        break;
                    }
                    curr=curr.getNext();
                }

            }
            deleteID.setText("");
            deleteBranch.setText("");
            deleteAverage.setText("");
        });

        Button findDeleteButton= new Button("Find");
        findDeleteButton.setOnAction(e->{
            if(gazaScienceDeleteRB.isSelected()) {
                Node<Tawjihi> curr = gazaScienceList.getHead();
                while (curr != null) {
                    if (deleteID.getText().equals("")) {
                        labelForUserDelete.setText("Make Sure To Fill In Seat Number");
                        deleteBranch.setText("");
                        deleteAverage.setText("");
                    }

                    else if (curr.getData().getSeatNumber() == Integer.parseInt(deleteID.getText())) {
                        labelForUserDelete.setText("Successful Operation!!!!");
                        deleteBranch.setText(curr.getData().getBranch());
                        deleteAverage.setText(String.valueOf(curr.getData().getAverage()));
                        break;
                    }

                    curr = curr.getNext();

                    if(curr.getData().getSeatNumber() != Integer.parseInt(deleteID.getText())){
                        labelForUserDelete.setText("Hmm...The Student Is Not On the System");
                        deleteBranch.setText("");
                        deleteAverage.setText("");
                    }
                }
            }

            if(gazaLiteraryDeleteRB.isSelected()) {
                Node<Tawjihi> curr = gazaLiteraryList.getHead();
                    while (curr != null) {
                        if (deleteID.getText().equals("")) {
                            labelForUserDelete.setText("Make Sure to Fill in Seat Number");
                            deleteBranch.setText("");
                            deleteAverage.setText("");

                        }
                        else if (curr.getData().getSeatNumber() == Integer.parseInt(deleteID.getText())) {
                            labelForUserDelete.setText("Successful Operation!!!!");
                            deleteBranch.setText(curr.getData().getBranch());
                            deleteAverage.setText(String.valueOf(curr.getData().getAverage()));
                            break;
                        }
                        curr = curr.getNext();
                        if(curr.getData().getSeatNumber() != Integer.parseInt(deleteID.getText())){
                            labelForUserDelete.setText("Hmm...The Student Is Not On the System");
                            deleteBranch.setText("");
                            deleteAverage.setText("");
                        }
                    }
            }

            if(westBankScienceDeleteRB.isSelected()) {
                Node<Tawjihi> curr = westBankLiteraryList.getHead();
                while (curr != null) {
                    if (deleteID.getText().equals("")) {
                        labelForUserDelete.setText("Make Sure to Fill in Seat Number");
                        deleteBranch.setText("");
                        deleteAverage.setText("");
                    }
                    else if (curr.getData().getSeatNumber() == Integer.parseInt(deleteID.getText())) {
                        labelForUserDelete.setText("Successful Operation!!!!");
                        deleteBranch.setText(curr.getData().getBranch());
                        deleteAverage.setText(String.valueOf(curr.getData().getAverage()));
                        break;
                    }
                    curr=curr.getNext();

                    if(curr.getData().getSeatNumber() != Integer.parseInt(deleteID.getText())){
                        labelForUserDelete.setText("Hmm...The Student Is Not On the System");
                        deleteBranch.setText("");
                        deleteAverage.setText("");
                    }
                }
            }

            if(westBankLiteraryDeleteRB.isSelected()) {
                Node<Tawjihi> curr = westBankScienceList.getHead();
                while (curr!= null) {
                    if (deleteID.getText().equals("")) {
                        labelForUserDelete.setText("Make Sure to Fill in Seat Number");
                        deleteBranch.setText("");
                        deleteAverage.setText("");
                    }
                    else if (curr.getData().getSeatNumber() == Integer.parseInt(deleteID.getText())) {
                        labelForUserDelete.setText("Successful Operation!!!!");
                        deleteBranch.setText(curr.getData().getBranch());
                        deleteAverage.setText(String.valueOf(curr.getData().getAverage()));
                        break;
                    }
                    curr=curr.getNext();
                    if(curr.getData().getSeatNumber() != Integer.parseInt(deleteID.getText())){
                        labelForUserDelete.setText("Hmm...The Student Is Not On the System");
                        deleteBranch.setText("");
                        deleteAverage.setText("");
                    }
                }
            }

        });

        Button backDelete = new Button("Back");
        backDelete.setOnAction(e-> {
            stage.setScene(scene);
            labelForUserDelete.setText("");
            deleteID.setText("");
            deleteBranch.setText("");
            deleteAverage.setText("");
        });


        HBox deleteAndBack = new HBox(20);
        deleteAndBack.getChildren().addAll(findDeleteButton, deleteButton, backDelete);
        deleteAndBack.setAlignment(Pos.CENTER);

        GridPane deleteGrid = new GridPane();
        deleteGrid.addRow(0, DisplayAreaDeleteToggle);
        deleteGrid.addRow(1, labelDeleteID, deleteID);
        deleteGrid.addRow(3, labelDeleteAverage, deleteAverage);
        deleteGrid.addRow(4, labelDeleteBranch, deleteBranch);
        deleteGrid.addRow(5, labelForUserDelete);
        deleteGrid.addRow(6, deleteAndBack);
        deleteGrid.setVgap(20);
        deleteGrid.setAlignment(Pos.CENTER);

        deletePane.setCenter(deleteGrid);
        delete = new Scene(deletePane, 900, 420);


        // Display the Top 10 Scene
        BorderPane displayPane = new BorderPane();
        Label labelDisplayID = new Label("The Top 10 Students Are: ");

        TextArea displayTextArea = new TextArea();

        Button backDisplay = new Button("Back");
        backDisplay.setOnAction(e->{
            stage.setScene(scene);
            displayTextArea.setText(null);
        });

        RadioButton gazaScienceDisplayRB = new RadioButton("Gaza-Scientific Branch");
        RadioButton gazaLiteraryDisplayRB = new RadioButton("Gaza-Literary Branch");
        RadioButton westBankScienceDisplayRB = new RadioButton("WestBank-Scientific Branch");
        RadioButton westBankLiteraryDisplayRB = new RadioButton("WestBank-Literary Branch");
        ToggleGroup tgAreaDisplayTop = new ToggleGroup();
        gazaScienceDisplayRB.setToggleGroup(tgAreaDisplayTop);
        gazaLiteraryDisplayRB.setToggleGroup(tgAreaDisplayTop);
        westBankScienceDisplayRB.setToggleGroup(tgAreaDisplayTop);
        westBankLiteraryDisplayRB.setToggleGroup(tgAreaDisplayTop);

        HBox DisplayAreaTopToggle = new HBox(20);
        DisplayAreaTopToggle.getChildren().addAll(gazaScienceDisplayRB, gazaLiteraryDisplayRB, westBankScienceDisplayRB, westBankLiteraryDisplayRB);
        DisplayAreaTopToggle.setAlignment(Pos.CENTER);

        Button displayButton = new Button("Display");
        displayButton.setOnAction(e->{
            if(gazaScienceDisplayRB.isSelected()) {
                String s="";
                Node<Tawjihi> prev = gazaScienceList.getHead();
                Node<Tawjihi> curr = prev.getNext();
                s += prev.getData() + "\n";
                for (int i=0; i<11; i++) {
                    if (curr.getData().getAverage() == prev.getData().getAverage()) {
                        s += curr.getData() + "\n";

                    }
                    prev = curr;
                    curr = curr.getNext();
                }
                displayTextArea.setText(s);
            }
            else if(gazaLiteraryDisplayRB.isSelected()) {
                String s="";
                Node<Tawjihi> prev = gazaLiteraryList.getHead();
                Node<Tawjihi> curr = prev.getNext();
                s += prev.getData() + "\n";
                for (int i=0; i<10; i++) {
                    if (curr.getData().getAverage() == prev.getData().getAverage()) {
                        s += curr.getData() + "\n";
                        prev = curr;
                        curr = curr.getNext();
                        i--;

                    } else {
                        prev = curr;
                        curr = curr.getNext();
                    }
                }
                displayTextArea.setText(s);
            }
            else if(westBankScienceDisplayRB.isSelected()) {
                String s="";
                Node<Tawjihi> prev = westBankScienceList.getHead();
                Node<Tawjihi> curr = prev.getNext();
                s += prev.getData() + "\n";
                for (int i=0; i<10; i++) {
                     if (curr.getData().getAverage() == prev.getData().getAverage()) {
                        s += curr.getData() + "\n";
                        prev = curr;
                        curr = curr.getNext();
                        i--;

                    } else {
                        prev = curr;
                        curr = curr.getNext();
                        }
                    }
                displayTextArea.setText(s);
            }

            else if(westBankLiteraryDisplayRB.isSelected()) {
                String s="";
                Node<Tawjihi> prev = westBankLiteraryList.getHead();
                Node<Tawjihi> curr = prev.getNext();
                s += prev.getData() + "\n";
                for (int i=0; i<10; i++) {
                    if (curr.getData().getAverage() == prev.getData().getAverage()) {
                        s += curr.getData() + "\n";
                        prev = curr;
                        curr = curr.getNext();
                        i--;

                    } else {
                        prev = curr;
                        curr = curr.getNext();
                    }
                }
                displayTextArea.setText(s);
            }



        });

        Button clearButton = new Button("Clear!");
        clearButton.setOnAction(e-> displayTextArea.setText(null));

        HBox displayAndBack = new HBox(20);
        displayAndBack.getChildren().addAll(displayButton, clearButton, backDisplay);
        displayAndBack.setAlignment(Pos.CENTER);

        VBox displayVBox = new VBox(20);
        displayVBox.getChildren().addAll(labelDisplayID, DisplayAreaTopToggle, displayAndBack, displayTextArea);
        displayVBox.setAlignment(Pos.CENTER);

        displayPane.setCenter(displayVBox);

        display = new Scene(displayPane, 900, 450);

        //Find the Mean Average Scene
        BorderPane meanAveragePane = new BorderPane();
        TextField meanAverageText = new TextField();
        Label meanAverageLabel = new Label("The Mean Average: ");

        HBox meanAverageHBox = new HBox(10);
        meanAverageHBox.getChildren().addAll(meanAverageLabel, meanAverageText);
        meanAverageHBox.setAlignment(Pos.CENTER);

        Button backMeanAverage = new Button("Back");
        backMeanAverage.setOnAction(e-> {
            stage.setScene(scene);
            meanAverageText.setText(null);
        });

        RadioButton gazaScienceMean = new RadioButton("Gaza-Scientific Branch");
        RadioButton gazaLiteraryMean = new RadioButton("Gaza-Literary Branch");
        RadioButton westBankScienceMean = new RadioButton("WestBank-Scientific Branch");
        RadioButton westBankLiteraryMean = new RadioButton("WestBank-Literary Branch");
        ToggleGroup tgDisplayMean = new ToggleGroup();
        gazaScienceMean.setToggleGroup(tgDisplayMean);
        gazaLiteraryMean.setToggleGroup(tgDisplayMean);
        westBankScienceMean.setToggleGroup(tgDisplayMean);
        westBankLiteraryMean.setToggleGroup(tgDisplayMean);


        HBox meanAverageToggle = new HBox(20);
        meanAverageToggle.getChildren().addAll(gazaScienceMean, gazaLiteraryMean, westBankScienceMean, westBankLiteraryMean);
        meanAverageToggle.setAlignment(Pos.CENTER);

        Button pressOnAverage = new Button("Find Average");


        pressOnAverage.setOnAction(e->{
            if(gazaScienceMean.isSelected()){
                Node<Tawjihi> curr = gazaScienceList.getHead();
                int studentCount = 0;
                double sum = 0;
                while (curr.getNext() != null) {
                    sum += curr.getData().getAverage();
                    studentCount++;
                    curr=curr.getNext();
                }
                meanAverageText.setText(String.valueOf(sum / studentCount));
            }
            else if(gazaLiteraryMean.isSelected()){
                Node<Tawjihi> curr = gazaLiteraryList.getHead();
                int studentCount = 0;
                double sum = 0;
                while (curr.getNext() != null) {
                    sum += curr.getData().getAverage();
                    studentCount++;
                    curr=curr.getNext();
                }
                meanAverageText.setText(String.valueOf(sum / studentCount));
            }

            else if(westBankScienceMean.isSelected()){
                Node<Tawjihi> curr = westBankScienceList.getHead();
                int studentCount = 0;
                double sum = 0;
                while (curr.getNext() != null) {
                    sum += curr.getData().getAverage();
                    studentCount++;
                    curr=curr.getNext();
                }
                meanAverageText.setText(String.valueOf(sum / studentCount));

            }
            else if(westBankLiteraryMean.isSelected()){
                Node<Tawjihi> curr = westBankLiteraryList.getHead();
                int studentCount = 0;
                double sum = 0;
                while (curr.getNext() != null) {
                    sum += curr.getData().getAverage();
                    studentCount++;
                    curr=curr.getNext();
                }
                meanAverageText.setText(String.valueOf(sum / studentCount));
            }
        });



        VBox meanAverageVBox = new VBox(20);
        meanAverageVBox.getChildren().addAll(meanAverageHBox, meanAverageToggle, pressOnAverage, backMeanAverage);
        meanAverageVBox.setAlignment(Pos.CENTER);

        meanAveragePane.setCenter(meanAverageVBox);
        average = new Scene(meanAveragePane, 900, 420);

        // Find The Mode Average Scene
        BorderPane modeAveragePane = new BorderPane();
        TextField modeAverageText = new TextField();
        Label modeAverageLabel = new Label("The Mode Average: ");

        HBox modeAverageHBox = new HBox(10);
        modeAverageHBox.getChildren().addAll(modeAverageLabel, modeAverageText);
        modeAverageHBox.setAlignment(Pos.CENTER);

        RadioButton gazaScienceMode = new RadioButton("Gaza-Science Branch");
        RadioButton gazaLiteraryMode = new RadioButton("Gaza-Literary Branch");
        RadioButton westBankScienceMode = new RadioButton("West Bank-Science Branch");
        RadioButton westBankLiteraryMode = new RadioButton("West Bank-Literary Branch");
        ToggleGroup tgDisplay = new ToggleGroup();
        gazaScienceMode.setToggleGroup(tgDisplay);
        gazaLiteraryMode.setToggleGroup(tgDisplay);
        westBankScienceMode.setToggleGroup(tgDisplay);
        westBankLiteraryMode.setToggleGroup(tgDisplay);


        HBox modeAverageToggle = new HBox(20);
        modeAverageToggle.getChildren().addAll(gazaScienceMode, gazaLiteraryMode, westBankScienceMode,westBankLiteraryMode);
        modeAverageToggle.setAlignment(Pos.CENTER);


        Button backModeAverage = new Button("Back");
        backModeAverage.setOnAction(e->{
            modeAverageText.setText(null);
            stage.setScene(scene);});

        Button pressOnMode = new Button("Find Mode");
        pressOnMode.setOnAction(e->{
            if (gazaScienceMode.isSelected()) {
                int counter=0;
                double maxCount;
                int count;
                Node<Tawjihi> prev=gazaScienceList.getHead();
                Node<Tawjihi> curr;
                while(prev != null) {
                    curr = prev;
                    count = 0;
                    while (curr != null) {
                        if (prev.getData().getAverage() == curr.getData().getAverage()) {
                            count++;
                        }
                        curr = curr.getNext();

                        if (count > counter) {
                            counter = count;
                            maxCount = prev.getData().getAverage();
                            modeAverageText.setText(String.valueOf(maxCount));
                        }
                    }
                    prev = prev.getNext();
                }
            }
            else if (gazaLiteraryMode.isSelected()) {
                int counter=0;
                int count;
                double maxCount;
                Node<Tawjihi> prev=gazaLiteraryList.getHead();
                Node<Tawjihi> curr;
                while(prev != null) {
                    curr = prev;
                    count = 0;
                    while (curr != null) {
                        if (prev.getData().getAverage() == curr.getData().getAverage())
                            count++;
                        curr = curr.getNext();

                        if (count > counter) {
                            counter = count;
                            maxCount = prev.getData().getAverage();
                            modeAverageText.setText(String.valueOf(maxCount));
                        }
                    }
                    prev = prev.getNext();
                }

            }

            else if (westBankScienceMode.isSelected()) {
                int counter=0;
                int count;
                double maxCount;
                Node<Tawjihi> prev=westBankScienceList.getHead();
                Node<Tawjihi> curr;
                while(prev != null) {
                    curr=prev;
                    count=0;
                    while(curr.getNext() != null) {
                            if(prev.getData().getAverage() == curr.getData().getAverage())
                                count++;
                            curr=curr.getNext();

                        if(count > counter) {
                            counter=count;
                            maxCount=prev.getData().getAverage();
                            modeAverageText.setText(String.valueOf(maxCount));

                        }
                    }
                    prev=prev.getNext();
                }

            }

            else if (westBankLiteraryMode.isSelected()) {
                int counter=0;
                int count;
                double maxCount;
                Node<Tawjihi> prev=westBankLiteraryList.getHead();
                Node<Tawjihi> curr;
                while(prev != null) {
                    curr=prev;
                    count=0;
                    while(curr.getNext() != null) {
                        if(prev.getData().getAverage() == curr.getData().getAverage())
                            count++;
                        curr=curr.getNext();

                        if(count > counter) {
                            counter=count;
                            maxCount=prev.getData().getAverage();
                            modeAverageText.setText(String.valueOf(maxCount));

                        }
                    }
                    prev=prev.getNext();
                }
            }
        });

        VBox modeAverageVBox = new VBox(20);
        modeAverageVBox.getChildren().addAll(modeAverageHBox, modeAverageToggle, pressOnMode, backModeAverage);
        modeAverageVBox.setAlignment(Pos.CENTER);

        modeAveragePane.setCenter(modeAverageVBox);
        mode = new Scene(modeAveragePane, 900, 420);


        // Find the Percentage And Amount of Students Who Scored Above Or Equal User's Input
        BorderPane percentagePane = new BorderPane();
        TextField userText = new TextField();
        Label userLabel = new Label("Enter A Number: ");

        TextField percentageText = new TextField();
        Label percentageLabel = new Label("The Percentage Of Students Who Scored Above or Equal Is: ");

        TextField amountText = new TextField();
        Label amountLabel = new Label("The Number Of Students Who Scored Above or Equal Is: ");


        RadioButton scienceGazaPercentage = new RadioButton("Gaza-Science Branch");
        RadioButton literaryGazaPercentage = new RadioButton("Gaza-Literary Branch");
        RadioButton scienceWestBankPercentage = new RadioButton("WestBank-Science Branch");
        RadioButton literaryWestBankPercentage = new RadioButton("WestBank-Literary Branch");
        ToggleGroup tgDisplayPercentage = new ToggleGroup();
        scienceGazaPercentage.setToggleGroup(tgDisplayPercentage);
        literaryGazaPercentage.setToggleGroup(tgDisplayPercentage);
        scienceWestBankPercentage.setToggleGroup(tgDisplayPercentage);
        literaryWestBankPercentage.setToggleGroup(tgDisplayPercentage);


        HBox percentageBranchToggle = new HBox(20);
        percentageBranchToggle.getChildren().addAll(literaryGazaPercentage, scienceWestBankPercentage, scienceGazaPercentage, literaryWestBankPercentage);
        percentageBranchToggle.setAlignment(Pos.CENTER);


        Button backPercentageButton = new Button("Back");
        backPercentageButton.setOnAction(e->{
            userText.setText(null);
            percentageText.setText(null);
            amountText.setText(null);
            stage.setScene(scene);
        });

        Button percentageButton = new Button("Show The Percentage And Number Of Students");
        percentageButton.setOnAction(e->{
            int count = 0;
            double sum = 0;
                if (scienceGazaPercentage.isSelected()) {
                    Node<Tawjihi> curr = gazaScienceList.getHead();
                    while(curr!= null) {
                        if (curr.getData().getAverage() >= Double.parseDouble(userText.getText())) {
                            count++;
                        }
                        sum++;
                        curr=curr.getNext();
                    }
                    double per=(count/sum)*100;
                    percentageText.setText(String.valueOf(per));
                    amountText.setText(String.valueOf(count));
                }

                else if (literaryGazaPercentage.isSelected()) {
                    Node<Tawjihi> curr = gazaLiteraryList.getHead();
                    while(curr!= null) {
                            if (curr.getData().getAverage() >= Double.parseDouble(userText.getText())) {
                                count++;
                            }
                            curr=curr.getNext();
                            sum++;

                    }
                    double per=(count/sum)*100;
                    percentageText.setText(String.valueOf(per));
                    amountText.setText(String.valueOf(count));
                }

                else if (scienceWestBankPercentage.isSelected()) {
                    Node<Tawjihi> curr = westBankScienceList.getHead();
                    while(curr!= null) {
                            if (curr.getData().getAverage()>=Double.parseDouble(userText.getText())) {
                                count++;
                            }
                            curr=curr.getNext();
                            sum++;
                    }
                    double per=(count/sum)*100;
                    percentageText.setText(String.valueOf(per));
                    amountText.setText(String.valueOf(count));
                }

                else if (literaryWestBankPercentage.isSelected()) {
                    Node<Tawjihi> curr = westBankLiteraryList.getHead();
                    while(curr!= null) {
                            if (curr.getData().getAverage()>=Double.parseDouble(userText.getText())) {
                                count++;
                            }
                        sum++;
                        curr=curr.getNext();
                    }
                    double per=(count/sum)*100;
                    percentageText.setText(String.valueOf(per));
                    amountText.setText(String.valueOf(count));
                }

        });

        HBox percentageAndBack = new HBox(20);
        percentageAndBack.getChildren().addAll(percentageButton, backPercentageButton);
        percentageAndBack.setAlignment(Pos.CENTER);

        GridPane PercentageGrid = new GridPane();
        PercentageGrid.addRow(1, userLabel, userText);
        PercentageGrid.addRow(2, percentageLabel, percentageText);
        PercentageGrid.addRow(3, amountLabel, amountText);
        PercentageGrid.addRow(5,percentageBranchToggle);
        PercentageGrid.addRow(6, percentageAndBack);
        PercentageGrid.setVgap(20);
        PercentageGrid.setAlignment(Pos.CENTER);

        percentagePane.setCenter(PercentageGrid);
        percentage = new Scene(percentagePane, 900, 420);


        scene = new Scene(mainPane, 450, 420);
        stage.setTitle("First Data Structure Project!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}