//
//  ViewController.swift
//  lab5
//
//  Created by Yamei Liao on 2019/10/21.
//  Copyright © 2019 Yamei Liao. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var labe1: UILabel!
    
    @IBOutlet weak var label2: UILabel!
    
    
    
    var user=Favorite()
    
    
    @IBAction func unwindSegue (_ segue:UIStoryboardSegue){
        labe1.text=user.favMovie
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}


