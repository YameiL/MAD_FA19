//
//  scene2ViewController.swift
//  lab5
//
//  Created by Yamei Liao on 2019/10/21.
//  Copyright © 2019 Yamei Liao. All rights reserved.
//

import UIKit

class scene2ViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var movieName: UILabel!
    
    @IBOutlet weak var movieText: UITextField!
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "doneFavs"{
            let scene1ViewController = segue.destination as! ViewController
            //check to see that text was entered in the textfields
            if movieText.text!.isEmpty == false{
                scene1ViewController.user.favMovie=movieText.text
            }
            
        }
    }
    
    override func viewDidLoad() {
        movieText.delegate=self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
