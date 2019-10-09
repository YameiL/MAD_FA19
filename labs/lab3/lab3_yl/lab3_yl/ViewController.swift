//
//  ViewController.swift
//  lab3_yl
//
//  Created by Yamei Liao on 2019/9/23.
//  Copyright © 2019 Yamei Liao. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var chinaImage: UIImageView!
    
    
    @IBOutlet weak var fontSizeLabel: UILabel!
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        let fontSize=sender.value
        fontSizeLabel.text=String(format: "%.0f", fontSize)
        let fontSizeCGFloat=CGFloat(fontSize)
        titleLabel.font=UIFont.systemFont(ofSize: fontSizeCGFloat)
    }
    @IBOutlet weak var capitalSwitch: UISwitch!
    @IBAction func updateFont(_ sender: UISwitch) {
        if capitalSwitch.isOn{
            titleLabel.text=titleLabel.text?.uppercased()
        }else{
            titleLabel.text=titleLabel.text?.lowercased()
        }
    }
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var imageControl: UISegmentedControl!
    @IBAction func changeInfo(_ sender: UISegmentedControl) {
        if imageControl.selectedSegmentIndex == 0{
            titleLabel.text = "Beijing"
            chinaImage.image = UIImage(named: "bj")
            
        }else if imageControl.selectedSegmentIndex == 1 {
            titleLabel.text = "Guangzhou"
            chinaImage.image = UIImage(named: "gz")
            
        }
    }
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

