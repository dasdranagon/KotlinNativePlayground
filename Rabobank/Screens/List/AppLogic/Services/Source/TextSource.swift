//
//  TextSource.swift
//  Rabobank
//
//  Created by Dennis Skokov on 24/02/2019.
//  Copyright © 2019 Dennis Skokov. All rights reserved.
//

import Foundation

protocol TextSource {
    typealias Response = (String)->()
    func fetch(response: Response)
}
