//
//  TextSourceMock.swift
//  RabobankTests
//
//  Created by Dennis Skokov on 25/02/2019.
//  Copyright © 2019 Dennis Skokov. All rights reserved.
//

@testable import Rabobank

class TextSourceMock: TextSource {
    var textToReturn: String?
    var fetchWasCalled = false
    func fetch(response: (String?) -> ()) {
        fetchWasCalled = true
        response(textToReturn)
    }
}
