//
//  ViewController.swift
//  midterm
//
//  Created by Yamei Liao on 2019/10/15.
//  Copyright © 2019 Yamei Liao. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate{
    @IBOutlet weak var tripTextField: UITextField!
    @IBOutlet weak var gasGallon: UILabel!
    @IBOutlet weak var transportSege: UISegmentedControl!
    @IBOutlet weak var transportImg: UIImageView!
    @IBOutlet weak var monthlySwitch: UISwitch!
    @IBOutlet weak var gallonGasLabel: UILabel!
    @IBOutlet weak var totalCommuteTimeDue: UILabel!
    @IBOutlet weak var totalGasDue: UILabel!
    @IBOutlet weak var toCommute: UIButton!
    
    
    @IBAction func transportSegeAction(_ sender: UISegmentedControl) {
        if transportSege.selectedSegmentIndex == 0{
            transportImg.image = UIImage(named: "car_icon.png")
            let alert=UIAlertController(title: "warning", message: "car pooling and public transportation is better to the world.", preferredStyle: UIAlertController.Style.alert)
            let cancelAction = UIAlertAction(title: "know", style: UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            present(alert,animated:true,completion:nil)
            updateTotalTime()
            
        }else if transportSege.selectedSegmentIndex == 1{
            transportImg.image = UIImage(named: "bus_icon.png")
            updateTotalTimeBus()
           
            
        }else if transportSege.selectedSegmentIndex == 2{
            transportImg.image = UIImage(named: "bike_icon.png")
            updateTotalTimeBike()
        }
        
        
    
    }
    
    @IBAction func commuteButton(_ sender: UIButton) {
        updateTotalTime()
    }
    
    func updateTotalTime(){
        var milesAmount:Float //
        //var gasAmount:Float
        if tripTextField.text!.isEmpty{
            milesAmount = 0.0
        }else{
            milesAmount = Float(tripTextField.text!)!
        }
        
        let carCommuteTime = milesAmount/20.00
        totalCommuteTimeDue.text=String(format:"%.0f",carCommuteTime)+" hours"
         //var gasAmount:Float=00.00
        let gasAmount = milesAmount/24.00
        totalGasDue.text=String(format:"%.0f",gasAmount)+" gallons"
    }
    
    func updateTotalTimeBus(){
        var milesAmount:Float //
        //var gasAmount:Float
        if tripTextField.text!.isEmpty{
            milesAmount = 0.0
        }else{
            milesAmount = Float(tripTextField.text!)!
        }
        
        let busCommuteTime = milesAmount/12.00
        totalCommuteTimeDue.text=String(format:"%.0f",busCommuteTime)+" hours"
        //var gasAmount:Float=00.00
        let gasAmount = 00.00
        totalGasDue.text=String(format:"%.0f",gasAmount)+" gallons"
    }
    func updateTotalTimeBike(){
        var milesAmount:Float //
        //var gasAmount:Float
        if tripTextField.text!.isEmpty{
            milesAmount = 0.0
        }else{
            milesAmount = Float(tripTextField.text!)!
        }
        
        let bikeCommuteTime =  milesAmount/10.00
        totalCommuteTimeDue.text=String(format:"%.0f",bikeCommuteTime)+" hours"
        //var gasAmount:Float=00.00
        let gasAmount = 00.00
        totalGasDue.text=String(format:"%.0f",gasAmount)+" gallons"
    }
    
    //here is working on the switch
    //how to combine it
    
    
    @IBAction func monthCommuteAction(_ sender: UISwitch) {
        
        if monthlySwitch.isOn{
            //do somethingwith the total commute showing label
            if transportSege.selectedSegmentIndex == 0{
                transportImg.image = UIImage(named: "car_icon.png")
                var milesAmount:Float //
                //var gasAmount:Float
                if tripTextField.text!.isEmpty{
                    milesAmount = 0.0
                }else{
                    milesAmount = Float(tripTextField.text!)!
                }
                
                let carCommuteTime = milesAmount//(devide 20 and time 20 which cancel out)
                totalCommuteTimeDue.text=String(format:"%.0f",carCommuteTime)+" hours"
                //var gasAmount:Float=00.00
                let gasAmountOneDay = milesAmount/24.00
                let monthGas = gasAmountOneDay*20.00
                totalGasDue.text=String(format:"%.0f",monthGas)+" gallons"
                
           
                
            }else if transportSege.selectedSegmentIndex == 1{
                transportImg.image = UIImage(named: "bus_icon.png")
                var milesAmount:Float //
                //var gasAmount:Float
                if tripTextField.text!.isEmpty{
                    milesAmount = 0.0
                }else{
                    milesAmount = Float(tripTextField.text!)!
                }
                
                let busCommuteTime = milesAmount/12.00
                let totalbusTime = busCommuteTime * 20.00
                totalCommuteTimeDue.text=String(format:"%.0f",totalbusTime)+" hours"
                //var gasAmount:Float=00.00
                let gasAmount = 00.00
                totalGasDue.text=String(format:"%.0f",gasAmount)+" gallons"
                
            
            }else if transportSege.selectedSegmentIndex == 2{
                transportImg.image = UIImage(named: "bike_icon.png")
                var milesAmount:Float //
                //var gasAmount:Float
                if tripTextField.text!.isEmpty{
                    milesAmount = 0.0
                }else{
                    milesAmount = Float(tripTextField.text!)!
                }
                
                let bikeCommuteTime =  milesAmount/10.00
                let totalBikeTime = bikeCommuteTime * 20.00
                totalCommuteTimeDue.text=String(format:"%.0f",totalBikeTime)+" hours"
                //var gasAmount:Float=00.00
                let gasAmount = 00.00
                totalGasDue.text=String(format:"%.0f",gasAmount)+" gallons"
            }
            
        }else{
            if transportSege.selectedSegmentIndex == 0{
                transportImg.image = UIImage(named: "car_icon.png")
                /*let alert=UIAlertController(title: "warning", message: "car pooling and public transportation is better to the world.", preferredStyle: UIAlertController.Style.alert)
                let cancelAction = UIAlertAction(title: "know", style: UIAlertAction.Style.cancel, handler: nil)
                alert.addAction(cancelAction)
                present(alert,animated:true,completion:nil)*/
                updateTotalTime()
                
            }else if transportSege.selectedSegmentIndex == 1{
                transportImg.image = UIImage(named: "bus_icon.png")
                updateTotalTimeBus()
                
                
            }else if transportSege.selectedSegmentIndex == 2{
                transportImg.image = UIImage(named: "bike_icon.png")
                updateTotalTimeBike()
            }
        }
        
    }
    
  
    @IBAction func gallonGasSlider(_ sender: UISlider) {
        let gallonOfGas=sender.value
        gallonGasLabel.text=String(format:"%.0f",gallonOfGas)+" gallons"
       // let gallonOfGasFloat=CGFloat(gallonOfGas)
    
    }
    
    
    
    //for keyboard to disapear
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    override func viewDidLoad() {
        tripTextField.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        //below is to make keyboard disapear when tapping outside
        let tap:UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
    }
    
    @objc func dismissKeyboard(){
        view.endEditing(true)
        
    }
    @objc func keyboardWillShow(notification:NSNotification){
        if let keyboardSize = (notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey]as?NSValue)?.cgRectValue{
            if self.view.frame.origin.y==0{
                self.view.frame.origin.y -= keyboardSize.height
            }
        }
    }
    @objc func keyboardWillHide(notification:NSNotification){
        if((notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey]as?NSValue)?.cgRectValue) != nil{
            if self.view.frame.origin.y != 0 {
                self.view.frame.origin.y = 0
            }
        }
    }
    

}//close class




