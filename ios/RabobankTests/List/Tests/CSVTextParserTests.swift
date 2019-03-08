//
//  CSVTextParserTests.swift
//  RabobankTests
//
//  Created by Dennis Skokov on 25/02/2019.
//  Copyright © 2019 Dennis Skokov. All rights reserved.
//

import Nimble
import Quick

@testable import Rabobank
@testable import main

class CSVTextParserTests: QuickSpec {
    override func spec() {
        var parser: CSVTextParser!
        
        beforeEach {
            parser = CSVTextParser()
        }
        
        describe("parse") {
            var parsingResult: [[String]]?
            context("valid text source") {
                
                let text = """
"First name","Sur name","Issue count","Date of birth"
"Theo","Jansen",5,"1978-01-02T00:00:00"
"Fiona","de Vries",7,"1950-11-12T00:00:00"
"Petra","Boersma",1,"2001-04-20T00:00:00"
"""
                let expectedParsingResult: [[String]] = [
                    ["\"First name\"","\"Sur name\"","\"Issue count\"","\"Date of birth\""],
                    ["\"Theo\"","\"Jansen\"","5","\"1978-01-02T00:00:00\""],
                    ["\"Fiona\"","\"de Vries\"","7","\"1950-11-12T00:00:00\""],
                    ["\"Petra\"","\"Boersma\"","1","\"2001-04-20T00:00:00\""]]
                
                beforeEach {
                    parsingResult = parser.parse(text: text)
                }
                
                it("parses text") {
                    expect(parsingResult) == expectedParsingResult
                }
            }
            
            context("invalid text source") {
                beforeEach {
                    parsingResult = parser.parse(text: "")
                }
                
                it("returns nil") {
                    expect(parsingResult).to(beNil())
                }
            }
        }
    }
}
