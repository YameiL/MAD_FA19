//
//  ViewController.swift
//  trashApp
//
//  Created by Yamei Liao on 2019/10/9.
//  Copyright © 2019 Yamei Liao. All rights reserved.
//

import UIKit

//learnt this structure method in multip area
//When they want to build a data struture they use it and it applies to my app
struct Trashes {
    //var differTrash : UIImage!
    //var Answers : [String]!
    let qimage : String
    let qLable : String
    let optionOne : String
    let optionTwo : String
    let optionThree : String
    let optionFour : String
    //answer is int because it associate with the tag number
    var Answer : Int
    // var wrongAnswers : Int
    //var picked : Bool
    init(image:String, questionText: String, pick1:String, pick2:String, pick3:String, pick4:String, tAnswer:Int){
        qimage = image
        qLable = questionText
        optionOne = pick1
        optionTwo = pick2
        optionThree = pick3
        optionFour = pick4
        Answer = tAnswer
    }
}

//to create the list of trash
class TrashBank{
    //list that is in the trashes sturct I created above
    var list = [Trashes]()
    
    init(){
        //type trashes() in the append will nicely auto fill all the info that need to fulfill, so filled with the info that for my trash question including img, question and the right answer
        list.append(Trashes(image: "apple", questionText: "What type of trash is for a ate apple? ", pick1: "A", pick2: "B", pick3: "C", pick4: "D", tAnswer: 4))
        
        list.append(Trashes(image: "battery", questionText: "What type of trash is for a battery? ", pick1: "A", pick2: "B", pick3: "C", pick4: "D", tAnswer: 2))
        
        
        list.append(Trashes(image: "water", questionText: "What type of trash is for a water bottle? ", pick1: "A", pick2: "B", pick3: "C", pick4: "D", tAnswer: 3))
        
        
        list.append(Trashes(image: "tissues", questionText: "What type of trash is for tissues? ", pick1: "A", pick2: "B", pick3: "C", pick4: "D", tAnswer: 1))
        
        list.append(Trashes(image: "toilet", questionText: "What type of trash is for toilet paper? ", pick1: "A", pick2: "B", pick3: "C", pick4: "D", tAnswer: 1))
        
        list.append(Trashes(image: "can", questionText: "What type of trash is for cans? ", pick1: "A", pick2: "B", pick3: "C", pick4: "D", tAnswer: 3))
    }
}
    



class ViewController: UIViewController {
    
    @IBOutlet weak var tittleL: UILabel!
    @IBOutlet weak var QuestionL: UILabel!
    
    //choice of buttons
    //each button has it own tag number, I have setted it to start at 1
//instead of make a image clickable use button instead
    @IBOutlet weak var option1: UIButton!
    @IBOutlet weak var option2: UIButton!
    @IBOutlet weak var option3: UIButton!
    @IBOutlet weak var option4: UIButton!
    
    @IBOutlet weak var ScoreL: UILabel!
    
    //allTrash store the trash var from TrashBank
    let allTrash = TrashBank()
    var questionNumber : Int = 0
    var pickedAnswer : Int = 0
    //may do something with score
    var score:Int = 0

    
    @IBAction func pickButton(_ sender: UIButton) {
        
        //for  testing purpose
        //if sender.tag == 1 {
        //  print("ganlaji")
        //}else if sender.tag == 2{
        //  print("harmful")
        //}else if sender.tag == 3{
        //  print("recycle")
        //}else{
        //  print("households")
        if sender.tag == pickedAnswer{
            print("correct")
            //do something with user score maybe
            score += 10 // correct answer worth points
        }else{
            print("wrong")
        }
        //this is to call the function that will update the question to another one, once after user made a choice
        updateInfo()
        questionNumber += 1//to update Q# so it will go to the next Q
        
    }
    
    @IBOutlet weak var trashImage: UIImageView!
    
    func updateInfo(){
    //wrong math
        //if questionNumber < allTrash.list.count{
        if questionNumber <= allTrash.list.count - 1{
        // need to add a range other wise crash
            trashImage.image = UIImage(named: (allTrash.list[questionNumber].qimage))
            QuestionL.text = allTrash.list[questionNumber].qLable
            option1.setTitle(allTrash.list[questionNumber].optionOne, for: UIControl.State.normal)
            option2.setTitle(allTrash.list[questionNumber].optionTwo, for: UIControl.State.normal)
            option3.setTitle(allTrash.list[questionNumber].optionThree, for: UIControl.State.normal)
            option4.setTitle(allTrash.list[questionNumber].optionFour, for: UIControl.State.normal)
            pickedAnswer = allTrash.list[questionNumber].Answer//this is going to return an int
        }else{
            // make an alert at the end to show the game is over
            let popAlert = UIAlertController(title: "NICE JOB!", message: "You have finished the game. Your score is \(score).", preferredStyle: .alert)
            // make an acton button
            let startOver = UIAlertAction(title: "start over", style: .default, handler: {action in self.startAgain()})//instead of the .cancle we used in class use .default
            //use the function call startAgain() to make this button in alert work
            popAlert.addAction(startOver)
            present(popAlert,animated: true)
        }
        updateScore()
    }
    
    func updateScore(){
        //Binary operator '+' cannot be applied to operands of type 'String' and 'Int'
        //ScoreL.text = "Score: " + score
        ScoreL.text = "Score: " + "\(score)" //use \ to ignore
        
        
    }

    func startAgain(){
        score = 0
        questionNumber = 0
        //call following func to upate the new question which means start a new round of the quiz
        updateInfo()
    }

    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        //call th8is question int the viewDidLoad() is becauswe here is what will load at first when the app is launch
        //so call this function will load the first question when my app  is launched
        updateInfo()
        updateScore()
        
    }


}

