//
//  ViewController.swift
//  Yamei_lab4
//
//  Created by Yamei Liao on 2019/10/2.
//  Copyright © 2019 Yamei Liao. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var hrPayment: UITextField!
    
    @IBOutlet weak var hrStepper: UIStepper!
    
//   test comment
    
    @IBOutlet weak var hourLabel: UILabel!
     @IBOutlet weak var totalDue: UILabel!
    
    @IBAction func updateHour(_ sender: UIStepper) {
        if hrStepper.value == 1{
            hourLabel.text = "1 (hr)"
            
        }else{
            hourLabel.text = String(format:"%.0f", hrStepper.value) + " (hr)"
        }
    }
    
    func textFieldShouldReturn(_ textField:UITextField)->Bool{
        textField.resignFirstResponder()
        return true
    }
    func updateTotalPay(){
        var amountHr: Float
        //var hrPay: Int
        
        if hrPayment.text!.isEmpty{
            amountHr = 1
        }else{
            print (hrPayment.text)
            amountHr = Float(hrPayment.text!)!
        }
         let numberOfHour = hrStepper.value
        //let total = amountHr * numberOfHour
 
        var totalPaycheck : Float = 0.0
        if numberOfHour>0{
            totalPaycheck = amountHr*Float(numberOfHour)
        }else{
            //create a UIAlertControlle3r object
            let alert = UIAlertController(title: "warning", message: "The number should greater than 0 in order to get pay", preferredStyle: UIAlertController.Style.alert)
            let cancelAction = UIAlertAction(title: "Cancel", style: UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction = UIAlertAction(title:"OK", style: UIAlertAction.Style.default, handler: {action in
                self.hrStepper.value = 1
                self.hourLabel.text? = "0 (hr)"
                self.updateTotalPay()
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion:nil)
        }//end of else
        //format results as currency
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle=NumberFormatter.Style.currency
        //hrPayment.text=currencyFormatter.string(from:NSNumber(value:amountHr))
        totalDue.text=currencyFormatter.string(from:NSNumber(value:totalPaycheck))
        //let numberOfHour = hrStepper.value
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateTotalPay()
    }
    
    override func viewDidLoad() {
        //need to learn more about this 
        hrPayment.delegate = self
        
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        //NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillShow),name:UIResponder.keyboardWillShowNotification, object: nil)
        //NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillHide), name: UIResponder.keyboardWillHideNotification, object: nil)
        
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

}

