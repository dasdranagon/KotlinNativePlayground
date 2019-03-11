//
//  ListAssembly.swift
//  Rabobank
//
//  Created by Dennis Skokov on 22/02/2019.
//  Copyright © 2019 Dennis Skokov. All rights reserved.
//

import UIKit
import main

extension ListAssembly {
    func createViewController() -> UIViewController {
        let viewController = initialControllerFromStoryboard() as! ListTableViewController
 
        presenter.view = viewController
        viewController.evensHandler = presenter
        dataSource.errorHandler = viewController
        
        let navigationController = UINavigationController(rootViewController: viewController)
        return navigationController
    }
    
    private func initialControllerFromStoryboard() -> UIViewController {
        let bundle = Bundle.main
        let storyboard = UIStoryboard(name: "List", bundle: bundle)
        return storyboard.instantiateInitialViewController()!
    }
}
