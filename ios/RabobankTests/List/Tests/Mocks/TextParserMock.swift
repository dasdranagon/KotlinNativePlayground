//
//  TextParserMock.swift
//  RabobankTests
//
//  Created by Dennis Skokov on 25/02/2019.
//  Copyright © 2019 Dennis Skokov. All rights reserved.
//

@testable import Rabobank
@testable import main

class TextParserMock: TextParser {
    var textToParse: String?
    var rowsToReturn: [[String]]!
    func parse(text: String)-> [[String]]? {
        textToParse = text
        return rowsToReturn
        
    }
}
