//
//  PersonsFactory.swift
//  Rabobank
//
//  Created by Dennis Skokov on 28/02/2019.
//  Copyright © 2019 Dennis Skokov. All rights reserved.
//

import main

protocol PersonsFactory {
    typealias Row = [String]
    func create(row: Row) -> Person?
}
